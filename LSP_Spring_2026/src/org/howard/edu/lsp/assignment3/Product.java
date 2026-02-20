package org.howard.edu.lsp.assignment3;

import java.math.BigDecimal;

/**
 * Represents a single product record.
 */
public class Product {

    private int productId;
    private String name;
    private BigDecimal price;
    private String category;
    private String priceRange;

    public Product(int productId, String name, BigDecimal price, String category) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public String getPriceRange() {
        return priceRange;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPriceRange(String priceRange) {
        this.priceRange = priceRange;
    }

    /**
     * Converts product to CSV output format.
     */
    public String toCsvRow() {
        return productId + "," +
               name + "," +
               price.toString() + "," +
               category + "," +
               priceRange;
    }
}
