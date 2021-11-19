<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.oqm.bean.QuestionBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EditQuestion</title>
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
session.getAttribute("username");
String userName=request.getParameter("name");
session.setAttribute("username",  userName);
%>
</h4>
<!-- Change Password -->
<p id="cp"><a  href="PasswordChange.jsp">change password</a></p>
</div>
<div id="logOut">
<!-- Navigate to Login Page -->
<a href="LandingPage.jsp"><img src="logout.png" width="35%" height="28%"></a>
</div>

<div id="bottom">
<div id="leftBottom">
<form action="QuestionController" method="get">
<br>
<input type="submit" name="questionButton" value=
<%
out.println(session.getAttribute("selectedTopic"));
%>><br>
</form>
</div>
<div id="rightBottom">
<br>
<br>

<%

String question=request.getParameter("question");
String option1=request.getParameter("option1");
String option2=request.getParameter("option2");
String option3=request.getParameter("option3");
String option4=request.getParameter("option4");
String answer=request.getParameter("answer");
String oldquestion=request.getParameter("question");
String topic=request.getParameter("topic");
%>
<!-- Edit Questions Field -->
<table align="center">
<form action="QuestionController" method="post">
<tr><td>Question</td><td><input type="text" name="question" style="width: 400px; height:50px;"  value="<%=question%>" oninvalid="this.setCustomValidity('Please Enter question')" oninput="setCustomValidity('')"required></td></tr>
<tr><td>option1</td><td><input type="text" name="option1" value="<%=option1%>" oninvalid="this.setCustomValidity('Please Enter option1')" oninput="setCustomValidity('')"required></td></tr>
<tr><td>option2</td><td><input type="text" name="option2" value="<%=option2%>" oninvalid="this.setCustomValidity('Please Enter option2')" oninput="setCustomValidity('')" required></td></tr>
<tr><td>option3</td><td><input type="text" name="option3" value="<%=option3%>" oninvalid="this.setCustomValidity('Please Enter option3')" oninput="setCustomValidity('')" required></td></tr>
<tr><td>option4</td><td><input type="text" name="option4" value="<%=option4%>" oninvalid="this.setCustomValidity('Please Enter option4')" oninput="setCustomValidity('')"required></td></tr>
<tr><td>answer</td><td><input type="text" name="answer" value="<%=answer%>" oninvalid="this.setCustomValidity('Please Enter correct option')" oninput="setCustomValidity('')"required></td></tr>
<tr><td></td><td><input type="hidden" name="oldqus" value="<%=oldquestion%>"></td></tr>
<tr><td></td><td><input type="hidden" name="topic" value="<%=topic%>"></td></tr>
<input type="hidden" name="oldqus" value="<%=oldquestion%>"></td></tr>
<tr><td></td><td><input type="submit" style="width:70px; height:30px;" name="questionButton" value="Update">
<tr><td></td><td><input type="submit" style="width:70px; height:30px;" name="questionButton" value="Delete">
</form>
</table>
</div>
</div>
</div>
</body>
</html>