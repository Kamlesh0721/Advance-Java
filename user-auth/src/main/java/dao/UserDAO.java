package dao;

import model.User;
import java.sql.*;

public class UserDAO {
	private final String jdbcURL = "jdbc:mysql://localhost:3306/jdbcconnect";
	private final String jdbcUsername = "root";
	private final String jdbcPassword = "root";

	public boolean registerUser(User user) throws SQLException, ClassNotFoundException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);

		String sql = "INSERT INTO users (username, email, password) VALUES (?, ?, ?)";
		PreparedStatement statement = connection.prepareStatement(sql);

		statement.setString(1, user.getUsername());
		statement.setString(2, user.getEmail());
		statement.setString(3, user.getPassword());

		return statement.executeUpdate() > 0;
	}

	public User loginUser(String username, String password) throws SQLException, ClassNotFoundException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);

		String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, username);
		statement.setString(2, password);
		ResultSet resultSet = statement.executeQuery();
		if (resultSet.next()) {
			User user = new User();

			user.setId(resultSet.getInt("id"));
			user.setUsername(resultSet.getString("username"));
			user.setEmail(resultSet.getString("email"));
			return user;

		}
		return null;
	}
}
