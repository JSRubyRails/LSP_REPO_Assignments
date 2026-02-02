package org.howard.edu.lsp.assignment2;

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class ETLPipeline {

	public static void main(String[] args) {
		String inputPath = "data/products.csv";
		String outputPath = "data/transformed_products.csv";
		
		int rowsRead = 0;
		int rowsWritten = 0;
		int rowsSkipped = 0;
		
		File inputFile = new File(inputPath);
		
		if (!inputFile.exists()) {
            System.out.println("Error: Input file not found at " + inputPath);
            return;
        }

        try (
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath))
        ) {

            // Always write header
            writer.write("ProductID,Name,Price,Category,PriceRange");
            writer.newLine();

            String header = reader.readLine(); // read header
            if (header == null) {
                // empty file (no header)
                printSummary(rowsRead, rowsWritten, rowsSkipped, outputPath);
                return;
            }

            String line;
            while ((line = reader.readLine()) != null) {
                rowsRead++;

                if (line.trim().isEmpty()) {
                    rowsSkipped++;
                    continue;
                }

                String[] parts = line.split(",");
                if (parts.length != 4) {
                    rowsSkipped++;
                    continue;
                }

                try {
                    int productId = Integer.parseInt(parts[0].trim());
                    String name = parts[1].trim().toUpperCase();
                    BigDecimal price = new BigDecimal(parts[2].trim());
                    String category = parts[3].trim();

                    boolean isElectronics = category.equals("Electronics");

                    // Apply 10% discount
                    if (isElectronics) {
                        price = price.multiply(new BigDecimal("0.90"));
                    }

                    // Round price
                    price = price.setScale(2, RoundingMode.HALF_UP);

                    // Premium Electronics check
                    if (isElectronics && price.compareTo(new BigDecimal("500.00")) > 0) {
                        category = "Premium Electronics";
                    }

                    // Determine price range
                    String priceRange;
                    if (price.compareTo(new BigDecimal("10.00")) <= 0) {
                        priceRange = "Low";
                    } else if (price.compareTo(new BigDecimal("100.00")) <= 0) {
                        priceRange = "Medium";
                    } else if (price.compareTo(new BigDecimal("500.00")) <= 0) {
                        priceRange = "High";
                    } else {
                        priceRange = "Premium";
                    }

                    writer.write(productId + "," + name + "," +
                                 price.toString() + "," +
                                 category + "," +
                                 priceRange);
                    writer.newLine();

                    rowsWritten++;

                } catch (NumberFormatException e) {
                    rowsSkipped++;
                }
            }

        } catch (IOException e) {
            System.out.println("Error processing files.");
            return;
        }

        printSummary(rowsRead, rowsWritten, rowsSkipped, outputPath);
    }

    private static void printSummary(int read, int written, int skipped, String outputPath) {
        System.out.println("Run Summary:");
        System.out.println("Rows read: " + read);
        System.out.println("Rows transformed: " + written);
        System.out.println("Rows skipped: " + skipped);
        System.out.println("Output written to: " + outputPath);
    }
}
