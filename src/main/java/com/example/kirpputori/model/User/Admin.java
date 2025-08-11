package com.example.kirpputori.model.User;

import jakarta.persistence.Entity;

@Entity
public class Admin extends AppUser {

    private String role = "Admin";

    public Admin() {
    }

    public Admin(String name, String password) {
        super(name, password);
    }

    public String getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "Admin " + super.toString() + "role=" + role + "]";
    }

}
