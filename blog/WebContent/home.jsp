<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">


<title>blogging site</title>
</head>

<style>
.search{
	padding-right: 50px;
}

.active-pink-4 input[type=text]:focus:not ([readonly] ) {
	border: 1px solid #f48fb1;
	box-shadow: 0 0 0 1px #f48fb1;
}

.active-pink-3 input[type=text] {
width: 200px;
	height: 40px;
	border: 1px solid #ff0000;
	box-shadow: 0 0 0 1px #f48fb1;
}
</style>

<body>

	<%
		String user = (String) session.getAttribute("user");
		session.setAttribute("user", user);
	%>

	<div
		class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom shadow-sm">
		<h5 class="my-0 mr-md-auto font-weight-normal">

			<%
				if (user != null) {
			%>
			<p m-auto>
				Hello
				<%=user%>
				!!!
			</p>
			<%
				} else {
			%>

			<p m-auto>Please Sign in !!!</p>

			<%
				}
			%>

		</h5>

		<nav class="my-2 md-0 mr-md-3">


			<%
				if (user != null) {
			%>

			<form class="search d-inline-block" action="http://localhost:8080/site.blog/search" method="post">
				<div class="active-pink-3 active-pink-4 mb-4 ">
					<input class="form-control" type="text" placeholder="Search" name="search">
				</div>
			</form>

			<a class="p-2 text-dark" href="http://localhost:8080/site.blog/logout.jsp"> Logout </a>

			<%
				} else {
			%>

			<a class="p-2 text-dark"
				href="http://localhost:8080/site.blog/home.jsp"> Home </a> <a
				class="p-2 text-dark"
				href="http://localhost:8080/site.blog/register.jsp"> Register </a> <a
				class="p-2 text-dark"
				href="http://localhost:8080/site.blog/login.jsp"> Login </a>

			<%
				}
			%>

		</nav>
	</div>


</body>
</html>