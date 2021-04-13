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
<title>Question</title>
</head>
<body>
<div class="container">
<h1 class="display-1">Question Placeholder</h1>
	<div class="mt-5">
	<h2>Tags:</h2>
	</div>
	<div class="row mt-5 d-flex justify-content-around">
		<div class="col-6">
		<table class="table">
	 	<thead>
	    <tr>
	      <th scope="col">Answers</th>
	    </tr>
	  </thead>
	  <tbody>
<%-- 	  	<c:forEach items="${}" var=""> --%>
	  	<tr>
	  		<td>Placeholder</td>
	  	</tr>
	  	<tr>
	  		<td>Placeholder</td>
	  	</tr>
<%-- 	  	</c:forEach> --%>
	  </tbody>
		</table>
	</div>
	
	<div class="col-5">
		<h3>Add your answer:</h3>
		<form action="/submitAnswer"  method="post" > <!--modelAttribute="category"  -->
		<div class="form-group">
		<label for="">Answer:</label>
		<textarea class="form-control" cols="50" rows="5"></textarea>
		</div>
		<div class="text-right">
		<button class="btn btn-primary mt-5" type="submit">Submit</button>
		</div>
		</form>
	</div>
	
	</div>
</div>
</body>
</html>