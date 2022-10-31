package com.proyecto1.financebackend.controller;

import com.proyecto1.financebackend.model.Category;
import com.proyecto1.financebackend.model.Product;
import com.proyecto1.financebackend.service.category.CategoryService;
import com.proyecto1.financebackend.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@CrossOrigin

public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/add")
    public ResponseEntity<String> add(@RequestBody Product product){
        Product responseProduct = productService.saveProduct(product);
        if (responseProduct == null) {
            return new ResponseEntity<>("Error while saving product", HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>("Product added successfully", HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public List<Product> getAll() {
        return productService.getAllProducts();
    }
}
