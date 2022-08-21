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
	
	<form:form action="/languages/edit-language/${ editLanguage.id }" modelAttribute="editLanguage">
		<input type="hidden" name="_method" value="put">
		
		<form:label path="name">Name:</form:label>
		<form:input path="name"/>
		<form:errors class="text-danger" path="name"/><br>
		
		<form:label path="creator">Creator:</form:label>
		<form:input path="creator"/>
		<form:errors class="text-danger" path="creator"/><br>
		
		<form:label path="version">Version:</form:label>
		<form:input path="version"/>
		<form:errors class="text-danger" path="version"/><br>
		
		<input type="submit" value="Submit">
	</form:form>
	
	<form:form action="/languages/delete-language/${editLanguage.id}">
		<input type="hidden" name="_method" value="delete">
		<input type="submit" value="delete">
	</form:form>

	
	
</body>
</html>