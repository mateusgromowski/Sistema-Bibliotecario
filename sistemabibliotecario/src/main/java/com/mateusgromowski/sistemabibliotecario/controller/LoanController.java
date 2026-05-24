package com.mateusgromowski.sistemabibliotecario.controller;

import java.sql.SQLException;

import com.mateusgromowski.sistemabibliotecario.dto.LoanDTO;
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
            service.devolute(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Loan getLoanById(int id) {
        Loan loan = null;
        try {
            loan = service.getLoanById(id).get();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return loan;
    }

    public void updateLoan(int id, int bookId, int userId) {
        LoanDTO dto = new LoanDTO(bookId, userId);
        try {
            service.updateLoan(userId, dto);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
