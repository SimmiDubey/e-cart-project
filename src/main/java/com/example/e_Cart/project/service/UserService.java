package com.example.e_Cart.project.service;

import com.example.e_Cart.project.dto.UserDTO;
import com.example.e_Cart.project.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface UserService {

    //add the user
    UserDTO addUser(UserDTO userDTO);

    //get the all user
    List<UserDTO>getAllUsers();

    Page<UserDTO> findByWarehouse(int pageNumber, int pageSize );
    List<UserDTO>getAllCustomer();
   // Optional<User> loginUser(String email,  String role);


}
