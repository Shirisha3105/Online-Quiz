<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<style>
#main
{
width:100%;
height:100%;
position: relative;

}
#top
{
width:100%;
height:18%;
display: inline-block;
vertical-align: top;
border-width: 1px;
border-bottom-style:inset;
background-color:#E6E8E8
}
#bottom
{
height:82%;
width:100%;
display: inline-block;
  vertical-align:bottom;
}
img{
margin-left:5%;
margin-top:2%;
margin-bottom:2%;
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
margin-top:-9.5%;
}
.top{
 width :700px ;
 margin:auto; 
 border : 300px;
 text-align : right;
}
<!--.form-submit99{
background-color:gray;
border :none ;
color: white;
padding :15px 32px;
text-align : center;
text-decoration :none;
display:inline-block;
font-size:32px;
font-color:black;
margin : 4px 2px;
 
cursor :pointer;
}-->
.form-submit{
background :#F0EDEB;
font-size:20px;
width :70%;
height :20%;
color : black;
border : 1px solid#eee;
border-radius :10px;
box-shadow : 5px 5px 5px #eee;
text-shadow :none;
font-family :"";
}
input[type = password]{
height: 10%;
padding : 12px 20px;
margin :8px 0;
display : inline-block;
border:1px solid #ccc;
border-radius :4px;
box-sizing: border-box;

}
input[type=submit],input[type=reset]{

background-color : #4CAF50;
color :white;
padding :14px 20px;
margin :8px 0;
border :1px solid;
border-radius:4px;
cursor:pointer;
}
::placeholder{
color :gray;
}
body
{
background-repeat:no-repeat;

}
td{
color:skyblue;
}
</style>
</head>
<body>
<div id="main">
<div id="top">
<img src="user.jpg" width="10%" height="60%">
<h4>
<%
request.getParameter("userName");
%>
</h4>
</div>
<div id="logOut">
<a href="LandingPage.jsp"><img src="logout.png" width="45%" height="32%"></a>
</div>

<div name="content" id="bottom">
<div>
<br>
<br>
<center>
   <form action ="OqmController"  method="post" class = "form-submit">
<table width=100%>
<br>
    
   <!-- <caption>CHANGE YOUR PASSWORD HERE</caption> --> 
    
 
    <tr>
 <td align="right"><label><b>Current Password</style> </b></label>: </td><td><input type = "password" placeholder = "Current password" name = "currentpassword"></td>
   </tr><tr>     
 <td  align="right"> <label> <b> New Password</b> </label>   : </td> <td> <input type = "password" placeholder = "New password"name = "newpassword" place> </td>
       </tr><tr>
 <td  align="right"> <label><b>Confirm Password </b></label> :</td> <td> <input type = "password"placeholder = "Confirm password" name = "confirmpassword"> </td>
</tr>

<tr><td></td>
<td align="left">
<!-- Reset Password -->
<input type ="submit" value = "submit" name = "Insert">&nbsp<input type ="reset" value = "Reset" name = "reset"> </td>
 	</tr>  
</table>
<p style="color:red;">Please enter valid details...</p>
</form>
</center> 
</div>
</div>
</div>
</body>
</html>