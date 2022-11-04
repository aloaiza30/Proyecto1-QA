package com.proyecto1.financebackend.repository;

// Importing the Product class, the JpaRepository class, and the Repository annotation.
import com.proyecto1.financebackend.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Creating a repository for the Product class.
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}