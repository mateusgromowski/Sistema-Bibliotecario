package com.mateusgromowski.sistemabibliotecario.service;

import java.sql.SQLException;

import com.mateusgromowski.sistemabibliotecario.model.Book;
import com.mateusgromowski.sistemabibliotecario.repository.BookRepository;

public class BookService {
    private BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public void addBook(Book book) throws SQLException {
        if (book.getTitle().isBlank() || book.getAuthor().isBlank() || book.getIsbn().isBlank()) {
            throw new IllegalArgumentException("O livro não pode ter espaços em branco.");
        }

        if (book.getIsbn().length() > 13) {
            throw new IllegalArgumentException("O ISBN não pode ser maior que 13 caracteres.");
        }

        repository.addBook(book);

    }

    public Book getBookById(int id) throws SQLException {
        return repository.getBookById(id);
    }

    public void updateBook(int id, Book book) throws SQLException {
        repository.updateBook(id, book);
    }
}
