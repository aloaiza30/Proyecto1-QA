package com.proyecto1.financebackend.repository;

// Importing the Category class and the JpaRepository interface.
import com.proyecto1.financebackend.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Creating a repository for the Category class.
@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
