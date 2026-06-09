package com.mateusgromowski.ui;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import com.mateusgromowski.sistemabibliotecario.controller.BookController;
import com.mateusgromowski.sistemabibliotecario.model.Book;

public class BookMenu {
    private BookController controller;
    private Scanner sc;

    public BookMenu(BookController controller, Scanner sc) {
        this.controller = controller;
        this.sc = sc;
    }

    public void showMenu() throws InputMismatchException, NumberFormatException {
        int input = 0;
        do {
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
        } while (input != 0);
    }

    private void booksMenuList(int input) {
        switch (input) {
            case 1:
                addBook();
                break;
            case 2:
                getBookById();
                break;
            case 3:
                updateBook();
                break;
            case 4:
                deleteBook();
                break;
            case 0:
                break;
            default:
                System.out.println("Entrada inválida.");
                break;
        }
    }

    private void deleteBook() {
        System.out.print("Insira o ID do livro: ");
        int id = Integer.parseInt(sc.nextLine());
        controller.deleteBook(id);
    }

    private void getBookById() {
        System.out.print("Insira o id do livro: ");
        int id = Integer.parseInt(sc.nextLine());
        try {
            Book book = controller.getBookById(id).orElseThrow(NoSuchElementException::new);
            printFormattedBook(book);
        } catch (NoSuchElementException e) {
            System.out.println("Livro inexistente.");
        }
    }

    private void printFormattedBook(Book book) {
        System.out.println("Id: " + book.getId());
        System.out.println("Título: " + book.getTitle());
        System.out.println("Autor: " + book.getAuthor());
        System.out.println("ISBN: " + book.getIsbn());
    }

    private void addBook() {
        System.out.print("Insira o nome do livro: ");
        String name = sc.nextLine();
        System.out.print("Insira o autor do livro: ");
        String author = sc.nextLine();
        System.out.print("Insira o ISBN do livro: ");
        String isbn = sc.nextLine();
        controller.addBook(name, author, isbn);
    }

    private void updateBook() {
        System.out.print("Insira o ID do livro: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.print("Insira o nome do livro: ");
        String name = sc.nextLine();
        System.out.print("Insira o autor do livro: ");
        String author = sc.nextLine();
        System.out.print("Insira o ISBN do livro: ");
        String isbn = sc.nextLine();
        controller.updateBook(id, name, author, isbn);
    }

}
