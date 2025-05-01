package com.example.e_Cart.project.dto;

import java.util.List;

public class ResultDTO {
    private List<ProductDTO>productDTOS;
    private double grandTotalPrice;
    private double grandProfitOrLoss;

    public ResultDTO(List<ProductDTO> productDTOS, double grandTotalPrice, double grandProfitOrLoss) {
        this.productDTOS = productDTOS;
        this.grandTotalPrice = grandTotalPrice;
        this.grandProfitOrLoss = grandProfitOrLoss;
    }

    public ResultDTO() {
    }

    public List<ProductDTO> getProductDTOS() {
        return productDTOS;
    }

    public void setProductDTOS(List<ProductDTO> productDTOS) {
        this.productDTOS = productDTOS;
    }

    public double getGrandTotalPrice() {
        return grandTotalPrice;
    }

    public void setGrandTotalPrice(double grandTotalPrice) {
        this.grandTotalPrice = grandTotalPrice;
    }

    public double getGrandProfitOrLoss() {
        return grandProfitOrLoss;
    }

    public void setGrandProfitOrLoss(double grandProfitOrLoss) {
        this.grandProfitOrLoss = grandProfitOrLoss;
    }
}
