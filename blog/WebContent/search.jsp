<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.ArrayList"%>
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
<style>

body{
background : url(https://images.assetsdelivery.com/compings_v2/vladimirgolovanov/vladimirgolovanov1912/vladimirgolovanov191200048.jpg);
}

.overlay {
  position: fixed;
  top: 0;
  bottom: 0;
  left: 0;
  right: 0;
  background: rgba(0, 0, 0, 0.7);
  transition: opacity 500ms;
  visibility: visible;
  opacity: 1;
}
.overlay:target {
  visibility: visible;
  opacity: 0;
}

.popup {
  margin: 70px auto;
  padding: 20px;
  background: #fff;
  border-radius: 5px;
  width: 30%;
  position: relative;
  transition: all 5s ease-in-out;
}

.popup h2 {
  margin-top: 0;
  color: #333;
  font-family: Tahoma, Arial, sans-serif;
}
.popup .close {
  position: absolute;
  top: 20px;
  right: 30px;
  transition: all 200ms;
  font-size: 30px;
  font-weight: bold;
  text-decoration: none;
  color: #333;
}
.popup .close:hover {
  color: #007bff;
}
.popup .content {
  max-height: 30%;
  overflow: auto;
}

@media screen and (max-width: 700px){
  .box{
    width: 70%;
  }
  .popup{
    width: 70%;
  }
}
</style>

</body>
<% ArrayList<String> result = (ArrayList<String>)session.getAttribute("users"); 
String action = (String)session.getAttribute("act");
String us = (String)session.getAttribute("us");
session.setAttribute("us", us);
session.setAttribute("act", action);
%>

<div id="popup1" class="overlay">
	<div class="popup">
		<h2 class="py-2">Search Result:</h2> <hr />
		<a class="close" href="http://localhost:8080/site.blog/mainPage.jsp">&times;</a>
		<div class="content">
			<% int i ;
				for(i = 0; i < result.size(); i++){ %>
				<form action = "http://localhost:8080/site.blog/req_follow">
	<p>
	<div class = "row">
	<div class = "col-8">
					<h3 style="display: inline-block; margin-right: 250px; margin-left: 10px;"> <%= result.get(i) %></h3> 
					</div>
					<div class = "col-4">
					<% session.setAttribute("search", result.get(i));
					%>
					<% if (action.contentEquals("follow")){ 
					%>
					<button class = "btn btn-lg btn-primary" type="submit" ><%= action %> </button>
					<% } else{ %>
					<button class = "btn btn-lg btn-primary" style = "background-color: red;"type="submit" ><%= action %> </button>
					<% } %>
					</div>
	</div>
	</p>
	</form>
				<% } %>
		</div>
	</div>
</div>
</html>