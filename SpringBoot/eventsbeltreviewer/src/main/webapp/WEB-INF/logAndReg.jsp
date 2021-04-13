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
<title>Welcome</title>
</head>
<body>
<div class="container">
	<div class="row">
	<!-- REGISTRATION FORM -->
	<div class="col-6">
		 <h1>Register!</h1>
    	 <p><form:errors path="user.*"/></p>
    
	    <form:form method="POST" action="/registration" modelAttribute="user">
	    	<p class="form-group mt-3">
	            <form:label path="firstName">First Name: </form:label>
	            <form:input type="text" path="firstName"/>
	        </p>
	        <p class="form-group mt-3">
	            <form:label path="lastName">Last Name: </form:label>
	            <form:input type="text" path="lastName"/>
	        </p>
	        <p class="form-group mt-3">
	            <form:label path="email">Email: </form:label>
	            <form:input type="email" path="email"/>
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
	        <p class="form-group mt-3">
	            <form:label path="password">Password: </form:label>
	            <form:password path="password"/>
	        </p>
	        <p class="form-group mt-3">
	            <form:label path="passwordConfirmation">Password Confirmation:</form:label>
	            <form:password path="passwordConfirmation"/>
	        </p>
	        <button class="btn btn-primary mt-5">Register!</button>
	    </form:form>
		
	</div>
	
	<!-- LOGIN FORM -->	
	<div class="col-6">
		<h1>Login</h1>
    	<p class="text-danger"><c:out value="${error}" /></p>
    	<form method="post" action="/login">
        <p class="form-group mt-3">
            <label for="email">Email</label>
            <input type="text" id="email" name="email"/>
        </p>
        <p class="form-group mt-3">
            <label for="password">Password</label>
            <input type="password" id="password" name="password"/>
        </p>
        <Button class="btn btn-primary mt-5" type="submit">Login!</Button>
    </form>    
	</div>
</div>
</div>
</body>
</html>