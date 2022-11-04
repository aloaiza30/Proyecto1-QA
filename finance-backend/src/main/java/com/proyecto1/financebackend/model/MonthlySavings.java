package com.proyecto1.financebackend.model;

// This is importing the necessary libraries to create the entity.
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.Month;


/**
 * A class that represents a monthly savings amount for a given month
 */
// A JPA annotation that marks the class as an entity.
@Entity
public class MonthlySavings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // The class attributes.
    Integer id;
    Month month;
    Float monthlySavings;

    // A constructor.
    public MonthlySavings() {
    }

    // Another constructor.
    public MonthlySavings(Integer id, Month month, Float monthlySavings) {
        this.id = id;
        this.month = month;
        this.monthlySavings = monthlySavings;
    }

    /**
     * > This function returns the id of the object
     * 
     * @return The id of the object.
     */
    public Integer getId() {
        return id;
    }

    /**
     * This function sets the id of the object to the id passed in.
     * 
     * @param id The id of the object.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This function returns the month of the year.
     * 
     * @return The month of the year.
     */
    public Month getMonth() {
        return month;
    }

    /**
     * This function sets the month of the year.
     * 
     * @param month The month of the year.
     */
    public void setMonth(Month month) {
        this.month = month;
    }

    /**
     * This function returns the monthly savings of the user
     * 
     * @return The monthlySavings variable is being returned.
     */
    public Float getMonthlySavings() {
        return monthlySavings;
    }

    /**
     * This function sets the monthly savings of the user
     * 
     * @param monthlySavings The amount of money you save each month.
     */
    
    public void setMonthlySavings(Float monthlySavings) {
        this.monthlySavings = monthlySavings;
    }
}
