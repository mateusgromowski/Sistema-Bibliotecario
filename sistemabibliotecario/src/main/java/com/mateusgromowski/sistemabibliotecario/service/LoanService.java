package com.mateusgromowski.sistemabibliotecario.service;

import java.sql.SQLException;
import java.util.Optional;

import com.mateusgromowski.sistemabibliotecario.dto.LoanDTO;
import com.mateusgromowski.sistemabibliotecario.dto.LoanDetailedDTO;
import com.mateusgromowski.sistemabibliotecario.model.Loan;
import com.mateusgromowski.sistemabibliotecario.repository.LoanRepository;

public class LoanService {
    private LoanRepository repository;

    public LoanService(LoanRepository repository) {
        this.repository = repository;
    }

    public void addLoan(LoanDTO dto) throws SQLException {
        repository.addLoan(dto);
    }

    public void returnLoan(int id) throws SQLException {
        repository.returnLoan(id);
    }

    public Optional<Loan> getLoanById(int id) throws SQLException {
        return repository.getLoanById(id);
    }

    public void updateLoan(int id, LoanDTO dto) throws SQLException {
        repository.updateLoan(id, dto);
    }

    public Optional<LoanDetailedDTO> getFormattedLoan(int id) throws SQLException {
        return repository.getFormattedLoan(id);
    }

    public void deleteLoan(int id) throws SQLException {
        repository.deleteLoan(id);
    }
}
