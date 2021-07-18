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
<title>Insert title here</title>
</head>

<body>
<jsp:include page = "home.jsp" />

<% String user = (String)request.getParameter("user");
	request.setAttribute("usernmae",user);
	System.out.println(user);
%>

<div class = "container pt-5 m-auto">
<div class = "row"> 

<div class = "col text-right"> 
<form action = "login.jsp"> 
<button class = "btn btn-lg btn-primary " type = "submit" > Followers </button>
</form>
</div>

<div class = "col text-left">
<form action = "register.jsp"> 
<button class = "btn btn-lg btn-primary " type = "submit"> Followings </button>
</form>
</div>

</div>

<div class = "col-md-12 text-center pt-5">
<form action = "create.jsp"> 
<button class = "btn btn-lg btn-primary " type = "submit"> Create Post </button>
</form>
</div>

</div>

</body>
</html>
