import java.util.Scanner;
import java.util.ArrayList;

public class Users {
	Scanner sc = new Scanner(System.in);
	ArrayList<String> userList = new ArrayList<>();
	String name;

	void userChoices(String choice) {
		switch(choice) {
			case "1":
				addUser();
				break;
			case "2":
				listUsers();
				break;
			case "3":
				//removeUser();
				break;
			case "0":
				break;
			default:
				System.out.println("Entrada Inválida.");
		}
	}
	
	void addUser() {
		System.out.print("Adicione o nome do usuário: ");
		name = sc.nextLine();
		userList.add(name);
	}
	
	void listUsers() {
		if (userList.size() == 0) {
			System.out.println("Nenhum livro foi registrado, ainda.");	
		} else {
			for (int iterator = 0; iterator < userList.size(); iterator++) {
				System.out.printf("%d - %s\n", iterator + 1, userList.get(iterator));				
			}
		}
	}
}

