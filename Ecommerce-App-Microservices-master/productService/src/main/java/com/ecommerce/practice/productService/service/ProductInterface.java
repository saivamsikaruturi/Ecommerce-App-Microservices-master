package com.ecommerce.practice.productService.service;

import com.ecommerce.practice.productService.entity.Product;

import java.util.List;

public interface ProductInterface {

    void  saveProducts(Product product);

    List<Product> getDetails();

    Product getDetailsById(Integer id);
}
