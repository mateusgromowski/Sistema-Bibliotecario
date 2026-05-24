package com.mateusgromowski;

import com.mateusgromowski.sistemabibliotecario.conn.ConnectionFactory;
import com.mateusgromowski.sistemabibliotecario.controller.LoanController;
import com.mateusgromowski.sistemabibliotecario.dto.LoanDetailedDTO;

import com.mateusgromowski.sistemabibliotecario.repository.LoanRepository;
import com.mateusgromowski.sistemabibliotecario.service.LoanService;

public class Main {
    public static void main(String[] args) {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        LoanRepository repository = new LoanRepository(connectionFactory);
        LoanService service = new LoanService(repository);
        LoanController controller = new LoanController(service);
        LoanDetailedDTO dto = controller.getFormattedLoan(1);
        System.out.println(dto);
    }
}
