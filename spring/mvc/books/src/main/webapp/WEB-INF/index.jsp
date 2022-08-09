<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>Books</title>
</head>
<body>
	<h1>All Books</h1>
	<table>
	    <thead>
	        <tr>
	            <th>ID</th>
	            <th>Title</th>
	            <th>Language</th>
	            <th>Number of Pages</th>
	        </tr>
	    </thead>
	    <tbody>
	         <c:forEach var="book" items="${ books }">
	         <tr>
		         <td><c:out value="${ book.id }"/></td>
		         <td>
		         	<a href="/api/books/+<c:out value="${ book.id }"/>">
		         	<c:out value="${ book.title }"/>
		         	</a>
		         </td>
		         <td><c:out value="${ book.language }"/></td>
		         <td><c:out value="${ book.numberOfPages }"/></td>
	         </tr>
	         </c:forEach>
	    </tbody>
	</table>
</body>
</html>




    
