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
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("Entrada inválida.");
                continue;
            }
            menusList(input);
        } while (input != 0);
        System.out.println("Obrigado por usar.");
    }

    public int mainMenu() throws InputMismatchException, NumberFormatException {
        int input = 0;
        System.out.println("\n=== SISTEMA BIBLIOTECARIO ===");
        System.out.println("1. Menu livros.");
        System.out.println("2. Menu usuários.");
        System.out.println("3. Menu empréstimos.");
        System.out.println("0. Sair.");
        System.out.print("Escolha: ");
        input = Integer.parseInt(sc.nextLine());
        if (input > 3 || input < 0) {
            throw new InputMismatchException();
        }
        return input;
    }

    public void menusList(int input) {
        switch (input) {
            case 1:
                try {
                    booksMenu();

                } catch (InputMismatchException | NumberFormatException e) {
                    System.out.println("Entrada inválida.");
                }
                break;

            default:
                break;
        }
    }

    public void booksMenu() throws InputMismatchException, NumberFormatException {
        int input = 0;
        System.out.println("\n===MENU LIVROS===");
        System.out.println("1. Adicionar livro");
        System.out.println("2. Buscar livro por ID");
        System.out.println("3. Atualizar livro");
        System.out.println("4. Deletar livro");
        System.out.print("Escolha: ");
        input = Integer.parseInt(sc.nextLine());
        if (input > 4 || input < 1) {
            throw new InputMismatchException();
        }
        booksMenuList(input);
    }

    // Todo
    public void booksMenuList(int input) {
        switch (input) {
            case 1:

                break;

            default:
                break;
        }
    }

}
