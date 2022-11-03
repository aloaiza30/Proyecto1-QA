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
@Epic("Savings Model Tests")
@Feature("Get and Set Savings Atributes")

public class SavingsTest {
    Savings savings = new Savings();

    @BeforeEach
    public void setUp() {
        List<MonthlySavings> monthlySavingsList = new ArrayList<MonthlySavings>();
        monthlySavingsList.add(new MonthlySavings(1, Month.JANUARY, 2500F));
        monthlySavingsList.add(new MonthlySavings(2, Month.FEBRUARY, 7500F));
        Savings savings = new Savings(1, 10000F, 20000F, monthlySavingsList);
    }

    @Story("Get Savings Id")
    @Description("This test get the id of the savings")
    @Test
    public void getId() {
        assertEquals(savings.getId(), 1);
    }

    @Story("Set Savings Id")
    @Description("This test set the id of the savings")
    @Test
    public void setId() {
        assertEquals(savings.getId(), 1);
    }

    @Story("Get total Savings ")
    @Description("This test get the total of the Savings")
    @Test
    public void getTotalSavings() {
        savings.setTotalSavings();
        assertEquals(savings.getTotalSavings(), 12F);
    }

    @Story("Set total Savings ")
    @Description("This test set the total of the Savings")
    @Test
    public void setTotalSavings() {
        assertEquals(savings.getTotalSavings(), 12F);
    }

    @Story("Get Category Goal")
    @Description("This test get the name of the goal")
    @Test
    public void getGoal() {
        savings.getGoal();
        assertEquals(this.savings.getGoal(), 1F);
    }

    @Story("Set Category Goal")
    @Description("This test set the name of the goal")
    @Test
    public void setGoal() {
        savings.setGoal();
        assertEquals(this.savings.getGoal(), 1F);
    }

    @Story("Get Monthly Savings List")
    @Description("This test get Monthly Savings List")
    @Test
    public void getMonthlySavingsList() {
        savings.getMonthlySavingsList();
        assertEquals(this.savings.getMonthlySavingsList(), 4F);
    }

    @Story("Set Monthly Savings List")
    @Description("This test set Monthly Savings List")
    @Test
    public void setMonthlySavingsList() {
        savings.setMonthlySavingsList();
        assertEquals(this.savings.getMonthlySavingsList(), 4F);
    }




}