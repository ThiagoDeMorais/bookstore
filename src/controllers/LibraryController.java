package controllers;

import java.util.List;

import DAO.LibraryDAO;
import entities.Book;
import entities.User;

public class LibraryController {
	
	LibraryDAO libraryDAO = new LibraryDAO();

	public boolean saveUser(User user) {
		return this.libraryDAO.saveUser(user);	
	}
	
	public boolean saveBook(Book book) {
		return this.libraryDAO.saveBook(book);	
	}

	public List<User> getListUser() {
		return this.libraryDAO.getListUser();
	}

	public boolean removeUser(Integer matricula) {
		return this.libraryDAO.removeUser(matricula);
	}

	public List<Book> getListBook() {
		return this.libraryDAO.getListBook();
	}
	
}
