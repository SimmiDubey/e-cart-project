package com.example.e_Cart.project.service.impl;

import com.example.e_Cart.project.enums.Role;
import com.example.e_Cart.project.dto.UserDTO;
import com.example.e_Cart.project.entity.User;
import com.example.e_Cart.project.repository.ProductRepo;
import com.example.e_Cart.project.repository.UserRepo;
import com.example.e_Cart.project.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDTO addUser(UserDTO userDTO) {
        User user = this.dtoToUser(userDTO);

        if (user.getRole() == null) {
            user.setRole(Role.USER); // Default role
        }

        User savedUser = userRepo.save(user);
        return this.userToDto(savedUser);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> users = this.userRepo.findAll();
        return users.stream()
                .map(this::userToDto)
                .collect(Collectors.toList());
    }


    @Override
    public Page<UserDTO> findByWarehouse(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<User> userPage = this.userRepo.findByRole(Role.WAREHOUSE, pageable);
        return userPage.map(this::userToDto);
    }

    @Override
    public List<UserDTO> getAllCustomer() {
        List<User> users = this.userRepo.findAll();
        return users.stream()
                .map(this::userToDto)
                .collect(Collectors.toList());
    }

    private User dtoToUser(UserDTO userDTO) {
        return this.modelMapper.map(userDTO, User.class);
    }

    private UserDTO userToDto(User user) {
        return this.modelMapper.map(user, UserDTO.class);
    }
}
