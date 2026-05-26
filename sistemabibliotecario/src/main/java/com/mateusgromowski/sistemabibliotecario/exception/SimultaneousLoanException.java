package com.mateusgromowski.sistemabibliotecario.exception;

public class SimultaneousLoanException extends Exception {

    public SimultaneousLoanException(String message) {
        super(message);
    }

}
