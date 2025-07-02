package com.example.e_Cart.project.dto;

import com.example.e_Cart.project.enums.OrderStatus;

import java.util.Date;

public class OrderResponseDTO {

    private int order_id;
    private int userId;
    private int productId;
    private int totalAmount;
    private int quantity;
    private Date order_Date;
    private OrderStatus status;


    public OrderResponseDTO() {

    }

    public OrderResponseDTO(int order_id, int userId, int productId,
                            int totalAmount, int quantity,Date order_Date,OrderStatus status) {
        this.order_id = order_id;
        this.userId = userId;
        this.productId = productId;
        this.totalAmount = totalAmount;
        this.quantity = quantity;
        this.order_Date=order_Date;
        this.status=status;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getOrder_Date() {
        return order_Date;
    }

    public void setOrder_Date(Date order_Date) {
        this.order_Date = order_Date;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "OrderResponseDTO{" +
                "order_id=" + order_id +
                ", userId=" + userId +
                ", productId=" + productId +
                ", totalAmount=" + totalAmount +
                ", quantity=" + quantity +
                ", order_Date=" +order_Date +
                ", status=" +status +
                '}';
    }
}


