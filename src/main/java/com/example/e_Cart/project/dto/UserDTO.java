package com.example.e_Cart.project.dto;

import com.example.e_Cart.project.enums.Role;

import java.util.List;

public class UserDTO {
    private String email;
    private String password;

   // private List<String>roles;

    private Role role;

    public UserDTO(String email, String password, Role role) {
        this.email = email;
        this.password = password;
        this.role = role;

    }

    public UserDTO() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email= email;
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
