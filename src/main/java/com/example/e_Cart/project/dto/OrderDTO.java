package com.example.e_Cart.project.dto;

import java.util.List;

public class OrderDTO {

    private int quantity;
    private int totalAmount;
    private String status;
    private int userId;
    private List<Integer> productIds;

    public OrderDTO() {
    }

    public OrderDTO(int quantity, int totalAmount, String status, int userId, List<Integer> productIds) {
        this.quantity = quantity;
        this.totalAmount = totalAmount;
        this.status = status;
        this.userId = userId;
        this.productIds = productIds;
    }

    // Getters and Setters

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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<Integer> getProductIds() {
        return productIds;
    }

    public void setProductIds(List<Integer> productIds) {
        this.productIds = productIds;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "quantity=" + quantity +
                ", totalAmount=" + totalAmount +
                ", status='" + status + '\'' +
                ", userId=" + userId +
                ", productIds=" + productIds +
                '}';
    }
}
