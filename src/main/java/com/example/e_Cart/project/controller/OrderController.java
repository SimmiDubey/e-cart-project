package com.example.e_Cart.project.controller;

import com.example.e_Cart.project.dto.OrderDTO;
import com.example.e_Cart.project.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;




}
