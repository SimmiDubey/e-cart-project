package com.example.e_Cart.project.dto;

import java.util.Date;
import java.util.List;


public class ProductDTO {


    private String productName;
    private int mrp;
    private double discount;
    private Date createdOn;
    private Date updatedOn;

    private String description;
    private double salePrice;
    private double purchasePrice;
    private double totalPrice;
    private int quantity;
    private double profitOrLoss;
    private List<ProductDTO>productDTOS;

    public ProductDTO(String productName, int mrp, double discount, Date createdOn, Date updatedOn, String description, double salePrice, double purchasePrice, double totalPrice, int quantity, double profitOrLoss, List<ProductDTO> productDTOS) {
        this.productName = productName;
        this.mrp = mrp;
        this.discount = discount;
        this.createdOn = createdOn;
        this.updatedOn = updatedOn;
        this.description = description;
        this.salePrice = salePrice;
        this.purchasePrice = purchasePrice;
        this.totalPrice = totalPrice;
        this.quantity = quantity;
        this.profitOrLoss = profitOrLoss;
        this.productDTOS = productDTOS;
    }

    public ProductDTO() {
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


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getProfitOrLoss() {
        return profitOrLoss;
    }

    public void setProfitOrLoss(double profitOrLoss) {
        this.profitOrLoss = profitOrLoss;
    }

    public List<ProductDTO> getProductDTOS() {
        return productDTOS;
    }

    public void setProductDTOS(List<ProductDTO> productDTOS) {
        this.productDTOS = productDTOS;
    }



    @Override
    public String toString() {
        return "ProductDTO{" +
                "productName='" + productName + '\'' +
                ", mrp=" + mrp +
                ", discount=" + discount +
                ", createdOn=" + createdOn +
                ", updatedOn=" + updatedOn +
                ", description='" + description + '\'' +
                ", salePrice=" + salePrice +
                ", purchasePrice=" + purchasePrice +
                ", totalPrice=" + totalPrice +
                ", quantity=" + quantity +
                ", profitOrLoss=" + profitOrLoss +
                ", productDTOS=" + productDTOS +
                '}';
    }
}

