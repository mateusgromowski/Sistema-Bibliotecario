package com.mateusgromowski.sistemabibliotecario.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.mateusgromowski.conn.ConnectionFactory;
import com.mateusgromowski.sistemabibliotecario.model.Book;

public class BookRepository {
    private ConnectionFactory connectionFactory;

    public BookRepository(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    public void addBook(Book book) {
        final String SQL = "INSERT INTO book(title, author, isbn) VALUES (?, ?, ?)";
        try (Connection conn = connectionFactory.getConnection();
                PreparedStatement ps = conn.prepareStatement(SQL);) {
            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setString(3, book.getIsbn());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
