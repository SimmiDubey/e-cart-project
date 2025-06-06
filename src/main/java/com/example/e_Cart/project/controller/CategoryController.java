package com.example.e_Cart.project.controller;

import com.example.e_Cart.project.dto.CategoryDTO;
import com.example.e_Cart.project.entity.Category;
import com.example.e_Cart.project.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller

@RequestMapping("/api")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    @PostMapping("/category")
    public ResponseEntity<CategoryDTO>saveCategory(@RequestBody CategoryDTO categoryDTO){
        CategoryDTO category=categoryService.createCategory(categoryDTO);
        return new ResponseEntity<>(category, HttpStatus.CREATED);
    }

    @GetMapping("/all-Category")
    public ResponseEntity <List<CategoryDTO>>getCategory(){
        return ResponseEntity.ok(this.categoryService.getAllCategory());
    }
}
