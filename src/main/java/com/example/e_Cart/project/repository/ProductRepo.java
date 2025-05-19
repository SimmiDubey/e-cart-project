package com.example.e_Cart.project.repository;

import com.example.e_Cart.project.dto.ProductDTO;
import com.example.e_Cart.project.entity.Product;
import com.example.e_Cart.project.entity.User;
import com.example.e_Cart.project.enums.ProductStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product,Integer> {
    List<Product> findByStatus(ProductStatus status);

    List<Product> findByCreatedBy(User user);
    List<Product> findByProductStatus(ProductStatus productStatus);

}
