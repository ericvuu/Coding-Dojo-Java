<%@ page isErrorPage="true" %>
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
<title>${language.name}</title>
</head>
<body>
<div class="row">
	<form action="/languages/${language.id}" method="post"> <input type="hidden" name="_method" value="delete" /> <input class="btn btn-link" type="submit" value="Delete"/> </form>
	<a href="/languages">Dashboard</a>
	<div class="col-md-8 mx-auto mt-3">
	<form:form action="/languages/${language.id}" method="post" modelAttribute="language">
		<input type="hidden" name="_method" value="put">
		 <p>
        <form:label path="name">Name</form:label>
        <form:errors path="name"/>
        <form:input path="name"/>
    	</p>
		<p>
        <form:label path="creator">Creator</form:label>
        <form:errors path="creator"/>
        <form:input path="creator"/>
    	</p>
		<p>
        <form:label path="version">Version</form:label>
        <form:errors path="version"/>
        <form:input path="version"/>
    	</p>	
    	<input type="submit" value="Submit"/>	
		</form:form>
	</div>
</div>
</body>
</html>