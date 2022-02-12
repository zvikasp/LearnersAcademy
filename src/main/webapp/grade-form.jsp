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
		<h1>Class Management</h1>
		<h2>
			<a href="grade?action=new">Add New Class</a> &nbsp;&nbsp;&nbsp; <a
				href="grade?action=list">List All Classes</a>
		</h2>
	</center>
	<div align="center">
		<c:if test="${grade != null}">
			<form action="grade" method="post">
		</c:if>
		<c:if test="${grade == null}">
			<form action="grade" method="post">
		</c:if>
		<table border="1" cellpadding="5">
			<caption>
				<h2>
					<c:if test="${grade != null}">
               Edit Class
               <input type="hidden" name="action" value="update">
					</c:if>
					<c:if test="${grade == null}">
               Add New Class
                              <input type="hidden" name="action"
							value="insert">
					</c:if>
				</h2>
			</caption>
			<c:if test="${grade != null}">
				<input type="hidden" name="id" value="<c:out value='${grade.id}' />" />
			</c:if>
			<tr>
				<th>Class Name:</th>
				<td><input type="text" name="name" size="45"
					value="<c:out value='${grade.name}' />" /></td>
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