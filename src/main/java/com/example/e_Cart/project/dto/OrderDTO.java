package com.example.e_Cart.project.dto;

public class OrderDTO {


    private int quantity;
    private int totalAmount;
    private String status;

    public OrderDTO(){

    }

    public OrderDTO(int quantity,int totalAmount,String status){

        this.quantity=quantity;
        this.totalAmount=totalAmount;
        this.status=status;
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

    @Override
    public String toString() {
        return "OrderDTO{" +
                ", quantity=" + quantity +
                ", totalAmount=" + totalAmount +
                ", status='" + status + '\'' +
                '}';
    }
}

