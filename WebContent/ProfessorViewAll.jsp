<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.oqm.bean.QuestionBean"%>
    <%@page import="java.util.*"%>
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
session.getAttribute("username");
String userName=request.getParameter("name");
session.setAttribute("username",userName);
%>
</h4>
<p id="cp"><a  href="PasswordChange.jsp" >change password</a></p>
</div>
<div id="logOut">
<a href="LandingPage.jsp"><img src="logout.png" width="35%" height="28%"></a>
</div>

<div id="bottom">
<div id="leftBottom">
<form action="QuestionController?questionButton=Aptitude" method="get">
<input type="submit" name="questionButton" value=<%out.println(session.getAttribute("topic")); %> style="margin-top:10%"><br>
<a style="margin-left:90px; margin-top:5px;"href="AddQuestion.jsp">Add question</a>
</form>
</div>
<div id="rightBottom">
<br>

<%
ArrayList<QuestionBean> empList=(ArrayList<QuestionBean>)request.getAttribute("qusList");
System.out.println(empList);
session.setAttribute("total_questions",empList.size());

Iterator<QuestionBean> iterator =empList.iterator();
int questionNo=0;
String qus="";
while(iterator.hasNext())
{
	
	++questionNo;
	qus=String.valueOf(questionNo);
	QuestionBean temp=iterator.next();
	session.setAttribute("selectedTopic",temp.getTopic());
	
	%><form action="EditQuestion.jsp" method="post">
<table>	<tr>
							
								<td>&nbsp<%out.print(questionNo); %>)<%=temp.getQuestion()%></td></tr>
								
								<tr><td>&nbsp&nbsp1&nbsp:&nbsp<%=temp.getOption1()%></td></tr>
								
								<tr><td>&nbsp&nbsp2&nbsp:&nbsp<%=temp.getOption2()%></td></tr>
								
								<tr><td>&nbsp&nbsp3&nbsp:&nbsp<%=temp.getOption3()%></td></tr>
								
								<tr><td>&nbsp&nbsp4&nbsp:&nbsp<%=temp.getOption4()%></td></tr>
								
								<tr><td>&nbsp&nbspanswer&nbsp:&nbsp<%=temp.getAnswer()%></td></tr>
	
	<input type="hidden" name="question" value= "<%=temp.getQuestion()%>" >
	<input type="hidden" name="option1" value= "<%=temp.getOption1()%>" >
	<input type="hidden" name="option2" value= "<%=temp.getOption2()%>" >
	<input type="hidden" name="option3" value= "<%=temp.getOption3()%>" >
	<input type="hidden" name="option4" value= "<%=temp.getOption4()%>" >
	<input type="hidden" name="answer" value= "<%=temp.getAnswer()%>" >
	<input type="hidden" name="topic" value= "<%=temp.getTopic()%>" >
	<tr><td>&nbsp<button  type="submit" name="oqaButton" value="CEdit">edit</button></td></tr>
	</form>
<%}
String email=(String)session.getAttribute("email");
System.out.println("email in viewall is"+email);
%>    


</table>
</div>
</div>
</div>
</body>
</html>