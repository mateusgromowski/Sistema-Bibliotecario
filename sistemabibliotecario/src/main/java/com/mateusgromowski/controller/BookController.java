package com.mateusgromowski.controller;

import com.mateusgromowski.service.BookService;
import com.mateusgromowski.sistemabibliotecario.model.Book;

public class BookController {
    private BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    public void addBook(String title, String author, String isbn) {
        Book book = Book.builder().title(title).author(author).isbn(isbn).build();
        service.addBook(book);
    }
}
