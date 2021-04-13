<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="webjars/bootstrap/4.0.0/css/bootstrap.css">
<script src="webjars/jquery/1.9.1/jquery.js"></script>
<script src="webjars/bootstrap/4.0.0/js/bootstrap.js"></script>
<title>Person Information</title>
</head>
<body>
	<div class="container">
		<h1><c:out value="${license.person.firstName}"/> <c:out value="${license.person.lastName}"/></h1>
		<p>License Number: <c:out value="${license.number}"/></p>
		<p>State: <c:out value="${license.state}"/></p>
		<p>Expiration Date: <c:out value="${license.expirationDate}"/></p>
	</div>
</body>
</html>
