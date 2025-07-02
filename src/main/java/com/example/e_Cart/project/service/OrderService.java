package com.example.e_Cart.project.service;

import com.example.e_Cart.project.dto.OrderDTO;
import com.example.e_Cart.project.dto.OrderResponseDTO;

import java.util.List;

public interface OrderService {

    // save the order

    OrderResponseDTO placeOrder(OrderDTO dto);

    List<OrderResponseDTO>getAllOrder();

}
