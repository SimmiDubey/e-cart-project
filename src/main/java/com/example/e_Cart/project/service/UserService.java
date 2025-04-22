package com.example.e_Cart.project.service;

import com.example.e_Cart.project.dto.UserDTO;

import java.util.List;

public interface UserService {

    //add the user
    UserDTO addUser(UserDTO userDTO);

    //get the all user
    List<UserDTO>getAllUsers();
}
