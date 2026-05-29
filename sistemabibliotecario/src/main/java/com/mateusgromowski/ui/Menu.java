package com.mateusgromowski.ui;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    private Scanner sc;
    private BookMenu bookMenu;

    public Menu(Scanner sc, BookMenu bookMenu) {
        this.sc = sc;
        this.bookMenu = bookMenu;
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
                    bookMenu.showMenu();

                } catch (InputMismatchException | NumberFormatException e) {
                    System.out.println("Entrada inválida.");
                }
                break;

            default:
                break;
        }
    }

}
