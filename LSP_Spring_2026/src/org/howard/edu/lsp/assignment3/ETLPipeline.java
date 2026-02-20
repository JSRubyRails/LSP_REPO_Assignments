package org.howard.edu.lsp.assignment3;

import java.util.List;

/**
 * Coordinates the ETL process.
 */
public class ETLPipeline {

    public void run() {

        String inputPath = "data/products.csv";
        String outputPath = "data/transformed_products.csv";

        int[] counters = new int[3]; 
        // [0] read, [1] written, [2] skipped

        try {

            CsvReader reader = new CsvReader();
            CsvWriter writer = new CsvWriter();
            ProductTransformer transformer = new ProductTransformer();

            List<Product> products = reader.read(inputPath, counters);

            for (Product product : products) {
                transformer.transform(product);
                counters[1]++; // rowsWritten
            }

            writer.write(outputPath, products);

            printSummary(counters, outputPath);

        } catch (Exception e) {
            System.out.println("Error processing files.");
        }
    }

    private void printSummary(int[] counters, String outputPath) {
        System.out.println("Run Summary:");
        System.out.println("Rows read: " + counters[0]);
        System.out.println("Rows transformed: " + counters[1]);
        System.out.println("Rows skipped: " + counters[2]);
        System.out.println("Output written to: " + outputPath);
    }
}
