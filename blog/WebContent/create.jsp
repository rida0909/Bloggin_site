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
  width: 50%;
  height: 70%;
  position: relative;
  transition: all 5s ease-in-out;
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
  height: 50%;
  width: 50%
  overflow: auto;
}

@media screen and (max-width: 1000px){
  .box{
    width: 90%;
  }
  .popup{
    width: 90%;
  }
}
</style>
<body>
<% String user = (String)session.getAttribute("user");
session.setAttribute("user", user);
%>

<div id="popup1" class="overlay">
	<div class="popup">
		<a class="close" href="http://localhost:8080/site.blog/mainPage.jsp">&times;</a>
		<div class="content">
			<form action = "http://localhost:8080/site.blog/createBlog" method= "post">
 
<label style = "margin-top: 30px; margin-bottom: 20px; margin-left: 50px; font-size: 30px;"> Content: </label><br />
<textarea class = "text-box" style = "margin-left: 10%; width: 600px; height: 350px;" name = "content" placeholder = "Write your post...."></textarea> <br />

<button class = "btn btn-lg btn-primary " style = "width: 300px; margin-left: 250px; margin-top: 100px;" type = "submit">Create Post</button>

</form>
		</div>
	</div>
</div>


</body>
</html>