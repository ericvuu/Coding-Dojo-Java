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
<title>Administrative Dashboard</title>
</head>
<body>
	<div class="container-fluid">
		<nav class="navbar">
			<h3>
				<a class="text-decoration-none text-dark" style="margin-left: 15px;"
					href="/">Back</a>
			</h3>
			<h1 class="text-dark" style="margin: 0 auto; padding: 10px;">Admin
				Dashboard</h1>
			<h3>
				<a class="text-decoration-none text-dark"
					style="margin-right: 15px;" href="/logout">Logout</a>
			</h3>
		</nav>
		<div class="container align-items-center">
			<div class="row d-flex justify-content-center">
				<div class="col-md-5 m-4">
					<a class="text-decoration-none text-dark" href="/admin/employees"><span
						class="display-5">View Employees</span></a>
				</div>
				<div class="col-md-5 m-4">
					<a class="text-decoration-none text-dark" href="/admin/departments"><span
						class="display-5">View Departments</span></a>
				</div>
			</div>
			<div class="row d-flex justify-content-center">
				<div class="col-md-5 m-4">
					<a class="text-decoration-none text-dark"
						href="/admin/employees/create"><span class="display-5">Add
							Employees</span></a>
				</div>
				<div class="col-md-5 m-4">
					<a class="text-decoration-none text-dark" href="/admin/hours"><span
						class="display-5">View Hours</span></a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>