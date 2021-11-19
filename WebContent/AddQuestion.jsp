<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AddQuestion</title>
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
input[type=text]
{
width:180px;
height:30px;
}
</style>
</head>
<body>
<div id="main">
<div id="top">
<img src="user.jpg" width="10%" height="70%">
<h4>
<%
request.getParameter("name");
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
<br>
<input type="submit" name="questionButton" value=
<%
out.println(session.getAttribute("topic"));
%>><br>
</form>
</div>
<div id="rightBottom">
<br>
<center>
<p style="font-size:28px;">
Add question to&nbsp
<%
out.println(session.getAttribute("topic"));
%>
</p>
</center>
<form action="QuestionController" method="post">

<!-- Questions Field -->
<table align="center">
<tr><td>Question&nbsp</td><td><input type="text" name="question"oninvalid="this.setCustomValidity('Please Enter question')" oninput="setCustomValidity('')"  required style="width: 400px; height:50px;"></td></tr>
<tr><td>option1</td><td><input type="text" name="option1" oninvalid="this.setCustomValidity('Please Enter option1')" oninput="setCustomValidity('')" required></td></tr>
<tr><td>option2</td><td><input type="text" name="option2" oninvalid="this.setCustomValidity('Please Enter option2')" oninput="setCustomValidity('')"required></td></tr>
<tr><td>option3</td><td><input type="text" name="option3" oninvalid="this.setCustomValidity('Please Enter option3')" oninput="setCustomValidity('')" required></td></tr>
<tr><td>option4</td><td><input type="text" name="option4" oninvalid="this.setCustomValidity('Please Enter option4')" oninput="setCustomValidity('')" required></td></tr>
<tr><td>answer</td><td><input type="text" name="answer" pattern="^[1-4]{1}"  oninvalid="this.setCustomValidity('Please Enter correct option')" oninput="setCustomValidity('')" required></td></tr>

<tr><td></td><td><input type="submit" style="width:130px; height:30px;" name="questionButton" value="Add"></td></tr>
</table>
</form>
</div>
</div>
</div>
</body>
</html>