package com.mateusgromowski.sistemabibliotecario.controller;

import java.sql.SQLException;

import com.mateusgromowski.sistemabibliotecario.dto.LoanDTO;
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
}
