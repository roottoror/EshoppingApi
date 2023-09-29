package com.restdemo.api.controller;

import com.restdemo.api.service.CategoryService;
import com.restdemo.api.entity.Category;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@AllArgsConstructor
@RequestMapping(value = "/category/v1")
public class CategoryController {
    CategoryService categoryService;

    @GetMapping("/health/")
    public ResponseEntity<String> health(@RequestParam String name){
        return ResponseEntity.ok("Hello "+ name + ", category controller is on" );
    }

    @PostMapping
    public ResponseEntity<String> persist(@RequestBody Category category){
        categoryService.persistCategory(category);
        return ResponseEntity.ok("Category is persisted");
    }
    @GetMapping("/{id}")
    public ResponseEntity<Category> get(@PathVariable Long id){
        Category category =categoryService.getCategory(id);
        return ResponseEntity.ok(category);

    }

}
