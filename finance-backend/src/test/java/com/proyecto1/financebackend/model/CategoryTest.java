package com.proyecto1.financebackend.model;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Epic("Category Model Tests")
@Feature("Get and Set User Atributes")
public class CategoryTest {
    Category category = new Category();

    @BeforeEach
    public void setUp() {
        category = new Category(1, "House", 1000F, 500F);
    }

    @Story("Get Category Id")
    @Description("This test get the id of the category")
    @Test
    public void getCategoryId() {
        assertEquals(category.getId(), 1);
    }

    @Story("Get Category Name")
    @Description("This test get the name of the Category")
    @Test
    public void getName() {
        assertEquals(category.getName(), "House");
    }

    @Story("Set Category Name")
    @Description("This test set the name of the category")
    @Test
    public void setName() {
        category.setName("Car");
        assertEquals(this.category.getName(), "Car");
    }

    @Story("Get Category MonthlyBudget")
    @Description("This test get the Category MonthlyBudget")
    @Test
    public void getMonthlyBudget() {
        assertEquals(category.getMonthlyBudget(), 1000F);
    }

    @Story("Set Category MonthlyBudget")
    @Description("This test set the MonthlyBudget")
    @Test
    public void setMonthlyBudget() {
        category.setMonthlyBudget(1200F);
        assertEquals(category.getMonthlyBudget(), 1200F);
    }

    @Story("Get Category Total Spent")
    @Description("This test get Total Spent")
    @Test
    public void getTotalSpent() {
        assertEquals(category.getTotalSpent(), 500F);
    }

    @Story("Set Category Total Spent")
    @Description("This test set the Total Spent")
    @Test
    public void setTotalSpent() {
        category.setTotalSpent(600F);
        assertEquals(category.getTotalSpent(), 600F);
    }

}
