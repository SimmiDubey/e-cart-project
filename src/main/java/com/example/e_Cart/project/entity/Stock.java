package com.example.e_Cart.project.entity;

import jakarta.persistence.*;

@Entity
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int quantity;

    @OneToOne
    @JoinColumn(name = "category_id", unique = true, nullable = false)
    private Category category;

    // No-arg constructor
    public Stock() {}

    // All-arg constructor (excluding id, since it's auto-generated)
    public Stock(int quantity, Category category) {
        this.quantity = quantity;
        this.category = category;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
