<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form class = "form-signin" action = "http://localhost:8080/site.blog/loginacc" method = "post">
	<h1 class = "h3 mb-3 font-weight-normal"> Login</h1>
			<input type = "email" name = "enter_email" class="form-control" placeholder = "Enter Email Address">
			<input type = "text" name = "enter_username" class="form-control" placeholder = "Enter Username">
			<input type = "password" name = "enter_password" class="form-control" placeholder = "Enter Password"> <br />
			
		<% String error = (String)request.getAttribute("error");
		if(error != null){
		%>
		<p style = "color:red"> <%= error %> </p>
		<% } %>
		
	<button class = "btn btn-lg btn-primary btn-block" type = "submit">Sign In</button>
	
	<a style = "color:blue; size:small; padding-top: 15px;" href = "http://localhost:8080/site.blog/pwdchange.jsp"> Change Password </a>
		
</form>
</body>
</html>