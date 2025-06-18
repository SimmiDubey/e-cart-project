package com.example.e_Cart.project.entity;

import jakarta.persistence.*;

import java.util.Date;

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

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public Orders(){

    }
    public Orders(int id, int quantity, int totalAmount, String status,Product product, User user, Date orderDate){
        this.id=id;


        this.quantity=quantity;
        this.totalAmount=totalAmount;
        this.status=status;
        this.user=user;
        this.orderDate=orderDate;
        this.product=product;
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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
