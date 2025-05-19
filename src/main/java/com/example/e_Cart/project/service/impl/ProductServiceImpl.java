package com.example.e_Cart.project.service.impl;

import com.example.e_Cart.project.dto.ProductDTO;
import com.example.e_Cart.project.dto.ResultDTO;
import com.example.e_Cart.project.entity.Product;
import com.example.e_Cart.project.entity.User;
import com.example.e_Cart.project.enums.ProductStatus;
import com.example.e_Cart.project.exception.ResourceNotFoundException;
import com.example.e_Cart.project.repository.ProductRepo;
import com.example.e_Cart.project.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private ModelMapper modelMapper;



        @Override
        public ResultDTO createAllProducts(List<ProductDTO> productDTOs) {
            double grandTotalPrice = 0.0;
            double grandProfitOrLoss = 0.0;

            List<Product> products = new ArrayList<>();

            for (ProductDTO productDTO : productDTOs) {
                ProductDTO calculatedProduct = calculateSale(productDTO);
                grandTotalPrice += calculatedProduct.getTotalPrice();
                grandProfitOrLoss += calculatedProduct.getProfitOrLoss();
                products.add(dtoToProduct(calculatedProduct));
            }

            List<Product> savedProducts = productRepo.saveAll(products);

            List<ProductDTO> savedProductDTOs = savedProducts.stream()
                    .map(this::productToDto)
                    .collect(Collectors.toList());

            ResultDTO resultDTO = new ResultDTO();
            resultDTO.setProductDTOS(savedProductDTOs);
            resultDTO.setGrandTotalPrice(grandTotalPrice);
            resultDTO.setGrandProfitOrLoss(grandProfitOrLoss);

            return resultDTO;
        }

        @Override
        public List<ProductDTO> getAllProducts() {
            List<Product> products = productRepo.findAll();
            return products.stream()
                    .map(this::productToDto)
                    .collect(Collectors.toList());
        }

        @Override
        public ProductDTO getProductById(int productId) {
            Product product = productRepo.findById(productId)
                    .orElseThrow(() -> new ResourceNotFoundException("Product", "productId", productId));
            return productToDto(product);
        }

        @Override
        public ProductDTO updateProductDto(ProductDTO productDTO, int productId) {
            Product product = productRepo.findById(productId)
                    .orElseThrow(() -> new ResourceNotFoundException("Product", "productId", productId));
            product.setId(productDTO.getId());
            product.setProductName(productDTO.getProductName());
            product.setMrp(productDTO.getMrp());
            product.setDiscount(productDTO.getDiscount());
            product.setCreatedOn(productDTO.getCreatedOn());
            product.setUpdatedOn(productDTO.getUpdatedOn());
            product.setDescription(productDTO.getDescription());
            product.setCategory(productDTO.getCategory());
            product.setSalePrice(productDTO.getSalePrice());
            product.setPurchasePrice(productDTO.getPurchasePrice());
            product.setTotalPrice(productDTO.getTotalPrice());
            product.setQuantity(productDTO.getQuantity());
            product.setProfitOrLoss(productDTO.getProfitOrLoss());

            Product updatedProduct = productRepo.save(product);
            return productToDto(updatedProduct);
        }

        @Override
        public void deleteProductDTOById(int productId) {
            Product product = productRepo.findById(productId)
                    .orElseThrow(() -> new ResourceNotFoundException("Product", "productId", productId));
            productRepo.delete(product);
        }

        @Override
        public ProductDTO calculateSale(ProductDTO productDTO) {
            double salePrice = productDTO.getSalePrice();
            int quantity = productDTO.getQuantity();
            double purchasePrice = productDTO.getPurchasePrice();
            double discountPercent = productDTO.getDiscount();

            double totalBeforeDiscount = salePrice * quantity;
            double discountAmount = (discountPercent / 100.0) * totalBeforeDiscount;
            double totalAfterDiscount = totalBeforeDiscount - discountAmount;

            double discountedSalePricePerUnit = salePrice - (discountPercent * salePrice / 100);
            double profitOrLossPerUnit = discountedSalePricePerUnit - purchasePrice;
            double profitOrLoss = profitOrLossPerUnit * quantity;

            productDTO.setTotalPrice(totalAfterDiscount);
            productDTO.setProfitOrLoss(profitOrLoss);

            if(productDTO.getStock() == null){
                productDTO.setStock(productDTO.getQuantity());
            }else {
                int updatedStock = productDTO.getStock()-productDTO.getQuantity();
                if(updatedStock < 0 ){
                    throw new IllegalArgumentException("Not enough stock available for products :"+productDTO.getProductName());

                }
                productDTO.setStock(updatedStock);
            }

            return productDTO;
        }

    @Override
    public List<Product> getApprovedProducts() {
        return productRepo.findByStatus(ProductStatus.APPROVED);
    }

    @Override
    public List<ProductDTO> getPendingProducts() {
        return productRepo.findByStatus(ProductStatus.PENDING)
                .stream()
                .map(this::productToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDTO updateProductStatus(int productId, ProductStatus status) {
        Product product = productRepo.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product", "productId", productId));
        product.setStatus(status); // Update the status
        Product updatedProduct = productRepo.save(product); // Save the updated product
        return productToDto(updatedProduct); // Return the updated product DTO
    }

    @Override
    public List<ProductDTO> getProductByUser(User user) {
        return productRepo.findByCreatedBy(user).stream()
                .map(this::productToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> getProductsByStatus(ProductStatus status) {
        return productRepo.findByStatus(status)
                .stream()
                .map(this::productToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<Product> getProductStatus(String productStatus) {
        ProductStatus statusEnum=ProductStatus.valueOf(productStatus.toUpperCase());
        return productRepo.findByProductStatus(statusEnum);
    }



    // Mapping Helpers
        public Product dtoToProduct(ProductDTO productDTO) {
            return modelMapper.map(productDTO, Product.class);
        }

        public ProductDTO productToDto(Product product) {
            ProductDTO dto=modelMapper.map(product,ProductDTO.class);
            dto.setId(product.getId());
            return dto;
        }
    }
