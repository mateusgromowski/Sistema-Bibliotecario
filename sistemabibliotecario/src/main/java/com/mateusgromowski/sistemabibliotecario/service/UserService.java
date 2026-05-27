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
        String name = user.getName();
        String email = user.getEmail();
        verifyInfo(name, Type.NOME);
        verifyInfo(email, Type.EMAIL);
        repository.addUser(user);
    }

    private void verifyInfo(String string, Type type) throws IllegalArgumentException {
        if (string == null || string.isBlank()) {
            throw new IllegalArgumentException(
                    "O %s não pode ser em branco, vazio ou nulo.".formatted(type.toString().toLowerCase()));
        }

        if (type == Type.EMAIL) {
            boolean match = string.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
            if (!match) {
                throw new IllegalArgumentException("Email inválido.");
            }
        }
    }

    public Optional<User> getUserById(int id) throws SQLException {
        return repository.getUserById(id);
    }

    public void updateUser(User user, int id) throws SQLException {
        repository.updateUser(user, id);
    }

    public void deleteUser(int id) throws SQLException {
        repository.deleteUser(id);
    }
}
