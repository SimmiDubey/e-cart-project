package com.example.e_Cart.project.dto;

import jakarta.validation.constraints.*;
import java.util.Date;

public class ProductDTO {

    private int id;

    @NotBlank(message = "Product name is required")
    private String productName;

    @Min(value = 1, message = "MRP must be at least 1")
    private int mrp;


    private Double discount;

    private Date createdOn;
    private Date updatedOn;

    @NotBlank(message = "Category is required")
    private String category;

    private String description;

    @NotNull(message = "Sale price must not be null")
    @DecimalMin(value = "0.0", inclusive = false, message = "Sale price must be greater than 0")
    private Double salePrice;

    @NotNull(message = "Purchase price must not be null")
    @DecimalMin(value = "0.0", inclusive = false, message = "Purchase price must be greater than 0")
    private Double purchasePrice;

    @DecimalMin(value = "0.0", inclusive = true, message = "Total price must be 0 or more")
    private double totalPrice;

    @NotNull(message = "Quantity is required")
    @Min(value = 1, message = "Quantity must be at least 1")
    private Integer quantity;

    private double profitOrLoss;

    @NotNull(message = "Stock is required")
   @Min(value = 0, message = "Stock cannot be negative")
    private Integer stock;

    public ProductDTO() {}

    public ProductDTO(int id, String productName, int mrp, Double discount, Date createdOn, Date updatedOn,
                      String category, String description, Double salePrice, Double purchasePrice, double totalPrice,
                      Integer quantity, double profitOrLoss, Integer stock) {
        this.id = id;
        this.productName = productName;
        this.mrp = mrp;
        this.discount = discount;
        this.createdOn = createdOn;
        this.updatedOn = updatedOn;
        this.category = category;
        this.description = description;
        this.salePrice = salePrice;
        this.purchasePrice = purchasePrice;
        this.totalPrice = totalPrice;
        this.quantity = quantity;
        this.profitOrLoss = profitOrLoss;
        this.stock = stock;
    }



    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }

    public int getMrp() { return mrp; }
    public void setMrp(int mrp) { this.mrp = mrp; }

    public Double getDiscount() { return discount; }
    public void setDiscount(Double discount) { this.discount = discount; }

    public Date getCreatedOn() { return createdOn; }
    public void setCreatedOn(Date createdOn) { this.createdOn = createdOn; }

    public Date getUpdatedOn() { return updatedOn; }
    public void setUpdatedOn(Date updatedOn) { this.updatedOn = updatedOn; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Double getSalePrice() { return salePrice; }
    public void setSalePrice(Double salePrice) { this.salePrice = salePrice; }

    public Double getPurchasePrice() { return purchasePrice; }
    public void setPurchasePrice(Double purchasePrice) { this.purchasePrice = purchasePrice; }

    public double getTotalPrice() { return totalPrice; }
    public void setTotalPrice(double totalPrice) { this.totalPrice = totalPrice; }

    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }

    public double getProfitOrLoss() { return profitOrLoss; }
    public void setProfitOrLoss(double profitOrLoss) { this.profitOrLoss = profitOrLoss; }

    public Integer getStock() { return stock; }
    public void setStock(Integer stock) { this.stock = stock; }

    // --- toString ---
    @Override
    public String toString() {
        return "ProductDTO{" +
                "productName='" + productName + '\'' +
                ", mrp=" + mrp +
                ", discount=" + discount +
                ", createdOn=" + createdOn +
                ", updatedOn=" + updatedOn +
                ", category='" + category + '\'' +
                ", description='" + description + '\'' +
                ", salePrice=" + salePrice +
                ", purchasePrice=" + purchasePrice +
                ", totalPrice=" + totalPrice +
                ", quantity=" + quantity +
                ", profitOrLoss=" + profitOrLoss +
                ", stock=" + stock +
                '}';
    }
}
