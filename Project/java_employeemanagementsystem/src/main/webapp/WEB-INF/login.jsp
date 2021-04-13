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
<title>Login Page</title>
</head>
<body>
	<div class="container-fluid">
		<div>
			<h1 class="display-1 text-center mt-4">WorkBright</h1>
			<h3 class="text-center mt-3">Human Resources Made Easy</h3>
		</div>
			<div class="col-5 mx-auto px-3 py-5 my-3">
				<h1 class="text-center">Login</h1>
				<p class="text-danger text-center h5">
					<c:out value="${error}" />
				</p>
				<form method="post" action="/login">
					<div class="form-group mt-3">
						<input class="form-control form-control-lg" type="text" id="email"
							name="email" placeholder="Enter email" />
					</div>
					<div class="form-group mt-3">
						<input class="form-control form-control-lg" type="password"
							id="password" name="password" placeholder="Password" />
					</div>
					<div class="text-center mt-3">
						<button class="btn btn-success btn-lg btn-block">Login</button>
					</div>
				</form>
			</div>
		</div>
</body>
</html>