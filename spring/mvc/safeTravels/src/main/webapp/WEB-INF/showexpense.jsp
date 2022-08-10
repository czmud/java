<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>Show Expense</title>
</head>
<body>
	<h1>Expense Details</h1>
	<a href="/expenses">Go Back</a>
	
	<p>Expense Name: <c:out value="${ expense.name }"/></p>
	<p>Expense Description: <c:out value="${ expense.description }"/></p>
	<p>Vendor: <c:out value="${ expense.vendor }"/></p>
	<p>Amount Spent: <c:out value="${ expense.formatAmount() }"/></p>

</body>
</html>