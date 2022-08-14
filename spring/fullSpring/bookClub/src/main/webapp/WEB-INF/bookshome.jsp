<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<title>Read Share</title>
</head>
<body>
	<h2>Welcome, <c:out value="${ user.fullName() }"/></h2><br>
	
	<p>Books from everyone's shelves:</p><br>
	
	<a href="/users/log-user-out">Logout</a><br>
	
	<a href="/books/new">+Add new book</a><br>
	
	<table>
		<tr>
			<th>ID</th>
			<th>Title</th>
			<th>Author</th>
			<th>Posted By</th>
		</tr>
 	<c:forEach var="oneBook" items="${ books }">
		<tr>
			<td><c:out value="${ oneBook.id }"/></td>
			<td><a href="/books/${ oneBook.id }"><c:out value="${ oneBook.title }"/></a></td>
			<td><c:out value="${ oneBook.author }"/></td>
			<td><c:out value="${ oneBook.user.fullName() }"/></td>
		</tr>
	</c:forEach>
	
	
	
	</table>
	
</body>
</html>