package com.example.inventoryservice;

import io.micrometer.observation.annotation.Observed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Observed
public interface InventoryRepo extends JpaRepository<Inventory,Long> {
    boolean existsBySkuCodeAndQuantityGreaterThanEqual(String skuCode,Integer quantity);
}
