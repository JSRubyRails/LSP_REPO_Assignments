package org.howard.edu.lsp.assignment3;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Handles transformation rules for products.
 */
public class ProductTransformer {

    public void transform(Product product) {

        // Uppercase name
        product.setName(product.getName().toUpperCase());

        BigDecimal price = product.getPrice();
        String category = product.getCategory();

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

        product.setPrice(price);
        product.setCategory(category);
        product.setPriceRange(priceRange);
    }
}
