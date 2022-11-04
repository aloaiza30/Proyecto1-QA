package com.proyecto1.financebackend.model;

// This is the JPA annotation that tells Spring Boot that this is an entity class.
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * It's a class that represents a category of expenses
 */
// A JPA annotation that tells Spring Boot that this is an entity class.
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // The attributes of the class.
    Integer id;
    String name;
    Float monthlyBudget;
    Float totalSpent;

    // A constructor.
    public Category() {
    }

    // Another constructor.
    public Category(Integer id, String name, Float monthlyBudget, Float totalSpent) {
        this.id = id;
        this.name = name;
        this.monthlyBudget = monthlyBudget;
        this.totalSpent = totalSpent;
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
     * This function sets the name of the object to the value of the parameter.
     * 
     * @param name The name of the parameter.
     */
    public void setName(String name) {
        this.name = name;
    }

   /**
    * This function returns the monthly budget of the user
    * 
    * @return The monthly budget of the user.
    */
    public Float getMonthlyBudget() {
        return monthlyBudget;
    }

  /**
   * This function returns the total amount of money spent by the customer
   * 
   * @return The total amount spent by the customer.
   */
    public Float getTotalSpent() {
        return totalSpent;
    }

   /**
    * This function sets the totalSpent variable to the value of the totalSpent parameter
    * 
    * @param totalSpent The total amount of money spent by the customer.
    */
    public void setTotalSpent(Float totalSpent) {
        this.totalSpent = totalSpent;
    }

    /**
     * This function sets the monthly budget for the user.
     * 
     * @param monthlyBudget The monthly budget for the campaign.
     */
    public void setMonthlyBudget(Float monthlyBudget) {
        this.monthlyBudget = monthlyBudget;
    }
    /**
     * This function returns the total amount spent by the customer.
     * 
     * @param v The version of the API you're using.
     * @return The total amount spent by the customer.
     */

    public Float getTotalSpent(float v) {
        return totalSpent;
    }

}
