package com.proyecto1.financebackend.model;

// This is the import of the libraries that are going to be used in the class.
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

/**
 * Savings is a class that has an id, totalSavings, goal, and a list of MonthlySavings
 */
// A JPA annotation that marks the class as a persistent Java class.
@Entity
public class Savings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Creating the atributes that are going to be used in the class.
    Integer id;
    Float totalSavings;
    Float goal;
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<MonthlySavings> monthlySavingsList;

    // A constructor
    public Savings() {
    }

    // Another constructor
    public Savings(Integer id, Float totalSavings, Float goal, List<MonthlySavings> monthlySavingsList) {
        this.id = id;
        this.totalSavings = totalSavings;
        this.goal = goal;
        this.monthlySavingsList = monthlySavingsList;
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
     * This function returns the total savings of the user
     * 
     * @return The totalSavings variable is being returned.
     */
    public Float getTotalSavings() {
        return totalSavings;
    }

    /**
     * This function sets the total savings of the user
     * 
     * @param totalSavings The total amount of money saved by the user.
     */
    public void setTotalSavings(Float totalSavings) {
        this.totalSavings = totalSavings;
    }

    /**
     * This function returns the goal of the user
     * 
     * @return The goal of the user.
     */
    public Float getGoal() {
        return goal;
    }

    /**
     * This function sets the goal of the user to the value of the parameter goal.
     * 
     * @param goal The goal you want to achieve.
     */
    public void setGoal(Float goal) {
        this.goal = goal;
    }

    /**
     * This function returns a list of monthly savings
     * 
     * @return A list of MonthlySavings objects.
     */
    public List<MonthlySavings> getMonthlySavingsList() {
        return monthlySavingsList;
    }

    /**
     * This function sets the monthlySavingsList variable to the monthlySavingsList parameter
     * 
     * @param monthlySavingsList This is the list of MonthlySavings objects that will be displayed in
     * the table.
     */
    public void setMonthlySavingsList(List<MonthlySavings> monthlySavingsList) {
        this.monthlySavingsList = monthlySavingsList;
    }
}
