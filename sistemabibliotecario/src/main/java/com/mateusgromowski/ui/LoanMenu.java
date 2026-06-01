package com.mateusgromowski.ui;

import java.util.Scanner;

import com.mateusgromowski.sistemabibliotecario.controller.LoanController;

public class LoanMenu {
    private LoanController controller;
    private Scanner sc;

    public LoanMenu(LoanController controller, Scanner sc) {
        this.controller = controller;
        this.sc = sc;
    }

    public void showMenu() {
        int input = 0;
        do {
            System.out.println("\n=== MENU DE EMPRÉSTIMOS ===");
            System.out.println("1. Criar empréstimo");
            System.out.println("2. Buscar empréstimo");
            System.out.println("3. Atualizar empréstimo");
            System.out.println("4. Devolver livro");
            System.out.println("5. Deletar empréstimo");
            System.out.println("0. Voltar");
            System.out.print("Escolha: ");
            input = Integer.parseInt(sc.nextLine());
            loanMenu(input);
        } while (input != 0);
    }

    private void loanMenu(int input) {
        switch (input) {
            case 1:
                addLoan();
                break;

            default:
                break;
        }
    }

    private void addLoan() {
        System.out.print("Insira o id do livro: ");
        int bookId = Integer.parseInt(sc.nextLine());
        System.out.print("Insira o id do usuário: ");

        int userId = Integer.parseInt(sc.nextLine());
        controller.addLoan(bookId, userId);
        System.out.println("Livro emprestado com sucesso.");
    }

}
