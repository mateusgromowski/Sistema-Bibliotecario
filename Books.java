import java.util.ArrayList;
import java.util.Scanner;
	
public class Books {
	ArrayList<String> bookName = new ArrayList<>();
	ArrayList<String> bookAuthor = new ArrayList<>();
	ArrayList<String> bookISBN = new ArrayList<>();
	Scanner sc = new Scanner(System.in);
	String strInput;
	int intInput;
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
			System.out.println("Qual livro você deseja remover?: ");
			intInput = sc.nextInt();
			bookName.remove(intInput - 1);
			bookAuthor.remove(intInput - 1);
			bookISBN.remove(intInput - 1);
			System.out.println("Livro removido com sucesso.");
		}
	}
}