package com.mateusgromowski.ui;

import java.sql.SQLException;
import java.util.Scanner;

import com.mateusgromowski.sistemabibliotecario.controller.UserController;

public class UserMenu {
    private UserController controller;
    private Scanner sc;

    public UserMenu(UserController controller, Scanner sc) {
        this.controller = controller;
        this.sc = sc;
    }

    public void showMenu() {
        int input = 0;
        do {
            System.out.println("1. Adicionar usuário");
            System.out.println("2. Buscar usuário por ID");
            System.out.println("3. Atualizar usuário");
            System.out.println("4. Deletar usuário");
            System.out.println("0. Voltar");
            System.out.print("Escolha: ");
            input = Integer.parseInt(sc.nextLine());
            userMenu(input);
        } while (input != 0);
    }

    private void userMenu(int input) {
        switch (input) {
            case 1:
                addUser();
                break;

            default:
                break;
        }
    }

    private void addUser() {
        System.out.print("Insira o nome do usuário: ");
        String name = sc.nextLine();
        System.out.println("Insira o email do usuário: ");
        String email = sc.nextLine();
        try {
            controller.addUser(name, email);
            System.out.println("Usuário adicionado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Email já cadastrado.");
        }
    }
}
