package controllers;

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
	
}
