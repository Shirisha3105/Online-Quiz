<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@page import="com.oqm.bean.TestBean"%>
    <%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
TestBean temp=(TestBean)request.getAttribute("next");
%>
<!-- Options for the Questions -->
<form action="TestController" method="get">
<input type="radio" value="1"  name="option"><% out.println(temp.getOption1());%></input><br>
<input type="radio" value="2"  name="option"><% out.println(temp.getOption2());%></input><br>
<input type="radio" value="3"  name="option"><% out.println(temp.getOption3());%></input><br>
<input type="radio" value="4"  name="option"><% out.println(temp.getOption4());%></input><br>
<!-- Submission -->
<input type="submit" name="ans" value="next"><br>

</form>
</body>
</html>