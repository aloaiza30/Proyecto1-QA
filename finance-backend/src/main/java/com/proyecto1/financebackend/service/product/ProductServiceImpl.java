package com.proyecto1.financebackend.service.product;

// This is importing the necessary libraries.
import com.proyecto1.financebackend.model.Product;
import com.proyecto1.financebackend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * It's a Spring service class that implements the ProductService interface and uses the
 * ProductRepository to save and retrieve products
 */
@Service
public class ProductServiceImpl implements ProductService {

    // It's injecting the ProductRepository into the ProductServiceImpl class.
    @Autowired
    private ProductRepository productRepository;

    /**
     * The function takes a product object as an argument, saves it to the database, and returns the
     * saved product object
     * 
     * @param product The product object that we want to save.
     * @return The product that was saved.
     */
    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    /**
     * The function returns a list of all products in the database
     * 
     * @return A list of all products in the database.
     */
    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
