<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Learner's Academy</title>
</head>
<body>
	<%
	String userName = (String) session.getAttribute("userName");
	//redirect user to home page if already logged in
	if (userName != null) {
		response.sendRedirect("home.jsp");
	}

	String status = request.getParameter("status");
	if (status != null) {
		if (status.equals("false")) {
			out.print("Incorrect login details!");
		} else {
			out.print("Some error occurred!");
		}
	}
	%>

	<div align="center">
		<h1>Welcome to Learner's Academy</h1>
		<form action="login" method="post">
			<table style="with: 100%">
				<tr>
					<td>UserName</td>
					<td><input type="text" name="username" /></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="password" /></td>
				</tr>
			</table>
			<input type="submit" value="Login" />
		</form>
	</div>
</body>
</html>