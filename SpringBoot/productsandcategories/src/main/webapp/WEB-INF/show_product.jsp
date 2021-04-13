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
<title><c:out value="${product.name}"/></title>
</head>
<body>
<div class="container">
<h1><c:out value="${product.name}"/></h1>
	<div class="row">
		<div class="col-6">
		<h2>Categories</h2>
				<ul>
				<c:forEach items="${product.categories}" var="cat">
        		
            	<li><c:out value="${cat.name}"/></li>
            	
    			</c:forEach>
    			</ul>
		</div>
	<div class="col-6">
		<h2>Add Category:</h2>
			 <!-- corresponds to the  @ModelAttribute("category") within the controller -->
	 		<form:form action="/addToProduct/${product.id}" method="post" modelAttribute="category">
	 		<!-- name corresponds to a field name  -->
	 		<form:select path="name">
	        	<c:forEach items="${filteredCategories}" var="c">
	        		<form:option value="${c.id}">${c.name}</form:option>
	        	</c:forEach>
	        </form:select>
	       	<button type="submit">Add</button>
			</form:form>
	</div>
</div>
</div>
</body>
</html>