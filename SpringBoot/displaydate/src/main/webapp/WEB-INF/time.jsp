<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/time.css"> 
<script type="text/javascript" src="js/time.js"></script>
<title>Time</title>
</head>
<body>
<div class="time-container">
<div class="time-text"><c:out value="${time}"/></div>
</div>
</body>
</html>