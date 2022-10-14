package com.proyecto1.financebackend.controller;

import com.proyecto1.financebackend.model.Category;
import com.proyecto1.financebackend.service.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@CrossOrigin
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping("/add")
    public ResponseEntity<String> add(@RequestBody Category category){
        Category responseCategory = categoryService.saveCategory(category);
        if (responseCategory == null) {
            return new ResponseEntity<>("Error while saving category", HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>("Category added successfully", HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public List<Category> getAll() {
        return categoryService.getAllCategories();
    }
}
