package com.example.e_Cart.project.service;

import com.example.e_Cart.project.dto.OrderDTO;

import java.util.List;

public interface OrderService {

    // save the order

   List<OrderDTO>createAll(List<OrderDTO> orderDTOS);

   //get all

    List<OrderDTO>getAllOrder();

}
