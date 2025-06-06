package com.example.e_Cart.project;

import com.example.e_Cart.project.dto.ProductDTO;
import com.example.e_Cart.project.entity.Product;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ECartProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ECartProjectApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();

		// Skip mapping category from DTO to Entity to avoid conversion error
		modelMapper.typeMap(ProductDTO.class, Product.class).addMappings(mapper -> {
			mapper.skip(Product::setCategory);
		});

		return modelMapper;
	}
}
