package com.ecommerce.practice.productService.service.impl;

import com.ecommerce.practice.productService.entity.Product;
import com.ecommerce.practice.productService.repository.ProductRepository;
import com.ecommerce.practice.productService.service.ProductInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ProductServiceImpl implements ProductInterface {

    @Autowired
    ProductRepository productRepository;

    @Override
    public void saveProducts(Product product) {
        log.info("calling save products methods"+product);
        productRepository.save(product);

    }

    @Override
    public List<Product> getDetails() {
        return productRepository.findAll();
    }

    @Override
    public Product getDetailsById(Integer id) {
        Optional<Product> product = productRepository.findById(id);
        if(product.isPresent()){
            return product.get();
        }
        else{
            return null;
        }

    }
}
