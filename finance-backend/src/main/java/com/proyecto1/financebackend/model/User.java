package com.proyecto1.financebackend.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String name;
    String lastName;
    String password; // ToDo Hash Password
    Float monthlyEarnings;
    @OneToMany(cascade = CascadeType.REMOVE)
    List<Category> categories;
    @OneToMany(cascade = CascadeType.REMOVE)
    List<Payment> payments;
    @OneToMany(cascade = CascadeType.REMOVE)
    List<Savings> savings;
    @OneToMany(cascade = CascadeType.REMOVE)
    List<Product> wishlist;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public Float getMonthlyEarnings() {
        return monthlyEarnings;
    }

    public void setMonthlyEarnings(Float monthlyEarnings) {
        this.monthlyEarnings = monthlyEarnings;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    public List<Savings> getSavings() {
        return savings;
    }

    public void setSavings(List<Savings> savings) {
        this.savings = savings;
    }

    public List<Product> getWishlist() {
        return wishlist;
    }

    public void setWishlist(List<Product> wishlist) {
        this.wishlist = wishlist;
    }
}
