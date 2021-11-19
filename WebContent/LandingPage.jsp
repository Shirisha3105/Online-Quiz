<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" href="LandingStyle.css">
</head>
<body bgcolor="white">
<div id="bodyDiv" >

<div id="externalDiv">
<h1>Login</h1>
<form action="OqmController" method="post">

<div  id="internalDiv">
<!-- Login Fields -->
<table >
<tr><td id="texts">Email:</td></tr><tr><td><input type="email" name="email"></td></tr>
<tr><td id="texts">password:</td></tr><tr><td><input type="password" name="password"></td></tr>
</table><br>
<table>
<tr><td><input type="submit" name="Insert" value="Log in"></td></tr>
</table>
</div>
</form>
<br>
<!-- forgot Password & New signup fields -->
<P>New user? <a href="Registration.jsp">signup </a>here</P>
<P>Forgot password? <a href="ForgotPassword.jsp">click </a>here</P>
</div>
</div>
</body>
</html>