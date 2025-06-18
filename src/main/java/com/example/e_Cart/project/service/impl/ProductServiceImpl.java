package com.example.e_Cart.project.service.impl;

import com.example.e_Cart.project.dto.ProductDTO;
import com.example.e_Cart.project.dto.ProductDTORes;

import com.example.e_Cart.project.dto.ResultDTORes;
import com.example.e_Cart.project.dto.StockDTO;
import com.example.e_Cart.project.entity.Category;
import com.example.e_Cart.project.entity.Product;
import com.example.e_Cart.project.entity.Stock;
import com.example.e_Cart.project.entity.User;
import com.example.e_Cart.project.enums.ProductStatus;
import com.example.e_Cart.project.exception.ResourceNotFoundException;
import com.example.e_Cart.project.repository.CategoryRepo;
import com.example.e_Cart.project.repository.ProductRepo;
import com.example.e_Cart.project.repository.StockRepo;
import com.example.e_Cart.project.repository.UserRepo;
import com.example.e_Cart.project.service.ProductService;
import com.example.e_Cart.project.service.StockService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Sort;
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

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private StockRepo stockRepo;

    @Autowired
    private StockService stockService;


    @Override
    public ResultDTORes createAllProducts(List<ProductDTO> productDTOs, User user) {
        double grandTotalPrice = 0.0;
        double grandProfitOrLoss = 0.0;

        List<Product> products = new ArrayList<>();

        for (ProductDTO productDTO : productDTOs) {
            ProductDTO calculatedProduct = calculateSale(productDTO);
            grandTotalPrice += calculatedProduct.getTotalPrice();
            grandProfitOrLoss += calculatedProduct.getProfitOrLoss();

            Product product = dtoToProduct(calculatedProduct);
            product.setCreatedBy(user);  // Set the createdBy field
            products.add(product);
        }

        List<Product> savedProducts = productRepo.saveAll(products);

        List<ProductDTORes> savedProductDTOs = savedProducts.stream()
                .map(this::productToDtoRes)
                .collect(Collectors.toList());

        ResultDTORes resultDTO = new ResultDTORes();
        resultDTO.setProductDTOSRes(savedProductDTOs);
        resultDTO.setGrandTotalPrice(grandTotalPrice);
        resultDTO.setGrandProfitOrLoss(grandProfitOrLoss);

        return resultDTO;
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        List<Product> products = productRepo.findAll(Sort.by(Sort.Direction.ASC, "productName"));
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

        product.setProductName(productDTO.getProductName());
        product.setMrp(productDTO.getMrp());
        product.setDiscount(productDTO.getDiscount());
        product.setCreatedOn(productDTO.getCreatedOn());
        product.setUpdatedOn(productDTO.getUpdatedOn());
        product.setSalePrice(productDTO.getSalePrice());
        product.setPurchasePrice(productDTO.getPurchasePrice());
        product.setTotalPrice(productDTO.getTotalPrice());
        product.setQuantity(productDTO.getQuantity());
        product.setProfitOrLoss(productDTO.getProfitOrLoss());
        product.setStatus(productDTO.getStatus());

        if(productDTO.getCategoryId() != null){
            Category category = categoryRepo.findById(productDTO.getCategoryId())
                    .orElseThrow(() -> new ResourceNotFoundException("categoryId", "categoryId", productDTO.getCategoryId()));
            product.setCategory(category);
        }

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

//        if (productDTO.getStock() == null) {
//            productDTO.setStock(productDTO.getQuantity());
//        } else {
//            int updatedStock = productDTO.getStock() - productDTO.getQuantity();
//            if (updatedStock < 0) {
//                throw new IllegalArgumentException("Not enough stock available for products :" + productDTO.getProductName());
//
//            }
//            productDTO.setStock(updatedStock);
//        }

        return productDTO;
    }


    @Override
    public ProductDTO updateProductStatus(int productId, ProductStatus status) {
        Product product = productRepo.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product", "productId", productId));

        product.setStatus(status); // Update the status

//        // If status is APPROVED, update or create stock
//        if (status == ProductStatus.APPROVED) {
//            Category category = product.getCategory();
//            int quantity = product.getQuantity();
//
//            Stock stock = stockRepo.findByCategory(category).orElse(null);
//            if (stock == null) {
//                // New stock entry
//                stock = new Stock(quantity, category);
//            } else {
//                // Update existing stock
//                stock.setQuantity(stock.getQuantity() + quantity);
//            }
//            stockRepo.save(stock);
//        }

          if(status==ProductStatus.APPROVED){
              int categoryId=product.getCategory().getId();
              int quantity=product.getQuantity();
              stockService.updateStockAfterApproval(categoryId,quantity);

          }

        Product updatedProduct = productRepo.save(product);
        return productToDto(updatedProduct);
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
    public List<ProductDTO> findByEmail(String email) {
        List<Product> products = productRepo.findByEmail(email);

        return products.stream()
                .map(this::productToDto)
                .collect(Collectors.toList());
    }


    @Override
    public List<ProductDTO> findByEmailAndStatus(String email, ProductStatus status) {
        List<Product> products = productRepo.findByEmailAndStatus(email, status);

        return products.stream()
                .map(this::productToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> searchProductByKeyword(String keyword) {
        List<Product> products = productRepo.findByProductNameContainingIgnoreCase(keyword);
        return products.stream()
                .map(this::productToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDTORes getUpdateImage(int productId, String imageName, String imageUrl) {

        Product product = productRepo.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        product.setImageName(imageName);
        product.setImageUrl(imageUrl);

        Product saved = productRepo.save(product);
        return productToDtoRes(saved);
    }


//    @Override
//    public ProductDTO getItemById(int productId) {
//     Product product=productRepo.findById(productId)
//             .orElseThrow(()->new RuntimeException("Product not found"));
//       return modelMapper.map(product,ProductDTO.class);
//    }


    // Mapping: ProductDTO → Product
    public Product dtoToProduct(ProductDTO productDTO) {
        return modelMapper.map(productDTO, Product.class);
    }

    // Mapping: Product → ProductDTO (with Stock info)
    public ProductDTO productToDto(Product product) {
        ProductDTO dto = modelMapper.map(product, ProductDTO.class);
        dto.setId(product.getId());

        // Load stock if exists by category
        stockRepo.findByCategoryId(product.getCategory().getId()).ifPresent(stock -> {
            StockDTO stockDTO = modelMapper.map(stock, StockDTO.class);
            dto.setStock(stockDTO);
        });

        return dto;
    }



    public ProductDTORes productToDtoRes(Product product) {
        ProductDTORes dto=modelMapper.map(product,ProductDTORes.class);
        dto.setId(product.getId());
        dto.setCreatedBy(product.getCreatedBy().getRole().name());
        return dto;
    }

}



    