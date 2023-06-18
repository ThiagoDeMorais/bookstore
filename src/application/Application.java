package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import controllers.LibraryController;
import entities.Book;
import entities.Library;
import entities.User;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		// ++
		Library library = new Library();
		User user = new User();
		Book book = new Book();
		LibraryController libraryController = new LibraryController();
		List<User> userList = new ArrayList<>();
		List<Book> bookList = new ArrayList<>();

		// --

		// CARREGANDO INFORMAÇÕES DO BANCO++
		userList = libraryController.getListUser();
		for (User user1 : userList) {
			library.addUserToLibrary(user1);
		}
		
		bookList = libraryController.getListBook();
		for (Book book1 : bookList) {
			library.addBookToLibrary(book1);
		}

		// CARREGANDO INFORMAÇÕES DO BANCO--

		// TESTE INSERÇÃO USUÁRIO++
//		user = new User();
//		String userName;
//		
//		System.out.println("Digite o nome do novo usuário");
//		userName = sc.nextLine();
//
//		user.setName(userName);
//		if(libraryController.saveUser(library.addUserToLibrary(user))){
//			System.out.println("Usuário cadastrao");
//		}else {
//			System.out.println("Erro ao cadastrar usuário");
//		}
		// TESTE INSERÇÃO USUÁRIO--

		// TESTE INSERÇÃO LIVRO++

		String bookTitle;
		String bookAuthor;
		Integer year;
		String status;
		
		System.out.println("Digite o título do novo livro");
		bookTitle = sc.nextLine();
		System.out.println("Digite o autor do livro");
		bookAuthor = sc.nextLine();
		System.out.println("Digite o ano de laçamento");
		year = Integer.parseInt(sc.nextLine());
		System.out.println("Digite a opção: disponivel/locado");
		status = sc.nextLine();
		book = new Book(bookTitle, bookAuthor, year, status);
		
		if(libraryController.saveBook(library.addBookToLibrary(book))){
			System.out.println("Livro cadastrao");
		}else {
			System.out.println("Erro ao cadastrar livro");
		}
		// TESTE INSERÇÃO LIVRO--

		// TESTE LISTAR USUÁRIOS++
//		System.out.println(library.listUsers());
		// TESTE LISTAR USUÁRIOS--
		
		// TESTE LISTAR LIVROS++
//		System.out.println(library.listBooks());
		// TESTE LISTAR LIVROS--

		// TESTE REMOVER USUÁRIOS++
		Integer matricula;
		System.out.println("Digite a matrícula do usuário que deve ser removido:");
		matricula = Integer.parseInt(sc.nextLine());

		libraryController.removeUser(library.removeUserById(matricula));
		// TESTE REMOVER USUÁRIOS--
		
		// TESTE REMOVER LIVROS++
		Integer codigo;
		System.out.println("Digiteo código do livro que deve ser removido:");
		codigo = Integer.parseInt(sc.nextLine());

		libraryController.removeBook(library.removeBookById(codigo));
		// TESTE REMOVER LIVROS--
		
		

	}

}
