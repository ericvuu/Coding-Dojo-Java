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
<title>Top Ten Songs</title>
</head>
<body>
<h1>Top Ten Songs</h1>
	<c:forEach items="${songs}" var="song">
	  		<p><c:out value="${song.rating}"/> - <a href="/songs/${song.id}"><c:out value="${song.title}"/></a> <c:out value="${song.artist}"/></p>
	</c:forEach>
</body>
</html>