package entities;

import java.util.ArrayList;
import java.util.List;

public class Library {
	
	private List<User> users = new ArrayList<User>();
	private List<Book> books = new ArrayList<Book>();
	
	public Library() {
		
	}
	
	public User addUserToLibrary(User user) {
		users.add(user);
		return user;
	}
	
	public Integer removeUserById(Integer id) {
		for(User user: users) {
			if(user.getId() == id) {
				if(user.getBooks().size() == 0) {
					users.remove(user);	
					return user.getId();
				}	
			}
		}
		return null;
	}
	
	public String listUsers() {
		StringBuilder sb = new StringBuilder();
		for(User user : users) {
			sb.append(user.toString() + "\n");
		}
		return sb.toString();
	}
	
	public void editUserById(Integer id, String newName) {
		for(User user: users) {
			if(user.getId() == id) {
				user.setName(newName);
			}
		}
	}
	
	
	public Book addBookToLibrary(Book book) {
		books.add(book);
		return book;
	}
	
	public Integer removeBookById(Integer id) {
		for(Book book: books) {
			if(book.getId() == id) {
				books.remove(book);
				return book.getId();
			}
		}
		return null;
	}
	
	public String infoBook(Integer id) {
		return books.get(id).toString();
	}
	
	public String listBooks() {
		StringBuilder sb = new StringBuilder();
		for(Book book : books) {
			sb.append(book.toString() + "\n");
		}
		return sb.toString();
	}
	
	public void bookLoan(Integer userId, Integer bookId) {
		if(books.get(bookId).getStatus().equals("disponivel")) {
			users.get(userId).setBook(books.get(bookId));
			books.get(bookId).setStatus("locado");
		}
	}
	
	public void bookReceipt(Integer userId, Integer bookId) {
		if(books.get(bookId).getStatus().equals("locado")) {
			users.get(userId).removeBookById(bookId);
			books.get(bookId).setStatus("disponivel");
		}
	}
	
}
