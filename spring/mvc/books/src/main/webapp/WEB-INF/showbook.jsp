<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>Show Book</title>
</head>
<body>
	<h1><c:out value="${books.title}"/></h1>
	<p>Description: <c:out value="${ books.description }"/></p>
	<p>Language: <c:out value="${ books.language }"/></p>
	<p>Number of Pages: <c:out value="${ books.numberOfPages }"/></p>
</body>
</html>