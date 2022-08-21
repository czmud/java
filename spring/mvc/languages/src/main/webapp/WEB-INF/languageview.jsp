<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<title>Languages</title>
</head>
<body>
	<a href="/languages">Dashboard</a>
	<p><c:out value="${ language.name }"/></p>
	<p><c:out value="${ language.creator }"/></p>
	<p><c:out value="${ language.version }"/></p>
	<a href="/languages/edit/${ language.id }">Edit</a>
	<form:form action="/languages/delete-language/${language.id}">
		<input type="hidden" name="_method" value="delete">
		<input type="submit" value="delete">
	</form:form>
	
</body>
</html>