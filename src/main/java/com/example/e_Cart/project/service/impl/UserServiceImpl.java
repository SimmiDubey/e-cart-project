package com.example.e_Cart.project.service.impl;

import com.example.e_Cart.project.dto.CustomPage;
import com.example.e_Cart.project.enums.Role;
import com.example.e_Cart.project.dto.UserDTO;
import com.example.e_Cart.project.entity.User;
import com.example.e_Cart.project.exception.DuplicateUserException;
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
        if (userRepo.existsByEmail(userDTO.getEmail())) {
            throw new DuplicateUserException("This user already exists with email: " + userDTO.getEmail());
        }

        User user = this.dtoToUser(userDTO);
        if (user.getRole() == null) {
            user.setRole(Role.USER);
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
    public CustomPage<UserDTO> findByWarehouse(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<User> userPage = userRepo.findByRole(Role.WAREHOUSE, pageable);

        List<UserDTO> userDTOs = userPage.getContent()
                .stream()
                .map(this::userToDto)
                .collect(Collectors.toList());

        return new CustomPage<UserDTO>(
                userDTOs,
                userPage.getNumber(),
                userPage.getSize(),
                userPage.getTotalElements(),
                userPage.getTotalPages()
        );
    }





    @Override
    public List<UserDTO> getAllCustomer() {
        List<User> users = this.userRepo.findAll();
        return users.stream()
                .map(this::userToDto)
                .collect(Collectors.toList());
    }

    @Override
    public boolean getExitsUser(String email) {
        return false;
    }


    private User dtoToUser(UserDTO userDTO) {
        return this.modelMapper.map(userDTO, User.class);
    }

    private UserDTO userToDto(User user) {
        return this.modelMapper.map(user, UserDTO.class);
    }
}
