package com.proyecto1.financebackend.model;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@Entity
public class Savings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    Float totalSavings;
    Float goal;
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<MonthlySavings> monthlySavingsList;

    public Savings() {
    }

    public Savings(Integer id, Float totalSavings, Float goal, List<MonthlySavings> monthlySavingsList) {
        this.id = id;
        this.totalSavings = totalSavings;
        this.goal = goal;
        this.monthlySavingsList = monthlySavingsList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getTotalSavings() {
        return totalSavings;
    }

    public void setTotalSavings() {
        this.totalSavings = totalSavings;
    }

    public Float getGoal() {
        return goal;
    }

    public void setGoal() {
        this.goal = goal;
    }

    public List<MonthlySavings> getMonthlySavingsList() {
        return monthlySavingsList;
    }

    public void setMonthlySavingsList() {
        this.monthlySavingsList = monthlySavingsList;
    }
}
