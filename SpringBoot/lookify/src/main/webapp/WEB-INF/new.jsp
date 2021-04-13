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
<title>New Song</title>
</head>
<body>
<div><a href="/dashboard">Dashboard</a></div>
<div class="row">
	<div class="col-md-8 mx-auto mt-3">
		<form:form action="/dashboard" method="post" modelAttribute="song">
		 <p>
        <form:label path="title">Title</form:label>
        <form:errors path="title"/>
        <form:input path="title"/>
    	</p>
		<p>
        <form:label path="artist">Artist</form:label>
        <form:errors path="artist"/>
        <form:input path="artist"/>
    	</p>
		<p>
 		<form:label path="rating">Rating</form:label>
        <form:errors path="rating"/>
        <form:input type="number" path="rating"/>
    	</p>	
    	<input type="submit" value="Submit"/>	
		</form:form>
	</div>
</div>
</body>
</html>