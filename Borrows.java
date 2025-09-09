import java.util.*;

public class Borrows {
	Scanner sc = new Scanner(System.in);
	int intInput;

	void borrowBook(Books books) {
		if (books.bookName.size() == 0) {
			System.out.println("Nenhum livro foi registrado, ainda.");			
		} else {
			System.out.print("Insira o ID do livro: ");
			intInput = sc.nextInt();
			if (intInput > 0 && intInput <= books.isBookBorrowed.size()) {
				books.isBookBorrowed.set(intInput - 1, true);
				System.out.println("Livro emprestado com sucesso.");
				} else {
					System.out.println("Entrada inválida.");
				}
			}
		}

	void giveBack(Books books) {
		if (books.bookName.size() == 0) {
			System.out.println("Nenhum livro foi registrado, ainda.");			
		} else {
			System.out.print("Insira o ID do livro: ");
			intInput = sc.nextInt();
			if (intInput > 0 && intInput <= books.isBookBorrowed.size()) {
				books.isBookBorrowed.set(intInput - 1, false);
				System.out.println("Livro devolvido com sucesso.");
				} else {
					System.out.println("Entrada inválida.");
				}
		}
	}

	void borrowChoices(String choice, Books books) {
		switch(choice) {
		 	case "1":
		 		borrowBook(books);
		 		break;
		 	case "2":
		 		giveBack(books);
		 		break;
		 	case "3":
		 		books.listBooks();
		 		break;
		 	case "0":
		 		break;
		 	default:
		 		System.out.println("Entrada inválida.");
		 		break;
		}
	}
}
