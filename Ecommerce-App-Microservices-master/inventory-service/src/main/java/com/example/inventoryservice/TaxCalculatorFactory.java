package com.example.inventoryservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class TaxCalculatorFactory {

    private final Map<String, TaxCalculator> calculatorMap;

    @Autowired
    public TaxCalculatorFactory() {
        calculatorMap = new HashMap<>();
        calculatorMap.put("old", new OldTaxCalculator());
        calculatorMap.put("new", new NewTaxCalculator());
    }
    public TaxCalculator getCalculator(String regime) {
        return calculatorMap.get(regime.toLowerCase());
    }
}

