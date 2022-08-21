<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<title>Languages</title>
</head>
<body>
	<table>
		<tr>
			<th>Name</th>
			<th>Creator</th>
			<th>Version</th>
			<th>Actions</th>
		</tr>
	<c:forEach var="oneLanguage" items="${ languages }">
		<tr>
			<td><a href="/languages/${ oneLanguage.id }"><c:out value="${ oneLanguage.name }"/></a></td>
			<td><c:out value="${ oneLanguage.creator }"/></td>
			<td><c:out value="${ oneLanguage.version }"/></td>
			<td>
				<a href="/languages/edit/${ oneLanguage.id }">Edit</a>
				<form:form action="/languages/delete-language/${oneLanguage.id}">
					<input type="hidden" name="_method" value="delete">
					<input type="submit" value="delete">
				</form:form>
			</td>
		</tr>
	</c:forEach>
	</table><br>
	
	<form:form action="/languages/create-new-language" modelAttribute="newLanguage">
		<form:label path="name">Name:</form:label>
		<form:input path="name"/>
		<form:errors class="text-danger" path="name"/><br>
		
		<form:label path="creator">Creator:</form:label>
		<form:input path="creator"/>
		<form:errors class="text-danger" path="creator"/><br>
		
		<form:label path="version">Version:</form:label>
		<form:input path="version"/>
		<form:errors class="text-danger" path="version"/><br>
		
		<input type="submit" value="Submit">
	</form:form>

</body>
</html>