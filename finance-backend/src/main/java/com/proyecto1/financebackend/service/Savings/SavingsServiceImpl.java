package com.proyecto1.financebackend.service.savings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SavingsServiceImpl implements SavingsService{
    @Autowired
    private SavingsRepository savingsRepository;

    @Override
    public Savings saveSavings(Savings saving) {
        return savingsRepository.save(savings);
    }

    @Override
    public List<Savings> getAllSavings() {
        return SavingsRepository.findAll();
    }
}
