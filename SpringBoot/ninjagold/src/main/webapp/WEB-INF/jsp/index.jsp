<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<%@ page import="java.util.*" %> 
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" href="/css/style.css" />
	<title>Homepage</title>
	</head>
	<body>
	<div id="container">
      <div id="scoreboard">
        <p id="your-gold">
          Your Gold
          <span id="gold-count"><c:out value="${amount}"></c:out></span>
        </p>
      </div>
      <div id="locations-container">
        <div class="locations">
          <h2>Farm</h2>
          <p>(Earns 10 - 20 golds)</p>
          <form action="/processMoney" method="post">
            <input type="hidden" name="which_form" value="farm" />
            <button type="submit">Find Gold!</button>
          </form>
        </div>
        <div class="locations">
          <h2>Cave</h2>
          <p>(Earns 5 - 10 golds)</p>
          <form action="/processMoney" method="post">
            <input type="hidden" name="which_form" value="cave" />
            <button type="submit">Find Gold!</button>
          </form>
        </div>
        <div class="locations">
          <h2>House</h2>
          <p>(Earns 2 - 5 golds)</p>
          <form action="/processMoney" method="post">
            <input type="hidden" name="which_form" value="house" />
            <button type="submit">Find Gold!</button>
          </form>
        </div>
        <div class="locations">
          <h2>Casino</h2>
          <p>(Earns/takes 0 - 50 golds)</p>
          <form action="/processMoney" method="post">
            <input type="hidden" name="which_form" value="casino" />
            <button type="submit">Find Gold!</button>
          </form>
        </div>
      </div>
      <div id="activities-container">
        <h3>Activities:</h3>
        <div id="actvities">
         	<c:forEach items="${activityLog}" var="activity">
         		<p>${activity}</p>
         	</c:forEach>
        </div>
      </div>
    </div>
</body>
</html>