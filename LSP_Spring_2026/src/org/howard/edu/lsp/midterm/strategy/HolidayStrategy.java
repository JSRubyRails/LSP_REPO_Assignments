package org.howard.edu.lsp.midterm.strategy;

/**
 * Strategy for holiday discounts (15% discount).
 * @author Elias Zegeye
 */
public class HolidayStrategy implements DiscountStrategy {

    public double applyDiscount(double price) {
        return price * 0.85;
    }
}