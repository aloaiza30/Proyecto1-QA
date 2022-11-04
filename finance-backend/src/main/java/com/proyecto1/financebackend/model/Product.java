package com.proyecto1.financebackend.model;

// Importing the JPA annotations.
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * It's a class that represents a product
 */
// It's a JPA annotation that tells the application that this class is a JPA entity.
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // It's the attributes of the class.
    Integer id;
    String name;
    Float Price;
    byte[] photo;
    boolean Purchaseable;

    // A constructor.
    public Product() {
    }

    // Another constructor.
    public Product(Integer id, String name, Float price, byte[] photo, boolean purchaseable) {
        this.id = id;
        this.name = name;
        Price = price;
        this.photo = photo;
        Purchaseable = purchaseable;
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
     * This function returns the name of the person.
     * 
     * @return The name of the person.
     */
    public String getName() {
        return name;
    }

    /**
     * This function returns the price of the item
     * 
     * @return The price of the item.
     */
    public Float getPrice() {
        return Price;
    }

    /**
     * This function returns the photo of the person.
     * 
     * @return The photo is being returned.
     */
    public byte[] getPhoto() {
        return photo;
    }

    /**
     * This function returns a boolean value that indicates whether the item is purchaseable or not
     * 
     * @return The boolean value of the variable Purchaseable.
     */
    public boolean isPurchaseable() {
        return Purchaseable;
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
     * This function sets the price of the item
     * 
     * @param price The price of the item.
     */
    public void setPrice(Float price) {
        Price = price;
    }

    /**
     * This function sets the photo attribute of the object to the value of the photo parameter.
     * 
     * @param photo The photo to be uploaded.
     */
    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    /**
     * This function sets the purchaseable variable to the value of the parameter
     * 
     * @param purchaseable Whether or not the item is purchaseable.
     */
    public void setPurchaseable(boolean purchaseable) {
        Purchaseable = purchaseable;
    }
}
