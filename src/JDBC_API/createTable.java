package JDBC_API;

import java.sql.*;

public class createTable {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/learnJava";
            String username = "root";
            String pass = "root";
            Connection con = DriverManager.getConnection(url, username, pass);

            Statement stmt = con.createStatement();
            String querry = "create table user (" +
                    "id int," +
                    "userName varchar(20)" +
                    ");";
            stmt.executeUpdate(querry);
            con.close();


        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
