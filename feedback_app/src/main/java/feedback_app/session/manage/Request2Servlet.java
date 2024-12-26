package feedback_app.session.manage;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;

//@WebServlet("/request2")
public class Request2Servlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();

		Cookie[] cookies = req.getCookies();

		boolean flag = false;
		StringBuilder content = new StringBuilder();

		if (cookies != null) {
			for (Cookie c : cookies) {
				String name = c.getName();
				if (name.equals("username")) {
					System.out.println(c.getValue());
					content.append("""
							<h2>Welcome User: %s</h2>
							""".formatted(c.getValue()));
					flag = true;
				} else if (name.equals("userId")) {
					System.out.println("userId");
					content.append("""
							<h2>UserId : %s</h2>
							""".formatted(c.getValue()));
					flag = true;
				}

			}
		}
		HttpSession session = req.getSession();
		String httpSessionSecret = (String) session.getAttribute("httpSessionSecret");
		String secretUsername = (String) session.getAttribute("username");
		String secretUserId = (String) session.getAttribute("userId");

		content.append("""
				<h2>Http Session : %s</h2>
				<h2>Secret userName : %s</h2>
				<h2>Secret userId : %s</h2>
				""".formatted(httpSessionSecret, secretUsername, secretUserId));


		// Servlet Config and Servlet Context
		
		ServletConfig servletConfig=getServletConfig();
		ServletContext servletContext = servletConfig.getServletContext();
		
		String userEmail=servletConfig.getInitParameter("userEmail");
		String appname=getServletContext().getInitParameter("appName");
		writer.print("""
				<h2>User Email : %s</h2>
				<h2>App Name : %s</h2>
				""".formatted(userEmail,appname));
		
		if (flag) {
			System.out.println(content);
			writer.println(content);

		} else {
			writer.println("<h3>No user Found</h3>");
		}
	}

}
