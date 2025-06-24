package com.example.e_Cart.project.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;


@Entity
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private int quantity;
    private int totalAmount;
    private String status;
    private Date orderDate;

    @ManyToOne
    private User user;

    @ManyToMany
    @JoinTable(
            name = "order_products",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> products;

    public Orders(){

    }
    public Orders(int id, int quantity, int totalAmount, String status,List<Product> products, User user, Date orderDate){
        this.id=id;


        this.quantity=quantity;
        this.totalAmount=totalAmount;
        this.status=status;
        this.user=user;
        this.orderDate=orderDate;
        this.products=products;
    }


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

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;

    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> product) {
        this.products = product;
    }
}
