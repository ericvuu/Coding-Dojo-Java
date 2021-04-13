<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/style.css" />
<title>Home page</title>
</head>
<body>
<div class="main-container">
	<div class="form-container">
	<h3 class="error"><c:out value="${error}"/></h3>
	
	<h1>What is the code?</h1>
	<form action="/checkCode" method="POST">
		<input type="text" name="codeInput" /></input>
		<button>Try Code</button>
	</form>
	</div>
</div>
</body>
</html>