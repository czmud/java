<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %> 
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>Show Dojo</title>
</head>
<body>
	<h1><c:out value="${dojo.name}"/> Ninjas</h1>
	
	<table>
		<tr>
			<th>Name</th>
			<th>Age</th>
		</tr>
	<c:forEach var="ninja" items="${ dojo.ninjas }">
		<tr>
			<td><c:out value="${ ninja.fullName() }"/></td>
			<td><c:out value="${ ninja.age }"/></td>
		</tr>
	</c:forEach>
	</table>
	
</body>
</html>