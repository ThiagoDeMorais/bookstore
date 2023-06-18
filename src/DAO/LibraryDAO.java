package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import db.SQLiteConnection;
import entities.Book;
import entities.User;

public class LibraryDAO extends SQLiteConnection {

	public boolean saveUser(User user) {
		toConnect();
		String sql = "INSERT INTO tb_user (name) VALUES (?)";
		PreparedStatement preparedStatement = createPreparedStatement(sql, Statement.RETURN_GENERATED_KEYS);
		try {
			preparedStatement.setString(1, user.getName());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			Logger.getLogger(LibraryDAO.class.getName()).log(Level.SEVERE, null, e);
			return false;
		}

		disconnect();
		return true;
	}

	public boolean saveBook(Book book) {
		toConnect();
		String sql = "INSERT INTO tb_book (title, author, publication, status) VALUES (?, ?, ?, ?)";
		PreparedStatement preparedStatement = createPreparedStatement(sql, Statement.RETURN_GENERATED_KEYS);
		try {
			preparedStatement.setString(1, book.getTitle());
			preparedStatement.setString(2, book.getAuthor());
			preparedStatement.setInt(3, book.getPublicationYear());
			preparedStatement.setString(4, book.getStatus());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			Logger.getLogger(LibraryDAO.class.getName()).log(Level.SEVERE, null, e);
			return false;
		}

		disconnect();
		return true;
	}

	public List<User> getListUser() {
		List<User> users = new ArrayList<>();
		User user = new User();
		toConnect();
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;

		String sql = "SELECT pk_user_id, name FROM tb_user";

		try {
			preparedStatement = createPreparedStatement(sql);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				user = new User();
				user.setId(resultSet.getInt(1));
				user.setName(resultSet.getString(2));
				users.add(user);
			}

		} catch (Exception e) {
			System.err.println(e);
		}
		disconnect();
		return users;

	}
	
	public List<Book> getListBook() {
		List<Book> books = new ArrayList<>();
		Book book = new Book();
		toConnect();
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;

		String sql = "SELECT pk_book_id, title, author, publication, status FROM tb_book";

		try {
			preparedStatement = createPreparedStatement(sql);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				book = new Book();
				book.setId(resultSet.getInt(1));
				book.setTitle(resultSet.getString(2));
				book.setAuthor(resultSet.getString(3));
				book.setStatus(resultSet.getString(4));
				books.add(book);
			}

		} catch (Exception e) {
			System.err.println(e);
		}
		disconnect();
		return books;

	}

	public boolean removeUser(Integer userId) {
		toConnect();
		PreparedStatement preparedStatement;
		String sql = "DELETE FROM tb_user WHERE pk_user_id = '" + userId + "'";
		preparedStatement = this.createPreparedStatement(sql);
		try {
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			Logger.getLogger(LibraryDAO.class.getName()).log(Level.SEVERE, null, e);
			return false;
		} finally {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
				Logger.getLogger(LibraryDAO.class.getName()).log(Level.SEVERE, null, e);
			}
		}
		disconnect();
		return true;
	}

	public boolean removeBook(Integer bookId) {
		toConnect();
		PreparedStatement preparedStatement;
		String sql = "DELETE FROM tb_book WHERE pk_book_id = '" + bookId + "'";
		preparedStatement = this.createPreparedStatement(sql);
		try {
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			Logger.getLogger(LibraryDAO.class.getName()).log(Level.SEVERE, null, e);
			return false;
		} finally {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
				Logger.getLogger(LibraryDAO.class.getName()).log(Level.SEVERE, null, e);
			}
		}
		disconnect();
		return true;
	}

}
