package com.mateusgromowski.sistemabibliotecario.service;

import java.sql.SQLException;
import java.util.NoSuchElementException;
import java.util.Optional;

import com.mateusgromowski.sistemabibliotecario.dto.LoanDTO;
import com.mateusgromowski.sistemabibliotecario.dto.LoanDetailedDTO;
import com.mateusgromowski.sistemabibliotecario.exception.BookAlreadyReturnedException;
import com.mateusgromowski.sistemabibliotecario.exception.InvalidLoanOperationException;
import com.mateusgromowski.sistemabibliotecario.exception.SimultaneousLoanException;
import com.mateusgromowski.sistemabibliotecario.model.Loan;
import com.mateusgromowski.sistemabibliotecario.repository.LoanRepository;

public class LoanService {
    private LoanRepository repository;

    public LoanService(LoanRepository repository) {
        this.repository = repository;
    }

    public void addLoan(LoanDTO dto) throws SQLException, SimultaneousLoanException {
        if (findBookByLoan(dto.bookId())) {
            repository.addLoan(dto);
            return;
        }
        throw new SimultaneousLoanException("Livro já emprestado.");
    }

    public void returnLoan(int id) throws SQLException, BookAlreadyReturnedException {
        if (getLoanById(id).orElseThrow(NoSuchElementException::new).getDevolutionDate() != null) {
            throw new BookAlreadyReturnedException("Livro já devolvido.");
        }
        repository.returnLoan(id);
    }

    public boolean findBookByLoan(int bookId) throws SQLException {
        return repository.findBookByLoan(bookId);
    }

    public Optional<Loan> getLoanById(int id) throws SQLException {
        return repository.getLoanById(id);
    }

    public void updateLoan(int id, LoanDTO dto) throws SQLException, InvalidLoanOperationException {
        if (getLoanById(id).orElseThrow(NoSuchElementException::new).getDevolutionDate() != null) {
            throw new InvalidLoanOperationException("Empréstimo finalizado. Não há motivos para alterar as infos.");

        }
        repository.updateLoan(id, dto);
    }

    public Optional<LoanDetailedDTO> getFormattedLoan(int id) throws SQLException {
        return repository.getFormattedLoan(id);
    }

    public void deleteLoan(int id) throws SQLException {
        repository.deleteLoan(id);
    }
}
