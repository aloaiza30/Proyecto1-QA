package com.proyecto1.financebackend.service;

import com.proyecto1.financebackend.model.*;
import com.proyecto1.financebackend.service.payment.PaymentService;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@SpringBootTest
@Epic("Payment Service Tests")
@Feature("Payment database data administration")
public class PaymentServiceTest {
    @Autowired
    PaymentService paymentService;

    static Payment payment1 = new Payment();

    @BeforeAll
    public static void SetUp() {
        Category category1 = new Category(1, "Personal", 2000F, 1000F);
        payment1 = new Payment(1, "iPhone", category1, Date.valueOf(LocalDate.now()),
                1000F, 1000F, 0F, Status.PAID);
    }

    @Story("Get All Payments from Database")
    @Description("This test will save payments in the database")
    @Test
    public void savePayments() throws IOException {
        Category category2 = new Category(1, "Personal", 2000F, 1000F);
        Payment payment2 = new Payment(2, "iPad", category2, Date.valueOf(LocalDate.now()),
                800F, 500F, 0F, Status.PENDING);
        paymentService.savePayment(payment1);
        paymentService.savePayment(payment2);
        List<Payment> categories =  paymentService.getAllPayments();
        assertEquals(categories.toArray().length, 2);
    }

    @Story("Get All Payments Entity")
    @Description("This test will save payments in the database")
    @Test
    public void getAllPayments() {
        paymentService.savePayment(payment1);
        List<Payment> categories =  paymentService.getAllPayments();
        assertEquals(categories.stream().findFirst().get().getName(), "iPhone");
    }

}
