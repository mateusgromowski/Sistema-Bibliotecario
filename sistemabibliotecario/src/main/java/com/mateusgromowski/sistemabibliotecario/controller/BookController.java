package com.mateusgromowski.sistemabibliotecario.controller;

import java.sql.SQLException;
import java.util.Optional;

import com.mateusgromowski.sistemabibliotecario.exception.ActiveBorrowException;
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
        } catch (SQLException | IllegalArgumentException e) {
            System.out.println("O livro não pôde ser adicionado.");
        }
    }

    public Optional<Book> getBookById(int id) {
        try {
            return service.getBookById(id);
        } catch (SQLException e) {
            System.out.println("O livro não pôde ser encontrado");
            return Optional.empty();
        }
    }

    public void updateBook(int id, String title, String author, String isbn) {
        Book book = Book.builder().id(id).title(title).author(author).isbn(isbn).build();
        try {
            service.updateBook(id, book);
            System.out.println("Livro atualizado com sucesso!");
        } catch (SQLException e) {
            System.out.println("O livro não pôde ser atualizado.");
        }
    }

    public void deleteBook(int id) {
        try {
            service.deleteBook(id);
            System.out.println("Livro deletado com sucesso!");
        } catch (SQLException | ActiveBorrowException e) {
            System.out.println("Livro não pôde ser deletado. Um empréstimo está ativo.");
        }
    }
}
