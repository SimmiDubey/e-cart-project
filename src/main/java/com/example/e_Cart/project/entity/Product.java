package com.example.e_Cart.project.entity;

import com.example.e_Cart.project.enums.ProductStatus;
import com.example.e_Cart.project.enums.Role;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String productName;
    private int mrp;
    private double discount;
    private Date createdOn;
    private Date updatedOn;

    private double salePrice;
    private double purchasePrice;
    private double totalPrice;
    private int quantity;
    private double profitOrLoss;
    private Integer stock;

    private String imageName;
    private String imageUrl;


    @Enumerated(EnumType.STRING)
    private ProductStatus status = ProductStatus.PENDING;

    @ManyToOne
    private User createdBy;
    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoryId",nullable = false)
    private Category category;


//    @Enumerated(EnumType.STRING)
//    @CollectionTable(name = "product_roles", joinColumns = @JoinColumn(name = "product_id"))
//    @Column(name = "role")
//    private List<Role> roles = new ArrayList<>();





    // Default constructor
    public Product() {
    }

    // Parameterized constructor
    public Product(int id, String productName, int mrp, double discount,
                   Date createdOn, Date updatedOn, String description,
                   double salePrice, double purchasePrice, double totalPrice, int quantity,
                   double profitOrLoss, Integer stock, ProductStatus status, User createdBy,String email
         ,String imageName,String imageUrl,Category category) {
        this.id = id;
        this.productName = productName;
        this.mrp = mrp;
        this.discount = discount;
        this.createdOn = createdOn;
        this.updatedOn = updatedOn;
        this.category=category;
        this.salePrice = salePrice;
        this.purchasePrice = purchasePrice;
        this.totalPrice = totalPrice;
        this.quantity = quantity;
        this.profitOrLoss = profitOrLoss;
        this.stock = stock;
        this.status = status;
        this.createdBy = createdBy;
        this.email=email;
        this.imageName=imageName;
        this.imageUrl=imageUrl;


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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }


    //    public List<Role> getRoles() {
//        return roles;
//    }
//
//    public void setRoles(List<Role> roles) {
//        this.roles = roles;
//    }
}
