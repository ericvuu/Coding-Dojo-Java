<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>
<title>Event</title>
</head>
<body>
<div class="container">
<div>
<h1><c:out value="${event.name}"></c:out></h1>
<p>Date: <fmt:formatDate pattern ="MMMM dd, yyyy" value ="${event.eventDate}"/></p>
<p>Location: <c:out value="${event.city}"></c:out><c:out value="${event.state}"></c:out>
<h5>People who are attending this event: <c:out value="${event.usersAttending.size()}"/></h5>
		<table class="table mt-5">
	 	<thead>
	    <tr>
	      <th scope="col">Name</th>
	      <th scope="col">Location</th>
	    </tr>
	  </thead>
	  <tbody>
	  	<c:forEach items="${event.usersAttending}" var="a">
	  		<tr>
			      <td><c:out value="${a.firstName}"/> <c:out value="${a.lastName}"/></td>
			      <td><c:out value="${a.city}"/></td>
		   </tr>
	  	</c:forEach>
	  </tbody>
	</table>
</div>
<div>

</div>
</div>
</body>
</html>