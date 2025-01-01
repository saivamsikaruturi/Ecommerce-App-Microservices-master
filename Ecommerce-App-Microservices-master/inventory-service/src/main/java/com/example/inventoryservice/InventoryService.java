package com.example.inventoryservice;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class InventoryService {

    @Autowired
    InventoryRepo inventoryRepo;

    @SneakyThrows
    public boolean fetchDetails(String skucode, Integer quantity)  {
      log.info("Wait started");
    //  Thread.sleep(5000);
      log.info("Wait ended");
        return inventoryRepo.existsBySkuCodeAndQuantityGreaterThanEqual(skucode,quantity);
    }
}

