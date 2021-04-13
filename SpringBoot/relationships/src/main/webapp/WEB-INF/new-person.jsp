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
<title>New Person</title>
</head>
<body>
	<h1>New Person</h1>
	<div class="row">
	<div class="col-md-8 mx-auto mt-3">
		<form:form action="/addPerson" method="post" modelAttribute="person">
		 <p>
        <form:label path="firstName">First Name</form:label>
        <form:errors path="firstName"/>
        <form:input path="firstName"/>
    	</p>
		<p>
        <form:label path="lastName">Last Name</form:label>
        <form:errors path="lastName"/>
        <form:input path="lastName"/>
    	</p>	
    	<input type="submit" value="Create"/>	
		</form:form>
	</div>
</div>
</body>
</html>