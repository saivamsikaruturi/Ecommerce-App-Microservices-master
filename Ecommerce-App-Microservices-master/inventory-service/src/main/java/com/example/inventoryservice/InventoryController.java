package com.example.inventoryservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {


    @Autowired
    InventoryService inventoryService;
    @GetMapping
    public boolean getInventory(@RequestParam String skucode, @RequestParam Integer quantity){
        System.out.println("s"+skucode+quantity);
        System.out.println(inventoryService.fetchDetails(skucode,quantity));
      return   inventoryService.fetchDetails(skucode,quantity);
    }

}
