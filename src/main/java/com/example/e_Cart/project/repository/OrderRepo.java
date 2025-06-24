package com.example.e_Cart.project.repository;

import com.example.e_Cart.project.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends JpaRepository<Orders,Long> {
}
