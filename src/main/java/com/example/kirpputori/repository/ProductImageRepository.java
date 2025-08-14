package com.example.kirpputori.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.multipart.MultipartFile;

import com.example.kirpputori.model.User.Product.ProductImage;

public interface ProductImageRepository extends JpaRepository<ProductImage, Long> {

}
