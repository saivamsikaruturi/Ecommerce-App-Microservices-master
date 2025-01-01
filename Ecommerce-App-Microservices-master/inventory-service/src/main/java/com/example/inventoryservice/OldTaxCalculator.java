package com.example.inventoryservice;

import org.springframework.stereotype.Component;

@Component("oldTaxCalculator")
public class OldTaxCalculator implements TaxCalculator {
    @Override
    public double calculateTax(double income) {
        // Implement tax calculation logic for old regime
        // Example: simple tax calculation for demonstration purposes
        return income * 0.2; // 20% tax rate
    }
}
