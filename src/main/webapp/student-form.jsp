<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Learner's Academy</title>
</head>
<body>
	<%
	String userName = (String) session.getAttribute("username");
	//redirect user to login page if not logged in
	if (userName == null) {
		response.sendRedirect("index.jsp");
	}
	%>
	<p>
		Welcome
		<%=userName%></p>
	<center>
		<h1>Student Management</h1>
		<h2>
			<a href="student?action=new">Add New Student</a> &nbsp;&nbsp;&nbsp; <a
				href="student?action=list">List All Student</a>
		</h2>
	</center>
	<div align="center">
		<c:if test="${student != null}">
			<form action="student" method="post">
		</c:if>
		<c:if test="${student == null}">
			<form action="student" method="post">
		</c:if>
		<table border="1" cellpadding="5">
			<caption>
				<h2>
					<c:if test="${student != null}">
               Edit Student
               <input type="hidden" name="action" value="update">
					</c:if>
					<c:if test="${student == null}">
               Add New Student
                              <input type="hidden" name="action"
							value="insert">
					</c:if>
				</h2>
			</caption>
			<c:if test="${student != null}">
				<input type="hidden" name="id"
					value="<c:out value='${student.id}' />" />
			</c:if>
			<tr>
				<th>Student Name:</th>
				<td><input type="text" name="name" size="45"
					value="<c:out value='${student.name}' />" /></td>
			</tr>
			<tr>
				<th>Student Email:</th>
				<td><input type="text" name="email" size="45"
					value="<c:out value='${student.email}' />" /></td>
			</tr>
			<tr>
				<th>Class Id:</th>
				<td><input type="text" name="classId" size="45"
					value="<c:out value='${student.classId}' />" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="Save" /></td>
			</tr>
		</table>
		</form>
	</div>
</body>
</html>