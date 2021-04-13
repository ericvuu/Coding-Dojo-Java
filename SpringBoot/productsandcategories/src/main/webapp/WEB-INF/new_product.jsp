<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>
<title>New Product</title>
</head>
<body>
<div class="container">
<h1 class="text-center">New Product</h1>
<div class="row">
	<div class="col-md-4 mx-auto mt-3">
		<form:errors path="product.*"/>
		<form:form action="/addProduct" method="post" modelAttribute="product">
		 <p>
        <form:label path="name">Name</form:label>
        <form:input path="name"/>
    	</p>
    	<p>
        <form:label path="description">Description</form:label>
        <form:textarea path="description"/>
    	</p>
    	<p>
        <form:label path="price">Price</form:label>
        <form:input path="price"/>
    	</p>
    	<input type="submit" value="Create"/>	
		</form:form>
	</div>
	</div>
</div>
</body>
</html>