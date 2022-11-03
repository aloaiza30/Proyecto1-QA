package com.proyecto1.financebackend.model;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@Epic("User Model Tests")
@Feature("Get and Set User Atributes")
public class UserTest {
    User user = new User();

    @BeforeEach
    public void setUp() throws IOException {
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

    @Story("Get User Id")
    @Description("This test get the id of the user")
    @Test
    public void getUserId() {
        assertEquals(user.getId(), 1);
    }

    @Story("Get User Name")
    @Description("This test get the name of the user")
    @Test
    public void getUserName() {
        assertEquals(user.getUserName(), "John");
    }

    @Story("Set User Name")
    @Description("This test set the name of the user")
    @Test
    public void setUserName() {
        user.setUserName("Jane");
        assertEquals(this.user.getUserName(), "Jane");
    }

    @Story("Get User Lastname")
    @Description("This test get the lastname of the user")
    @Test
    public void getUserLastname() {
        assertEquals(user.getLastName(), "Doe");
    }

    @Story("Set User Lastname")
    @Description("This test set the lastname of the user")
    @Test
    public void setUserLastname() {
        user.setLastName("Doee");
        assertEquals(this.user.getLastName(), "Doee");
    }

    @Story("Get User Email")
    @Description("This test get the email of the user")
    @Test
    public void getUserEmail() {
        assertEquals(user.getEmail(), "fake@email.com");
    }

    @Story("Set User Email")
    @Description("This test set the lastname of the user")
    @Test
    public void setUserEmail() {
        user.setLastName("email@fake.com");
        assertEquals(this.user.getLastName(), "email@fake.com");
    }


    @Story("Get User Password")
    @Description("This test get the password of the user")
    @Test
    public void getUserPassword() {
        assertEquals(user.getPassword(), "password");
    }

    @Story("Set User Password")
    @Description("This test set the password of the user")
    @Test
    public void setUserPassword() {
        user.setPassword("drowssap");
        assertEquals(this.user.getPassword(), "drowssap");
    }


    @Story("Get User Categories")
    @Description("This test get the categories of the user")
    @Test
    public void getUserCategories() {
        assertAll(
                () -> assertEquals(user.getCategories().stream().findFirst().get().getId(), 1),
                () -> assertEquals(user.getCategories().stream().findFirst().get().getName(), "House"),
                () -> assertEquals(user.getCategories().stream().findFirst().get().getTotalSpent(), 500F)
        );
    }

    @Story("Set User Categories")
    @Description("This test set the categories of the user")
    @Test
    public void setUserCategories() {
        List<Category> categories = new ArrayList<Category>();
        categories.add(new Category(1, "Cookies", 100F, 50F));
        categories.add(new Category(2, "Cake", 200F, 80F));
        categories.add(new Category(3, "Sports", 300F, 10F));
        user.setCategories(categories);
        assertSame(user.getCategories(), categories);
    }

    @Story("Get User Savings")
    @Description("This test get the savings of the user")
    @Test
    public void getUserSavings() {
        assertAll(
                () -> assertEquals(user.getSavings().getId(), 1),
                () -> assertEquals(user.getSavings().getTotalSavings(), 10000F),
                () -> assertEquals(user.getSavings().getGoal(), 20000F)
                );
    }

    @Story("Set User Savings")
    @Description("This test set the savings of the user")
    @Test
    public void setUserSavings() {
        List<MonthlySavings> monthlySavingsList = new ArrayList<MonthlySavings>();
        monthlySavingsList.add(new MonthlySavings(1, Month.MARCH, 250F));
        monthlySavingsList.add(new MonthlySavings(2, Month.MAY, 750F));
        Savings savings = new Savings(1, 1000F, 2000F, monthlySavingsList);
        user.setSavings(savings);
        assertSame(user.getSavings(), savings);
    }

    @Story("Get User Payments")
    @Description("This test get the payments of the user")
    @Test
    public void getUserPayments() {
        assertAll(
                () -> assertEquals(user.getPayments().stream().findFirst().get().getId(), 1),
                () -> assertEquals(user.getPayments().stream().findFirst().get().getName(), "iPhone"),
                () -> assertEquals(user.getPayments().stream().findFirst().get().getPaid(), 1000F),
                () -> assertEquals(user.getPayments().stream().findFirst().get().getBilled(), 1000F),
                () -> assertEquals(user.getPayments().stream().findFirst().get().getReceived(), 0F)
        );
    }

    @Story("Set User Payments")
    @Description("This test set the payments of the user")
    @Test
    public void setUserPayments() {
        Category category = new Category(1, "Personal", 100F, 200F);
        List<Payment> payments = new ArrayList<Payment>();
        payments.add(new Payment(1, "iPad", category, Date.valueOf(LocalDate.now()),
                400F, 200F, 0F, Status.PENDING));
        user.setPayments(payments);
        assertSame(user.getPayments(), payments);
    }

    @Story("Get User Categories")
    @Description("This test get the categories of the user")
    @Test
    public void getUserWishlist() {
        assertAll(
                () -> assertEquals(user.getWishlist().stream().findFirst().get().getId(), 1),
                () -> assertEquals(user.getWishlist().stream().findFirst().get().getName(), "PS5"),
                () -> assertEquals(user.getWishlist().stream().findFirst().get().getPrice(), 500F)
        );
    }

    @Story("Set User Wishlist")
    @Description("This test set the payments of the user")
    @Test
    public void setUserWishlist() throws IOException {
        List<Product> wishlist = new ArrayList<Product>();
        File photo = new File("src/test/java/com/proyecto1/financebackend/resources/testImage2.png");
        byte[] photoContent =  Files.readAllBytes(photo.toPath());
        wishlist.add(new Product(1, "XBOX", 300F, photoContent, false));
        user.setWishlist(wishlist);
        assertSame(user.getWishlist(), wishlist);
    }

}
