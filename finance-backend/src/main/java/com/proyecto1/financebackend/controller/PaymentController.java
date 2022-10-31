package com.proyecto1.financebackend.controller;

import com.proyecto1.financebackend.model.Payment;
import com.proyecto1.financebackend.service.payment.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment")
@CrossOrigin
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping("/add")
    public ResponseEntity<String> add(@RequestBody Payment payment){
        Payment responsePayment = paymentService.savePayment(payment);
        if (responsePayment == null) {
            return new ResponseEntity<>("Error while saving payment", HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>("Payment added successfully", HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public List<Payment> getAll() {
        return paymentService.getAllPayments();
    }
}
