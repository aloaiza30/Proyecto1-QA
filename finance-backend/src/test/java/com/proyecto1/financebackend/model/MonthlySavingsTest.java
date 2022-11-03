package com.proyecto1.financebackend.model;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
@Epic("MonthlySavings Model Tests")
@Feature("Get and Set MonthlySavings Atributes")

public class MonthlySavingsTest {
    MonthlySavings monthlySavings = new MonthlySavings();

    @BeforeEach
    public void setUp() {
        monthlySavings = new MonthlySavings(1, Month.JANUARY, 2500F);
    }

    @Story("Get MonthlySavings Id")
    @Description("This test get the id of the MonthlySavings")
    @Test
    public void getId() {
        assertEquals(monthlySavings.getId(), 1);
    }

    @Story("Set MonthlySavings Id")
    @Description("This test set the id of the monthlySavings")
    @Test
    public void setId() {
        monthlySavings.setId(2);
        assertEquals(monthlySavings.getId(), 2);
    }

    @Story("get Month")
    @Description("This test Get the id of the month")
    @Test
    public void getMonth() {
        assertEquals(monthlySavings.getMonth(), Month.JANUARY);
    }

    @Story("Set Month")
    @Description("This test set the id of the month")
    @Test
    public void setMonth() {
        monthlySavings.setMonth(Month.FEBRUARY);
        assertEquals(monthlySavings.getMonth(), Month.FEBRUARY);

    }

    @Story("get MonthlySavings")
    @Description("This test set the MonthlySavings")
    @Test
    public void getMonthlySavings() {
        assertEquals(monthlySavings.getMonthlySavings(), 2500F);

    }

    @Story("set MonthlySavings")
    @Description("This test set the MonthlySavings")
    @Test
    public void setMonthlySavings() {
        monthlySavings.setMonthlySavings(3000F);
        assertEquals(monthlySavings.getMonthlySavings(), 3000F);

    }

}