package com.proyecto1.financebackend.service.savings;

// This is importing the necessary libraries.
import com.proyecto1.financebackend.model.Savings;
import com.proyecto1.financebackend.repository.SavingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * It's a service class that implements the SavingsService interface and uses the SavingsRepository to
 * save and retrieve Savings objects
 */
@Service
public class SavingsServiceImpl implements SavingsService {
    // It's injecting the SavingsRepository into the SavingsServiceImpl class.
    @Autowired
    private SavingsRepository savingsRepository;

    /**
     * It takes a Savings object as a parameter, saves it to the database, and returns the saved
     * Savings object
     * 
     * @param savings The savings object that we want to save.
     * @return The savings object is being returned.
     */
    @Override
    public Savings saveSavings(Savings savings) {
        return savingsRepository.save(savings);
    }

    /**
     * This function returns a list of all the savings in the database
     * 
     * @return A list of all the savings accounts in the database.
     */
    @Override
    public List<Savings> getAllSavings() {
        return savingsRepository.findAll();
    }
}