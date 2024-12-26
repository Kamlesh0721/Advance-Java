package servlets;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class Welcome extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("user") == null) {
			response.sendRedirect("jsp/login.jsp");
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/welcome.jsp");
			dispatcher.forward(request, response);
		}
	}
}
