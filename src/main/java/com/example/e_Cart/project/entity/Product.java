package com.example.e_Cart.project.entity;

import com.example.e_Cart.project.enums.ProductStatus;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String productName;
    private int mrp;
    private double discount;
    private Date createdOn;
    private Date updatedOn;
    private String description;
    private String category;
    private double salePrice;
    private double purchasePrice;
    private double totalPrice;
    private int quantity;
    private double profitOrLoss;
    private Integer stock;

    @Enumerated(EnumType.STRING)
    private ProductStatus status = ProductStatus.PENDING;

    @ManyToOne
    private User createdBy;

    // Default constructor
    public Product() {
    }

    // Parameterized constructor
    public Product(int id, String productName, int mrp, double discount,
                   Date createdOn, Date updatedOn, String description, String category,
                   double salePrice, double purchasePrice, double totalPrice, int quantity,
                   double profitOrLoss, Integer stock, ProductStatus status, User createdBy) {
        this.id = id;
        this.productName = productName;
        this.mrp = mrp;
        this.discount = discount;
        this.createdOn = createdOn;
        this.updatedOn = updatedOn;
        this.description = description;
        this.category = category;
        this.salePrice = salePrice;
        this.purchasePrice = purchasePrice;
        this.totalPrice = totalPrice;
        this.quantity = quantity;
        this.profitOrLoss = profitOrLoss;
        this.stock = stock;
        this.status = status;
        this.createdBy = createdBy;
    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public ProductStatus getStatus() {
        return status;
    }

    public void setStatus(ProductStatus status) {
        this.status = status;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }
}
