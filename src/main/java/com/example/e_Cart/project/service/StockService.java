package com.example.e_Cart.project.service;

import com.example.e_Cart.project.dto.StockDTO;

public interface StockService {

    StockDTO updateStockAfterApproval(int categoryId, int quantity);


}
