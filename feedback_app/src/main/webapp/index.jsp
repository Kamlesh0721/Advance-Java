<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Feedback App</title>
<%@include file="links.jsp"%>
</head>
<body>
	<div class="container">
		<nav
			class="navbar border-bottom border-body navbar-expand-lg bg-body-tertiary">
			<div class="container-fluid">
				<a class="navbar-brand" href="#">Feedback App</a>
			</div>
		</nav>


		<div
			class="d-flex flex-column justify-content-center  align-items-center vh-100 ">
			<a href="<%=application.getContextPath()%>/feedbackForm.jsp">
				<button class="mb-3 btn btn-primary" type="button">Feedback</button>
			</a> <a href="<%=application.getContextPath()%>/request1">
				<button class="mb-3 btn btn-primary" type="button">Request
					1</button>
			</a> <a href="<%=application.getContextPath()%>/request2">
				<button class="mb-3 btn btn-primary" type="button">Request
					2</button>
			</a>
		</div>
	</div>
	<%@include file="scripts.jsp"%>
</body>
</html>