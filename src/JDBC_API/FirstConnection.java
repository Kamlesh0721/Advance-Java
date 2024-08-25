package JDBC_API;

import java.sql.*;

public class FirstConnection {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/learnJava";
            String username = "root";
            String pass = "root";
            Connection con = DriverManager.getConnection(url, username, pass);

            if(con.isClosed()){
                System.out.println("Connection Fail !");
            }else{
                System.out.println("Connection Established ");
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
