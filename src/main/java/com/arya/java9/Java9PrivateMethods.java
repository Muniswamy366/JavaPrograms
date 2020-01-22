package com.arya.java9;

public interface Java9PrivateMethods {
    double getPrice();

    default double getPriceWithTax() {
        return getTaxPriceInternal();
    }

    default double getPriceWithTax(double discount) {
        return getTaxPriceInternal() * discount;
    }

    // Java 9 private method abstract the private helper methods from child class
    private double getTaxPriceInternal() {
        return getPrice() * 1.21;
    }
}
