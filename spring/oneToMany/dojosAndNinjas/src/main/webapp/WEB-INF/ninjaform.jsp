<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %> 
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>New Ninja</title>
</head>
<body>
	<h1>New Ninja</h1>
	<form:form action="/ninjas/create-new-ninja" method="post" modelAttribute="ninja">
		<form:select path="dojo">
			<c:forEach var="oneDojo" items="${ dojos }">
				<form:option value="${oneDojo.id}"><c:out value="${ oneDojo.name }"/></form:option>
			</c:forEach>
		</form:select><br>
		
		<form:label path="firstName">First Name:</form:label>
		<form:input path="firstName"/>
		<form:errors path="firstName"/><br>
		
		<form:label path="lastName">Last Name:</form:label>
		<form:input path="lastName"/>
		<form:errors path="lastName"/><br>
		
		<form:label path="age">Age:</form:label>
		<form:input path="age" type="number"/>
		<form:errors path="age"/><br>
		
		<input type="submit" value="Create">
	</form:form>

</body>
</html>