package com.example.inventoryservice;



import lombok.*;

import jakarta.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "t_inventory")
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String skuCode;
    private Integer quantity;
}
