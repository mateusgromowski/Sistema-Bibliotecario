package com.mateusgromowski.sistemabibliotecario.model;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Loan {
    private int id;
    private LocalDate borrowDate;
    private LocalDate devolutionDate;
    private int bookId;
    private int userId;
}
