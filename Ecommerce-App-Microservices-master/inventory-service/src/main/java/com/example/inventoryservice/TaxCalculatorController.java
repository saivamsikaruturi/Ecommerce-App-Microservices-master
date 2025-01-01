package com.example.inventoryservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tax")
public class TaxCalculatorController {

    @Autowired
    private TaxCalculatorFactory taxCalculatorFactory;


    @Autowired
    @Qualifier("oldTaxCalculator")
    TaxCalculator old;

    @Autowired
    @Qualifier("newTaxCalculator")
    TaxCalculator newtax;

    @PostMapping("/calculate")
    public ResponseEntity<Double> calculateTax(@RequestParam double income,
                                               @RequestParam String employeeId,
                                               @RequestParam String regime) {
        TaxCalculator calculator = taxCalculatorFactory.getCalculator(regime);
        if (calculator == null) {
            return ResponseEntity.badRequest().build();
        }

        double taxAmount = calculator.calculateTax(income);
        return ResponseEntity.ok(taxAmount);
    }

    @PostMapping("/calculate1")
    public ResponseEntity<Double> calculateTax1(@RequestParam double income,
                                               @RequestParam String employeeId,
                                               @RequestParam String regime) {
        double v;
       if(regime.equals("old")){
            v = old.calculateTax(income);
       }
       else{
            v = newtax.calculateTax(income);
       }
        return ResponseEntity.ok(v);
    }
}
