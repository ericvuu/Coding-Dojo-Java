<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
<title>Employees</title>
</head>
<body>
	<div class="container-fluid">
		<div class="container-fluid">
			<nav class="navbar">
				<h3>
					<a class="text-decoration-none text-dark"
						style="margin-left: 15px;" href="/admin">Back</a>
				</h3>
				<h1 class="text-dark" style="margin: 0 auto; padding: 10px;">Employees</h1>
				<h3>
					<a class="text-decoration-none text-dark"
						style="margin-right: 15px;" href="/logout">Logout</a>
				</h3>
			</nav>
			<div class="row justify-content-end">
			<div class="col-3">
				
				<a class="btn btn-success" href="/admin/employees/create"> <i class="fas fa-user-plus"></i> Add an Employee</a>
			
				<a class="btn btn-success" href="/admin/positions/create"> <i class="fas fa-plus"></i> Create a Position</a>
	
			</div>
			</div>
			<table class="table mt-5">
				<thead>
					<tr>
						<th scope="col">ID</th>
						<th scope="col">Name</th>
						<th scope="col">Hire Date</th>
						<th scope="col">Position</th>
						<th scope="col">Department</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${allEmployees}" var="e">
						<tr>
							<td><c:out value="${e.id}" /></td>
							<td><c:out value="${e.firstName}" /> <c:out
									value="${e.lastName}" /></td>
							<td><fmt:formatDate pattern="MMMM dd, yyyy"
									value="${e.hireDate}" /></td>
							<td><c:out value="${e.position.name}" /></td>
							<td><c:out value="${e.department.name}" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>