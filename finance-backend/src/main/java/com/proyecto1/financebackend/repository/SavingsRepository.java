package com.proyecto1.financebackend.repository;

// Importing the Category class and the JpaRepository interface.
import com.proyecto1.financebackend.model.Savings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
// Creating a repository for the Savings class.
public interface SavingsRepository extends JpaRepository<Savings, Integer> {
}