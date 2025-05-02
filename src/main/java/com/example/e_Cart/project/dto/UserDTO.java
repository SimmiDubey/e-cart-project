package com.example.e_Cart.project.dto;

import com.example.e_Cart.project.enums.Role;

import java.util.List;

public class UserDTO {
    private String username;
    private String password;
   // private List<String>roles;

    private Role role;

    public UserDTO(String username, String password, Role role) {
        this.username = username;
        this.password = password;
        this.role = role;
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
}
