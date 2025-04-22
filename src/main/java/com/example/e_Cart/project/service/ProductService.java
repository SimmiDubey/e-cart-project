package com.example.e_Cart.project.service;

import com.example.e_Cart.project.dto.ProductDTO;

import java.util.List;

public interface ProductService {

    //create product

     ProductDTO createProduct(ProductDTO productDTO);

     //get all product

    List<ProductDTO>getAllProducts();

    //getProducts

    ProductDTO getProductById(int productId);

    //update products

    ProductDTO updateProductDto(ProductDTO productDTO , int productId);


    //delete product

    void deleteProductDTOById(int productId);
}
