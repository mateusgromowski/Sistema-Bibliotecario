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

    private int mainMenu() throws InputMismatchException, NumberFormatException {
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

    private void menusList(int input) {
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

    private void booksMenu() throws InputMismatchException, NumberFormatException {
        int input = 0;
        System.out.println("\n===MENU LIVROS===");
        System.out.println("1. Adicionar livro");
        System.out.println("2. Buscar livro por ID");
        System.out.println("3. Atualizar livro");
        System.out.println("4. Deletar livro");
        System.out.println("0. Voltar");
        System.out.print("Escolha: ");
        input = Integer.parseInt(sc.nextLine());
        if (input > 4 || input < 0) {
            throw new InputMismatchException();
        }
        booksMenuList(input);
    }


    private void booksMenuList(int input) {
        switch (input) {
            case 1:
                addBook();
                break;
            case 2:
                getBookById();
                break;
            case 0:
                break;
            default:
                break;
        }
    }

    private void addBook() {
        System.out.print("Imprima o nome do livro: ");
        String name = sc.nextLine();
        System.out.print("Imprima o autor do livro: ");
        String author = sc.nextLine();
        System.out.print("Imprima o ISBN do livro: ");
        String isbn = sc.nextLine();
        bookController.addBook(name, author, isbn);
    }

}
