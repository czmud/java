<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>Current Visit Count</title>
</head>
<body>
	<p>You have visited http://your-server 
	<c:out value="${visitCount}"/>
	times.
	</p>
	<a href="/your-server">Test another visit?</a><br><br>
	<a href="/your-server/double-whammy">Test even more of a visit?</a><br><br>
	<a href="/your-server/reset-counter">Reset to zero</a><br><br>
</body>
</html>