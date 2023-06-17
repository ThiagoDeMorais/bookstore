package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
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

		}catch(SQLException e) {
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

		}catch(SQLException e) {
			Logger.getLogger(LibraryDAO.class.getName()).log(Level.SEVERE, null, e);
			return false;
		}
		
		disconnect();
		return true;
	}

}
