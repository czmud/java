<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>Dashboard</title>
</head>
<body>
	<h2>Welcome, <c:out value="${ user.fullName() }"/></h2><br>
	
	<p>This is your dashboard. Nothing to see here yet.</p><br>
	
	<a href="/users/log-user-out">Logout</a>
</body>
</html>