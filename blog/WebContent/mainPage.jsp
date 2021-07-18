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
.left-box{
text-align: center;
padding-top: 30%;
}
.profile{
background: #ff0000;
color: #fff;
padding: 30px 60px;
border-radius: 50%;
font-size: 70px;
}
.dp{
background: #ff0000;
color: #fff;
padding: 10px 18px;
border-radius: 50%;
font-size: 15px;
margin-right: 10px;
display: inline-block;
}


</style>

<body>
 <jsp:include page = "home.jsp" /> 
 
 <% String user = (String)session.getAttribute("us");
 session.setAttribute("user", user);
 
 String dp = user.substring(0,1).toUpperCase();
 %>
 
 <div class = "row mx-3">
 
 <div class = "col-sm-3 border">
 <div class = "left-box mx-2">
 
 <span class = "profile"> <%= dp.charAt(0) %></span>

 <h1 style = "margin-top: 15%;"> <%= user %> </h1><hr />
 
<form action = "http://localhost:8080/site.blog/follower"> 
<button class = "btn btn-lg btn-primary mt-4 " type = "submit" > Followers </button>
</form>

<form action = "http://localhost:8080/site.blog/follow"> 
<button class = "btn btn-lg btn-primary my-4" type = "submit"> Followings </button>
</form><hr />
<form action = "create.jsp"> 
<button class = "btn btn-lg btn-primary mt-4" type = "submit"> Create Post </button>
</form>
 
 </div> 
 </div>
 
 <div class = "col-sm-6 ">
 


<% ArrayList<String> username = (ArrayList<String>)session.getAttribute("un"); 
ArrayList<String> blogpost = (ArrayList<String>)session.getAttribute("bp");
ArrayList<String> posted = (ArrayList<String>)session.getAttribute("pdate");
int i;
for(i = blogpost.size() - 1; i >=0 ; i--){ %> 

<div class = "card mb-4">

<div class = "card-body ml-5 ">

<%  String dp2 = username.get(i).substring(0,1).toUpperCase(); %>
<span class = "dp"> <%= dp2.charAt(0) %></span>
<h2 class = "card-title" style = "display: inline-block; vertical-align: middle;"><%= username.get(i) %></h2>

<p class = "card-text pt-1 mx-1 "> <% out.println(blogpost.get(i)); %> 


</p></div>

<div class = "card-footer text-muted mx-3 mb-2 py-2 text-right text-top" style = "font-size: 10px; text-align: top;">
Posted on <%= posted.get(i) %>
</div>
</div>
<%	 } %>



</div>

<div class = "col-sm-3 border ">

<div class = "right-box pt-3">

<h2 style = "text-align: center; padding-bottom: 20px"> Your Posts</h2>



<%
ArrayList<String> myPost = (ArrayList<String>)session.getAttribute("myPost");
ArrayList<String> myDate = (ArrayList<String>)session.getAttribute("myDate");
ArrayList<String> myId =  (ArrayList<String>)session.getAttribute("myId");
int j;
for(j = myPost.size() - 1; j >= 0 ; j--){ %> 

<div class = "card mb-3">

<div class = "card-body pb-1">

<p class = "card-text pt-1 mx-3"> <% out.println(myPost.get(j)); %> <br />
</p>

<% 
String post = myPost.get(j);
String id = myId.get(j);
String date = myDate.get(j);
%>

<a style = "color:blue; size:small; padding-top: 1%; padding-left: 80%; " href = "http://localhost:8080/site.blog/update.jsp?post=<%=post %>&&id=<%=id %>&&date=<%=date %>" >
 Update </a>

</div>

<div class = "card-footer text-muted mx-3 mb-2 py-2 text-right text-top" style = "font-size: 10px;" >
Posted on <%= myDate.get(j) %>
</div>
</div>
<% } %>




</div>
</div>

</div>

</body>
</html>