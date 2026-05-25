package com.mateusgromowski.sistemabibliotecario.controller;

import java.sql.SQLException;
import java.util.Optional;

import com.mateusgromowski.sistemabibliotecario.model.Book;
import com.mateusgromowski.sistemabibliotecario.service.BookService;

public class BookController {
    private BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    public void addBook(String title, String author, String isbn) {
        Book book = Book.builder().title(title).author(author).isbn(isbn).build();
        try {
            service.addBook(book);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Optional<Book> getBookById(int id) {
        try {
            return service.getBookById(id);
        } catch (SQLException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    public void updateBook(int id, String title, String author, String isbn) {
        Book book = Book.builder().id(id).title(title).author(author).isbn(isbn).build();
        try {
            service.updateBook(id, book);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteBook(int id) {
        try {
            service.deleteBook(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
