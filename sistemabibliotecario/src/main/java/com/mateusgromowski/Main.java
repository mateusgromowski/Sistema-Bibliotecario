package com.mateusgromowski;

import com.mateusgromowski.conn.ConnectionFactory;
import com.mateusgromowski.controller.BookController;
import com.mateusgromowski.service.BookService;
import com.mateusgromowski.sistemabibliotecario.repository.BookRepository;

public class Main {
    public static void main(String[] args) {
        ConnectionFactory factory = new ConnectionFactory();
        BookRepository bookRepository = new BookRepository(factory);
        BookService bookService = new BookService(bookRepository);
        BookController bookController = new BookController(bookService);

        bookController.addBook("Crime e Castigo", "Fiódor Dostoiévski", "1234567890123");
    }
}
