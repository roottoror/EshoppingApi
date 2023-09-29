package com.restdemo.api.service;


import com.restdemo.api.entity.Product;

public interface ProductService {
    void persistProduct(Product product);
        Product getProduct(Long id);


}
