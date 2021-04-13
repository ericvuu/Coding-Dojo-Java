<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="webjars/bootstrap/4.0.0/css/bootstrap.css">
<link rel="stylesheet" href="webjars/bootstrap/4.0.0/css/bootstrap.css">
<script src="webjars/jquery/1.9.1/jquery.js"></script>
<script src="webjars/bootstrap/4.0.0/js/bootstrap.js"></script>
<title><c:out value="${language.name}"/></title>
</head>
<body>
	<a href="/languages">Dashboard</a>
	<p><c:out value="${language.name}"/></p>
	<p><c:out value="${language.creator}"/></p>
	<p><c:out value="${language.version}"/></p>
	<a href="/languages/${language.id}/>/edit">Edit</a>
	<form action="/languages/${language.id}" method="post"> <input type="hidden" name="_method" value="delete" /> <input class="btn btn-link" type="submit" value="Delete"/> </form>
</body>
</html>