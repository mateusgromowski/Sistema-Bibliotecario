public class Menus {
	void showMenus() {
		System.out.println("Qual função você deseja acessar?: ");
		System.out.println("1 - Gerenciar Livros");
		System.out.println("2 - Gerenciar Usuários");
		System.out.println("3 - Empréstimo De Livros");
		System.out.println("0 - Sair");
	}
	
	void booksMenu() {
		System.out.println("Qual tarefa você deseja fazer?");
		System.out.println("1 - Adicionar Livro");
		System.out.println("2 - Listar Livros");
		System.out.println("3 - Remover Livro");
		System.out.println("4 - Buscar Livro");
		System.out.println("0 - Sair");
	}
	
	void usersMenu() {	
		System.out.println("Qual tarefa você deseja fazer?");
		System.out.println("1 - Adicionar Usuário");
		System.out.println("2 - Listar Usuários");
		System.out.println("3 - Apagar Usuário");
		System.out.println("0 - Sair");	 		
	}
	
	void borrowsMenu() {
		System.out.println("Qual tarefa você deseja fazer?");
		System.out.println("1 - Registrar empréstimo de livro");
		System.out.println("2 - Registrar devolução");
		System.out.println("3 - Mostrar livros emprestados e disponíveis");
		System.out.println("0 - Sair");							
	}			
}