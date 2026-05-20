package com.mateusgromowski;

import com.mateusgromowski.sistemabibliotecario.conn.ConnectionFactory;
import com.mateusgromowski.sistemabibliotecario.controller.BookController;
import com.mateusgromowski.sistemabibliotecario.repository.BookRepository;
import com.mateusgromowski.sistemabibliotecario.service.BookService;

public class Main {
    public static void main(String[] args) {
        ConnectionFactory factory = new ConnectionFactory();
        BookRepository bookRepository = new BookRepository(factory);
        BookService bookService = new BookService(bookRepository);
        BookController bookController = new BookController(bookService);
        bookController.updateBook(1, "Noites Brancas", "Fiódor Dostoiévski", "1234567890123");
    }
}
