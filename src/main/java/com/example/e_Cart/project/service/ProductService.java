package com.example.e_Cart.project.service;

import com.example.e_Cart.project.dto.ProductDTO;
import com.example.e_Cart.project.dto.ResultDTO;
import com.example.e_Cart.project.entity.Product;
import com.example.e_Cart.project.entity.User;
import com.example.e_Cart.project.enums.ProductStatus;

import java.util.List;

public interface ProductService {

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

        // Get all approved products for users
        List<Product> getApprovedProducts();

        // Get all pending products for admin review
        List<ProductDTO> getPendingProducts();

        // Approve or reject a product by admin
        ProductDTO updateProductStatus(int productId, ProductStatus status);

        // Get all products created by a specific warehouse user
        List<ProductDTO> getProductByUser(User user);

        // Get products by status (APPROVED, PENDING, REJECTED, etc.)
        List<ProductDTO> getProductsByStatus(ProductStatus status);

        // Get product status by status string
        List<Product> getProductStatus(String productStatus);

        // Optionally, implement search functionality here in the future
        // List<ProductDTO> getSearchProduct();
}
