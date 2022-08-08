<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>Document</title>
</head>
<body>
	<h1>Here's Your Omikuji!</h1>
	<p style="background-color: blue; padding: 5px; height: 300px; width: 200px"> In <c:out value="${omikuji.years}"/> years, you will live in <c:out value="${omikuji.city}"/>
	 with <c:out value="${omikuji.person}"/> as your roommate, <c:out value="${omikuji.profession}"/> for a living.
	 The next time you see a <c:out value="${omikuji.animal}"/>, you will have good luck. Also, <c:out value="${omikuji.statement}"/>
	</p>
	<a href="/omikuji/">Go Back</a>
</body>
</html>