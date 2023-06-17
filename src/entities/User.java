package entities;

import java.util.ArrayList;
import java.util.List;

public class User {
	
	private Integer id;
	private String name;
	private List<Book> books = new ArrayList<Book>();
	
	public User() {
		
	}

	public User(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setBook(Book book) {
		books.add(book);
	}
	
	public List<Book> getBooks(){
		return this.books;
	}
	
	public void removeBookById(Integer id) {
		for(Book book: books) {
			if(book.getId() == id) {
				books.remove(book);
			}
		}
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + "]";
	}
}
