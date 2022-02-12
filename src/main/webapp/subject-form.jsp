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
		<h1>Subject Management</h1>
		<h2>
			<a href="grade?action=new">Add New Subject</a> &nbsp;&nbsp;&nbsp; <a
				href="grade?action=list">List All Subject</a>
		</h2>
	</center>
	<div align="center">
		<c:if test="${subject != null}">
			<form action="subject" method="post">
		</c:if>
		<c:if test="${subject == null}">
			<form action="subject" method="post">
		</c:if>
		<table border="1" cellpadding="5">
			<caption>
				<h2>
					<c:if test="${subject != null}">
               Edit Subject
               <input type="hidden" name="action" value="update">
					</c:if>
					<c:if test="${subject == null}">
               Add New Subject
                              <input type="hidden" name="action"
							value="insert">
					</c:if>
				</h2>
			</caption>
			<c:if test="${subject != null}">
				<input type="hidden" name="id"
					value="<c:out value='${subject.id}' />" />
			</c:if>
			<tr>
				<th>Subject Name:</th>
				<td><input type="text" name="name" size="45"
					value="<c:out value='${subject.name}' />" /></td>
			</tr>
			<tr>
				<th>Class Id:</th>
				<td><input type="text" name="classId" size="45"
					value="<c:out value='${subject.classId}' />" /></td>
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