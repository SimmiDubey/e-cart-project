  //test cases for the ProductServiceImpl class
package com.example.e_Cart.project.service;
import com.example.e_Cart.project.dto.ProductDTO;
import com.example.e_Cart.project.dto.ProductDTORes;
import com.example.e_Cart.project.dto.ResultDTORes;
import com.example.e_Cart.project.entity.Product;
import com.example.e_Cart.project.repository.ProductRepo;
import com.example.e_Cart.project.repository.ProductRepo;
import com.example.e_Cart.project.service.impl.ProductServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;


import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)



public class ProductServiceImplTest {


    @Mock
    private ProductRepo productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllProducts() {
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "shoes", 800.0, 10,500,600,800, "Category1", "Description1"));
        products.add(new Product(2, "Product2", 200.0, 20, "Category2", "Description2"));

        when(productRepository.findAll()).thenReturn(products);

        List<ProductDTO> result = productService.getAllProducts();

        assertEquals(2, result.size());
        assertEquals("Product1", result.get(0).getProductName());
        assertEquals("Product2", result.get(1).getProductName());
    }
    }