<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>Product View</title>
</head>
<body>
	<h1><c:out value="${ product.name }"/></h1>
	<a href="/">Home</a>
	<hr>

	<h2>Categories</h2>
	<ul>
		<c:forEach var="oneCategory" items="${ product.categories }">
			<li>
				<c:out value="${ oneCategory.name }"/>
			</li>
		</c:forEach>
	</ul>
	
	<hr>
	<c:if test="${ !categoriesToAdd.isEmpty() }">
	<h2>Add Category</h2>
	<form action="/products/add-category/${ product.id }" method="post">
		<select name="categoryId">
		<c:forEach var="oneAddCategory" items="${ categoriesToAdd }">
			<option value="${ oneAddCategory.id }"><c:out value="${ oneAddCategory.name }"/></option>
		</c:forEach>
		</select>
		<input type="submit" value="Add Category">
	</form>
	</c:if>
	
</body>
</html>