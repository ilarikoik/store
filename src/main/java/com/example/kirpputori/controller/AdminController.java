package com.example.kirpputori.controller;

import org.springframework.web.bind.annotation.RestController;
import com.example.kirpputori.dataTransferObject.ApiResponse;
import com.example.kirpputori.model.User.Admin;
import com.example.kirpputori.service.AdminService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api")
public class AdminController {

    @Autowired
    AdminService adminService;

    @PostMapping("/admin")
    public ResponseEntity<ApiResponse> addCustomer(@RequestBody Admin admin) {
        ApiResponse response = adminService.saveAdmin(admin); // service palauttaa viestin

        if (!response.isSuccess()) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(response);
        }

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @GetMapping("/admin")
    public List<Admin> getAllCustomers() {
        return adminService.findAllAdmins();
    }

}
