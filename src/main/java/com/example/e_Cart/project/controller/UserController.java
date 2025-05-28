package com.example.e_Cart.project.controller;

import com.example.e_Cart.project.dto.ProductDTO;
import com.example.e_Cart.project.dto.UserDTO;
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
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO){
        UserDTO createuserDto=this.userService.addUser(userDTO);
        return new ResponseEntity<>(createuserDto, HttpStatus.OK);
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
    public ResponseEntity<Page<UserDTO>>getWarehouse(@RequestParam(defaultValue = "0") int page,
                                                     @RequestParam(defaultValue = "5")int size){
        Page<UserDTO>userDTOS=userService.findByWarehouse(page, size);
        return ResponseEntity.ok(userDTOS);
    }

    @GetMapping("/customers")
    public ResponseEntity<List<UserDTO>>getCustomer(){
        return ResponseEntity.ok(this.userService.getAllCustomer());
    }



}
