package com.mateusgromowski.sistemabibliotecario.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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


}
