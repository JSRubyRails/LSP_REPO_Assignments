package org.howard.edu.lsp.midterm.strategy;

/**
 * Strategy for VIP customers (20% discount).
 * @author Elias Zegeye
 */
public class VIPStrategy implements DiscountStrategy {

    public double applyDiscount(double price) {
        return price * 0.80;
    }
}