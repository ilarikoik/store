package com.example.kirpputori.model.User;

import jakarta.persistence.Entity;

@Entity
public class Customer extends AppUser {

    private String role = "Customer";

    public Customer() {
        super();
    }

    public Customer(String name, String password) {
        super(name, password);
        this.role = "Customer";
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Customer " + super.toString() + "[role=" + role + "]";
    }

}
