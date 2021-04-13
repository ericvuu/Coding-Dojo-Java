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
<title>Insert title here</title>
</head>
<body>
	<div class="container-fluid">
		<div class="container-fluid">
			<div class="container-fluid">
				<nav class="navbar">
					<h3>
						<a class="text-decoration-none text-dark"
							style="margin-left: 15px;" href="/admin">Home</a>
					</h3>
					<h1 class="text-dark" style="margin: 0 auto; padding: 10px;">Add
						New Position</h1>
					<h3>
						<a class="text-decoration-none text-dark"
							style="margin-right: 15px;" href="/logout">Logout</a>
					</h3>
				</nav>
				<div class="container jumbotron" style="margin-top: 10px;">
					<div class="text-danger text-center h5">
						<form:errors path="position.*" />
					</div>
					<div class="row mx-auto px-3 py-5 my-3">
						<form:form class="container" method="post"
							action="/admin/positions/create" modelAttribute="position">
							<div class="row">
								<div class="col-lg-6 mx-auto">
									<h3 class="text-center">Add a Position</h3>
									<div class="form-group mt-3">
										<form:input class="form-control form-control-lg" type="text"
											path="name" placeholder="Name" />
									</div>
									<div class="form-group mt-3">
										<form:input class="form-control form-control-lg" type="number"
											path="wage" placeholder="Wage" />
									</div>
									<div class="form-group mt-5 text-center">
										<h5 class="mt-3">Does this position have administrative privileges?</h5>
										<form:radiobutton class="form-check-input" path="privileges" value="true" /> Yes
										<form:radiobutton class="form-check-input" path="privileges" value="false" /> No
									</div>
								</div>
							</div>
							<div class="row">
								<div class="text-center mt-5">
									<button class="btn btn-success btn-lg">Create Position</button>
								</div>
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>