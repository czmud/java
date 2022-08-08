<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>Document</title>
</head>
<body>
	<h1>Send an Omikuji!</h1>
	<form action="/omikuji/submit-fortune-form" method="post">
		<label for="years">Pick any number from 5 to 25:</label>
		<input type="number" name="years" required><br>
		<label for="city">Enter the name of any city:</label>
		<input type="text" name="city" required><br>
		<label for="person">Enter the name of any person:</label>
		<input type="text" name="person" required><br>
		<label for="profession">Enter professional endeavor or hobby:</label>
		<input type="text" name="profession" required><br>
		<label for="animal">Enter any type of living thing:</label>
		<input type="text" name="animal" required><br>
		<label for="statement"> Say something nice to someone:</label>
		<textarea name="statement" required></textarea>
		<label for="submit" >Send and show a friend</label>
		<input type="submit" name="submit" value="Send">
	</form>
</body>
</html>