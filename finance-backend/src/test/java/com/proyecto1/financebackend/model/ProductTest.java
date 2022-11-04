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
    public void setUp() throws IOException {
        File photo = new File("src/test/java/com/proyecto1/financebackend/resources/testImage.png");
        byte[] photoContent =  Files.readAllBytes(photo.toPath());
        product = new Product(1, "PS5", 500F, photoContent, true);

    }


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
        assertEquals(product.getName(), "PS5");
    }

    @Story("Set Product Name")
    @Description("This test set the name of the product")
    @Test
    public void setName () {
        product.setName("XBOX");
        assertEquals(this.product.getName(), "XBOX");
    }

    @Story("Set Product photo")
    @Description("This test Set the name of the photo")
    @Test
    public void setPhoto () throws IOException {
        File photo = new File("src/test/java/com/proyecto1/financebackend/resources/testImage2.png");
        byte[] photoContent =  Files.readAllBytes(photo.toPath());
        product.setPhoto(photoContent);
        assertEquals(product.getPhoto(), photoContent);
    }

    @Story("Get Price")
    @Description("This test get price")
    @Test
    public void getPrice () {
        assertEquals(product.getPrice(), 500F);
    }
    @Story("Set Price")
    @Description("This test set price")
    @Test
    public void setPrice () {
        product.setPrice(1000F);
        assertEquals(product.getPrice(), 1000F);
    }

    @Story("Get isPurchasable")
    @Description("This test get the isPurchasable flag")
    @Test
    public void getIsPurchasable () {
        assertEquals(product.isPurchaseable(), true);
    }

    @Story("Set isPurchasable")
    @Description("This test set isPurchasable flag")
    @Test
    public void setIsPurchasable () {
        product.setPurchaseable(false);
        assertEquals(product.isPurchaseable(), false);
    }
}
