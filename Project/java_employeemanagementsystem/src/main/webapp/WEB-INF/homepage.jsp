<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script defer
	src="https://use.fontawesome.com/releases/v5.0.7/js/all.js"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0"
	crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="css\homepage.css">
<title>Homepage</title>
</head>
<body>
	<section class="colored-section">

		<div class="container-fluid">
			<nav class="navbar navbar-expand-lg navbar-light">
				<div class="container-fluid">
					<a class="navbar-brand text-white" href="#">WorkBright</a>
					<div class="collapse navbar-collapse">
						<div class="navbar-nav">
							<a class="nav-link active text-white" aria-current="page"
								href="#">Home</a> <a class="nav-link text-white" href="#">Features</a>
							<a class="nav-link text-white" href="#">Pricing</a>
						</div>
					</div>
					<a class="nav-link text-white ml-auto h5" href="/login"
						tabindex="-1" aria-disabled="true">Sign-in</a> <a
						class="nav-link text-white ml-auto h5" href="#" tabindex="-1"
						aria-disabled="true">Register</a>
				</div>
			</nav>
			<div class="row">
				<div class="col">
					<h1 class="big-heading text-center pt-5">Digitally transform
						your workplace, all from a single database.</h1>
					<h3 class="big-heading text-center mt-3">Comprehensive HR &
						Payroll Software.</h3>
					<div class="text-center pt-5">
						<button type="button"
							class="btn btn-success btn-lg download-button">
							<i class="fab fa-apple"></i> Download
						</button>
						<button type="button"
							class="btn btn-outline-light btn-lg download-button">
							<i class="fab fa-google-play"></i> Download
						</button>
					</div>
				</div>
			</div>
		</div>
		<!-- Pricing -->

		<section class="white-section mt-5" id="features">
			<h2 class="display-5 text-center">A Plan for Every Business's
				Needs</h2>
			<h3 class="h5 text-center">Simple and affordable price plans for
				your business.</h3>

			<div class="row pt-5">

				<div class="features-column col-lg-4 col-md-6">
					<div class="card">
						<div class="card-header">
							<h3>Employee-managed data</h3>
						</div>
						<div class="card-body">
							<p class="text-center">
								<i class="fas fa-chart-bar card-icon"></i>
							</p>
							<p class="py-3 text-center">Your employees can access their info through
								easy-to-use tech, 24/7.</p>
							<button class="btn btn-lg btn-success w-100" type="button">Learn
								More</button>
						</div>
					</div>
				</div>

				<div class="features-column col-lg-4 col-md-6">
					<div class="card">
						<div class="card-header">
							<h3>Industry experience to address your challenges</h3>
						</div>
						<div class="card-body">
							<p class="text-center">
								<i class="fas fa-building card-icon"></i>
							</p>
							<p class="py-3 text-center">We've designed our solutions with industry
								input, backed by years of real-world experience. See how you can
								put our solutions to work for your industry.</p>
							<button class="btn btn-lg btn-success w-100" type="button">Learn
								More</button>
						</div>
					</div>
				</div>

				<div class="features-column col-lg-4 col-md-6">
					<div class="card">
						<div class="card-header">
							<h3>Seamless user experience</h3>
						</div>
						<div class="card-body">
							<p class="text-center">
								<i class="fas fa-database card-icon"></i>
							</p>
							<p class="py-3 text-center">With a true single database, information is
								entered once. And only once.</p>
							<button class="btn btn-lg btn-success w-100" type="button">Learn
								More</button>
						</div>
					</div>
				</div>
			</div>
		</section>

		<footer>
			<div class="container-fluid">
				<i class="social-icon fab fa-facebook-f"></i> <i
					class="social-icon fab fa-twitter"></i> <i
					class="social-icon fab fa-instagram"></i> <i
					class="social-icon fas fa-envelope"></i>
				<p>© Copyright 2021 WorkBright</p>
			</div>
		</footer>
	</section>
</body>
</html>