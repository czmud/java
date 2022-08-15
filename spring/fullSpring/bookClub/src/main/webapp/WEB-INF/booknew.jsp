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
	<h1>Add a Book to Your Shelf!</h1>
	
	<a href="/users/log-user-out">Logout</a><br>
	
	<a href="/books">Back to the shelves</a><br>
	
	<form:form action="/books/create-new-book" modelAttribute="newBook">
		<input type="hidden" name="user" value="${ user.id }">
		<input type="hidden" name="borrower" value="${ user.id }">
		
		<form:label path="title">Title:</form:label>
		<form:input path="title"/>
		<form:errors class="text-danger" path="title"/><br>
		
		<form:label path="author">Author:</form:label>
		<form:input path="author"/>
		<form:errors class="text-danger" path="author"/><br>
		
		<form:label path="thoughts">My Thoughts:</form:label>
		<form:textarea path="thoughts"/>
		<form:errors class="text-danger" path="thoughts"/><br>
	
		<input type="submit" value="Save">
	</form:form>
	
</body>
</html>