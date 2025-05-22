package com.example.e_Cart.project.dto;

import com.example.e_Cart.project.enums.Role;

import java.util.List;

public class UserDTO {
    private String username;
    private String password;
    private String email;
   // private List<String>roles;

    private Role role;

    public UserDTO(String username, String password, Role role,String email) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.email=email;
    }

    public UserDTO() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
