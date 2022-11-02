package com.proyecto1.financebackend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.Month;

@Entity
public class Savings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    Month month;
    Float monthlySavings;
    Float totalSavings;

    public Savings() {
    }

    public Integer getId() {
        return id;
    }

    public Month getMonth() {
        return month;
    }

    public void setMonth(Month month) {
        this.month = month;
    }

    public Float getMonthlySavings() {
        return monthlySavings;
    }

    public void setMonthlySavings(Float monthlySavings) {
        this.monthlySavings = monthlySavings;
    }

    public Float getTotalSavings() {
        return totalSavings;
    }

    public void setTotalSavings(Float totalSavings) {
        this.totalSavings = totalSavings;
    }
}
