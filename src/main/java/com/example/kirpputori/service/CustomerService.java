package com.example.kirpputori.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.kirpputori.dataTransferObject.ApiResponse;
import com.example.kirpputori.model.User.Admin;
import com.example.kirpputori.model.User.Customer;
import com.example.kirpputori.repository.CustomerRepository;
import com.example.kirpputori.util.UserValidation;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public List<Customer> findAllCustomers() {
        return repository.findAll();
    }

    public ApiResponse saveCustomer(Customer customer) {
        try {
            if (userExists(customer.getUsername())) {
                return ApiResponse.error("User already exists");
            }

            if (!UserValidation.isValidUser(customer)) {
                return ApiResponse.error("Invalid parameters");
            }
            repository.save(customer);
            return ApiResponse.success(customer);
        } catch (Exception e) {
            return ApiResponse.error(e.getMessage());
        }
    }

    public Optional<Customer> findCustomerById(Long id) {
        return repository.findById(id);
    }

    public void deleteCustomerById(Long id) {
        repository.deleteById(id);
    }

    // utils
    private boolean userExists(String username) {
        return repository.findByUsername(username).isPresent();
    }
}
