package com.example.e_Cart.project.controller;

import com.example.e_Cart.project.dto.ProductDTO;
import com.example.e_Cart.project.dto.UserDTO;
import com.example.e_Cart.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/")
    public ResponseEntity<List<UserDTO>> getUsers(){
        return ResponseEntity.ok(this.userService.getAllUsers());

    }
}
