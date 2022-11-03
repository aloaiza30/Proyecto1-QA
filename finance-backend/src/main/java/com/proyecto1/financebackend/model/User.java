package com.proyecto1.financebackend.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String userName;
    String lastName;
    String email;
    String password; // ToDo Hash Password
    Float monthlyEarnings;
    @OneToOne(cascade = CascadeType.ALL)
    Savings savings;
    @OneToMany(cascade = CascadeType.ALL)
    List<Category> categories;
    @OneToMany(cascade = CascadeType.ALL)
    List<Payment> payments;
    @OneToMany(cascade = CascadeType.ALL)
    List<Product> wishlist;

    public User() {
    }

    public User(Integer id, String userName, String lastName, String email, String password, Float monthlyEarnings,
                Savings savings, List<Category> categories, List<Payment> payments, List<Product> wishlist) {
        this.id = id;
        this.userName = userName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.monthlyEarnings = monthlyEarnings;
        this.savings = savings;
        this.categories = categories;
        this.payments = payments;
        this.wishlist = wishlist;
    }

    public Integer getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String name) {
        this.userName = name;
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

    public void setPassword(String password) {
        this.password = password;
    }

    public Float getMonthlyEarnings() {
        return monthlyEarnings;
    }

    public void setMonthlyEarnings(Float monthlyEarnings) {
        this.monthlyEarnings = monthlyEarnings;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public Savings getSavings() {
        return savings;
    }

    public void setSavings(Savings savings) {
        this.savings = savings;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }


    public List<Product> getWishlist() {
        return wishlist;
    }

    public void setWishlist(List<Product> wishlist) {
        this.wishlist = wishlist;
    }
}
