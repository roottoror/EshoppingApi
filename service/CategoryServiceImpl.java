package com.restdemo.api.service;

import com.restdemo.api.entity.Category;
import com.restdemo.api.repository.CategoryRepository;
import com.restdemo.api.service.CategoryService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void persistCategory(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public Category getCategory(Long id) {
        Optional<Category> category = categoryRepository.findById(id);
        if(category.isEmpty()){
            throw new EntityNotFoundException();
        }
        return category.get();
    }
}

