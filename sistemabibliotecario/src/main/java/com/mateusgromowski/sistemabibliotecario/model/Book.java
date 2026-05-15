package com.mateusgromowski.sistemabibliotecario.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Book {
    int id;
    String title;
    String author;
    String isbn;
}
