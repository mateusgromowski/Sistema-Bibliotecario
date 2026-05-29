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

    public void addUser(String name, String email) throws SQLException {
        User user = User.builder().name(name).email(email).build();
        try {
            service.addUser(user);
        } catch (SQLException e) {
            throw new SQLException(e.getMessage() + " Email já existente.");
        }
    }

    public Optional<User> getUserById(int id) {
        try {
            return service.getUserById(id);
        } catch (SQLException e) {
            e.printStackTrace();
            return Optional.empty();
        }
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
