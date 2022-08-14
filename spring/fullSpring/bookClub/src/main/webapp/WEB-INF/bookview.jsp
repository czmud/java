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
	<h1><c:out value="${ book.title }"/></h1>
	
	<a href="/users/log-user-out">Logout</a><br>
	
	<a href="/books">Back to the shelves</a><br>
	<p>
		<c:choose>
			<c:when test="${ user.id == book.user.id }">You</c:when>
			<c:otherwise><c:out value="${ book.user.fullName() }"/></c:otherwise>	
		</c:choose>
	
		 read <c:out value="${ book.title }"/> 
		by <c:out value="${ book.author }"/>.
	</p>
	
	<p>
		Here are 
		<c:choose>
			<c:when test="${ user.id == book.user.id }">your</c:when>
			<c:otherwise><c:out value="${ book.user.firstName }"/>'s</c:otherwise>
		</c:choose>
		thoughts:
	</p>
	
	<hr>
		
	<p><c:out value="${ book.thoughts }"/></p>
		
	<hr>
	
	<c:if test="${ user.id == book.user.id}"> 
		<a href="/books/edit/${ book.id }">Edit</a>
	</c:if>
	
</body>
</html>