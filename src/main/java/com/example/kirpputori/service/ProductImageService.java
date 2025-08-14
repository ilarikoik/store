package com.example.kirpputori.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.kirpputori.model.User.Product.Product;
import com.example.kirpputori.model.User.Product.ProductImage;

@Service
public class ProductImageService {

    // public String store(MultipartFile file) throws IOException {
    // String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();
    // Path path = Paths.get("uploads").resolve(fileName);
    // Files.createDirectories(path.getParent());
    // Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
    // return "/uploads/" + fileName;
    // }

    public ProductImage store(MultipartFile file, Product product) throws IOException {
        ProductImage img = new ProductImage();
        img.setFileName(file.getOriginalFilename());
        img.setContentType(file.getContentType());
        img.setData(file.getBytes());
        img.setProduct(product);
        return img; // Tämän ProductImage-olion tallennat repositoryn kautta
    }

}
