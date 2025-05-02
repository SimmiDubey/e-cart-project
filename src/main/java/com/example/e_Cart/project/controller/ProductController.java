package com.example.e_Cart.project.controller;

import com.example.e_Cart.project.dto.ApiResponse;
import com.example.e_Cart.project.dto.ProductDTO;
import com.example.e_Cart.project.dto.ResultDTO;
import com.example.e_Cart.project.entity.Product;
import com.example.e_Cart.project.entity.User;
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

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
        );

        if (authentication.isAuthenticated()) {
            UserDetails userDetails;
            userDetails = myUserDetailsService.loadUserByUsername(user.getUsername());
            return jwtService.generateToken(userDetails);
        } else {
            return "Login Failed";
        }
    }




    //save product
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/admin/add")


    public ResponseEntity<ResultDTO> addProduct(@Valid @RequestBody List<@Valid ProductDTO> productDtos) {
        ResultDTO createproductDto = this.productService.createAllProducts(productDtos);
        return new ResponseEntity<>(createproductDto, HttpStatus.CREATED);
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


}
