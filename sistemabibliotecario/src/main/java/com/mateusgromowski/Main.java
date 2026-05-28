package com.mateusgromowski;

import java.util.Scanner;

import com.mateusgromowski.sistemabibliotecario.conn.ConnectionFactory;
import com.mateusgromowski.sistemabibliotecario.controller.BookController;
import com.mateusgromowski.sistemabibliotecario.controller.LoanController;
import com.mateusgromowski.sistemabibliotecario.controller.UserController;
import com.mateusgromowski.sistemabibliotecario.repository.BookRepository;
import com.mateusgromowski.sistemabibliotecario.repository.LoanRepository;
import com.mateusgromowski.sistemabibliotecario.repository.UserRepository;
import com.mateusgromowski.sistemabibliotecario.service.BookService;
import com.mateusgromowski.sistemabibliotecario.service.LoanService;
import com.mateusgromowski.sistemabibliotecario.service.UserService;
import com.mateusgromowski.ui.Menu;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ConnectionFactory connectionFactory = new ConnectionFactory();
        BookRepository repository = new BookRepository(connectionFactory);
        BookService bookService = new BookService(repository);
        BookController bookController = new BookController(bookService);

        UserRepository userRepository = new UserRepository(connectionFactory);
        UserService userService = new UserService(userRepository);
        UserController userController = new UserController(userService);

        LoanRepository loanRepository = new LoanRepository(connectionFactory);
        LoanService loanService = new LoanService(loanRepository);
        LoanController loanController = new LoanController(loanService);

        Menu menu = new Menu(sc, bookController, userController, loanController);
        menu.start();
    }
}
