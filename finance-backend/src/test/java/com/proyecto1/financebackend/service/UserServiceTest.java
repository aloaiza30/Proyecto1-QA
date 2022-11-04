package com.proyecto1.financebackend.service;

import com.proyecto1.financebackend.model.*;
import com.proyecto1.financebackend.service.user.UserService;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Epic("User Service Tests")
@Feature("User database data administration")
public class UserServiceTest {
    @Autowired
    UserService userService;

    static User user = new User();

    @BeforeAll
    public static void SetUp() throws IOException {
        List<MonthlySavings> monthlySavingsList = new ArrayList<MonthlySavings>();
        monthlySavingsList.add(new MonthlySavings(1, Month.JANUARY, 2500F));
        monthlySavingsList.add(new MonthlySavings(2, Month.FEBRUARY, 7500F));
        List<Category> categories = new ArrayList<Category>();
        categories.add(new Category(1, "House", 1000F, 500F));
        categories.add(new Category(2, "Car", 2000F, 800F));
        categories.add(new Category(3, "Personal", 3000F, 100F));
        List<Payment> payments = new ArrayList<Payment>();
        payments.add(new Payment(1, "iPhone", categories.get(2), Date.valueOf(LocalDate.now()),
                1000F, 1000F, 0F, Status.PAID));
        List<Product> wishlist = new ArrayList<Product>();
        File photo = new File("src/test/java/com/proyecto1/financebackend/resources/testImage.png");
        byte[] photoContent =  Files.readAllBytes(photo.toPath());
        wishlist.add(new Product(1, "PS5", 500F, photoContent, true));
        Savings savings = new Savings(1, 10000F, 20000F, monthlySavingsList);
        user = new User(1, "John", "Doe", "fake@email.com", "password",
                12345F, savings, categories, payments, wishlist);
    }

    @Story("Save User Entity")
    @Description("This test will save a user in the database")
    @Order(1)
    @Test
    public void saveUser() {
        userService.saveUser(user);
        assertEquals(userService.getUserByEmail(user.getEmail()).get().getUserName(), "John");
    }

    @Story("Get User Categories")
    @Description("This test will get the user categories in the database")
    @Order(2)
    @Test
    public void getUserCategories() {
        Integer id = userService.getUserByEmail("fake@email.com").get().getId();
        Optional<List<Category>> categories = userService.getUserCategories(id);
        assertTrue(categories.get().stream().anyMatch(category -> Objects.equals(category.getName(), "House")));
    }

    @Story("Get User Savings")
    @Description("This test will get the user savings in the database")
    @Order(3)
    @Test
    public void getUserSavings() {
        Integer id = userService.getUserByEmail("fake@email.com").get().getId();
        Optional<Savings> savings = userService.getUserSavings(id);
        assertEquals(savings.get().getGoal(), 20000F);
    }

    @Story("Get User By Email")
    @Description("This test will get the user by email in the database")
    @Order(4)
    @Test
    public void getUserByEmail() {
        Optional<User> user1 = userService.getUserByEmail(user.getEmail());
        assertEquals(user1.get().getEmail(), "fake@email.com");
    }

    @Story("Get User By Email")
    @Description("This test will try to get the user by non existent email in the database")
    @Order(5)
    @Test
    public void getUserByNonExistentEmail() {
        Optional<User> user1 = userService.getUserByEmail("email@fake.com");
        assertFalse(user1.isPresent());
    }


    @Story("Get User By Id")
    @Description("This test will try to get the user by non existent id in the database")
    @Order(6)
    @Test
    public void getUserByNonExistentId() {
        Optional<User> user1 = userService.getUserById(1000);
        assertFalse(user1.isPresent());
    }

}
