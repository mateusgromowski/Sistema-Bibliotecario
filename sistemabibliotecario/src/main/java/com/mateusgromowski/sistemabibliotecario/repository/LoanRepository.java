package com.mateusgromowski.sistemabibliotecario.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Optional;

import com.mateusgromowski.sistemabibliotecario.conn.ConnectionFactory;
import com.mateusgromowski.sistemabibliotecario.dto.LoanDTO;
import com.mateusgromowski.sistemabibliotecario.model.Loan;

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

    public Optional<Loan> getLoanById(int id) throws SQLException {
        String sql = "SELECT * FROM loan WHERE id = ?";
        Loan loan = null;
        try (Connection conn = connectionFactory.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                loan = Loan.builder().id(id).bookId(rs.getInt("book_id")).userId(rs.getInt("user_id"))
                        .borrowDate(rs.getDate("borrow_date").toLocalDate())
                        .devolutionDate(rs.getDate("devolution_date").toLocalDate()).build();
            }
        } catch (SQLException e) {
            throw new SQLException("Empréstimo inalcançável. " + e.getMessage());
        }
        return Optional.ofNullable(loan);
    }

    public void updateLoan(int id, int book_id, int user_id) throws SQLException {
        String sql = "UPDATE loan SET book_id = ?, user_id = ? WHERE id = ?";
        try (Connection conn = connectionFactory.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, book_id);
            ps.setInt(2, user_id);
            ps.setInt(3, id);
        } catch (SQLException e) {
            throw new SQLException("Impossível atualizar empréstimo. " + e.getMessage());
        }
    }

}
