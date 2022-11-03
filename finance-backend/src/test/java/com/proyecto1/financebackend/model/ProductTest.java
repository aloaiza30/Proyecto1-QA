package com.proyecto1.financebackend.model;

import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductTest {

    Product product = new Product();

    @BeforeEach

    public void setUp() {

        List<Product> wishlist = new ArrayList<Product>();  }
        File photo = new File("src/test/java/com/proyecto1/financebackend/resources/testImage.png");


        @Story("Get Product Id")
        @Description("This test get the id of the product")
        @Test
        public void getId () {
            assertEquals(product.getId(), 1);
        }

        @Story("Get Product Name")
        @Description("This test get the name of the Product")
        @Test
        public void getName () {
            assertEquals(product.getName(), "Membresia");
        }

        @Story("Set Product Name")
        @Description("This test set the name of the product")
        @Test
        public void setName () {
            product.setName("Membresia");
            assertEquals(this.product.getName(), "Membresia");
        }

        @Story("Get Product photo")
        @Description("This test Get the name of the photo")
        @Test
        public void getPhoto () {
            product.getPhoto();
            assertEquals(this.product.getPhoto(), "Membresia");

        }

        @Story("Set Product photo")
        @Description("This test Set the name of the photo")
        @Test
        public void setPhoto () {
            product.setPhoto(Files.readAllBytes(photo.toPath());
            assertEquals(this.product.getPhoto(), Files.readAllBytes(photo.toPath());
        }

        @Story("Set Price")
        @Description("This test set price")
        @Test
        public void setPrice () {
            assertEquals(product.setPrice(0989F), "Membresia");
        }
    }
