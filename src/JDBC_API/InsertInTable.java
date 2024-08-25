package JDBC_API;

import java.sql.*;

public class InsertInTable {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/learnJava";
            String username = "root";
            String pass = "root";
            Connection con = DriverManager.getConnection(url, username, pass);

            String qerry = "insert into user values(?,?);";
            PreparedStatement prStmt = con.prepareStatement(qerry);
            prStmt.setInt(1, 1);
            prStmt.setString(2, "Kamlesh Singh");

            prStmt.executeUpdate();

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
