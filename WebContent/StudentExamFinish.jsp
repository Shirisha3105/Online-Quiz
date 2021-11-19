<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@page import="com.oqm.bean.HistoryBean"%>
    <%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<style>
#main
{
width:100%;
height:100%;
position: absolute;

}
#top
{
width:100%;
height:20%;
display: inline-block;
vertical-align: top;
border-width: 1px;
border-bottom-style:inset;
background-color:#E6E8E8;
}
#bottom
{
margin-top:1%;
border-width: 1px;
border-top-style:inset;
height:79%;
width:100%;
display: inline-block;
vertical-align: bottom;
background-color:#E6E8E8;

}
img{
margin-left:5%;
margin-top:2%;
}
h4
{
margin-top:-3.5%;
margin-left:18%;
}
#cp
{
margin-left:70%;
margin-top:-5%;
}
p{
color:balck;
}
a{
text-decoration:none;

}
#logOut
{
margin-left:85%;
margin-top:-8%;
}



</style>
</head>
<body>
<div id="main">
<div id="top">
<img src="user.jpg" width="10%" height="70%">
<h4>
<%
out.println(session.getAttribute("uname"));
String userName=String.valueOf(session.getAttribute("uname"));
session.setAttribute("username",  userName);
%>
</h4>
</div>
<div id="logOut">
<!-- Navigate to Login Page -->
<a href="LandingPage.jsp"><img src="logout.png" width="35%" height="28%"></a>
</div>
<h1>your score is:
<%out.print(request.getParameter("name")); %>
in&nbsp
<%
out.println(session.getAttribute("topic"));
%></h1>
<!-- Navigate to student Home page -->
<P>Click here to go to <a href="Student_Home.jsp">Home page </a></P>
</body>
</html>