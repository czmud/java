<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>Fruity Loops</title>
</head>
<body>
	<h1>Fruit Store</h1>
	<table>
		<tr>
			<th>Name</th>
			<th>Price</th>
		</tr>
	<c:forEach var="fruit" items="${fruits}">
		<tr>
			<td><c:out value="${fruit.name}"/></td>
			<td><c:out value="${fruit.price}"/></td>
		</tr>
	</c:forEach>
	</table>
	
</body>
</html>