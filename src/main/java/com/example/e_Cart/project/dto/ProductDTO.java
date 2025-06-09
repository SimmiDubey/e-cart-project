package com.example.e_Cart.project.dto;

import com.example.e_Cart.project.enums.ProductStatus;
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

//    @NotNull(message = "Stock is required")
//    @Min(value = 0, message = "Stock cannot be negative")
//    private Integer stock;

    private ProductStatus status = ProductStatus.PENDING;

    private String email;

    private String imageName;
    private String imageUrl;

    private Integer categoryId;

    private StockDTO stock;


    // --- Constructors ---
    public ProductDTO() {}

    public ProductDTO(int id, String productName, int mrp, Double discount, Date createdOn, Date updatedOn,
                      Double salePrice, Double purchasePrice, double totalPrice,
                      Integer quantity, double profitOrLoss,
                      ProductStatus status, String email, String imageName, String imageUrl
                       ,Integer categoryId,StockDTO stock) {

        this.id = id;
        this.productName = productName;
        this.mrp = mrp;
        this.discount = discount;
        this.createdOn = createdOn;
        this.updatedOn = updatedOn;
        this.salePrice = salePrice;
        this.purchasePrice = purchasePrice;
        this.totalPrice = totalPrice;
        this.quantity = quantity;
        this.profitOrLoss = profitOrLoss;

        this.status = status;
        this.email = email;
        this.imageName = imageName;
        this.imageUrl = imageUrl;
        this.categoryId=categoryId;
        this.stock=stock;
    }

    // --- Getters and Setters ---
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


    public ProductStatus getStatus() { return status; }
    public void setStatus(ProductStatus status) { this.status = status; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getImageName() { return imageName; }
    public void setImageName(String imageName) { this.imageName = imageName; }

    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }


    public Integer getCategoryId() {
        return categoryId;
    }

    public StockDTO getStock() {
        return stock;
    }

    public void setStock(StockDTO stock) {
        this.stock = stock;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    // --- toString ---
    @Override
    public String toString() {
        return "ProductDTO{" +
                "productName='" + productName + '\'' +
                ", mrp=" + mrp +
                ", discount=" + discount +
                ", createdOn=" + createdOn +
                ", updatedOn=" + updatedOn +
                ", salePrice=" + salePrice +
                ", purchasePrice=" + purchasePrice +
                ", totalPrice=" + totalPrice +
                ", quantity=" + quantity +
                ", profitOrLoss=" + profitOrLoss +

                ", status=" + status +
                ", email='" + email + '\'' +
                ", imageName='" + imageName + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ",categoryId=" +categoryId +
                ",stock=" +stock +
                '}';
    }
}
