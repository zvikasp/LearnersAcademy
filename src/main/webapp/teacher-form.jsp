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
		<h1>Teacher Management</h1>
		<h2>
			<a href="teacher?action=new">Add New Teacher</a> &nbsp;&nbsp;&nbsp; <a
				href="teacher?action=list">List All Teacher</a>
		</h2>
	</center>
	<div align="center">
		<c:if test="${teacher != null}">
			<form action="teacher" method="post">
		</c:if>
		<c:if test="${teacher == null}">
			<form action="teacher" method="post">
		</c:if>
		<table border="1" cellpadding="5">
			<caption>
				<h2>
					<c:if test="${teacher != null}">
               Edit Teacher
               <input type="hidden" name="action" value="update">
					</c:if>
					<c:if test="${teacher == null}">
               Add New Teacher
                              <input type="hidden" name="action"
							value="insert">
					</c:if>
				</h2>
			</caption>
			<c:if test="${teacher != null}">
				<input type="hidden" name="id"
					value="<c:out value='${teacher.id}' />" />
			</c:if>
			<tr>
				<th>Teacher Name:</th>
				<td><input type="text" name="name" size="45"
					value="<c:out value='${teacher.name}' />" /></td>
			</tr>
			<tr>
				<th>Teacher Email:</th>
				<td><input type="text" name="email" size="45"
					value="<c:out value='${teacher.email}' />" /></td>
			</tr>
			<tr>
				<th>Teaches ClassId:</th>
				<td><input type="text" name="classId" size="45"
					value="<c:out value='${teacher.classId}' />" /></td>
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