package com.mateusgromowski;

import com.mateusgromowski.sistemabibliotecario.conn.ConnectionFactory;
import com.mateusgromowski.sistemabibliotecario.controller.LoanController;
import com.mateusgromowski.sistemabibliotecario.model.Loan;
import com.mateusgromowski.sistemabibliotecario.repository.LoanRepository;
import com.mateusgromowski.sistemabibliotecario.service.LoanService;

public class Main {
    public static void main(String[] args) {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        LoanRepository repository = new LoanRepository(connectionFactory);
        LoanService service = new LoanService(repository);
        LoanController controller = new LoanController(service);
        Loan loan = controller.getLoanById(1);
    }
}
