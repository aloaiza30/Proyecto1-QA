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
        List<Payment> payments = new ArrayList<Payment>();
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
        assertEquals(payment.getName(), "Dog pills");
    }

    @Story("Set Payment Name")
    @Description("This test set the name of the payment")
    @Test
    public void setName() {
        payment.setName("Dog pills");
        assertEquals(this.payment.getName(), "Dog pills");
    }

    @Story("Get payment Categories")
    @Description("This test get the categories of the payment")
    @Test
    public void getCategory() {
        assertAll(
                () -> assertEquals(payment.getCategory().getId(), 1),
                () -> assertEquals(payment.getCategory().getName(), "Dog pills"),
                () -> assertEquals(payment.getCategory().getTotalSpent(12F), 500F)
        );
    }

    @Story("Get Payment Date")
    @Description("This test get the date of the payment")
    @Test
    public void getDate() {
        payment.getDate();
        assertEquals(this.payment.getDate(), Date.valueOf(LocalDate.now()));
    }

    @Story("Set Payment Date")
    @Description("This test set the date of the payment")
    @Test
    public void setDate() {
        payment.setDate(Date.valueOf(LocalDate.now()));
        assertEquals(this.payment.getDate(), 12);
    }

    @Story("Get Paid")
    @Description("This test get paid")
    @Test
    public void getPaid() {
        payment.getPaid();
        assertEquals(this.payment.getPaid(), 190F);

    }

    @Story("Set Paid")
    @Description("This test set paid")
    @Test
    public void setPaid() {
        payment.setPaid(128F);
        assertEquals(this.payment.getPaid(), 190F);

    }

    @Story("Get Billed")
    @Description("This test get billed")
    @Test
    public void getBilled() {
        payment.getBilled();
        assertEquals(this.payment.getBilled(), 190F);

    }

    @Story("Set Billed")
    @Description("This test set billed")
    @Test
    public void setBilled() {
        payment.setBilled(123F);
        assertEquals(this.payment.getBilled(), 123F);

    }

    @Story("Get Received")
    @Description("This test get received")
    @Test
    public void getReceived() {
        payment.getReceived();
        assertEquals(this.payment.getReceived(), 0F);

    }

    @Story("Set Received")
    @Description("This test set received")
    @Test
    public void setReceived() {
        payment.setReceived(0F);
        assertEquals(this.payment.getReceived(), 0F);
    }

    @Story("Get Status")
    @Description("This test get status")
    @Test
    public void getStatus() {
        payment.getStatus();
        assertEquals(this.payment.getStatus(), Status.PENDING);
    }

    @Story("Set Status")
    @Description("This test set status")
    @Test
    public void setStatus() {
        payment.setStatus(Status.PENDING);
        assertEquals(this.payment.getStatus(), Status.PENDING);
    }
}
