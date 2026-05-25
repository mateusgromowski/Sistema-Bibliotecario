package com.mateusgromowski.sistemabibliotecario.service;

import java.sql.SQLException;
import java.util.Optional;

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

    public Optional<User> getUserById(int id) throws SQLException {
        return Optional.ofNullable(repository.getUserById(id));
    }

    public void updateUser(User user, int id) throws SQLException {
        repository.updateUser(user, id);
    }

    public void deleteUser(int id) throws SQLException {
        repository.deleteUser(id);
    }
}
