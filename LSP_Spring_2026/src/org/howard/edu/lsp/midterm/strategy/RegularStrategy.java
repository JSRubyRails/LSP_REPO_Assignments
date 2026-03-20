package org.howard.edu.lsp.midterm.strategy;

/**
 * Strategy for regular customers (no discount).
 * @author Eias Zegeye
 */
public class RegularStrategy implements DiscountStrategy {

    /**
     * Returns the original price.
     */
    public double applyDiscount(double price) {
        return price;
    }
}