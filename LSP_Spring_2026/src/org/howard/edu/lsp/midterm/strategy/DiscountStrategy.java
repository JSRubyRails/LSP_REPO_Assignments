package org.howard.edu.lsp.midterm.strategy;

/**
 * Strategy interface for pricing behavior.
 * Defines a method for calculating discounted price.
 * @author Elias Zegeye
 */
public interface DiscountStrategy {
    
    /**
     * Calculates the final price after applying a discount.
     * 
     * @param price original price
     * @return final price after discount
     */
    double applyDiscount(double price);
}