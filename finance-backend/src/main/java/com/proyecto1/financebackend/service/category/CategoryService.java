package com.proyecto1.financebackend.service.category;

import com.proyecto1.financebackend.model.Category;

import java.util.List;

public interface CategoryService {
    public Category saveCategory(Category category);
    public List<Category> getAllCategories();
}
