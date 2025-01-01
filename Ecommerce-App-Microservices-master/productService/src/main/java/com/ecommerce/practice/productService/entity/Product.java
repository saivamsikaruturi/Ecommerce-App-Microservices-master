package com.ecommerce.practice.productService.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "product")
@Getter
@Setter
@ToString
public class Product {
    @Id
    private Integer id;
    private String description;
    private String name;
    private Integer price;

}
