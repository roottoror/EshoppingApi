package com.restdemo.api.service;

import com.restdemo.api.entity.Product;
import com.restdemo.api.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void persistProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public Product getProduct(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if(product.isEmpty()){
            throw new EntityNotFoundException();
        }
        return product.get();
    }
}
