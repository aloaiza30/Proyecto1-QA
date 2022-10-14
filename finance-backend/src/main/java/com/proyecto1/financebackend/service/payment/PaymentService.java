package com.proyecto1.financebackend.service.payment;

import com.proyecto1.financebackend.model.Payment;

import java.util.List;

public interface PaymentService {
    public Payment savePayment(Payment category);
    public List<Payment> getAllPayments();
}
