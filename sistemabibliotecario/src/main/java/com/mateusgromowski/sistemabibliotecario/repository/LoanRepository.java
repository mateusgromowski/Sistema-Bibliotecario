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
import com.mateusgromowski.sistemabibliotecario.dto.LoanDetailedDTO;
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
            throw new SQLException("Impossível criar empréstimo. " + e.getMessage());
        }
    }

    public void returnLoan(int id) throws SQLException {
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
        try (Connection conn = connectionFactory.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    int bookId = rs.getInt("book_id");
                    int userId = rs.getInt("user_id");
                    LocalDate borrowDate = rs.getDate("borrow_date").toLocalDate();
                    Date devolutionDate = rs.getDate("devolution_date");
                    LocalDate devolutionLocalDate = devolutionDate != null ? devolutionDate.toLocalDate() : null;
                    loan = Loan.builder().id(id).bookId(bookId).userId(userId)
                            .borrowDate(borrowDate)
                            .devolutionDate(devolutionLocalDate)
                            .build();
                }
            }
            return Optional.ofNullable(loan);
        } catch (SQLException e) {
            throw new SQLException("Empréstimo inalcançável. " + e.getMessage());
        }

    }

    public void updateLoan(int id, LoanDTO dto) throws SQLException {
        String sql = "UPDATE loan SET book_id = ?, user_id = ? WHERE id = ?";
        try (Connection conn = connectionFactory.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, dto.bookId());
            ps.setInt(2, dto.userId());
            ps.setInt(3, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException("Impossível atualizar empréstimo. " + e.getMessage());
        }
    }

    public Optional<LoanDetailedDTO> getFormattedLoan(int id) throws SQLException {
        String sql = "select loan.id, title, name, borrow_date, devolution_date from loan join book on loan.book_id = book.id join user_table on loan.user_id = user_table.id where loan.id = ?";
        LoanDetailedDTO loanDto = null;
        try (Connection conn = connectionFactory.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery();) {
                if (rs.next()) {
                    Date devolutionDate = rs.getDate("devolution_date");
                    LocalDate devolutionLocalDate = devolutionDate != null ? devolutionDate.toLocalDate() : null;
                    String title = rs.getString("title");
                    String userName = rs.getString("name");
                    LocalDate borrowDate = rs.getDate("borrow_date").toLocalDate();
                    loanDto = LoanDetailedDTO
                            .builder()
                            .id(id)
                            .title(title)
                            .name(userName)
                            .borrowDate(borrowDate)
                            .devolutionDate(devolutionLocalDate)
                            .build();

                }
            }

            return Optional.ofNullable(loanDto);
        } catch (SQLException e) {
            throw new SQLException("Empréstimo inalcançável. " + e.getMessage());
        }
    }

    public void deleteLoan(int id) throws SQLException {
        String sql = "DELETE FROM loan WHERE id = ?";
        try (Connection conn = connectionFactory.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new SQLException("Impossível deletar empréstimo. " + e.getMessage());
        }
    }

}
