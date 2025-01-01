package com.example.orderservice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class InventoryRequest {
    String skuCode;
   Integer quantity;
}
