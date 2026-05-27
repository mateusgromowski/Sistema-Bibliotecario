package com.mateusgromowski.sistemabibliotecario.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.NoSuchElementException;
import java.util.Optional;

import com.mateusgromowski.sistemabibliotecario.conn.ConnectionFactory;
import com.mateusgromowski.sistemabibliotecario.exception.ActiveBorrowException;
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

    public Optional<Book> getBookById(int id) throws SQLException {
        Book book = null;
        String sql = "SELECT id, title, author, isbn FROM book WHERE id = ?";
        try (Connection conn = connectionFactory.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery();) {
                if (rs.next()) {
                    book = Book.builder().id(rs.getInt("id")).title(rs.getString("title"))
                            .author(rs.getString("author"))
                            .isbn(rs.getString("isbn"))
                            .build();
                }
            }
            return Optional.ofNullable(book);
        } catch (SQLException e) {
            throw new SQLException("Erro ao buscar o livro no banco de dados. " + e.getMessage());
        }
    }

    public void updateBook(int id, Book book) throws SQLException {
        String sql = "UPDATE book SET title = ?, author = ?, isbn = ? WHERE id = ?";
        try (Connection conn = connectionFactory.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setString(3, book.getIsbn());
            ps.setInt(4, id);
            int rows = ps.executeUpdate();
            if (rows == 0) {
                throw new SQLException("Livro não encontrado.");
            }
        } catch (SQLException e) {
            throw new SQLException("Erro ao atualizar o livro: " + e.getMessage());
        }
    }

    public void verifyLoanByBookId(int id) throws ActiveBorrowException {
        String sql = "SELECT * FROM loan WHERE book_id = ? AND devolution_date IS NULL";
        try (Connection conn = connectionFactory.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery();) {

                if (rs.next()) {
                    throw new ActiveBorrowException("O livro está com empréstimo ativo.");
                }
            }
        } catch (SQLException e) {
            throw new NoSuchElementException("Livro não encontrado." + e.getMessage());
        }
    }

    public void deleteBook(int id) throws SQLException {
        String sql = "DELETE FROM book WHERE id = ?";
        try (Connection conn = connectionFactory.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            if (rows == 0) {
                throw new NoSuchElementException("Elemento inexistente.");
            }
        } catch (SQLException e) {
            throw new SQLException("Erro ao deletar livro: " + e.getMessage());
        }
    }
}
