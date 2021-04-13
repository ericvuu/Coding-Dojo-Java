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
<title>Dashboard</title>
</head>
<body>
<div class="container">
<h1>Questions Dashboard</h1>
		<div class="mt-5">
		<table class="table">
	 	<thead>
	    <tr>
	      <th scope="col">Name</th>
	      <th scope="col">Rating</th>
	    </tr>
	  </thead>
	  <tbody>
  	<c:forEach items="${allQuestions}" var="q"> 
	  	<tr>
	  		<td><c:out value="${q.id}">${q.question}</c:out></td>
	  		<td>
				<c:forEach items="${q.tags}" var="t">
				<c:out value="${t.subject},"></c:out>
				</c:forEach>		
	  		</td>
	  	</tr>
	  	</c:forEach>
	  </tbody>
	</table>
	<a class="h3 success mt-5" href="/questions/new">New Question</a>
  </div>
</div>
</body>
</html>