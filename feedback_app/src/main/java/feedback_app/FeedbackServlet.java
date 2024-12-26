package feedback_app;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/feedback")
public class FeedbackServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Default doGet method");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email=req.getParameter("email");
		String phoneno=req.getParameter("phoneno");
		String feedback=req.getParameter("feedback");
		
		resp.setContentType("Text/html");
		PrintWriter writer = resp.getWriter();
		writer.println("<h1>Form Submitted ...</h1>");	
		writer.println("""
				Email: %s 
				Phoneno: %s 
				Feedback: %s 
				""".formatted(email,phoneno,feedback));
	}

}
