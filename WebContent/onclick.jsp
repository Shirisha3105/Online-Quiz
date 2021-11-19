<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body><p>djhfgg</p>
<a href="InsertFail.jsp" onclick="myfunction()">go</a>
<script>
function myfunction()
{
	<%	
	  String k="10";
	  session.setAttribute("username", k);%>
}

</script>

</body>
</html>