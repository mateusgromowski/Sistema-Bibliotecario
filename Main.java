import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Menus menus = new Menus();
		Books books = new Books();
		Users users = new Users();
		Borrows borrows = new Borrows();
		String choice;
		String mainMenuChoice = ":P";
		while (!mainMenuChoice.equals("0")) {
			System.out.println("\n----------SISTEMA BIBLIOTECÁRIO----------");
			menus.showMenus();
			System.out.printf("Sua escolha: ");
			mainMenuChoice = sc.nextLine();

			switch (mainMenuChoice) {
				case "1":
					System.out.println("\n---------------MENU LIVROS---------------");
					menus.booksMenu();
					System.out.print("Sua escolha: ");
					choice = sc.nextLine();
					books.booksChoices(choice);	
					break;
				case "2":
					System.out.println("\n---------------MENU USUÁRIOS---------------");
					menus.usersMenu();
					System.out.print("Sua escolha: ");
					choice = sc.nextLine();	
					users.userChoices(choice);
					break;
				case "3":
					System.out.println("\n-------------MENU EMPRÉSTIMOS-------------");
					menus.borrowsMenu();
					System.out.print("Sua escolha: ");
					choice = sc.nextLine();
					borrows.borrowChoices(choice, books);
					break;
				case "0":
					break;
				default:
					System.out.println("Entrada Inválida.");
			}
		}
		System.out.println("Desligando o sistema...");
		sc.close();
	}
}