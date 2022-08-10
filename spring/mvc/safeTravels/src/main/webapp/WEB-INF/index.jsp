<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %> 
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>Safe Travels</title>
</head>
<body>
	<h1>Safe Travels</h1>
	<table>
		<tr>
			<th>Expense</th>
			<th>Vendor</th>
			<th>Amount</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
	<c:forEach var="expense" items="${ expenses }">
		<tr>
			<td><a href="/expenses/${ expense.id }"><c:out value="${ expense.name }"/></a></td>
			<td><c:out value="${ expense.name }"/></td>
			<td><c:out value="${ expense.vendor }"/></td>
			<td><c:out value="${ expense.formatAmount() }"/></td>
			<td><a href="/expenses/edit/${ expense.id }">edit</a></td>
			<td>
				<form action="/expenses/delete-expense/${ expense.id }" method="post">
	    			<input type="hidden" name="_method" value="delete">
	    			<input type="submit" value="Delete">
				</form>
			</td>
		</tr>
	</c:forEach>
		
	</table>
	
	
	<h2>Add an expense</h2>
	<form:form action="/expenses/add-new-expense" method="post" modelAttribute="expense">
			<form:label path="name">Expense Name</form:label>
			<form:input path="name"/>
			<form:errors path="name"/><br>
			<form:label path="vendor">Vendor</form:label>
			<form:input path="vendor"/>
			<form:errors path="vendor"/><br>
			<form:label path="amount">Amount</form:label>
			<form:input type="number" path="amount" step="0.01"/>
			<form:errors path="amount"/><br>
			<form:label path="description">Description</form:label>
	        <form:textarea path="description"/>
			<form:errors path="description"/><br>
		<input type="submit" value="Submit">
	</form:form>
	
</body>
</html>