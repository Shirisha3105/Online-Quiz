<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
<style>
div
{
 width :500px;
 margin:auto; 
 height : 530px;
 text-align :left;
background :white;
font-size:20px;
color : black;
border : 1px solid#eee;
border-radius :10px;
text-shadow :none;

}
input[type = text]{
width :80%;
height : 30px;
padding : 5px 10px;
margin :8px 0;
display : inline-block;
border:1px solid #ccc;
border-radius :4px;

box-sizing: border-box;
}
input[type = number]{
width :80%;
height : 30px;
padding : 5px 10px;
margin :8px 0;
display : inline-block;
border:1px solid #ccc;
border-radius :4px;
box-sizing: border-box;
}
input[type = email]{
width :80%;
height : 30px;
padding : 5px 10px;
margin :8px 0;
display : inline;
border:1px solid #ccc;
border-radius :4px;
box-sizing: border-box;
}
input[type = password]{
width :80%;
height : 30px;
padding : 5px 10px;
margin :8px 0;
display : inline-block;
border:1px solid #ccc;
border-radius :4px;
box-sizing: border-box;
}

input[type=reset],input[type=submit]{
width :20%;
background-color :green;
color :white;
padding :10px 10px;
margin :8px 0;
border :1px solid;
border-radius:4px;
cursor:pointer;
}
p
{
margin-top:0%;
font-size:14px;
font-family:verdana;
}
a{
font-style:italic;
text-decoration:none;
}
</style>
<script type="text/javascript">  
function matchpass(){  
var firstpassword=document.f1.password.value;  
var secondpassword=document.f1.cpassword.value;  
  
if(firstpassword==secondpassword){  
return true;  
}  
else{  
alert("password must be same!");  
return false;  
}  
}  
</script>  

</head>
<body bgcolor=lightblue>
<div>
<center>
<br>
<b><h2>REGISTER</h2></b>

<form name=f1 action="OqmController" method="post" onsubmit="return matchpass();">

<table>
<tr><td>Name</td><td><input type="text" name="name" required></td></tr>

<tr><td>Email<sup>*</sup></td><td><input type="email" name="email" required></td></tr>

<tr><td>Password<sup>*</sup></td><td><input type="password" name="password" required></td></tr>

<tr><td>Confirm Password<sup>*</sup>&nbsp</td><td><input type="password" name="cpassword" required></td></tr>

<tr><td>Mobile Number</td><td><input type="number" name="mobileno"></td></tr>

<tr><td>Designation</td><td><input type="radio"  name="designation" value="professor">professor
<input type="radio" value="student" checked="checked" name="designation">Student</td></tr>

</table>

<br>

<input type="submit" value="Register" name="Insert">&nbsp&nbsp
<input type="reset" value="Reset">

</form>
<p>Already a user <a href="LandingPage.jsp"> signin </a>here</p>

<p style="color:red">Email already registered...</p>
</center>
</div>
</body>
</html>