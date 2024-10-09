package com.example;

import java.math.BigDecimal;

public class Car {
    private int id;
    private String make;
    private String model;
    private int year;
    private BigDecimal price;

    public Car(int id, String make, String model, int year, BigDecimal price) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.year = year;
        this.price = price;
    }

    public Car(String make, String model, int year, BigDecimal price) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.price = price;
    }

    // Getters and setters
    public int getId() { return id; }
    public String getMake() { return make; }
    public String getModel() { return model; }
    public int getYear() { return year; }
    public BigDecimal getPrice() { return price; }
}
