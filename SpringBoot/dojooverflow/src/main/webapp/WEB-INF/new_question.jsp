<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0"
	crossorigin="anonymous"></script>
<title>New Question</title>
</head>
<body>
	<div class="container">
		<h1 class="display-1">What is your Question?</h1>
		<form:errors path="question.*" />
		<form:form method="post" action="/questions/new" modelAttribute="newQuestion">
			<div class="form-group">
				<form:label path="question">Question:</form:label>
				<form:textarea path="question" class="form-control" cols="50"
					rows="5"></form:textarea>
			</div>
			<div class="form-group mt-5">
				<form:label path="">Tags:</form:label>
				<form:input path="" class="col-5" />
			</div>
			<div class="text-right">
				<button class="btn btn-primary mt-5" type="submit">Submit</button>
			</div>
		</form:form>
	</div>
</body>
</html>