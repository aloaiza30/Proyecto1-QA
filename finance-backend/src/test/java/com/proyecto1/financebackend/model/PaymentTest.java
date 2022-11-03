package com.proyecto1.financebackend.model;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Epic("Payment Model Tests")
@Feature("Get and Set Payment Atributes")

public class PaymentTest {
    Payment payment = new Payment();

    @BeforeEach
    public void setUp() {
        Category category = new Category(1, "Personal", 3000F, 100F);
        payment = new Payment(1, "iPhone", category, Date.valueOf(LocalDate.now()),
                1000F, 1000F, 0F, Status.PAID);
    }

    @Story("Get Payment Id")
    @Description("This test get the id of the payment")
    @Test
    public void getId() {
        assertEquals(payment.getId(), 1);
    }

    @Story("Get Payment Name")
    @Description("This test get the name of the payment")
    @Test
    public void getName() {
        assertEquals(payment.getName(), "iPhone");
    }

    @Story("Set Payment Name")
    @Description("This test set the name of the payment")
    @Test
    public void setName() {
        payment.setName("Dog pills");
        assertEquals(payment.getName(), "Dog pills");
    }

    @Story("Get payment Category")
    @Description("This test get the categories of the payment")
    @Test
    public void getCategory() {
        assertEquals(payment.getCategory().getName(), "Personal");
    }

    @Story("Get Payment Date")
    @Description("This test get the date of the payment")
    @Test
    public void getDate() {
        assertEquals(payment.getDate(), Date.valueOf(LocalDate.now()));
    }

    @Story("Set Payment Date")
    @Description("This test set the date of the payment")
    @Test
    public void setDate() {
        payment.setDate(Date.valueOf(LocalDate.of(2002, 1, 1)));
        assertEquals(payment.getDate(), Date.valueOf(LocalDate.of(2002, 1, 1)));
    }

    @Story("Get Paid")
    @Description("This test get paid")
    @Test
    public void getPaid() {
        assertEquals(payment.getPaid(), 1000F);

    }

    @Story("Set Paid")
    @Description("This test set paid")
    @Test
    public void setPaid() {
        payment.setPaid(500F);
        assertEquals(payment.getPaid(), 500F);

    }

    @Story("Get Billed")
    @Description("This test get billed")
    @Test
    public void getBilled() {
        assertEquals(payment.getBilled(), 1000F);

    }

    @Story("Set Billed")
    @Description("This test set billed")
    @Test
    public void setBilled() {
        payment.setBilled(1500F);
        assertEquals(payment.getBilled(), 1500F);

    }

    @Story("Get Received")
    @Description("This test get received")
    @Test
    public void getReceived() {
        assertEquals(payment.getReceived(), 0F);

    }

    @Story("Set Received")
    @Description("This test set received")
    @Test
    public void setReceived() {
        payment.setReceived(100F);
        assertEquals(payment.getReceived(), 100F);
    }

    @Story("Get Status")
    @Description("This test get status")
    @Test
    public void getStatus() {
        assertEquals(payment.getStatus(), Status.PAID);
    }

    @Story("Set Status")
    @Description("This test set status")
    @Test
    public void setStatus() {
        payment.setStatus(Status.PENDING);
        assertEquals(payment.getStatus(), Status.PENDING);
    }
}
