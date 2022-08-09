<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<title>Ninja Gold Game</title>
</head>
<body class="content p-4">
	<div class="d-flex justify-content-start align-items-center">
	<h2 class="m-3">Your Gold: <c:out value="${goldTotal}"/></h2>
	<a class="m-3" href="/reset-gold" role="button">Reset Gold</a>
	</div>
	<div class="d-flex justify-content-start">
		<div class="d-flex flex-column align-items-center p-2">
			<h4>Farm</h4>
			<p>Earns 10-20 gold</p>
			<form action="/find-gold" method="post">
				<input type="hidden" name="activityChar" value="f">
				<input type="submit" value="Find Gold">
			</form>
		</div>
		<div class="d-flex flex-column align-items-center p-2">
			<h4>Cave</h4>
			<p>Earns 5-10 gold</p>
			<form action="/find-gold" method="post">
				<input type="hidden" name="activityChar" value="c">
				<input type="submit" value="Find Gold">
			</form>
		</div>
		<div class="d-flex flex-column align-items-center p-2">
			<h4>House</h4>
			<p>Earns 10-20 gold</p>
			<form action="/find-gold" method="post">
				<input type="hidden" name="activityChar" value="h">
				<input type="submit" value="Find Gold">
			</form>
		</div>
		<div class="d-flex flex-column align-items-center p-2">
			<h4>Quest</h4>
			<p>Earns/Loses 0-50 gold</p>
			<form action="/find-gold" method="post">
				<input type="hidden" name="activityChar" value="q">
				<input type="submit" value="Find Gold">
			</form>
		</div>
		<div class="d-flex flex-column align-items-center p-2">
			<h4>Spa</h4>
			<p>Loses 5-20 gold</p>
			<form action="/find-gold" method="post">
				<input type="hidden" name="activityChar" value="s">
				<input type="submit" value="Find Gold">
			</form>
		</div>
	</div>
	
	
	<h2>Activites:</h2>
	<div>
	<c:forEach var="activity" items="${activityLog}">
		<c:choose>
			<c:when test="${activity.goldEarned > 0 }">
				<p class="text-success">
					<c:out value="${activity.generateEarningStatement()}"/>
				</p>
			</c:when>
			<c:otherwise>
				<p class="text-danger">
					<c:out value="${activity.generateEarningStatement()}"/>
				</p>
			</c:otherwise>
		</c:choose>
	</c:forEach>
	</div>
</body>
</html>