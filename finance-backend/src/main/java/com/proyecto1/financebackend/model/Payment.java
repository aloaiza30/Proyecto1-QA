package com.proyecto1.financebackend.model;

import javax.persistence.*;
import java.util.Date;

/**
 * It's a class that represents a payment
 */
// It's a JPA annotation that marks the class as an entity.
@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Payment class atributes
    Integer id;
    String name;
    @OneToOne(cascade = CascadeType.ALL)
    Category category;
    Date date;
    Float paid;
    Float billed;
    Float received;
    @Enumerated(EnumType.ORDINAL)
    Status status;

    // A constructor.
    public Payment() {
    }

    // Another constructor.
    public Payment(Integer id, String name, Category category, Date date, Float paid, Float billed, Float received, Status status) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.date = date;
        this.paid = paid;
        this.billed = billed;
        this.received = received;
        this.status = status;
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
     * This function returns the name of the payment.
     * 
     * @return The name of the payment.
     */
    public String getName() {
        return name;
    }

    /**
     * This function sets the name of the object to the value of the parameter.
     * 
     * @param name The name of the parameter.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This function returns the category of the product.
     * 
     * @return The category object.
     */
    public Category getCategory() {
        return category;
    }

    /**
     * The function sets the category of the product
     * 
     * @param category The category that the product belongs to.
     */
    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     * This function returns the date.
     * 
     * @return The date of the event.
     */
    public Date getDate() {
        return date;
    }

    /**
     * This function sets the date of the object.
     * 
     * @param date The date of the event
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * > This function returns the value of the paid variable
     * 
     * @return The value of the paid variable.
     */
    public Float getPaid() {
        return paid;
    }

    /**
     * This function sets the value of the paid variable to the value of the paid parameter
     * 
     * @param paid The amount paid by the customer.
     */
    public void setPaid(Float paid) {
        this.paid = paid;
    }

    /**
     * This function returns the value of the variable billed
     * 
     * @return The value of the variable billed.
     */
    public Float getBilled() {
        return billed;
    }

    /**
     * This function sets the value of the variable billed to the value of the parameter billed
     * 
     * @param billed The amount billed for the invoice.
     */
    public void setBilled(Float billed) {
        this.billed = billed;
    }

    /**
     * This function returns the value of the received variable
     * 
     * @return The value of the variable received.
     */
    public Float getReceived() {
        return received;
    }

    /**
     * This function sets the value of the received variable to the value of the received parameter
     * 
     * @param received The amount of money received from the customer.
     */
    public void setReceived(Float received) {
        this.received = received;
    }

    /**
     * Returns the status of the current game.
     * 
     * @return The status of the order.
     */
    public Status getStatus() {
        return status;
    }

    /**
     * This function sets the status of the object to the status passed in.
     * 
     * @param status The status of the response.
     */
    public void setStatus(Status status) {
        this.status = status;
    }
}
