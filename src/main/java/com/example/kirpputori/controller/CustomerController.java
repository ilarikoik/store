package com.example.kirpputori.controller;

import org.springframework.web.bind.annotation.RestController;
import com.example.kirpputori.dataTransferObject.ApiResponse;
import com.example.kirpputori.model.User.Customer;
import com.example.kirpputori.service.CustomerService;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping("/customer")
    public ResponseEntity<ApiResponse> addCustomer(@RequestBody Customer customer) {
        ApiResponse res = customerService.saveCustomer(customer);

        if (!res.isSuccess()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(res);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(res);
    }

    @GetMapping("/customer")
    public List<Customer> getAllCustomers() {
        return customerService.findAllCustomers();
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<ApiResponse> getCustomerById(@PathVariable Long id) {
        ApiResponse res = customerService.findCustomerById(id);
        if (!res.isSuccess()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(res);
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(res);
    }

}
