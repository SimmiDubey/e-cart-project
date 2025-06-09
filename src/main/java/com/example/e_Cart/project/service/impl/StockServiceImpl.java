package com.example.e_Cart.project.service.impl;

import com.example.e_Cart.project.dto.CategoryDTO;
import com.example.e_Cart.project.dto.StockDTO;
import com.example.e_Cart.project.entity.Category;
import com.example.e_Cart.project.entity.Stock;
import com.example.e_Cart.project.exception.ResourceNotFoundException;
import com.example.e_Cart.project.repository.CategoryRepo;
import com.example.e_Cart.project.repository.StockRepo;
import com.example.e_Cart.project.service.StockService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StockServiceImpl implements StockService {

    @Autowired
    private StockRepo stockRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public StockDTO updateStockAfterApproval(int categoryId, int quantity) {
        Category category = categoryRepo.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId", categoryId));

        Optional<Stock> stockOptional = stockRepo.findByCategoryId(categoryId);

        Stock updatedStock;

        if (stockOptional.isPresent()) {
            updatedStock = stockOptional.get();
            updatedStock.setQuantity(updatedStock.getQuantity() + quantity);
        } else {
            updatedStock = new Stock();
            updatedStock.setQuantity(quantity);
            updatedStock.setCategory(category);
        }

        Stock savedStock = stockRepo.save(updatedStock);
        return modelMapper.map(savedStock, StockDTO.class);
    }

    // Helper method: DTO to Entity
    public Stock dtoToStock(StockDTO stockDTO) {
        return modelMapper.map(stockDTO, Stock.class);
    }

    // Helper method: Entity to DTO
    public StockDTO stockToDto(Stock stock) {
        return modelMapper.map(stock, StockDTO.class);
    }

    // Optional: map to CategoryDTO if needed
    public CategoryDTO categoryToDto(Category category) {
        return modelMapper.map(category, CategoryDTO.class);
    }
}
