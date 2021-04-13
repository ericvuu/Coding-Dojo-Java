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
<title>Welcome</title>
</head>
<body>
<div class="container">
<div class="row">
<div class="col-10">
<h1 class="display-2">Welcome <c:out value="${thisUser.name}"/></h1>
</div>
<div class="col-2">
<a class="h2" href="/logout">Log out</a>
</div>
</div>
<div class="row mt-5">
<h3>Here are some of the events in your state: </h3>
		<table class="table mt-5">
	 	<thead>
	    <tr>
	      <th scope="col">Name</th>
	      <th scope="col">Date</th>
	      <th scope="col">Locations</th>
	      <th scope="col">Host</th>
	      <th scope="col">Action/Status</th>
	    </tr>
	  </thead>
	  <tbody>
	  	<c:forEach items="${inStateEvents}" var="is">
	  		<tr>
	  		<td><a href="/events/${is.id}"><c:out value="${is.name}"/></a></td>
	  		<td><fmt:formatDate pattern ="MMMM dd, yyyy" value ="${is.eventDate}"/></td>
			<td><c:out value="${is.city}"/></td>
			<td><c:out value="${is.host.firstName}"/></td>
			<td>
				<c:if test="${user.id == is.host.id}">
					<a href="/events/${is.id}/edit">Edit</a>
				</c:if>
				<c:if test="${user.id != is.host.id}">
					<form action="/events/${is.id}/join" method="POST">
						<input type="hidden" name="eventJoin" value="${is.id}" />
						<input class="btn btn-link" type="submit" value="join"/>
					</form>
				</c:if>
			</td>
	  	</c:forEach>
	  </tbody>
	</table>
</div>
<div class="row mt-5">
<h3>Here are some of the events in other states: </h3>
		<table class="table mt-5">
	 	<thead>
	    <tr>
	      <th scope="col">Name</th>
	      <th scope="col">Date</th>
	      <th scope="col">Locations</th>
	      <th scope="col">Host</th>
	      <th scope="col">Action/Status</th>
	    </tr>
	  </thead>
	  <tbody>
	  	<c:forEach items="${outOfStateEvents}" var="os">
	  		<tr>
	  		<td><a href="/events/${os.id}"><c:out value="${os.name}"/></a></td>
	  		<td><fmt:formatDate pattern ="MMMM dd, yyyy" value ="${os.eventDate}"/></td>
			<td><c:out value="${os.city}"/></td>
			<td><c:out value="${os.host.firstName}"/></td>
			<td>
				<c:if test="${user.id == os.host.id}">
					<a href="/events/${os.id}/edit">Edit</a>
				</c:if>
				<c:if test="${user.id != os.host.id}">
					<form action="/events/${os.id}/join" method="POST">
						<input type="hidden" name="eventJoin" value="${os.id}" />
						<input class="btn btn-link" type="submit" value="join"/>
					</form>
				</c:if>
			</td>
	  	</c:forEach>
	  </tbody>

	</table>
</div>
<div class="row mt-5">
<h3>Create an Event: </h3>
    	<p><form:errors path="event.*"/></p>
    	<form:form method="post" action="/createEvent" modelAttribute="event">
        <p class="form-group mt-3">
	       <form:label path="name">Name: </form:label>
	       <form:input type="text" path="name"/>
	     </p>
	     <p class="form-group mt-3">
	       <form:label path="eventDate">Date: </form:label>
	       <form:input type="Date" path="eventDate"/>
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
        <Button class="btn btn-primary mt-5" type="submit">Create!</Button>
    </form:form>    
</div>
</div>
</body>
</html>