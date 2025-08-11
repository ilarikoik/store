package com.example.kirpputori.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.kirpputori.dataTransferObject.ApiResponse;
import com.example.kirpputori.model.User.Customer;
import com.example.kirpputori.repository.CustomerRepository;
import com.example.kirpputori.util.UserValidation;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repository;

    @Autowired
    ApiResponse apiResponse;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public List<Customer> findAllCustomers() {
        return repository.findAll();
    }

    public ApiResponse saveCustomer(Customer customer) {
        try {
            if (userExists(customer.getUsername())) {
                return apiResponse.error("User already exists");
            }

            if (!UserValidation.isValidUser(customer)) {
                return apiResponse.error("Invalid parameters");
            }
            repository.save(customer);
            return apiResponse.success(customer);
        } catch (Exception e) {
            return apiResponse.error(e.getMessage());
        }
    }

    public ApiResponse findCustomerById(Long id) {
        try {
            Optional<Customer> customer = repository.findById(id);
            if (customer.isPresent()) {
                return apiResponse.success(customer);
            }
            return apiResponse.error("User not found");
        } catch (Exception e) {
            return apiResponse.error(e.getMessage());
        }
    }

    public void deleteCustomerById(Long id) {
        repository.deleteById(id);
    }

    // utils
    private boolean userExists(String username) {
        return repository.findByUsername(username).isPresent();
    }
}
