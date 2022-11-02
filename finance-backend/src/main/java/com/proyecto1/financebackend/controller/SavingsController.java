package com.proyecto1.financebackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class SavingsController {
    // To Do
    //    @Autowired
    //    private MonthlySavingsService monthlySavingsService;
    //
    //    @PostMapping("/add")
    //    public ResponseEntity<String> add(@RequestBody MonthlySavings monthlySavings){
    //        MonthlySavings responseMonthlySavings = monthlySavingsService.saveSavings(monthlySavings);
    //        if (responseMonthlySavings == null) {
    //            return new ResponseEntity<>("Error while storing Savings", HttpStatus.CONFLICT);
    //        }
    //        return new ResponseEntity<>("Saving added successfully", HttpStatus.OK);
    //    }
    //
    //    @GetMapping("/getAll")
    //    public List<MonthlySavings> getAll() {
    //        return monthlySavingsService.getAllSavings();
    //    }
}
