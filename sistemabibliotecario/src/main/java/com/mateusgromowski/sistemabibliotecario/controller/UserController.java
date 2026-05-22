package com.mateusgromowski.sistemabibliotecario.controller;

import java.sql.SQLException;
import java.util.Optional;

import com.mateusgromowski.sistemabibliotecario.model.User;
import com.mateusgromowski.sistemabibliotecario.service.UserService;

public class UserController {
    private UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    public boolean addUser(String name, String email) {
        User user = User.builder().name(name).email(email).build();
        try {
            service.addUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public Optional<User> getUserById(int id) {
        Optional<User> user = Optional.empty();
        try {
            user = Optional.ofNullable(service.getUserById(id));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public boolean updateUser(int id, String name, String email) {
        User user = User.builder().name(name).email(email).build();
        try {
            service.updateUser(user, id);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean deleteUser(int id) {
        try {
            service.deleteUser(id);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
