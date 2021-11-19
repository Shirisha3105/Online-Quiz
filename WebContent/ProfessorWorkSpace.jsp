<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ProfessorHome</title>
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
#leftBottom
{
height:100%;
width:20%;
background-color:#D1E8D8;
display:inline-block;
    float: left;
}
#rightBottom
{
height:100%;
width:80%;

display:inline-block;
float: right;
}
input[type=submit]
{
width:100%;
height:40px;
}
</style>
</head>
<body>
<div id="main">
<div id="top">
<img src="user.jpg" width="10%" height="70%">
<h4>
<%
out.println(request.getParameter("name"));
String userName=request.getParameter("name");
session.setAttribute("username",  userName);
%>
</h4>
<p id="cp"><a  href="PasswordChange.jsp?name="<%=userName%> >change password</a></p>
</div>
<div id="logOut">
<a href="LandingPage.jsp"><img src="logout.png" width="35%" height="28%"></a>
</div>

<div id="bottom">
<div id="leftBottom">
<form action="QuestionController" method="post">
<input type="submit" name="questionButton" value="Apptitude" style="margin-top:10%"><br>
<input type="submit" name="questionButton" value="C"><br>
<input type="submit" name="questionButton" value="JAVA">
</form>
</div>
<div id="rightBottom">

</div>
</div>
</div>
</body>
</html>