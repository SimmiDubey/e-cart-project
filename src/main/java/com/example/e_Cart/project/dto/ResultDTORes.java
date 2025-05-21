package com.example.e_Cart.project.dto;

import java.util.List;

public class ResultDTORes
{
    private List<ProductDTORes>productDTOS;
    private double grandTotalPrice;
    private double grandProfitOrLoss;
    private List<ProductDTO> productDTOSRes;

    public ResultDTORes(List<ProductDTORes> productDTOS, double grandTotalPrice, double grandProfitOrLoss) {
        this.productDTOS = productDTOS;
        this.grandTotalPrice = grandTotalPrice;
        this.grandProfitOrLoss = grandProfitOrLoss;
    }

    public ResultDTORes() {
    }

    public List<ProductDTORes> getProductDTOS() {
        return productDTOS;
    }

    public void setProductDTOSRes(List<ProductDTORes> productDTOS) {
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


   

    public List<ProductDTO> getProductDTOSRes() {
        return productDTOSRes;
    }
}
