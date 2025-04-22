package com.example.e_Cart.project.dto;

import java.util.Date;

public class ProductDTO {


    private String productName;
    private int mrp;
    private double discount;
    private Date createdOn;
    private Date updatedOn;

    public ProductDTO(String productName,int mrp,double discount,Date createdOn,Date updatedOn){

        this.productName=productName;
        this.mrp=mrp;
        this.discount=discount;
        this.createdOn=createdOn;
        this.updatedOn=updatedOn;

    }

    public  ProductDTO(){

    }



    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getMrp() {
        return mrp;
    }

    public void setMrp(int mrp) {
        this.mrp = mrp;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }
}
