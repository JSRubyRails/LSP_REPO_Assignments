package org.howard.edu.lsp.assignment3;

import java.io.*;
import java.util.List;

/**
 * Writes transformed products to CSV.
 */
public class CsvWriter {

    public void write(String outputPath, List<Product> products) throws IOException {

        BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath));

        writer.write("ProductID,Name,Price,Category,PriceRange");
        writer.newLine();

        for (Product product : products) {
            writer.write(product.toCsvRow());
            writer.newLine();
        }

        writer.close();
    }
}
