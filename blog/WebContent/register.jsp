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
<title>register</title>
</head>
<style>
.form-register {
        width: 100%;
        max-width: 330px;
        padding: 15px;
        padding-top: 100px;
        margin: auto;
    }
    .form-register .form-control {
        position: relative;
        box-sizing: border-box;
        height: auto;
        padding: 10px;
        font-size: 16px;
    }
    .form-register .form-control:focus {
        z-index: 2;
    }
    .form-register input {
        margin-bottom: 10px;
        border-bottom-right-radius: 0;
        border-bottom-left-radius: 0;
    }
</style>
<body>
 <jsp:include page = "home.jsp" />  
<form class = "form-register" action = "http://localhost:8080/site.blog/registeracc" method = "post">
	<h1 class = "h3 mb-3 font-weight-normal"> Register</h1>
			<input type = "email" name = "email" class="form-control" placeholder = "Enter Email Address">
			<input type = "text" name = "username" class="form-control" placeholder = "Enter Username">
			<input type = "password" name = "password1" class="form-control" placeholder = "Enter Password">
			<input type = "password" name = "password2" class="form-control" placeholder = "Re-Enter Password"> <br />
			
		<%	String error = (String)request.getAttribute("notmatch"); %>
		<% if (error != null){ %>
		
		<p style = "color:red"> <%= error %></p> 
			
		<% } %> 
		
	<button class = "btn btn-lg btn-primary btn-block" type = "submit">Register</button>
		
</form>

</body>
</html>