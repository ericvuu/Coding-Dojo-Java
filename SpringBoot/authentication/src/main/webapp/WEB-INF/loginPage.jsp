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
<title>Login Page</title>
</head>
<body>
<div class="container">
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
        <input class="btn btn-primary mt-5" type="submit" value="Login!"/>
    </form>    
</div>
</body>
</html>