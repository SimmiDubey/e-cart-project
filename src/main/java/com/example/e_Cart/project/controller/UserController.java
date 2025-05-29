package com.example.e_Cart.project.controller;

import com.example.e_Cart.project.dto.ApiResponse;
import com.example.e_Cart.project.dto.CustomPage;
import com.example.e_Cart.project.dto.ProductDTO;
import com.example.e_Cart.project.dto.UserDTO;
import com.example.e_Cart.project.exception.DuplicateUserException;
import com.example.e_Cart.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/api")
    public ResponseEntity<?> registerUser(@RequestBody UserDTO userDTO) {
        try {
            UserDTO savedUser = userService.addUser(userDTO);
            return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
        } catch (DuplicateUserException ex) {
            ApiResponse response = new ApiResponse(ex.getMessage(), false);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }
//    @GetMapping("/customers")
//    public ResponseEntity<List<UserDTO>> getUsers(){
//        return ResponseEntity.ok(this.userService.getAllCustomer());
//
//    }


    @GetMapping("/users")
    public ResponseEntity<List<UserDTO>>getUsers(){
        return ResponseEntity.ok(this.userService.getAllUsers());
    }



    @GetMapping("/warehouse")
    public ResponseEntity<CustomPage<UserDTO>> getWarehouseUsers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {


        page = Math.max(page, 0);   // page must be 0 or more
        size = Math.max(size, 1);   // size must be 1 or more


        CustomPage<UserDTO> pageResult = userService.findByWarehouse(page, size);


        return ResponseEntity.ok(pageResult);
    }


    @GetMapping("/customers")
    public ResponseEntity<List<UserDTO>>getCustomer(){
        return ResponseEntity.ok(this.userService.getAllCustomer());
    }




}
