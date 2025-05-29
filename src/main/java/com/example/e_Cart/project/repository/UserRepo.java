package com.example.e_Cart.project.repository;

import com.example.e_Cart.project.entity.User;
import com.example.e_Cart.project.enums.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);

    Page<User> findByRole(Role role, Pageable pageable);

    boolean existsByEmail(String email);
}
