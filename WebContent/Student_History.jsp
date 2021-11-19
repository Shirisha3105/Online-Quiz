<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.oqm.bean.HistoryBean"%>
<%@page import="java.util.*"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>History</title>

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
#newdiv{
padding:25px;
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
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {
  background-color: #dddddd;
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
<!-- Navigate to Login page -->
<a href="LandingPage.jsp"><img src="logout.png" width="35%" height="28%"></a>
</div>
<center>
<div id=newdiv>
<h2>History</h2>
<form action="TestController" method="post">
<table >
<tr><th>Topic</th><th>Date</th><th>Score</th></tr>

<%
ArrayList<HistoryBean> historylist=new ArrayList<HistoryBean>();
historylist=(ArrayList<HistoryBean>)request.getAttribute("testlist");
Iterator<HistoryBean> iterator=historylist.iterator();
while(iterator.hasNext())
{
	HistoryBean temp=iterator.next();
%>
<tr><td><%out.println(temp.getTopic()); %></td>
<td><%out.println(temp.getDate()); %></td>
<td><%out.println(temp.getScore()); %></td>
</tr>
<%} %>
</table>
<div id="newdiv">
<!-- Navigate to student home page -->
<P>Click here to go to <a href="Student_Home.jsp">Home page </a></P>
</div>
</form>
</div>
</center>
</div>
</body>
</html>