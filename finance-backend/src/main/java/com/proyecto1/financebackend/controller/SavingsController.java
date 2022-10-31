package com.proyecto1.financebackend.controller;

import com.proyecto1.financebackend.model.Payment;
import com.proyecto1.financebackend.model.Savings;
import com.proyecto1.financebackend.service.savings.SavingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class SavingsController {
    @Autowired
    private SavingsService savingsService;

    @PostMapping("/add")
    public ResponseEntity<String> add(@RequestBody Savings savings){
        Savings responseSavings = savingsService.saveSavings(savings);
        if (responseSavings == null) {
            return new ResponseEntity<>("Error while storing Savings", HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>("Saving added successfully", HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public List<Savings> getAll() {
        return savingsService.getAllSavings();
    }
}
