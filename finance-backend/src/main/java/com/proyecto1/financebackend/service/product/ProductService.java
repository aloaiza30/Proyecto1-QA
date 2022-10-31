package com.proyecto1.financebackend.service.product;

import com.proyecto1.financebackend.model.Product;

import java.util.List;

public interface ProductService {
    public Product saveProduct(Product product);
    public List<Product> getAllProducts();
}
