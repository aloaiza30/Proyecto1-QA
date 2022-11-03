package com.proyecto1.financebackend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String name;
    Float Price;
    byte[] photo;
    boolean Purchaseable;

    public Product() {
    }

    public Product(Integer id, String name, Float price, byte[] photo, boolean purchaseable) {
        this.id = id;
        this.name = name;
        Price = price;
        this.photo = photo;
        Purchaseable = purchaseable;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Float getPrice() {
        return Price;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public boolean isPurchaseable() {
        return Purchaseable;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Float price) {
        Price = price;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public void setPurchaseable(boolean purchaseable) {
        Purchaseable = purchaseable;
    }
}
