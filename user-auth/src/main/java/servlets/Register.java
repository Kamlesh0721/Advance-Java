package servlets;

import java.io.IOException;
import java.sql.SQLException;

import dao.UserDAO;
import model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Register extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		// Save user data to the database
		User user = new User(username, email, password);

		// print in console
		System.out.println(user);

		UserDAO dao = new UserDAO();
		try {
			if (dao.registerUser(user)) {
				System.out.println("User Registered");
			}

		} catch (Exception e) {
			System.out.println("Something went wrong ...\nUnable to Connect..." + e);
		}

		response.sendRedirect("jsp/login.jsp");
	}
}
