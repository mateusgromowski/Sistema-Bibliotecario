package com.mateusgromowski.ui;

import java.time.LocalDate;
import java.util.NoSuchElementException;
import java.util.Scanner;

import com.mateusgromowski.sistemabibliotecario.controller.LoanController;
import com.mateusgromowski.sistemabibliotecario.dto.LoanDetailedDTO;

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

    // 6. Deletar empréstimo
    private void loanMenu(int input) {
        switch (input) {
            case 1:
                addLoan();
                break;
            case 2:
                findLoanById();
                break;
            case 3:
                updateLoan();
                break;
            case 4:
                returnBook();
                break;
            case 5:
                deleteLoan();
                break;
            default:
                break;
        }
    }

    private void deleteLoan() {
        System.out.print("Insira o id do empréstimo: ");
        int id = Integer.parseInt(sc.nextLine());
        controller.deleteLoan(id);
    }

    private void returnBook() {
        System.out.print("Insira o ID do empréstimo: ");
        int id = Integer.parseInt(sc.nextLine());
        controller.returnLoan(id);
        System.out.println("Livro devolvido com sucesso!");
    }

    private void updateLoan() {
        System.out.print("Insira o ID do empréstimo: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.print("Insira o ID do livro: ");
        int bookId = Integer.parseInt(sc.nextLine());
        System.out.print("Insira o ID do usuário: ");
        int userId = Integer.parseInt(sc.nextLine());
        controller.updateLoan(id, bookId, userId);
        System.out.println("Empréstimo atualizado com sucesso!");
    }

    private void addLoan() {
        System.out.print("Insira o id do livro: ");
        int bookId = Integer.parseInt(sc.nextLine());
        System.out.print("Insira o id do usuário: ");
        int userId = Integer.parseInt(sc.nextLine());
        controller.addLoan(bookId, userId);
        System.out.println("Livro emprestado com sucesso.");
    }

    private void findLoanById() {
        System.out.print("Insira o ID do empréstimo: ");
        int id = Integer.parseInt(sc.nextLine());
        try {
            LoanDetailedDTO dto = controller.getFormattedLoan(id).orElseThrow(NoSuchElementException::new);
            printDto(dto);
        } catch (NoSuchElementException e) {
            System.out.println("Empréstimo inexistente. Consulte o banco de dados.");
        }
    }

    private void printDto(LoanDetailedDTO dto) {
        System.out.println("Nome do livro: " + dto.title());
        System.out.println("Usuário com o livro: " + dto.name());
        System.out.println("Data do empréstimo: " + dto.borrowDate());
        LocalDate devolutionDate = dto.devolutionDate();
        if (devolutionDate == null) {
            System.out.println("Data de devolução: ainda não devolvido");
            return;
        }
        System.out.println("Data de devolução: " + devolutionDate);
    }

}
