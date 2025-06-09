package com.example.e_Cart.project.dto;

import com.example.e_Cart.project.entity.Product;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

public class CategoryDTO {
    private int id;
    private String title;
    private String description;







    public CategoryDTO() {
    }

    public CategoryDTO(int id,String title, String description) {
        this.title = title;
        this.description = description;
        this.id=id;


    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }




    }

