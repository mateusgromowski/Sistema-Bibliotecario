package com.mateusgromowski.service;

import com.mateusgromowski.sistemabibliotecario.model.Book;
import com.mateusgromowski.sistemabibliotecario.repository.BookRepository;

public class BookService {
    private BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public void addBook(Book book) {
        if (book.getTitle().isBlank() || book.getAuthor().isBlank() || book.getIsbn().isBlank()) {
            throw new IllegalArgumentException("O livro não pode ter espaços em branco.");
        }

        if (book.getIsbn().length() > 13) {
            throw new IllegalArgumentException("O ISBN não pode ser maior que 13 caracteres.");
        }

        repository.addBook(book);

    }
}
