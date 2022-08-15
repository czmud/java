<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>New Category</title>
</head>
<body>
	<h1>New Category</h1>
	<a href="/">Home</a>
	
	<hr>
	
	<form:form action="/categories/create-new-category" modelAttribute="newCategory">
		<form:label path="name">Name:</form:label>
		<form:input path="name"/>
		<form:errors class="text-danger" path="name"/><br>
		
		<input type="submit" value="Submit">
	</form:form>
	
</body>
</html>