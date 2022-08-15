<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<title>Home</title>
</head>
<body>
	<h1>Home Page</h1>
	
	<a href="/products/new">+New Product</a><br>
	<a href="/categories/new">+New Category</a><br>
	
	<hr>
	
	<div class="d-flex">
		<div class="col">
			<h2>Products</h2>
			<ul>
			<c:forEach var="oneProduct" items="${ products }">
				<li><a href="/products/${ oneProduct.id }">
					<c:out value="${ oneProduct.name }"/>
				</a></li>
			</c:forEach>
			</ul>
		</div>
		<div class="col">
			<h2>Categories</h2>
			<ul>
			<c:forEach var="oneCategory" items="${ categories }">
				<li><a href="/categories/${ oneCategory.id }">
					<c:out value="${ oneCategory.name }"/>
				</a></li>
			</c:forEach>
			</ul>			
		</div>
	</div>
	
</body>
</html>