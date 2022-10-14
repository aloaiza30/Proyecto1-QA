package com.proyecto1.financebackend.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String name;
    Date date;
    Float paid;
    Float billed;
    Float received;
    @Enumerated(EnumType.ORDINAL)
    Status status;

    public Payment() {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Float getPaid() {
        return paid;
    }

    public void setPaid(Float paid) {
        this.paid = paid;
    }

    public Float getBilled() {
        return billed;
    }

    public void setBilled(Float billed) {
        this.billed = billed;
    }

    public Float getReceived() {
        return received;
    }

    public void setReceived(Float received) {
        this.received = received;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
