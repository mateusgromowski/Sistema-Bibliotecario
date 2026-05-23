package com.mateusgromowski;

import com.mateusgromowski.sistemabibliotecario.conn.ConnectionFactory;
import com.mateusgromowski.sistemabibliotecario.controller.BookController;
import com.mateusgromowski.sistemabibliotecario.controller.LoanController;
import com.mateusgromowski.sistemabibliotecario.controller.UserController;
import com.mateusgromowski.sistemabibliotecario.model.User;
import com.mateusgromowski.sistemabibliotecario.repository.BookRepository;
import com.mateusgromowski.sistemabibliotecario.repository.LoanRepository;
import com.mateusgromowski.sistemabibliotecario.repository.UserRepository;
import com.mateusgromowski.sistemabibliotecario.service.BookService;
import com.mateusgromowski.sistemabibliotecario.service.LoanService;
import com.mateusgromowski.sistemabibliotecario.service.UserService;

public class Main {
    public static void main(String[] args) {

        ConnectionFactory connectionFactory = new ConnectionFactory();

        // Create repositories for all models
        BookRepository bookRepository = new BookRepository(connectionFactory);
        UserRepository userRepository = new UserRepository(connectionFactory);
        LoanRepository loanRepository = new LoanRepository(connectionFactory);

        // Create services for all models
        BookService bookService = new BookService(bookRepository);
        UserService userService = new UserService(userRepository);
        LoanService loanService = new LoanService(loanRepository);

        // Create controllers for all models
        BookController bookController = new BookController(bookService);
        UserController userController = new UserController(userService);
        LoanController loanController = new LoanController(loanService);

        // Mock model parameters
        String mockBookTitle = "Mock Book Title";
        String mockBookAuthor = "Mock Author";
        String mockUserName = "Mock User";
        String mockUserEmail = "mock.user@example.com";
        // bookController.addBook(mockBookTitle, mockBookAuthor, "1234567890");
        // userController.addUser(mockUserName, mockUserEmail);
        // loanController.addLoan(2, 2);
        loanController.devolute(1);
    }
}
