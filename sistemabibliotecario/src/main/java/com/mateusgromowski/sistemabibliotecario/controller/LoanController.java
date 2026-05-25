package com.mateusgromowski.sistemabibliotecario.controller;

import java.sql.SQLException;
import java.util.Optional;

import com.mateusgromowski.sistemabibliotecario.dto.LoanDTO;
import com.mateusgromowski.sistemabibliotecario.dto.LoanDetailedDTO;
import com.mateusgromowski.sistemabibliotecario.model.Loan;
import com.mateusgromowski.sistemabibliotecario.service.LoanService;

public class LoanController {
    private LoanService service;

    public LoanController(LoanService service) {
        this.service = service;
    }

    public void addLoan(int bookId, int userId) {
        try {
            service.addLoan(new LoanDTO(bookId, userId));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void devolute(int id) {
        try {
            service.returnLoan(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Optional<Loan> getLoanById(int id) {
        Optional<Loan> loan = Optional.empty();
        try {
            loan = service.getLoanById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return loan;
    }

    public void updateLoan(int id, int bookId, int userId) {
        LoanDTO dto = new LoanDTO(bookId, userId);
        try {
            service.updateLoan(id, dto);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Optional<LoanDetailedDTO> getFormattedLoan(int id) {
        try {
            return service.getFormattedLoan(id);
        } catch (SQLException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    public void deleteLoan(int id) {
        try {
            service.deleteLoan(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
