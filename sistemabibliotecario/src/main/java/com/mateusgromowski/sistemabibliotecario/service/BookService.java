package com.mateusgromowski.sistemabibliotecario.service;

import java.sql.SQLException;
import java.util.Optional;

import com.mateusgromowski.sistemabibliotecario.model.Book;
import com.mateusgromowski.sistemabibliotecario.repository.BookRepository;

public class BookService {
    private BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public void addBook(Book book) throws SQLException {
        validateBook(book);
        repository.addBook(book);

    }

    private void validateBook(Book book) throws IllegalArgumentException {
        String title = book.getTitle();
        String author = book.getAuthor();
        String isbn = book.getIsbn();
        if (title == null || author == null || isbn == null) {
            throw new NullPointerException("Os dados do livro não podem ser nulos.");
        }

        if (title.isBlank() || author.isBlank() || isbn.isBlank()) {
            throw new IllegalArgumentException("O livro não pode ter nome, autor ou ISBN em branco.");
        }

        if (!isbn.matches("\\d+")) {
            throw new IllegalArgumentException("O ISBN deve conter apenas dígitos, sem hífens.");
        }

        int isbnLength = isbn.length();
        if (!(isbnLength == 10 || isbnLength == 13)) {
            throw new IllegalArgumentException("O ISBN deve ter 13 ou 10 dígitos.");
        }
    }

    public Optional<Book> getBookById(int id) throws SQLException {
        return repository.getBookById(id);
    }

    public void updateBook(int id, Book book) throws SQLException {
        validateBook(book);
        repository.updateBook(id, book);
    }

    public void deleteBook(int id) throws SQLException {
        repository.deleteBook(id);
    }
}
