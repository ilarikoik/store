package com.example.kirpputori.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.kirpputori.dataTransferObject.ApiResponse;
import com.example.kirpputori.model.User.Admin;
import com.example.kirpputori.repository.AdminRepository;
import com.example.kirpputori.util.UserValidation;

@Service
public class AdminService {

    @Autowired
    private AdminRepository repository;

    public AdminService(AdminRepository repository) {
        this.repository = repository;
    }

    public List<Admin> findAllAdmins() {
        return repository.findAll();
    }

    public ApiResponse saveAdmin(Admin admin) {
        try {
            if (userExists(admin.getUsername())) {
                return ApiResponse.error("User already exists");
            }
            if (!UserValidation.isValidUser(admin)) {
                return ApiResponse.error("Invalid parameters");
            }
            repository.save(admin);
            return ApiResponse.success(admin);

        } catch (Exception e) {
            return ApiResponse.error(e.getMessage());
        }
    }

    public ApiResponse findAdminById(Long id) {
        try {
            Optional<Admin> user = repository.findById(id);
            if (user.isPresent()) {
                return ApiResponse.success(user);
            }
        } catch (Exception e) {
            return ApiResponse.error(e.getMessage());
        }
        return ApiResponse.error("User not found");
    }

    public void deleteAdminById(Long id) {
        repository.deleteById(id);
    }

    // utils
    // --------------------------------------------------------------------------
    private boolean userExists(String username) {
        return repository.findByUsername(username).isPresent();
    }
}
