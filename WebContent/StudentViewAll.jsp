<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.oqm.bean.QuestionBean"%>
    <%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!-- Question Buttons -->
<form action="QuestionController?questionButton=Aptitude" method="get">
<input type="submit" name="questionButton" value="Aptitude" style="margin-top:10%"><br>
<a style="margin-left:90px; margin-top:5px;"href="AddQuestion.jsp">Add question</a>
</form>
</div>
<div id="rightBottom">
<br>
<%
ArrayList<QuestionBean> empList=(ArrayList<QuestionBean>)request.getAttribute("qusList");
System.out.println(empList);
Iterator<QuestionBean> iterator =empList.iterator();
int questionNo=0;
while(iterator.hasNext())
{
	
	++questionNo;
	QuestionBean temp=iterator.next();
	ArrayList<QuestionBean> editList=new ArrayList<QuestionBean>();
	QuestionBean edit=new QuestionBean();
	//edit.setQuestionNo(questionNo);
	//Getting the values
	edit.setTopic("temp.getTopic()");
	edit.setQuestion("temp.getQuestion()");
	edit.setOption1("temp.getOption1()");
	edit.setOption2("temp.getOption2()");
	edit.setOption3("temp.getOption3()");
	edit.setOption4("temp.getOption4()");
	edit.setAnswer("temp.getAnswer()");
	editList.add(edit);
	//Edit Question
      out.println("&nbsp"+temp.getQuestion()+"&nbsp<a href=EditQuestion.jsp>edit</a><br>&nbsp&nbsp 1." + temp.getOption1()+"<br>&nbsp&nbsp 2."+ temp.getOption2() +"<br>&nbsp&nbsp 3." + temp.getOption3()+"<br>&nbsp&nbsp 4." +temp.getOption4()+"<br>&nbsp&nbsp Ans:" +temp.getAnswer());
}
%>

</body>
</html>