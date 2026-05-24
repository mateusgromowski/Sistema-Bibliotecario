package com.mateusgromowski.sistemabibliotecario.dto;

import java.time.LocalDate;

import lombok.Builder;

@Builder
public record LoanDetailedDTO(int id, String title, String name, LocalDate borrowDate, LocalDate devolutionDate) {

}
