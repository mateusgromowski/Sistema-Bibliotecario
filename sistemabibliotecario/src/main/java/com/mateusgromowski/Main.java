package com.mateusgromowski;

import com.mateusgromowski.sistemabibliotecario.conn.ConnectionFactory;
import com.mateusgromowski.sistemabibliotecario.controller.BookController;
import com.mateusgromowski.sistemabibliotecario.controller.UserController;
import com.mateusgromowski.sistemabibliotecario.repository.BookRepository;
import com.mateusgromowski.sistemabibliotecario.repository.UserRepository;
import com.mateusgromowski.sistemabibliotecario.service.BookService;
import com.mateusgromowski.sistemabibliotecario.service.UserService;

public class Main {
    public static void main(String[] args) {
        ConnectionFactory factory = new ConnectionFactory();
        UserRepository ur = new UserRepository(factory);
        UserService us = new UserService(ur);
        UserController uc = new UserController(us);
        uc.addUser("Mateus", "mateusbarbosagromowski@gmail.com");
    }
}
