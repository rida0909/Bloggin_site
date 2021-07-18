<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="ISO-8859-1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
<title>Insert title here</title>
</head>

<style>
.form-signin {
        width: 100%;
        max-width: 330px;
        padding: 15px;
        padding-top: 100px;
        margin: auto;
    }
    .form-signin .form-control {
        position: relative;
        box-sizing: border-box;
        height: auto;
        padding: 10px;
        font-size: 16px;
    }
    .form-signin .form-control:focus {
        z-index: 2;
    }
    .form-signin input {
        margin-bottom: 10px;
        border-bottom-right-radius: 0;
        border-bottom-left-radius: 0;
    }
</style>

<body>
<form class = "form-signin" action = "http://localhost:8080/site.blog/changepassword" method = "post">
	<h1 class = "h3 mb-3 font-weight-normal"> Update Password</h1>
			<input type = "text" name = "username" class="form-control" placeholder = "Enter Username">
			<input type = "password" name = "passwordold" class="form-control" placeholder = "Enter Current Password">
			<input type = "password" name = "password1" class="form-control" placeholder = "Enter Password">
			<input type = "password" name = "password2" class="form-control" placeholder = "re-Enter Password"> <br />
			
			<%	String error = (String)request.getAttribute("notmatch"); %>
		<% if (error != null){ %>
		
		<p style = "color:red"> <%= error %></p> 
			
		<% } %> 
			
			<button class = "btn btn-lg btn-primary btn-block" type = "submit">Update</button>
</body>
</html>