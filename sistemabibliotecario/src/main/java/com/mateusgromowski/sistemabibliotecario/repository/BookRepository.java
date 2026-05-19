package com.mateusgromowski.sistemabibliotecario.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mateusgromowski.conn.ConnectionFactory;
import com.mateusgromowski.sistemabibliotecario.model.Book;

public class BookRepository {
    private ConnectionFactory connectionFactory;

    public BookRepository(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    public void addBook(Book book) throws SQLException {
        final String SQL = "INSERT INTO book(title, author, isbn) VALUES (?, ?, ?)";
        try (Connection conn = connectionFactory.getConnection(); PreparedStatement ps = conn.prepareStatement(SQL);) {
            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setString(3, book.getIsbn());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException("Erro ao adicionar livro ao banco de dados. " + e.getMessage());
        }
    }

    public Book getBookById(int id) throws SQLException {
        Book book = null;
        String sql = "SELECT id, title, author, isbn FROM book WHERE id = ?";
        try (Connection conn = connectionFactory.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                book = Book.builder().id(Integer.parseInt(rs.getString("id"))).title(rs.getString("title"))
                        .author(rs.getString("author"))
                        .isbn(rs.getString("isbn"))
                        .build();
            }
            return book;
        } catch (SQLException e) {
            throw new SQLException("Erro ao buscar o livro no banco de dados. " + e.getMessage());
        }
    }
}
