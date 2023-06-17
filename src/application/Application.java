package application;

import java.util.Scanner;

import controllers.LibraryController;
import entities.Book;
import entities.Library;
import entities.User;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		
		//++
		Library library = new Library();
		User user = new User();
		Book book = new Book();
		LibraryController libraryController = new LibraryController();
		//--
		
		// teste inserção usuário++
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
		// teste inserção usuário--

		// teste inserção livro++
		
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
		book = new Book(null, bookTitle, bookAuthor, year, status);
		
		if(libraryController.saveBook(library.addBookToLibrary(book))){
			System.out.println("Livro cadastrao");
		}else {
			System.out.println("Erro ao cadastrar livro");
		}
		// teste inserção livro--

	}

}
