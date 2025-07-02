package com.example.e_Cart.project.dto;

import com.example.e_Cart.project.enums.OrderStatus;

import java.util.Date;
import java.util.List;

public class OrderDTO {

     private int order_id;
     private OrderStatus status;
     private Date order_date;
     private int productId;
     private String email;

     public OrderDTO(){

     }

    public OrderDTO(int order_id, OrderStatus status, Date order_date,int productId,String email) {
        this.order_id = order_id;
        this.status = status;
        this.order_date = order_date;
        this.productId=productId;
        this.email=email;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Date getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "order_id=" + order_id +
                ", status='" + status + '\'' +
                ", order_date=" + order_date +
                '}';
    }
}
