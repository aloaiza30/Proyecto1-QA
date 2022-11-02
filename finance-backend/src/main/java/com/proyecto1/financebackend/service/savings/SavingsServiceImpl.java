package com.proyecto1.financebackend.service.Savings;

import com.proyecto1.financebackend.model.Savings;
import com.proyecto1.financebackend.repository.SavingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proyecto1.financebackend.service.savings.SavingsService;

import java.util.List;

@Service
public class SavingsServiceImpl implements SavingsService {
    @Autowired
    private SavingsRepository savingsRepository;

    @Override
    public Savings saveSavings(Savings savings) {
        return savingsRepository.save(savings);
    }

    @Override
    public List<Savings> getAllSavings() {
        return savingsRepository.findAll();
    }
}