<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Result</title>
<link rel="stylesheet" href="webjars/bootstrap/4.0.0/css/bootstrap.css">
<script src="webjars/jquery/1.9.1/jquery.js"></script>
<script src="webjars/bootstrap/4.0.0/js/bootstrap.js"></script>
</head>
<body>
<div class="row mt-5">
	<div class="col-4 mx-auto mt-5 p-5 border border-5 border-dark">
		<h1>Submitted Info</h1>
		<p>Name: <c:out value="${name}"></c:out></p>
		<p>Dojo Location: <c:out value="${dojo}"></c:out></p>
		<p>Favorite Language <c:out value="${language}"></c:out></p>
		<p>Comment: <c:out value="${comment}"></c:out></p>
	</div>
</div>
</body>
</html>