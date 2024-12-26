<%@ page import="model.User"%>
<%--
    User user = (User) session.getAttribute("user");
    if (user == null) {
        response.sendRedirect("login.jsp");
        return;
    }
--%>

<%
String user = (String) session.getAttribute("user");
%>
<!DOCTYPE html>
<html>
<head>
<title>Welcome</title>
</head>
<body>
	<h1>
		Welcome,
		<%=user%>!
	</h1>
	<p>
		Your email:
		<%=user%></p>
	<form action="logout" method="post">
		<button type="submit">Logout</button>
	</form>
</body>
</html>
