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
	crossorigin="anonymous">
</script>
<title>Add a Employee</title>
</head>
<body>
	<div class="container-fluid">
		<nav class="navbar">
			<h3>
				<a class="text-decoration-none text-dark"
					style="margin-left: 15px;" href="/admin">Back</a>
			</h3>
			<h1 class="text-dark" style="margin: 0 auto; padding: 10px;">Add
				New Employee</h1>
			<h3>
				<a class="text-decoration-none text-dark"
					style="margin-right: 15px;" href="/logout">Logout</a>
			</h3>
		</nav>
		<div class="container jumbotron" style="margin-top: 10px;">
			<div class="text-danger text-center h5">
				<form:errors path="employee.*" />
			</div>
			<div class="row mx-auto px-3 py-5 my-3">
				<form:form class="container" method="post" action="/admin/employees/create"
					modelAttribute="employee">
					<div class="row">
						<div class="col-lg-6">
							<h3 class="text-center">Employee Contact</h3>
							<div class="form-group mt-3">
								<form:input class="form-control form-control-lg" type="text"
									path="firstName" placeholder="First Name" />
							</div>
							<div class="form-group mt-3">
								<form:input class="form-control form-control-lg" type="text"
									path="lastName" placeholder="Last Name" />
							</div>
							<div class="form-group mt-3">
								<form:input class="form-control form-control-lg" type="text"
									path="street" placeholder="Street Address" />
							</div>
							<div class="form-group mt-3">
								<form:input class="form-control form-control-lg" type="text"
									path="city" placeholder="City" />
							</div>
							<div class="form-group mt-3">
								<form:select class="form-control form-control-lg" path="state">
									<option value="" disabled selected>Select a State</option>
									<c:forEach items="${allStates}" var="s">
										<form:option value="${s}"> ${s}</form:option>
									</c:forEach>
								</form:select>
							</div>
							<div class="form-group mt-3">
								<form:input class="form-control form-control-lg" type="text"
									path="zip" placeholder="Zip Code" />
							</div>
							<div class="form-group mt-3">
								<form:input class="form-control form-control-lg" type="text"
									path="phoneNumber" placeholder="Phone Number" />
							</div>

							<div class="form-group mt-3">
								<form:input class="form-control form-control-lg" type="text"
									path="email" placeholder="Email" />
							</div>
							<div class="form-group mt-3">
								<form:input class="form-control form-control-lg" type="password"
									path="password" placeholder="Password" />
							</div>
							<div class="form-group mt-3">
								<form:input class="form-control form-control-lg" type="password"
									path="passwordConfirmation" placeholder="Password Confirmation" />
							</div>
						</div>

						<div class="col-lg-6">
							<h3 class="text-center">Position Details</h3>
							<div class="form-group mt-3">
								<form:input class="form-control form-control-lg" type="date"
									path="hireDate" placeholder="Hire Date" />
							</div>

							<div class="form-group mt-3">
								<form:select class="form-control form-control-lg"
									path="position">
									<option value="" disabled selected>Select a Position</option>
									<c:forEach items="${allPositions}" var="p">
										<form:option value="${p.id}"> ${p.name}</form:option>
									</c:forEach>
								</form:select>
							</div> 

							<div class="form-group mt-3">
								<form:select class="form-control form-control-lg" path="department">
									<option value="" disabled selected>Select a Department</option>
									<c:forEach items="${allDepartments}" var="d">
										<form:option value="${d.id}"> ${d.name}</form:option>
									</c:forEach>
								</form:select>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="text-center mt-3">
							<button class="btn btn-success btn-lg btn-block">Add Employee</button>
						</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>