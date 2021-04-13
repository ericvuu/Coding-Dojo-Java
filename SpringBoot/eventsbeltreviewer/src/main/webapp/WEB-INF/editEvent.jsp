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
<title><c:out value="${e.name}"/></title>
</head>
<body>
<div class="container">
<h1 class="display-1"><c:out value="${e.name}"/></h1>
	<p><form:errors path="user.*"/></p>
	<form:form method="POST" action="/events/${id}/edit" modelAttribute="event">
	        <p class="form-group mt-3">
	            <form:label path="name">Name </form:label>
	            <form:input type="text" path="name"/>
	        </p>
	        <p class="form-group mt-3">
	            <form:label path="eventDate">Date </form:label>
	            <form:input type="date" path="eventDate"/>
	        </p>
	        <p class="form-group mt-3">
	            <form:label path="city">City: </form:label>
	            <form:input type="text" path="city"/>
	            
	 	        <form:select path="state">
	 	        <option value="" disabled selected>Select a State</option>
		        	<c:forEach items="${allStates}" var="s">
		        		<form:option value="${s}"> ${s}</form:option>
		        	</c:forEach>
	        	</form:select> 
	        </p>
	        <button class="btn btn-primary mt-5">Edit!</button>
	    </form:form>
</div>
</body>
</html>