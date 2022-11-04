package com.proyecto1.financebackend.repository;

// Importing the Payment class, the JpaRepository class, and the Repository class.
import com.proyecto1.financebackend.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Creating a repository for the Payment class.
@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {
}
