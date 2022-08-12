<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>New Dojo</title>
</head>
<body>
	<h1>New Dojo</h1>
	<form:form action="/dojos/create-new-dojo" method="post" modelAttribute="dojo">
		<form:label path="name">Name:</form:label>
		<form:input path="name"/>
		<form:errors path="name"/><br>
		<input type="submit" value="Create">
	</form:form>
</body>
</html>