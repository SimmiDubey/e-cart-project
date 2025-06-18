
package com.example.e_Cart.project.dto;

import com.example.e_Cart.project.entity.User;
import com.example.e_Cart.project.entity.Product;
import java.util.Date;

public class OrderResponse {

    private int orderId;
    private User user;
    private Product product;
    private int quantity;
    private double totalAmount;
    private String status;


    public OrderResponse(int orderId, User user, Product product, int quantity, double totalAmount, String status) {
        this.orderId = orderId;
        this.user = user;
        this.product = product;
        this.quantity = quantity;
        this.totalAmount = totalAmount;
        this.status = status;

    }

    // Getters and Setters


    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}
