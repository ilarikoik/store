package com.example.kirpputori;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.kirpputori.model.User.Admin;
import com.example.kirpputori.model.User.Customer;
import com.example.kirpputori.service.CustomerService;

@SpringBootApplication
public class KirpputoriApplication {

	public static void main(String[] args) {
		SpringApplication.run(KirpputoriApplication.class, args);

	}

}
