package com.example.e_Cart.project.service.impl;

import com.example.e_Cart.project.service.FileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;


 @Service
public class FileServiceImpl implements FileService {



    @Override
    public String saveImage(MultipartFile file, String uploadPath) {

        String originalFilename=file.getOriginalFilename();
        String fileExtension = originalFilename.substring(originalFilename.lastIndexOf("."));
        String newFileName= UUID.randomUUID() +fileExtension;

        try{
            Path path= Paths.get(uploadPath+ File.separator+newFileName);
            Files.createDirectories(path.getParent());
            file.transferTo(path);
            return newFileName;
        }catch (IOException e){
            throw new RuntimeException("Image upload failed");
        }


    }
}
