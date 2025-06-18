package com.example.e_Cart.project.service.impl;

import com.example.e_Cart.project.dto.OrderDTO;
import com.example.e_Cart.project.entity.Orders;
import com.example.e_Cart.project.repository.OrderRepo;
import com.example.e_Cart.project.service.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<OrderDTO> createAll(List<OrderDTO> orderDTOS) {
        // Convert DTO to Entity
        List<Orders> orders = orderDTOS.stream()
                .map(this::dtoToOrder)
                .collect(Collectors.toList());

        // Save to DB
        List<Orders> savedOrders = orderRepo.saveAll(orders);

        // Convert Entity to DTO
        return savedOrders.stream()
                .map(this::orderToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<OrderDTO> getAllOrder() {
        List<Orders> orders = orderRepo.findAll();
        return orders.stream()
                .map(this::orderToDto)
                .collect(Collectors.toList());
    }

    // ModelMapper helper methods
    public Orders dtoToOrder(OrderDTO orderDTO) {
        return modelMapper.map(orderDTO, Orders.class);
    }

    public OrderDTO orderToDto(Orders order) {
        return modelMapper.map(order, OrderDTO.class);
    }
}
