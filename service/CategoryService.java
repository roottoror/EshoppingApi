package com.restdemo.api.service;

import com.restdemo.api.entity.Category;

public interface CategoryService {
    void persistCategory(Category category);
    Category getCategory(Long id);
}
