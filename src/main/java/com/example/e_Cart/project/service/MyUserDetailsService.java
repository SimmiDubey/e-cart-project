package com.example.e_Cart.project.service;

import com.example.e_Cart.project.entity.User;
import com.example.e_Cart.project.entity.UserPrincipal;
import com.example.e_Cart.project.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo userRepository;

    // Removed 'static' modifier
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Find the user by username
        User user = userRepository.findByUsername(username);

        // If user not found, throw exception
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }

        // Return a custom UserPrincipal with user details
        return new UserPrincipal(user);
    }
}
