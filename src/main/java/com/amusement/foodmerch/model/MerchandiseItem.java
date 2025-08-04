package com.amusement.foodmerch.model;

import jakarta.persistence.*;

@Entity
public class MerchandiseItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double price;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}
public Long getId() {
    return id;
}

public void setId(Long id) {
    this.id = id;
}




}
