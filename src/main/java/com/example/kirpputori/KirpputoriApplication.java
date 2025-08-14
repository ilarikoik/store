package com.example.kirpputori;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.multipart.MultipartFile;

import com.example.kirpputori.service.ProductImageService;

@SpringBootApplication
public class KirpputoriApplication {

	public static void main(String[] args) {
		SpringApplication.run(KirpputoriApplication.class, args);

		System.out.println("Tallennettu URL: ");
	}

}
