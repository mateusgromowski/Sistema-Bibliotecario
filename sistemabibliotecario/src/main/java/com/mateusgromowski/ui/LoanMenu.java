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
        
    }

}
