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
	<a href="logout">Logout</a>
	<center>
		<h2>
			<a href="grade?action=new">Add New Class</a> &nbsp;&nbsp;&nbsp; <a
				href="grade?action=list">List All Classes</a>
		</h2>
	</center>
	<center>
		<h2>
			<a href="student?action=new">Add New Student</a> &nbsp;&nbsp;&nbsp; <a
				href="student?action=list">List All Students</a>
		</h2>
	</center>
	<center>
		<h2>
			<a href="subject?action=new">Add New Subject</a> &nbsp;&nbsp;&nbsp; <a
				href="subject?action=list">List All Subjects</a>
		</h2>
	</center>
	<center>
		<h2>
			<a href="teacher?action=new">Add New Teacher</a> &nbsp;&nbsp;&nbsp; <a
				href="teacher?action=list">List All Teachers</a>
		</h2>
	</center>
	<center>
		<h2>
			<a href="LearnersApp">Learner's Academy Classes Information</a>
		</h2>
	</center>

	</center>
	<c:if test="${listgrade != null}">
		<div align="center">
			<table border="1" cellpadding="3">
				<caption>
					<h2>List of Classes</h2>
				</caption>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Actions</th>
				</tr>
				<c:forEach var="grade" items="${listgrade}">
					<tr>
						<td><c:out value="${grade.id}" /></td>
						<td><c:out value="${grade.name}" /></td>
						<td><a
							href="grade?action=edit&id=<c:out value='${grade.id}' />">Edit</a>
							&nbsp;&nbsp;&nbsp;&nbsp; <a
							href="grade?action=delete&id=<c:out value='${grade.id}' />">Delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</c:if>


	<c:if test="${listStudent != null}">
		<div align="center">
			<table border="1" cellpadding="5">
				<caption>
					<h2>List of Students</h2>
				</caption>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Email</th>
					<th>Enrolled Class</th>
					<th>Actions</th>
				</tr>
				<c:forEach var="student" items="${listStudent}">
					<tr>
						<td><c:out value="${student.id}" /></td>
						<td><c:out value="${student.name}" /></td>
						<td><c:out value="${student.email}" /></td>
						<td><c:out value="${student.classId}" /></td>
						<td><a
							href="student?action=edit&id=<c:out value='${student.id}' />">Edit</a>
							&nbsp;&nbsp;&nbsp;&nbsp; <a
							href="student?action=delete&id=<c:out value='${student.id}' />">Delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</c:if>
	<c:if test="${listSubject != null}">
		<div align="center">
			<table border="1" cellpadding="4">
				<caption>
					<h2>List of Subjects</h2>
				</caption>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>With Class</th>
					<th>Actions</th>
				</tr>
				<c:forEach var="subject" items="${listSubject}">
					<tr>
						<td><c:out value="${subject.id}" /></td>
						<td><c:out value="${subject.name}" /></td>
						<td><c:out value="${subject.classId}" /></td>
						<td><a
							href="subject?action=edit&id=<c:out value='${subject.id}' />">Edit</a>
							&nbsp;&nbsp;&nbsp;&nbsp; <a
							href="subject?action=delete&id=<c:out value='${subject.id}' />">Delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</c:if>
	<c:if test="${listTeacher != null}">
		<div align="center">
			<table border="1" cellpadding="5">
				<caption>
					<h2>List of Teachers</h2>
				</caption>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Email</th>
					<th>Teaches In</th>
					<th>Actions</th>
				</tr>
				<c:forEach var="teacher" items="${listTeacher}">
					<tr>
						<td><c:out value="${teacher.id}" /></td>
						<td><c:out value="${teacher.name}" /></td>
						<td><c:out value="${teacher.email}" /></td>
						<td><c:out value="${teacher.classId}" /></td>
						<td><a
							href="teacher?action=edit&id=<c:out value='${teacher.id}' />">Edit</a>
							&nbsp;&nbsp;&nbsp;&nbsp; <a
							href="teacher?action=delete&id=<c:out value='${teacher.id}' />">Delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</c:if>
</body>
</html>