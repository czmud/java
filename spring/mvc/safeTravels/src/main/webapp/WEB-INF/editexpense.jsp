<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>Edit Expense</title>
</head>
<body>
	<h1>Edit Expense</h1>
	<a href="/expenses">Go Back</a>
	
	<form:form action="/expenses/update-expense/${ expense.id }" method="post" modelAttribute="expense">
		<input type="hidden" name="_method" value="put">
		<form:label path="name">Expense Name</form:label>
		<form:input path="name"/>
		<form:errors path="name"/><br>
		<form:label path="vendor">Vendor</form:label>
		<form:input path="vendor"/>
		<form:errors path="vendor"/><br>
		<form:label path="amount">Amount</form:label>
		<form:input path="amount" type="number"/>
		<form:errors path="amount"/><br>
		<form:label path="description">Description</form:label>
        <form:textarea path="description"/>
		<form:errors path="description"/><br>
		<input type="submit" value="Submit">
	</form:form>

</body>
</html>