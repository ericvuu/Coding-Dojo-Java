<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="webjars/bootstrap/4.0.0/css/bootstrap.css">
<script src="webjars/jquery/1.9.1/jquery.js"></script>
<script src="webjars/bootstrap/4.0.0/js/bootstrap.js"></script>
<title>New License</title>
</head>
<body>
	<h1>New License</h1>
	<div class="row">
	<div class="col-md-8 mx-auto mt-3">
		<form:form action="/addLicense" method="post" modelAttribute="license">
		 <p>
        <form:label path="person">Person</form:label>
        <form:errors path="person"/>
        <form:select path="person">
        	<c:forEach items="${allPeople}" var="person">
        		<c:choose>
        			<c:when test="${person.license == null}">
        				<form:option value="${person.id}"><c:out value="${person.firstName}"/> <c:out value="${person.lastName}"/></form:option>
        			</c:when>
        			    <c:otherwise>
       						<td>I have a License</td>
    					</c:otherwise>
					</c:choose>
        	</c:forEach>
        </form:select>
    	</p>
		<p>
        <form:label path="state">State</form:label>
        <form:errors path="state"/>
        <form:input path="state"/>
    	</p>
    	<p>
        <form:label path="expirationDate">Expiration Date</form:label>
        <form:errors path="expirationDate"/>
        <form:input type="date" path="expirationDate"/>
    	</p>
    	<input type="submit" value="Create"/>	
		</form:form>
	</div>
</div>
</body>
</html>