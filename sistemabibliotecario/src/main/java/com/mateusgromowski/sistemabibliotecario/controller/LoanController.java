package com.mateusgromowski.sistemabibliotecario.controller;

import java.sql.SQLException;
import java.util.Optional;

import com.mateusgromowski.sistemabibliotecario.dto.LoanDTO;
import com.mateusgromowski.sistemabibliotecario.dto.LoanDetailedDTO;
import com.mateusgromowski.sistemabibliotecario.exception.BookAlreadyReturnedException;
import com.mateusgromowski.sistemabibliotecario.exception.InvalidLoanOperationException;
import com.mateusgromowski.sistemabibliotecario.exception.SimultaneousLoanException;
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
            System.out.println("Empréstimo adicionado com sucesso!");
        } catch (SQLException | SimultaneousLoanException e) {
            System.out.println("O empréstimo não pôde ser adicionado.");
        }
    }

    public void returnLoan(int id) {
        try {
            service.returnLoan(id);
            System.out.println("Livro devolvido com sucesso!");
        } catch (SQLException | BookAlreadyReturnedException e) {
            System.out.println("O livro não pôde ser devolvido.");
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
            System.out.println("Empréstimo atualizado com sucesso!");
        } catch (SQLException | InvalidLoanOperationException e) {
            System.out.println("O empréstimo não pôde ser atualizado");
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
