package org.howard.edu.lsp.midterm.strategy;

/**
 * PriceCalculator uses a DiscountStrategy to compute final price.
 * @author Elias Zegeye
 */
public class PriceCalculator {

    private DiscountStrategy strategy;

    /**
     * Sets the pricing strategy.
     * 
     * @param strategy discount strategy
     */
    public void setStrategy(DiscountStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * Calculates final price using the selected strategy.
     * 
     * @param price original price
     * @return final price
     */
    public double calculatePrice(double price) {
        if (strategy == null) {
            throw new IllegalStateException("Strategy not set");
        }
        return strategy.applyDiscount(price);
    }
}