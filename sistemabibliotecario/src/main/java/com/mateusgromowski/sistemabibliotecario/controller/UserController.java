package com.mateusgromowski.sistemabibliotecario.controller;

import java.sql.SQLException;

import com.mateusgromowski.sistemabibliotecario.model.User;
import com.mateusgromowski.sistemabibliotecario.service.UserService;

public class UserController {
    private UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    public void addUser(String name, String email) {
        User user = User.builder().name(name).email(email).build();
        try {
            service.addUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
