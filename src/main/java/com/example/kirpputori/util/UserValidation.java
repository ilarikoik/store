package com.example.kirpputori.util;

import com.example.kirpputori.model.User.Admin;
import com.example.kirpputori.model.User.Customer;

public class UserValidation {

    public static boolean isValidUser(Customer user) {
        return user != null &&
                user.getUsername() != null && !user.getUsername().isEmpty() &&
                user.getPassword() != null && !user.getPassword().isEmpty();
    }

    public static boolean isValidUser(Admin user) {
        return user != null &&
                user.getUsername() != null && !user.getUsername().isEmpty() &&
                user.getPassword() != null && !user.getPassword().isEmpty();
    }

}
