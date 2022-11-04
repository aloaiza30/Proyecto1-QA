package com.proyecto1.financebackend.service.category;

// This is importing the necessary libraries.
import com.proyecto1.financebackend.model.Category;
import com.proyecto1.financebackend.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * It's a service class that implements the CategoryService interface and uses the CategoryRepository
 * to save and retrieve categories
 */
@Service
public class CategoryServiceImpl implements CategoryService{
    // It's injecting the CategoryRepository into the CategoryServiceImpl class.
    @Autowired
    private CategoryRepository categoryRepository;

    /**
     * It saves the category to the database.
     * 
     * @param category object that we want to save.
     * @return The category object is being returned.
     */
    @Override
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    /**
     * Get all categories from the database and return them as a list.
     * 
     * @return A list of all the categories in the database.
     */
    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}
