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
	
	<a href="/books">Back to the shelves</a><br>
	
	<p>Available Books to Borrow</p>
	<table>
		<tr>
			<th>ID</th>
			<th>Title</th>
			<th>Author</th>
			<th>Owner</th>
			<th>Actions</th>
		</tr>
 	<c:forEach var="oneBook" items="${ books }">
		<c:if test="${ !oneBook.isBorrowed() }">
		<tr>
			<td><c:out value="${ oneBook.id }"/></td>
			<td><a href="/books/${ oneBook.id }"><c:out value="${ oneBook.title }"/></a></td>
			<td><c:out value="${ oneBook.author }"/></td>
			<td><c:out value="${ oneBook.user.fullName() }"/></td>
			<td>
		<c:choose>
			<c:when test="${ user.id == oneBook.user.id }">
				<a href="/books/edit/${oneBook.id}">edit</a>
				<form:form action="/books/delete-book/${oneBook.id}">
					<input type="hidden" name="_method" value="delete">
					<input type="submit" value="delete">
				</form:form>
			</c:when>
			<c:otherwise>
				<form:form action="/bookmarket/borrow/${oneBook.id}">
					<input type="hidden" name="_method" value="put">
					<input type="submit" value="borrow">
				</form:form>
			</c:otherwise>
		</c:choose>
			</td>
		</tr>
		</c:if>
	</c:forEach>
	</table><br><br>
	
	<p>Books I'm Borrowing.</p>
	<table>
		<tr>
			<th>ID</th>
			<th>Title</th>
			<th>Author</th>
			<th>Owner</th>
			<th>Actions</th>
		</tr>
 	<c:forEach var="oneBorrowedBook" items="${ user.borrowedBooks }">
		<c:if test="${ oneBorrowedBook.isBorrowed() }">
		<tr>
			<td><c:out value="${ oneBorrowedBook.id }"/></td>
			<td><a href="/books/${ oneBorrowedBook.id }"><c:out value="${ oneBorrowedBook.title }"/></a></td>
			<td><c:out value="${ oneBorrowedBook.author }"/></td>
			<td><c:out value="${ oneBorrowedBook.user.fullName() }"/></td>
			<td>
				<form:form action="/bookmarket/return/${oneBorrowedBook.id}">
					<input type="hidden" name="_method" value="put">
					<input type="submit" value="return">
				</form:form>
			</td>
		</tr>
		</c:if>
	</c:forEach>
	</table>
	
</body>
</html>