package com.example.e_Cart.project.service.impl;

import com.example.e_Cart.project.dto.CategoryDTO;
import com.example.e_Cart.project.entity.Category;
import com.example.e_Cart.project.repository.CategoryRepo;
import com.example.e_Cart.project.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CategoryDTO

    createCategory(CategoryDTO categoryDTO) {
        Category categories = dtoToCategory(categoryDTO);
        Category saved = categoryRepo.save(categories);
        return categoryToDto(saved);
    }

    @Override
    public List<CategoryDTO> getAllCategory() {
        List<Category> categories = categoryRepo.findAll();
        return categories.stream()
                .map(this::categoryToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<CategoryDTO> getAllCategoryWithStock() {
        return List.of();
    }

    public Category dtoToCategory(CategoryDTO categoryDTO) {

        return modelMapper.map(categoryDTO, Category.class);
    }

    public CategoryDTO categoryToDto(Category category) {
        return modelMapper.map(category, CategoryDTO.class);
    }
}
