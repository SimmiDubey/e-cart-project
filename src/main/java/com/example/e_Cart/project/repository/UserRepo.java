package com.example.e_Cart.project.repository;

import com.example.e_Cart.project.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {
    User findByUsername(String username);
   // Optional<User> findByEmail(String email);
}
