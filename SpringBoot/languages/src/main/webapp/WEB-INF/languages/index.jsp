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
<title>Dashboard</title>
</head>
<body>
	<div class="container">
	<div class="row">
	<div class="col-md-8 mx-auto mt-5">
	<table class="table">
	 <thead>
	    <tr>
	      <th scope="col">Name</th>
	      <th scope="col">Creator</th>
	      <th scope="col">Version</th>
	      <th scope="col">Action</th>
	    </tr>
	  </thead>
	  <tbody>
	  	<c:forEach items="${languages}" var="language">
	  		<tr>
	  		<td><c:out value="${language.name}"/></td>
	  		<td><c:out value="${language.creator}"/></td>
	  		<td><c:out value="${language.version}"/></td>
	  		<td>
	  		<form action="/languages/${language.id}" method="post"> 
	  			<input type="hidden" name="_method" value="delete" /> 
	  			<input class="btn btn-link" type="submit" value="Delete"/> 
	  		</form>|
	  		<a href="/languages/${language.id}/edit"> Edit </a>
	  		</td>
	  		</tr>
	  	</c:forEach>
	  </tbody>
	</table>
	</div>
	</div>
	<div class="row">
	<div class="col-md-8 mx-auto mt-3">
		<form:form action="/languages" method="post" modelAttribute="language">
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
</div>
</body>
</html>