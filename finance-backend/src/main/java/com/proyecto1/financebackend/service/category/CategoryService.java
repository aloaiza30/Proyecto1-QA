package com.proyecto1.financebackend.service.category;

import com.proyecto1.financebackend.model.Category;

import java.util.List;

// Defining the methods that the class that implements this interface will have to implement.
public interface CategoryService {
    public Category saveCategory(Category category);
    public List<Category> getAllCategories();
}
