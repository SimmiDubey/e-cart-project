package com.example.e_Cart.project.service;

import com.example.e_Cart.project.dto.CategoryDTO;
import com.example.e_Cart.project.entity.Category;

import java.util.List;

public interface CategoryService {
    //create category
      CategoryDTO createCategory(CategoryDTO categoryDTOS);

      //get category

    List<CategoryDTO>getAllCategory();



}
