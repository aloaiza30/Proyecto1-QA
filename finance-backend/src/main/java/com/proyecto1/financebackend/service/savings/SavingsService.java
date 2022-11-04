package com.proyecto1.financebackend.service.savings;

import com.proyecto1.financebackend.model.Savings;

import java.util.List;

// An interface that defines the methods that will be implemented in the SavingsServiceImpl class.
public interface SavingsService {
    public Savings saveSavings(Savings savings);
    public List<Savings> getAllSavings();
}
