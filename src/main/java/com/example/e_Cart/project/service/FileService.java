package com.example.e_Cart.project.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    String saveImage(MultipartFile file, String uploadPath);

}
