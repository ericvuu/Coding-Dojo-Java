<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/date.css"> 
<script type="text/javascript" src="js/date.js"></script>
<title>Date</title>
</head>
<body>
<div class="date-container">
<div class="date-text">
	<c:out value="${finalString}"/>
</div>
</div>
</body>
</html>