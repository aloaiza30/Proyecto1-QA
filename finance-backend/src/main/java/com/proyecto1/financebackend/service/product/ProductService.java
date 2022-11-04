package com.proyecto1.financebackend.service.product;

import com.proyecto1.financebackend.model.Product;

import java.util.List;

// Defining the methods that the class that implements this interface will have to implement.
public interface ProductService {
    public Product saveProduct(Product product);
    public List<Product> getAllProducts();
}
