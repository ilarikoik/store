package com.example.kirpputori.model.User;

import jakarta.persistence.Entity;

@Entity
public class Admin extends AppUser {

    private String role = "Admin";

    public Admin() {
    }

    public Admin(String name, String password) {
        super(name, password);
        this.role = "Admin";
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Admin " + super.toString() + "role=" + role + "]";
    }

}
