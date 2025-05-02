package com.example.e_Cart.project.service.impl;

import com.example.e_Cart.project.enums.Role;
import com.example.e_Cart.project.dto.ProductDTO;
import com.example.e_Cart.project.dto.UserDTO;
import com.example.e_Cart.project.entity.Product;
import com.example.e_Cart.project.entity.User;
import com.example.e_Cart.project.repository.UserRepo;
import com.example.e_Cart.project.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;



    @Override
    public UserDTO addUser(UserDTO userDTO) {
        User user=this.dtoToUser(userDTO);

        if (user.getRole() == null) {
            user.setRole(Role.USER); // Default role
        }

        User savedProduct=userRepo.save(user);

        return this.userToDto(savedProduct);
        }


    @Override
    public List<UserDTO> getAllUsers() {
        List<User>users=this.userRepo.findAll();


      List<UserDTO>userDTOS = users.stream()
                .map(this::userToDto)
                .collect(Collectors.toList());
        return userDTOS;
    }





    public User dtoToUser(UserDTO userDTO){
        User user=this.modelMapper.map(userDTO,User.class);
        return user;
    }

    public UserDTO userToDto(User user){
        UserDTO userDTO=this.modelMapper.map(user,UserDTO.class);
        return userDTO;
    }


}
