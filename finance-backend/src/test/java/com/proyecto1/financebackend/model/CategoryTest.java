package com.proyecto1.financebackend.model;

import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CategoryTest {
        Category category = new Category();

    @Story("Get Category Id")
    @Description("This test get the id of the category")
    @Test
    public void getCategoryId() { assertEquals(category.getId(), 1);

    }

    @Story("Get Category Name")
    @Description("This test get the name of the Category")
    @Test
    public void getName() { assertEquals(category.getName(), "House");
    }

    @Story("Set Category Name")
    @Description("This test set the name of the category")
    @Test
    public void setName() {
        category.setName("House"); assertEquals(this.category.getName(), "House");
    }

    @Story("Get Category MonthlyBudget")
    @Description("This test get the Category MonthlyBudget")
    @Test
    public void getMonthlyBudget() {
        category.getMonthlyBudget(12F); assertEquals(this.category.getMonthlyBudget(12F), 12F);
    }

    @Story("Set Category MonthlyBudget")
    @Description("This test set the MonthlyBudget")
    @Test
    public void setMonthlyBudget() {
        category.setMonthlyBudget(12F); assertEquals(this.category.getMonthlyBudget(12F), 12F);
    }

    @Story("Get Category Total Spent")
    @Description("This test get Total Spent")
    @Test
    public void getTotalSpent() {
        category.getTotalSpent(12F); assertEquals(this.category.getTotalSpent(12F), 12F);
    }

    @Story("Set Category Total Spent")
    @Description("This test set the Total Spent")
    @Test
    public void setTotalSpent() {
        category.setTotalSpent(12F); assertEquals(this.category.getTotalSpent(12F), 12F);
    }




}
