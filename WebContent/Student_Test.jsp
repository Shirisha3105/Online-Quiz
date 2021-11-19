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
<body bgcolor=#C8ECF5> 

<%
ArrayList<TestBean> empList=(ArrayList<TestBean>)request.getAttribute("qusList");
Iterator<TestBean> iterator =empList.iterator();
int count=1;
session.setAttribute("size",empList.size());

%>
<!-- Options for the Questions -->
<form action="TestController?num=empList.size()" method="post">
<%
while(iterator.hasNext())
{
	TestBean temp=iterator.next();
	String option1=String.valueOf(count);
	out.println("<br>"+count+")"+" "+temp.getQuestion()+"<br>");
	out.println("<input type='hidden' value='"+temp.getQuestion()+"' name='Ques"+count+"'/>");
	out.println("<input type='radio' value='1' name='"+option1+"'>"+" "+temp.getOption1()+"<br>");
	out.println("<input type='radio' value='2' name='"+option1+"'>"+" "+temp.getOption2()+"<br>");
	out.println("<input type='radio' value='3' name='"+option1+"'>"+" "+temp.getOption3()+"<br>");
	out.println("<input type='radio' value='4' name='"+option1+"'>"+" "+temp.getOption4()+"<br>");
	count++;
}
String email=(String)session.getAttribute("email");
%>
<br>
<!-- submission-->
<button type="submit" name="aptitude" value="ans" onclick="return confirmation(this);">Submit</button>
</form>
</body>
</html>