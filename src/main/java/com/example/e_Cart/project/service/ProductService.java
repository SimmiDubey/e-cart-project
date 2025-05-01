package com.example.e_Cart.project.service;

import com.example.e_Cart.project.dto.ProductDTO;
import com.example.e_Cart.project.dto.ResultDTO;

import java.util.List;

public interface ProductService {


        // Add single product
      //  ProductDTO createProduct(ProductDTO productDTO);

        // Add multiple products
        ResultDTO createAllProducts(List<ProductDTO> productDTOs);

        // Get all products
        List<ProductDTO> getAllProducts();

        // Get product by ID
        ProductDTO getProductById(int productId);

        // Update product
        ProductDTO updateProductDto(ProductDTO productDTO, int productId);

        // Delete product by ID
        void deleteProductDTOById(int productId);

        // Calculate sale price and profit/loss for a single product
        ProductDTO calculateSale(ProductDTO productDTO);
    }




//    //create product
//
//    // ProductDTO createProduct(ProductDTO productDTO);
//
//     //get all product
//
//    List<ProductDTO>getAllProducts();
//
//    //getProducts
//
//    ProductDTO getProductById(int productId);
//
//    //update products
//
//    ProductDTO updateProductDto(ProductDTO productDTO , int productId);
//
//
//    //delete product
//
//    void deleteProductDTOById(int productId);
//
//     ProductDTO calculateSale(ProductDTO productDTO);
//
//    List<ProductDTO> createAllProducts(List<ProductDTO> productDTOs);
//
//   // List<ProductDTO> createProductAll(List<ProductDTO> productDto);
//}


