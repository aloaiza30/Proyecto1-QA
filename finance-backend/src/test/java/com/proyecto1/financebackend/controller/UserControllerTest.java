package com.proyecto1.financebackend.controller;

import com.proyecto1.financebackend.DTO.LoginDTO;
import com.proyecto1.financebackend.model.*;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Epic("User Controller Tests")
@Feature("User API Endpoints")
public class UserControllerTest {
    @Autowired
    UserController userController;
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

    @Story("Register User Endpoint")
    @Description("This test will execute the endpoint to register a user")
    @Order(1)
    @Test
    public void registerUserTest() {
        ResponseEntity<String> response =  userController.registerUser(
                new User(3, "Jane", "Doe", "jane@doe.com", "password",
                12345F, new Savings(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));
        assertEquals(response.getStatusCodeValue(), HttpStatus.OK.value());
    }

    @Story("Register User Endpoint")
    @Description("This test will execute the endpoint to register a user when it's already registered")
    @Order(1)
    @Test
    public void alreadyRegisteredUserTest() {
        userController.registerUser(user);
        ResponseEntity<String> response =  userController.registerUser(user);
        assertEquals(response.getStatusCodeValue(), HttpStatus.BAD_REQUEST.value());
    }

    @Story("Login Endpoint")
    @Description("This test will execute the endpoint to authenticate the user")
    @Order(2)
    @Test
    public void loginTest() {
        LoginDTO loginDTO = new LoginDTO("fake@email.com", "password");
        ResponseEntity<String> response =  userController.login(loginDTO);
        assertEquals(response.getStatusCodeValue(), HttpStatus.OK.value());
    }

    @Story("Login Endpoint")
    @Description("This test will execute the endpoint to authenticate the user")
    @Order(3)
    @Test
    public void unexistentUserLoginTest() {
        LoginDTO loginDTO = new LoginDTO("email@fake.com", "password");
        ResponseEntity<String> response =  userController.login(loginDTO);
        assertEquals(response.getStatusCodeValue(), HttpStatus.NOT_FOUND.value());
    }

    @Story("Login Endpoint")
    @Description("This test will execute the endpoint to authenticate the user")
    @Order(4)
    @Test
    public void unauthorizedLoginTest() {
        LoginDTO loginDTO = new LoginDTO("fake@email.com", "password1");
        ResponseEntity<String> response =  userController.login(loginDTO);
        assertEquals(response.getStatusCodeValue(), HttpStatus.UNAUTHORIZED.value());
    }

    @Story("Delete User Endpoint")
    @Description("This test will execute the endpoint to delete the user")
    @Order(5)
    @Test
    public void deleteUserTest() {
        userController.registerUser(
                new User(1, "Test", "Test", "test@test.com", "password",
                        12345F, new Savings(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));
        ResponseEntity<String> response =  userController.deleteUser(1);
        assertEquals(response.getStatusCodeValue(), HttpStatus.OK.value());
    }

    @Story("Delete User Endpoint")
    @Description("This test will execute the endpoint to delete an unexistent user")
    @Order(6)
    @Test
    public void unexistentUserDeleteTest() {
        ResponseEntity<String> response =  userController.deleteUser(1000);
        assertEquals(response.getStatusCodeValue(), HttpStatus.NOT_FOUND.value());
    }

}
