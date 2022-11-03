package com.proyecto1.financebackend.service;

import com.proyecto1.financebackend.model.*;
import com.proyecto1.financebackend.service.product.ProductService;
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
import java.nio.file.Files;
import java.util.List;

@SpringBootTest
@Epic("Savings Service Tests")
@Feature("Savings database data administration")
public class ProductServiceTest {
    @Autowired
    ProductService productService;

    static Product product1 = new Product();

    @BeforeAll
    public static void SetUp() throws IOException {
        File photo1 = new File("src/test/java/com/proyecto1/financebackend/resources/testImage.png");
        byte[] photoContent1 =  Files.readAllBytes(photo1.toPath());
        product1 = new Product(1, "XBOX", 250F, photoContent1, false);
    }

    @Story("Save Savings")
    @Description("This test will save savings in the database")
    @Test
    public void saveProducts() throws IOException {
        File photo2 = new File("src/test/java/com/proyecto1/financebackend/resources/testImage2.png");
        byte[] photoContent2 =  Files.readAllBytes(photo2.toPath());
        Product product2 = new Product(2, "PS5", 500F, photoContent2, true);
        productService.saveProduct(product1);
        productService.saveProduct(product2);
        List<Product> products =  productService.getAllProducts();
        assertEquals(products.toArray().length, 2);
    }

    @Story("Get All Savings")
    @Description("This test will get all savings in the database")
    @Test
    public void getAllProducts() {
        productService.saveProduct(product1);
        List<Product> products =  productService.getAllProducts();
        assertEquals(products.stream().findFirst().get().getName(), "XBOX");
    }

}
