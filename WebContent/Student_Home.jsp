<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
#logOut
{
margin-left:85%;
margin-top:-8%;
}
img{
margin-left:4%;
margin-top:2%;
margin-bottom:3%;
}
#top
{
width:100%;
height:20%;
display: inline-block;
vertical-align: top;
border-width: 1px;
border-bottom-style:inset;
background-color:#E6E8E8
}
input[type = submit]
{
  height:40px;
  width:100px;
  border-radius :30px;
  border-color:black;
  border-width:thin;
}
input[type=submit]:hover
{
background-color:black;
color:white;
position:relative;
cursor: pointer;
}


#main
{
width:100%;
height:100%;
position: relative;

}
#cp
{
margin-left:70%;
margin-top:-5%;
}
p{
color:balck;
}
#external
{
font-size:18px;
font-family:Arial black;
font-weight:bold;
font-color:#138B8C;

}
table
{

background-collapse:collapse;
width:50%;  
margin-left:30%;      
}

table tr,td{
align:center;
color:#138B8C;

}
td
{

height:80px;
width:100px;
margin-left:10px;
}
body{
background-color:#E6E8E8;
}
h1,h3
{
color:#138B8C;
}
#jj
{
height:25px;
  width:100px;

}
h4
{
margin-top:-2.5%;
margin-left:18%;
}

</style>
</head>
<body  >
<%String email=request.getParameter("name"); 
   session.setAttribute("email",email);
  // String uname=String.valueOf(session.getAttribute("uname"));%>
<div id="main">
<div id="top">
<img src="studentlogo.png" width="20%" height="80%">
<h4>
<%
out.println(session.getAttribute("uname"));
String userName=String.valueOf(session.getAttribute("uname"));
session.setAttribute("username",  userName);
%>
</h4>
<!-- change Password -->
<p id="cp"><a  href="PasswordChange.jsp?name=" >change password</a></p>

<div id="logOut">
<!-- Navigate to Login page -->
<a href="LandingPage.jsp"><img src="logout.png" width="35%" height="28%"></a>
</div>
</div>
<center>
<h1> TOPICS AVAILABLE FOR QUIZ</h1>
</center>
<div id="external">
<form action="TestController" method="get">
<table>
<tr><td>Aptitude:</td>
<!-- Tests -->
<td><input type="submit" name="aptitude" value="taketest1" ></td></tr>
<tr><td>C:</td>
<td><input type="submit" name="aptitude" value="taketest2"></td></tr>
<tr><td>Java:</td>
<td><input type="submit" name="aptitude" value="taketest3"></td></tr>
</table>

</div>
<center>
</form>
<form action="TestController" method="post">
<h3> for your history click  <input id="jj" type="submit" name="aptitude" value="here" ></h3>
</form>
</div>
</center>
</body>
</html>