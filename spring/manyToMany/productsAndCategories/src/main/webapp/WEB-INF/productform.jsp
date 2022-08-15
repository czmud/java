<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>New Product</title>
</head>
<body>
	<h1>New Product</h1>
	<a href="/">Home</a>
	
	<hr>

	<form:form action="/products/create-new-product" modelAttribute="newProduct">
		<form:label path="name">Name:</form:label>
		<form:input path="name"/>
		<form:errors class="text-danger" path="name"/><br>
		
		<form:label path="description">Description:</form:label>
		<form:input path="description"/>
		<form:errors class="text-danger" path="description"/><br>
	
		<form:label path="price">Price:</form:label>
		<form:input path="price" type="number" step="0.01"/>
		<form:errors class="text-danger" path="price"/><br>
	
		<input type="submit" value="Submit">
	</form:form>
	
</body>
</html>