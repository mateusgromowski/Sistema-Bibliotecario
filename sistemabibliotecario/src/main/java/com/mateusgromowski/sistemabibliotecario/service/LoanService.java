package com.mateusgromowski.sistemabibliotecario.service;

import java.sql.SQLException;

import com.mateusgromowski.sistemabibliotecario.dto.LoanDTO;
import com.mateusgromowski.sistemabibliotecario.repository.LoanRepository;

public class LoanService {
    private LoanRepository repository;

    public LoanService(LoanRepository repository) {
        this.repository = repository;
    }

    public void addLoan(LoanDTO dto) throws SQLException {
        repository.addLoan(dto);
    }
}
