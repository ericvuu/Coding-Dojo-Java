<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Insert title here</title>
<link rel="stylesheet" href="webjars/bootstrap/4.0.0/css/bootstrap.css">
<script src="webjars/jquery/1.9.1/jquery.js"></script>
<script src="webjars/bootstrap/4.0.0/js/bootstrap.js"></script>
</head>
<body>
	<div class="container">
		<div id="form-container">
			<div class="col-8 mx-auto mt-5">
				<form action="/process" method="post" class="p-5 border border-dark">
					<div class="form-group row">
						<label for="nameInput" class="col-4">Your Name:</label> 
						<input type="text" class="col-8" name="nameInput">
					</div>
					<div class="form-group row">
						<label for="dojoInput" class="col-4">Dojo Location:</label> 
						<select class="col-8" name="dojoInput">
							<option value="online">Online</option>
							<option value="san_jose">San Jose</option>
							<option value="los_angeles">Los Angeles</option>
							<option value="bellevue">Bellevue</option>
						</select>
					</div>
					<div class="form-group row">
						<label for="languageInput" class="col-4">Favorite Location:</label> 
						<select class="col-8" name="languageInput">
							<option value="Python">Python</option>
							<option value="Java">Java</option>
							<option value="Javascript">JavaScript</option>
							<option value="C#">C#</option>
						</select> 
					</div>
					<div class="form-group row">
						<label for="comments" class="ml-3">Comments (optional):</label>
						<textarea name="comments" class="form-control col-md-11 mx-auto" style="resize: none;"></textarea>
					</div>
					<div class="form-group">
					<button type="submit" class="btn btn-primary float-right">button</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>