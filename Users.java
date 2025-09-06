import java.util.Scanner;
import java.util.ArrayList;

public class Users {
	Scanner sc = new Scanner(System.in);
	ArrayList<String> userList = new ArrayList<>();
	String strInput;
	int intInput;

	void userChoices(String choice) {
		switch(choice) {
			case "1":
				addUser();
				break;
			case "2":
				listUsers();
				break;
			case "3":
				removeUser();
				break;
			case "0":
				break;
			default:
				System.out.println("Entrada Inválida.");
		}
	}
	
	void addUser() {
		System.out.print("\nAdicione o nome do usuário: ");
		strInput = sc.nextLine();
		userList.add(strInput);
	}
	
	void listUsers() {
		if (userList.size() == 0) {
			System.out.println("Nenhum usuário foi registrado, ainda.");	
		} else {
			for (int iterator = 0; iterator < userList.size(); iterator++) {
				System.out.printf("\n%d - %s\n", iterator + 1, userList.get(iterator));				
			}
		}
	}

	void removeUser() {
		if (userList.size() == 0) {
			System.out.println("\nNenhum usuário foi registrado, ainda.");
		} else {
			System.out.print("\nInsira o ID do usuário que você deseja apagar: ");
			intInput = sc.nextInt();
			userList.remove(intInput - 1);
		}
	}
}

