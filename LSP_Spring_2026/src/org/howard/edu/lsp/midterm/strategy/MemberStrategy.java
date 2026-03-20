package org.howard.edu.lsp.midterm.strategy;

/**
 * Strategy for member customers (10% discount).
 * @author Elias Zegeye
 */
public class MemberStrategy implements DiscountStrategy {

    public double applyDiscount(double price) {
        return price * 0.90;
    }
}