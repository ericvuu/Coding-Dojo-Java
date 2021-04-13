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
<title><c:out value="${song.artist}"/></title>
</head>
<body>
<div class="container">
	<div>
		<h2>Songs by artist: <c:out value="${song.artist}"/></h2>
		<form action="/search" class="mt-5">
			<input type="text" name="artistSearch" /> <input type="submit"
				value="Search Artist" />
		</form>
		<a href="/dashboard">Dashboard</a>
	</div>
	<div class="mt-5">
		<table class="table">
			<thead>
				<tr>
					<th scope="col">Name</th>
					<th scope="col">Rating</th>
					<th scope="col">Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${songs}" var="song">
					<tr>
						<td><a href="/songs/${song.id}"><c:out
									value="${song.title}" /></a></td>
						<td><c:out value="${song.rating}" /></td>
						<td>
							<form action="/delete/${song.id}" method="post">
								<input type="hidden" name="_method" value="delete" /> <input
									class="btn btn-link" type="submit" value="Delete" />
							</form>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
</body>
</html>