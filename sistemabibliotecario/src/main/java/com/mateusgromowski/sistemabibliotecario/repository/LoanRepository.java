package com.mateusgromowski.sistemabibliotecario.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

import com.mateusgromowski.sistemabibliotecario.conn.ConnectionFactory;
import com.mateusgromowski.sistemabibliotecario.dto.LoanDTO;

public class LoanRepository {
    private ConnectionFactory connectionFactory;

    public LoanRepository(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    public void addLoan(LoanDTO dto) throws SQLException {
        String sql = "INSERT INTO loan(book_id, user_id) VALUES (?, ?)";
        try (Connection conn = connectionFactory.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, dto.bookId());
            ps.setInt(2, dto.userId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException("Impossível criar empréstimo.");
        }
    }

    public void devolute(int id) throws SQLException {
        String sql = "UPDATE loan SET devolution_date = ? WHERE id = ?";
        try (Connection conn = connectionFactory.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setDate(1, Date.valueOf(LocalDate.now()));
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException("Impossível devolver livro." + e.getMessage());
        }
    }

}
