<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>
<title>Dojo Information</title>
</head>
<body>
<div class="container">
<h1 class="text-center">${dojo.name}</h1>
<table class="table">
    <thead>
        <tr>
            <th scope="col">First Name</th>
            <th scope="col">Last Name</th>
            <th scope="col">Age</th>
        </tr>
    </thead>
    <tbody>
    <!-- ninjas is a list attribute on dojo table  -->
        <c:forEach items="${dojo.ninjas}" var="ninja">
        <tr>
            <td><c:out value="${ninja.firstName}"/></td>
            <td><c:out value="${ninja.lastName}"/></td>
            <td><c:out value="${ninja.age}"/></td>
        </tr>
        </c:forEach>
    </tbody>
</table>
</div>
</body>
</html>