package com.proyecto1.financebackend.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Savings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    Float totalSavings;
    Float goal;
    @OneToMany(cascade = CascadeType.ALL)
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

    public void setTotalSavings(Float totalSavings) {
        this.totalSavings = totalSavings;
    }

    public Float getGoal() {
        return goal;
    }

    public void setGoal(Float goal) {
        this.goal = goal;
    }

    public List<MonthlySavings> getMonthlySavingsList() {
        return monthlySavingsList;
    }

    public void setMonthlySavingsList(List<MonthlySavings> monthlySavingsList) {
        this.monthlySavingsList = monthlySavingsList;
    }
}
