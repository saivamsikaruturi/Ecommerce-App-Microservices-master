package com.ecommerce.practice.productService.controller;


import com.ecommerce.practice.productService.entity.Product;
import com.ecommerce.practice.productService.service.ProductInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@Slf4j
public class ProductController {

    @Autowired
    ProductInterface productInterface;

    @PostMapping("/createProducts")
     public void createProducts(@RequestBody Product product){
        log.info("calling create products api");
      productInterface.saveProducts(product);
     }


     @GetMapping("/getAllProductDetails")
     public List<Product> getAllDetails(){
       return productInterface.getDetails();
     }

    @GetMapping("/getAllProductDetails/{id}")
    public Product getAllDetailsById(@PathVariable("id") Integer id){
        return productInterface.getDetailsById(id);
    }
}
