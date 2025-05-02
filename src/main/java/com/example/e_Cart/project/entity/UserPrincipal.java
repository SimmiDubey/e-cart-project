package com.example.e_Cart.project.entity;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class UserPrincipal implements UserDetails {

    private static final long serialVersionUID = 1L;

    private final User user;

    public UserPrincipal(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Convert the role enum to a Spring Security authority (e.g., "ROLE_ADMIN")
        return List.of(new SimpleGrantedAuthority("ROLE_" + user.getRole().name()));
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    // Optional: Add this getter if you want to access the full user elsewhere
    public User getUser() {
        return user;
    }
}










//
//
//
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.Collection;
//import java.util.Collections;
//import java.util.List;
//import java.util.stream.Collectors;
//
//public class UserPrincipal implements UserDetails{
//
//
//    private static final long serialVersionUID = 1L;
//
//
//    private User user;
//
//    public UserPrincipal(User user) {
//        this.user=user;
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
////        return user.getRoles().stream()
////                .map(role -> new SimpleGrantedAuthority("ROLE_" + role)) // Adding the prefix
////                .collect(Collectors.toSet());
//
//        List<SimpleGrantedAuthority> simple = List.of(new SimpleGrantedAuthority("ROLE_" + user.getRole().name()));
//
//    }
//
//
//    @Override
//    public String getPassword() {
//
//        return user.getPassword();
//    }
//
//    @Override
//    public String getUsername() {
//
//        return user.getUsername();
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//
//}
//
