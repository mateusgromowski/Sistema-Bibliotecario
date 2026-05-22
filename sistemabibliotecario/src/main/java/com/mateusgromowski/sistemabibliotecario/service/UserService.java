package com.mateusgromowski.sistemabibliotecario.service;

import java.sql.SQLException;

import com.mateusgromowski.sistemabibliotecario.model.User;
import com.mateusgromowski.sistemabibliotecario.repository.UserRepository;

public class UserService {
    private UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public void addUser(User user) throws SQLException {
        repository.addUser(user);
    }

    public User getUserById(int id) throws SQLException {
        return repository.getUserById(id);
    }

    public void updateUser(User user, int id) throws SQLException {
        repository.updateUser(user, id);
    }

    public void deleteUser(int id) throws SQLException {
        repository.deleteUser(id);
    }
}
