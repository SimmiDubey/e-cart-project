package com.example.e_Cart.project.dto;



public class StockDTO {



    private int quantity;

    private int categoryId;

    public StockDTO(){

    }
    public StockDTO(int quantity,int id,int categoryId ){
        this.quantity=quantity;
        this.categoryId=categoryId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


}
