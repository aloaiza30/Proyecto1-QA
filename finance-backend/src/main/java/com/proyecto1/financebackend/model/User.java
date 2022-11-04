package com.proyecto1.financebackend.model;

// This is importing the necessary libraries for the class to work.
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

/**
 * A user class that has a list of categories, a list of payments, a list of products in his
 * wishlist and a savings account
 */
// A JPA annotation that marks the class as an entity.
@Entity
// Telling the database that the table name is users.
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // This is the class that represents the user. It has all the necessary attributes
    // to represent a user.
    Integer id;
    String userName;
    String lastName;
    String email;
    String password;
    Float monthlyEarnings;
    @OneToOne(cascade = CascadeType.ALL)
    Savings savings;
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.ALL)
    List<Category> categories;
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.ALL)
    List<Payment> payments;
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.ALL)
    List<Product> wishlist;

    // A constructor.
    public User() {
    }

    // Another constructor.
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

    /**
     * This function returns the id of the object
     * 
     * @return The id of the object.
     */
    public Integer getId() {
        return id;
    }

    /**
     * This function returns the userName of the user
     * 
     * @return The userName variable is being returned.
     */
    public String getUserName() {
        return userName;
    }

    /**
     * This function sets the userName variable to the value of the name parameter.
     * 
     * @param name The name of the user.
     */
    public void setUserName(String name) {
        this.userName = name;
    }

    /**
     * This function returns the last name of the person.
     * 
     * @return The last name of the person.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * This function sets the last name of the person.
     * 
     * @param lastName The last name of the user.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * This function returns the password of the user
     * 
     * @return The password
     */
    public String getPassword() {
        return password;
    }

    /**
     * This function sets the password of the user.
     * 
     * @param password of the user.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * This function returns the monthly earnings of the user
     * 
     * @return The monthlyEarnings variable is being returned.
     */
    public Float getMonthlyEarnings() {
        return monthlyEarnings;
    }

    /**
     * This function sets the monthly earnings of the user
     * 
     * @param monthlyEarnings The monthly earnings of the user.
     */
    public void setMonthlyEarnings(Float monthlyEarnings) {
        this.monthlyEarnings = monthlyEarnings;
    }

    /**
     * This function returns the email of the user
     * 
     * @return The email address of the user.
     */
    public String getEmail() {
        return email;
    }

    /**
     * This function sets the email of the user
     * 
     * @param email The email address of the user.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * This function returns a list of categories.
     * 
     * @return A list of categories.
     */
    public List<Category> getCategories() {
        return categories;
    }

    /**
     * This function sets the categories of the product
     * 
     * @param categories The list of categories that the user has selected.
     */
    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    /**
     * This function returns the savings object.
     * 
     * @return The savings object.
     */
    public Savings getSavings() {
        return savings;
    }

    /**
     * This function sets the savings variable to the savings parameter.
     * 
     * @param savings The savings account that the user wants to deposit money into.
     */
    public void setSavings(Savings savings) {
        this.savings = savings;
    }

    /**
     * This function returns a list of payments.
     * 
     * @return A list of payments.
     */
    public List<Payment> getPayments() {
        return payments;
    }

    /**
     * This function sets the payments of the customer
     * 
     * @param payments A list of Payment objects.
     */
    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }


    /**
     * This function returns the wishlist of the user
     * 
     * @return A list of products.
     */
    public List<Product> getWishlist() {
        return wishlist;
    }

    /**
     * This function sets the wishlist of the user to the wishlist passed in as a parameter
     * 
     * @param wishlist The list of products that the user has added to their wishlist.
     */
    public void setWishlist(List<Product> wishlist) {
        this.wishlist = wishlist;
    }
}
