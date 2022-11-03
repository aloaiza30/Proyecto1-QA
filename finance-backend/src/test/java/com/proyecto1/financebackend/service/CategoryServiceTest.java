package com.proyecto1.financebackend.service;

import com.proyecto1.financebackend.model.*;
import com.proyecto1.financebackend.service.category.CategoryService;
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
import java.util.List;

@SpringBootTest
@Epic("Category Service Tests")
@Feature("Category database data administration")
public class CategoryServiceTest {
    @Autowired
    CategoryService categoryService;

    static Category category1 = new Category();

    @BeforeAll
    public static void SetUp() throws IOException {
        category1 = new Category(1, "House", 1000F, 500F);
    }

    @Story("Get All Categories")
    @Description("This test will save a category in the database")
    @Test
    public void saveCategories() {
        Category category2 = new Category(2, "Car", 2000F, 800F);
        categoryService.saveCategory(category1);
        categoryService.saveCategory(category2);
        List<Category> categories =  categoryService.getAllCategories();
        assertEquals(categories.toArray().length, 3);
    }

    @Story("Get All Categories Entity")
    @Description("This test will save a user in the database")
    @Test
    public void getAllCategories() {
        categoryService.saveCategory(category1);
        List<Category> categories =  categoryService.getAllCategories();
        assertEquals(categories.stream().findFirst().get().getName(), "Car");
    }

}
