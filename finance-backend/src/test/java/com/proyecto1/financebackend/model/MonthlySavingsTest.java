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
        List<MonthlySavings> monthlySavingsList = new ArrayList<MonthlySavings>();
        monthlySavingsList.add(new MonthlySavings(1, Month.JANUARY, 2500F));
        monthlySavingsList.add(new MonthlySavings(2, Month.FEBRUARY, 7500F));
        Savings savings = new Savings(1, 10000F, 20000F, monthlySavingsList);
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
        assertEquals(monthlySavings.getId(), 1);
    }

    @Story("get Month")
    @Description("This test Get the id of the month")
    @Test
    public void getMonth() {
        assertEquals(monthlySavings.getMonth(), 1);
    }

    @Story("Set Month")
    @Description("This test set the id of the month")
    @Test
    public void setMonth() {
        monthlySavings.setMonth(Month.JANUARY);
        assertEquals(monthlySavings.getMonth(), 1);

    }

    @Story("get MonthlySavings")
    @Description("This test set the MonthlySavings")
    @Test
    public void getMonthlySavings() {
        assertEquals(monthlySavings.getMonthlySavings(), 1F);

    }

    @Story("set MonthlySavings")
    @Description("This test set the MonthlySavings")
    @Test
    public void setMonthlySavings() {
        monthlySavings.setMonthlySavings(111F);
        assertEquals(monthlySavings.getMonthlySavings(), 1);

    }

}