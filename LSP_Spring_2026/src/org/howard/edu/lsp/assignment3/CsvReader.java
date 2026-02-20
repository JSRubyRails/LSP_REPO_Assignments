package org.howard.edu.lsp.assignment3;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Reads products from CSV file.
 */
public class CsvReader {

    public List<Product> read(String inputPath, int[] counters) throws IOException {

        List<Product> products = new ArrayList<>();

        File inputFile = new File(inputPath);
        if (!inputFile.exists()) {
            throw new FileNotFoundException("Input file not found at " + inputPath);
        }

        BufferedReader reader = new BufferedReader(new FileReader(inputFile));

        reader.readLine(); // skip header

        String line;
        while ((line = reader.readLine()) != null) {
            counters[0]++; // rowsRead

            if (line.trim().isEmpty()) {
                counters[2]++; // rowsSkipped
                continue;
            }

            String[] parts = line.split(",");
            if (parts.length != 4) {
                counters[2]++;
                continue;
            }

            try {
                int productId = Integer.parseInt(parts[0].trim());
                String name = parts[1].trim();
                BigDecimal price = new BigDecimal(parts[2].trim());
                String category = parts[3].trim();

                products.add(new Product(productId, name, price, category));

            } catch (NumberFormatException e) {
                counters[2]++;
            }
        }

        reader.close();
        return products;
    }
}
