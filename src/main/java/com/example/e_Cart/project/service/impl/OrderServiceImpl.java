
package com.example.e_Cart.project.service.impl;

import com.example.e_Cart.project.dto.OrderDTO;
import com.example.e_Cart.project.dto.OrderResponseDTO;
import com.example.e_Cart.project.entity.Orders;
import com.example.e_Cart.project.entity.Product;
import com.example.e_Cart.project.entity.User;
import com.example.e_Cart.project.enums.OrderStatus;
import com.example.e_Cart.project.repository.OrderRepo;
import com.example.e_Cart.project.repository.ProductRepo;
import com.example.e_Cart.project.repository.UserRepo;
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

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private UserRepo userRepo;


    @Override
    public OrderResponseDTO placeOrder(OrderDTO dto) {

        Product product=productRepo.findById(dto.getProductId()).orElseThrow(()->new RuntimeException("Product Not found"));

        User user=userRepo.findByEmail(dto.getEmail()).orElseThrow(()->new RuntimeException("User not found"));

        Orders orders=new Orders();
        orders.setProducts(product);
        orders.setUser(user);
        orders.getStatus(String.valueOf(dto.getStatus()));

        //calculate total

        double total=product.getSalePrice()*product.getQuantity();
        orders.setTotalAmount((int) total);
        orders.setQuantity(product.getQuantity());
        Orders savedOrder=orderRepo.save(orders);

        //prepare Response

        OrderResponseDTO responseDTO=new OrderResponseDTO();
        responseDTO.setOrder_id(savedOrder.getId());
        responseDTO.setProductId(product.getId());
        responseDTO.setUserId(user.getId());
        responseDTO.setQuantity(product.getQuantity());
        responseDTO.setTotalAmount((int) total);
        responseDTO.setOrder_Date(savedOrder.getOrderDate());
        responseDTO.setStatus(OrderStatus.valueOf(savedOrder.getStatus("confirm")));


        return responseDTO;
    }





    @Override
    public List<OrderResponseDTO> getAllOrder() {
        return List.of();
    }

    // ModelMapper helper methods
    public Orders dtoToOrder(OrderDTO orderDTO) {
        return modelMapper.map(orderDTO, Orders.class);
    }

    public OrderDTO orderToDto(Orders order) {
        return modelMapper.map(order, OrderDTO.class);
    }


}
