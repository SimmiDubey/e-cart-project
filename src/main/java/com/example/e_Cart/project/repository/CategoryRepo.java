package com.example.e_Cart.project.repository;

import com.example.e_Cart.project.dto.CategoryDTO;
import com.example.e_Cart.project.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

//    @Query("SELECT new com.example.e_Cart.project.dto.CategoryDTO(" +
//            "c.id, c.title, c.description, COALESCE(s.quantity, 0)) " +
//            "FROM Category c LEFT JOIN c.stock s")
//    List<CategoryDTO> getCategoryWithStock();

}
