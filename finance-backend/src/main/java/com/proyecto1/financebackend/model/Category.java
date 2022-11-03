package com.proyecto1.financebackend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String name;
    Float monthlyBudget;
    Float totalSpent;

    public Category() {
    }

    public Category(Integer id, String name, Float monthlyBudget, Float totalSpent) {
        this.id = id;
        this.name = name;
        this.monthlyBudget = monthlyBudget;
        this.totalSpent = totalSpent;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getMonthlyBudget() {
        return monthlyBudget;
    }

    public Float getTotalSpent() {
        return totalSpent;
    }

    public void setTotalSpent(Float totalSpent) {
        this.totalSpent = totalSpent;
    }

    public void setMonthlyBudget(Float monthlyBudget) {
        this.monthlyBudget = monthlyBudget;
    }

    public Float getTotalSpent(float v) {
        return totalSpent;
    }

}
