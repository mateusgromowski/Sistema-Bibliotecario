import java.util.ArrayList;
import java.util.Scanner;
	
public class Books {
	ArrayList<String> bookName = new ArrayList<>();
	ArrayList<String> bookAuthor = new ArrayList<>();
	ArrayList<String> bookISBN = new ArrayList<>();
	Scanner sc = new Scanner(System.in);
	String strInput;
	int intInput;
	boolean isBookFound;
	void booksChoices(String choice) {
		switch (choice) {
		 	case "1":
		 		addBook();
		 		break;
		 	case "2":
		 		listBooks();
		 		break;
		 	case "3": 
		 		removeBook();
		 		break;
		 	case "4":
		 		searchBook();
		 		break;
		}
	}

	void addBook() {
		System.out.print("Qual livro você deseja adicionar?: ");
		strInput = sc.nextLine();
		bookName.add(strInput);
		System.out.print("Qual é o nome do autor?: ");
		strInput = sc.nextLine();
		bookAuthor.add(strInput);
		System.out.print("Qual é o ISBN do livro?: ");
		strInput = sc.nextLine();
		bookISBN.add(strInput);
		System.out.println("Livro adicionado com sucesso.");
	}

	void listBooks() {
		if (bookName.size() == 0) {
			System.out.println("Nenhum livro foi registrado, ainda.");	
		} else {
			for (int i = 0; i < bookName.size(); i++) {
				System.out.printf("%d - %s - %s - %s\n",(i + 1), bookName.get(i), bookAuthor.get(i), bookISBN.get(i));	
			}
		}
	}

	void removeBook() {
	if (bookName.size() == 0) {
			System.out.println("Nenhum livro foi registrado, ainda.");
		} else {
			System.out.println("Insira o ID do livro que você deseja remover: ");
			intInput = sc.nextInt();
			bookName.remove(intInput - 1);
			bookAuthor.remove(intInput - 1);
			bookISBN.remove(intInput - 1);
			System.out.println("Livro removido com sucesso.");
		}
	}

	void searchBook() {
		if (bookName.size() == 0) {
			System.out.println("Nenhum livro foi registrado, ainda.");				
		} else {
			System.out.print("Insira o nome do livro: ");
			strInput = sc.nextLine();
			for (int iterator = 0; iterator < bookName.size(); iterator++) {
				if (strInput.equals(bookName.get(iterator))) {
					System.out.println("O livro seguinte foi encontrado: ");
					System.out.printf("ID - %d\n", iterator + 1);
					System.out.printf("Nome - %s\n", bookName.get(iterator));
					System.out.printf("ISBN - %s\n",bookISBN.get(iterator));
					isBookFound = true;
					break;
				}
			}
			if (!isBookFound) {
				System.out.println("Livro não encontrado.");
			}
		}
	}
}