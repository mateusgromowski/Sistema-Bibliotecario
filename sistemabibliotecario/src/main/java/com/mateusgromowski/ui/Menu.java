package com.mateusgromowski.ui;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.mateusgromowski.sistemabibliotecario.controller.BookController;
import com.mateusgromowski.sistemabibliotecario.controller.LoanController;
import com.mateusgromowski.sistemabibliotecario.controller.UserController;

public class Menu {
    private Scanner sc;
    private BookController bookController;
    private UserController userController;
    private LoanController loanController;

    public Menu(Scanner sc, BookController bookController, UserController userController,
            LoanController loanController) {
        this.sc = sc;
        this.bookController = bookController;
        this.userController = userController;
        this.loanController = loanController;
    }

    public void start() {
        int input = 0;
        do {
            try {
                input = mainMenu();
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
                continue;
            }

        } while (input != 0);
        System.out.println("Obrigado por usar.");
    }

    public int mainMenu() throws InputMismatchException {
        int input = 0;
        System.out.println("\n=== SISTEMA BIBLIOTECARIO ===");
        System.out.println("1. Menu livros.");
        System.out.println("2. Menu usuários.");
        System.out.println("3. Menu empréstimos.");
        System.out.println("0. Sair.");
        System.out.print("Escolha: ");
        input = Integer.parseInt(sc.nextLine());
        if (input > 3 || input < 0) {
            throw new InputMismatchException("Entrada inválida.");
        }
        return input;
    }

}
