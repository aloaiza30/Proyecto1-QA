package com.proyecto1.financebackend.service;

import com.proyecto1.financebackend.model.*;
import com.proyecto1.financebackend.service.savings.SavingsService;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Epic("Savings Service Tests")
@Feature("Savings database data administration")
public class SavingsServiceTest {
    @Autowired
    SavingsService savingsService;

    static Savings savings1 = new Savings();

    @BeforeAll
    public static void SetUp() throws IOException {
        List<MonthlySavings> monthlySavingsList = new ArrayList<MonthlySavings>();
        monthlySavingsList.add(new MonthlySavings(1, Month.JANUARY, 2500F));
        monthlySavingsList.add(new MonthlySavings(2, Month.FEBRUARY, 7500F));
        savings1 = new Savings(1, 10000F, 20000F, monthlySavingsList);
    }

    @Story("Save Savings")
    @Description("This test will save savings in the database")
    @Test
    public void saveSavings() {
        List<MonthlySavings> monthlySavingsList = new ArrayList<MonthlySavings>();
        monthlySavingsList.add(new MonthlySavings(3, Month.MARCH, 3000F));
        monthlySavingsList.add(new MonthlySavings(4, Month.APRIL, 10000F));
        Savings savings2 = new Savings(2, 10000F, 20000F, monthlySavingsList);
        savingsService.saveSavings(savings1);
        savingsService.saveSavings(savings2);
        List<Savings> savings =  savingsService.getAllSavings();
        assertEquals(savings.toArray().length, 2);
    }

    @Story("Get All Savings")
    @Description("This test will get all savings in the database")
    @Test
    public void getAllSavings() {
        savingsService.saveSavings(savings1);
        List<Savings> savings =  savingsService.getAllSavings();
        assertEquals(savings.stream().findFirst().get().getTotalSavings(), 10000F);
    }

}
