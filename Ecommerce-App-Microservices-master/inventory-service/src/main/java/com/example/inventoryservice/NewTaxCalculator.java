package com.example.inventoryservice;

import org.springframework.stereotype.Component;

@Component("newTaxCalculator")
public class NewTaxCalculator implements TaxCalculator {
    @Override
    public double calculateTax(double income) {
        // Implement tax calculation logic for new regime
        // Example: progressive tax calculation for demonstration purposes
        if (income <= 50000) {
            return income * 0.1; // 10% tax rate for income <= 50000
        } else {
            return 5000 + (income - 50000) * 0.2; // 20% tax rate for income > 50000
        }
    }
}
