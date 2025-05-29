package com.example.e_Cart.project.controller;

import com.example.e_Cart.project.dto.ApiResponse;
import com.example.e_Cart.project.dto.ProductDTO;
//import com.example.e_Cart.project.dto.ResultDTO;
import com.example.e_Cart.project.dto.ResultDTORes;
import com.example.e_Cart.project.entity.User;
import com.example.e_Cart.project.enums.ProductStatus;
import com.example.e_Cart.project.exception.ResourceNotFoundException;
import com.example.e_Cart.project.repository.UserRepo;
import com.example.e_Cart.project.service.JwtService;
import com.example.e_Cart.project.service.MyUserDetailsService;
import com.example.e_Cart.project.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserRepo userRepo;

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword())
        );

        if (authentication.isAuthenticated()) {
            UserDetails userDetails;
            userDetails = myUserDetailsService.loadUserByUsername(user.getEmail());
            return jwtService.generateToken(userDetails);
        } else {
            return "Login Failed";
        }
    }




    @PreAuthorize("hasRole('WAREHOUSE')")
    @PostMapping("/admin/add")
    public ResponseEntity<ResultDTORes> addProduct(
            @Valid @RequestBody List<@Valid ProductDTO> productDtos,
            @RequestHeader("Authorization") String authHeader) {

        // Extract JWT token from Authorization header
        String token = authHeader.substring(7);

        //  Use correct method from JwtService
        String email = jwtService.extractUserName(token);

        //  Find user by username
        Optional<User> user = userRepo.findByEmail(email);
        if (user.isEmpty()) {
            throw new ResourceNotFoundException("Email", "email", email);
        }

        //  Pass user to ProductService
        ResultDTORes result = productService.createAllProducts(productDtos, user.orElse(null));
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }






    //get the product

    @PreAuthorize("hasAnyRole('WAREHOUSE','USER')")
    @GetMapping("/products/warehouse")
    public ResponseEntity<List<ProductDTO>> getProducts(){
    return ResponseEntity.ok(this.productService.getAllProducts());

    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductDTO>getProducts(@PathVariable int productId){
   return ResponseEntity.ok(this.productService.getProductById(productId));
    }

    @PreAuthorize("hasAnyRole('ADMIN','WAREHOUSE')")
    @PutMapping("/admin/{productId}")

      public ResponseEntity<ProductDTO>updateProduct(@RequestBody ProductDTO productDTO,@PathVariable int productId){
     ProductDTO updateProduct = this.productService.updateProductDto(productDTO,productId);
     return ResponseEntity.ok(updateProduct);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/admin/{productId}")
    public ResponseEntity<?>deleteProduct(@PathVariable("productId") int productId){
     this.productService.deleteProductDTOById(productId);
     return new ResponseEntity<>(new ApiResponse("Product deleted Successfully",true),HttpStatus.OK);

    }


    @PreAuthorize("hasAnyRole('ADMIN','WAREHOUSE')")
    @GetMapping("/status")
    public ResponseEntity<List<ProductDTO>> getProductsByStatus(@RequestParam("value") String value) {
        ProductStatus productStatus = ProductStatus.valueOf(value.toUpperCase());
        List<ProductDTO> products = productService.getProductsByStatus(productStatus);
        return ResponseEntity.ok(products);
    }

    @GetMapping("/api/products/{email}")
    public ResponseEntity<List<ProductDTO>> getProductsByEmail(@PathVariable String email) {
        List<ProductDTO> products = productService.findByEmail(email);
        return ResponseEntity.ok(products);
    }

    @GetMapping("/api/{email}/status/{status}")
    public ResponseEntity<List<ProductDTO>> getStatusProduct(@PathVariable String email,@PathVariable ProductStatus status) {
        List<ProductDTO> products = productService.findByEmailAndStatus(email,status);
        return ResponseEntity.ok(products);
    }


    @GetMapping("/search")
    public ResponseEntity<?> getSearchProduct(
            @RequestParam String keyword) {

        List<ProductDTO> productDTOS = productService.searchProductByKeyword(keyword);

        if (productDTOS.isEmpty()) {
            ApiResponse response = new ApiResponse("This product is not available", false);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(productDTOS);
    }


    }