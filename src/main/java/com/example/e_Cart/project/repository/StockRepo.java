package com.example.e_Cart.project.repository;

import com.example.e_Cart.project.entity.Category;
import com.example.e_Cart.project.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StockRepo extends JpaRepository<Stock,Integer>
{

    Optional<Stock> findByCategoryId(int categoryId);
}
