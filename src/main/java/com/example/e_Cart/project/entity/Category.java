package com.example.e_Cart.project.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
@Entity
public class Category {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String description;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<Product>products=new ArrayList<>();

    @OneToOne(mappedBy = "category",cascade = CascadeType.ALL)
    private Stock stock;

    public Category() {
    }

    public Category(int id, String title, String description, List<Product> products,Stock stock) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.products = products;
        this.stock=stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }
}
