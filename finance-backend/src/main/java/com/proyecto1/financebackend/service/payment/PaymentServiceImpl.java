package com.proyecto1.financebackend.service.payment;

// This is importing the necessary libraries.
import com.proyecto1.financebackend.model.Payment;
import com.proyecto1.financebackend.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * It's a Spring service class that implements the PaymentService interface and uses the
 * PaymentRepository to save and retrieve payments
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    // It's injecting the PaymentRepository into the PaymentServiceImpl class.
    @Autowired
    private PaymentRepository paymentRepository;

    /**
     * It saves the payment to the database.
     * 
     * @param payment The payment object that we want to save.
     * @return Payment
     */
    @Override
    public Payment savePayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    /**
     * This function returns a list of all the payments in the database
     * 
     * @return A list of all the payments in the database.
     */
    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }
}
