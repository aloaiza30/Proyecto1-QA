package com.proyecto1.financebackend.repository;

import com.proyecto1.financebackend.model.Savings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SavingRepository extends JpaRepository<Savings, Integer> {
}