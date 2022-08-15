<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>Category View</title>
</head>
<body>
	<h1><c:out value="${ category.name }"/></h1>
	<a href="/">Home</a>
	<hr>

	<h2>Products</h2>
	<ul>
		<c:forEach var="oneProduct" items="${ category.products }">
			<li>
				<c:out value="${ oneProduct.name }"/>
			</li>
		</c:forEach>
	</ul>
	
	<hr>
	<c:if test="${ !productsToUpdate.isEmpty() }">
	<h2>Add to Product</h2>
	<form action="/categories/add-to-product/${ category.id }" method="post">
		<select name="productId">
		<c:forEach var="oneProductToUpdate" items="${ productsToUpdate }">
			<option value="${ oneProductToUpdate.id }"><c:out value="${ oneProductToUpdate.name }"/></option>
		</c:forEach>
		</select>
		<input type="submit" value="Add to Product">
	</form>
	</c:if>
	
</body>
</html>