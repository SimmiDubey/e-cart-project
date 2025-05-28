package com.example.e_Cart.project.service;

import com.example.e_Cart.project.entity.User;
import com.example.e_Cart.project.entity.UserPrincipal;
import com.example.e_Cart.project.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo userRepository;

    // Removed 'static' modifier
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // Find the user by username
        Optional<User> user = userRepository.findByEmail(email);

        // If user not found, throw exception
        if (user.isEmpty()) {
            throw new UsernameNotFoundException("User not found with username: " + email);
        }

        // Return a custom UserPrincipal with user details
        return new UserPrincipal(user.orElse(null));
    }
}
