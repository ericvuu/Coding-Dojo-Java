<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.0.7/css/all.css" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.4/Chart.min.js"
	integrity="sha512-d9xgZrVZpmmQlfonhQUvTR7lMPtO7NkZMkA0ABN3PHCbKA5nqylQ/yWlFAyY6hYgdF1Qh6nYiuADWwKB4C2WSw=="
	crossorigin="anonymous">
</script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js">
</script>
<script type="text/javascript" src="/js/departments.js"></script>
<title>Departments</title>
</head>
<body>
	<div class="container-fluid">
		<nav class="navbar">
			<h3>
				<a class="text-decoration-none text-dark" style="margin-left: 15px;"
					href="/admin">Back</a>
			</h3>
			<h1 class="text-dark" style="margin: 0 auto; padding: 10px;">Departments</h1>
			<h3>
				<a class="text-decoration-none text-dark"
					style="margin-right: 15px;" href="/logout">Logout</a>
			</h3>
		</nav>

		<div class="row justify-content-end">
			<div class="col-2">
				<a class="btn btn-success" href="/admin/departments/create"> <i
					class="fas fa-users"></i> Add a Department
				</a>
			</div>
		</div>
		<div>
		<table class="table mt-5">
			<thead>
				<tr>
					<th scope="col">ID</th>
					<th scope="col">Name</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${allDepartments}" var="d">
					<tr>
						<td><c:out value="${d.id}" /></td>
						<td><c:out value="${d.name}" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="row">
			<div class="col-5 mx-auto">
				<canvas id="departSizeChart"></canvas>
			</div>
			<div class="col-5 mx-auto">
				<canvas id="departSalaryChart"></canvas>
			</div>
		</div>
	</div>
	</div>
</body>
</html>