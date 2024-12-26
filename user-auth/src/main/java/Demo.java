import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Demo {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/jdbcconnect";
		String username = "root";
		String password = "root";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url, username, password);
			System.out.println("Connection successful!");

			String sql = "INSERT INTO users (username, email, password) VALUES (?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setString(1, "Kamlesh");
			statement.setString(2, "kamleshsingh0198@gmail.com");
			statement.setString(3, "kamleshPass");
			int rowsAffected = statement.executeUpdate();
			System.out.print(rowsAffected);
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC Driver not found!");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
