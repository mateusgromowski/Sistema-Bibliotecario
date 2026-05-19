package com.mateusgromowski.controller;

import java.sql.SQLException;

import com.mateusgromowski.service.BookService;
import com.mateusgromowski.sistemabibliotecario.model.Book;

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

    public Book getBookById(int id) {
        try {
            return service.getBookById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
