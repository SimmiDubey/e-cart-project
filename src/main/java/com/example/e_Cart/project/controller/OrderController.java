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

    @PostMapping("/save")
    public ResponseEntity<List<OrderDTO>>saveAll(@RequestBody List<OrderDTO> orderDTO){
        List<OrderDTO>orderDTOS=this.orderService.createAll(orderDTO);
        return ResponseEntity.ok(orderDTOS);
    }

    @GetMapping()

    public ResponseEntity<List<OrderDTO>>getAll(){
        List<OrderDTO>orderDTOS=this.orderService.getAllOrder();
        return ResponseEntity.ok(orderDTOS);
    }
}
