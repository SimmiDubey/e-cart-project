package com.example.e_Cart.project.service.impl;

import com.example.e_Cart.project.dto.ProductDTO;
import com.example.e_Cart.project.entity.Product;
import com.example.e_Cart.project.exception.ResourceNotFoundException;
import com.example.e_Cart.project.repository.ProductRepo;
import com.example.e_Cart.project.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
        productDTO = calculateSale(productDTO);

       Product product=this.dtoToProduct(productDTO);
      Product savedProduct=productRepo.save(product);

        return this.productToDto(savedProduct);
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        List<Product>products=this.productRepo.findAll();


        List<ProductDTO>productDTOS = products.stream()
                .map(this::productToDto)
                .collect(Collectors.toList());
        return productDTOS;
    }

    @Override
    public ProductDTO getProductById(int productId) {
        Product product=this.productRepo.findById(productId).orElseThrow(()-> new ResourceNotFoundException("Product","productId",+productId));
        return this.productToDto(product);
    }

    @Override
    public ProductDTO updateProductDto(ProductDTO productDTO, int productId) {
        Product product=this.productRepo.findById(productId).orElseThrow(()-> new ResourceNotFoundException("Product","productId",+productId));
        product.setProductName(productDTO.getProductName());
        product.setMrp(productDTO.getMrp());
        product.setDiscount(productDTO.getDiscount());
        product.setCreatedOn(productDTO.getCreatedOn());
        product.setUpdatedOn(productDTO.getUpdatedOn());
        product.setDescription(productDTO.getDescription());
        product.setCategory(productDTO.getDescription());
        product.setSalePrice(productDTO.getSalePrice());
        product.setPurchasePrice(productDTO.getPurchasePrice());
        product.setTotalPrice(productDTO.getTotalPrice());
        product.setQuantity(productDTO.getQuantity());

        Product updateProduct=this.productRepo.save(product);
        ProductDTO productDTO1=this.productToDto(updateProduct);

        return productDTO1;
    }

    @Override
    public void deleteProductDTOById(int productId) {
     Product product=this.productRepo.findById(productId).orElseThrow(()-> new ResourceNotFoundException("Product","productId",productId));
        this.productRepo.delete(product);
    }

    @Override
    public ProductDTO calculateSale(ProductDTO productDTO) {

        //List<ProductDTO>productDTOS = productDTO.getProductDTOS();


        double salePrice = productDTO.getSalePrice();
        int quantity = productDTO.getQuantity();
        double purchasePrice = productDTO.getPurchasePrice();
        double discountPercent = productDTO.getDiscount();


        double totalBeforeDiscount = salePrice * quantity;


        double discountAmount = (discountPercent / 100.0) * totalBeforeDiscount;


        double totalAfterDiscount = totalBeforeDiscount - discountAmount;


      //  double profitOrLoss = (salePrice - purchasePrice) * quantity;

        double profitOrLoss=(salePrice-(discountPercent*salePrice/100))-purchasePrice;


        productDTO.setTotalPrice(totalAfterDiscount);
        productDTO.setProfitOrLoss(profitOrLoss);

        return productDTO;
    }


    public Product dtoToProduct(ProductDTO productDTO){
       Product product=this.modelMapper.map(productDTO,Product.class);
       return product;
    }

    public ProductDTO productToDto(Product product){
        ProductDTO productDTO=this.modelMapper.map(product,ProductDTO.class);
        return productDTO;
    }


}
