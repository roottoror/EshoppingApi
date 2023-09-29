package com.restdemo.api.controller;


import com.restdemo.api.entity.Product;
import com.restdemo.api.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@AllArgsConstructor
@RequestMapping(value = "/product/v1")
public class ProductController {
    ProductService productService;
    @GetMapping("/health/")
    public ResponseEntity<String> health(@RequestParam String name){
        return ResponseEntity.ok("Hello "+ name + ", product controller is on");
    }
    @PostMapping
    public ResponseEntity<String> persist(@RequestBody Product product){
        productService.persistProduct(product);
        return ResponseEntity.ok("Product is persisted");
    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> get(@PathVariable Long id) {
        Product product = productService.getProduct(id);
        return ResponseEntity.ok(product);
    }

    }
