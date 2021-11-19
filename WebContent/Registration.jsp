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
	//Validations to check entered passwords & Mobile number
var firstpassword=document.f1.password.value;  
var secondpassword=document.f1.cpassword.value;  
var phonenumber=document.f1.mobileno.value; 

console.log("phonenumber"+phonenumber);
console.log("phonenumber"+phonenumber.length);
  if(firstpassword.length<6){//checking the length of password
	 alert("password length must be minimum 6 characters");
	  return false;
  }
  else if(firstpassword==secondpassword){  //checking the passwords same or not
	  if((phonenumber.length<10)||(phonenumber.length>10))//Phone number validation
	  {
	  alert("phone number should be of 10 digits");
	  return false;
	  }
 
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

<!-- Login Fields -->
<table>
<tr><td>Name</td><td><input type="text" name="name"oninvalid="this.setCustomValidity('Please Enter valid name')" oninput="setCustomValidity('')" required></td></tr>

<tr><td>Email<sup>*</sup></td><td><input type="email" name="email" oninvalid="this.setCustomValidity('Please Enter valid email')"  oninput="setCustomValidity('')" required></td></tr>

<tr><td>Password<sup>*</sup></td><td><input type="password" name="password" oninvalid="this.setCustomValidity('Please Enter password')" oninput="setCustomValidity('')"  required></td></tr>

<tr><td>Confirm Password<sup>*</sup>&nbsp</td><td><input type="password" name="cpassword" oninvalid="this.setCustomValidity('Please Enter confirm password')" oninput="setCustomValidity('')" required></td></tr>
<tr><td>Mobile Number</td><td><input type="number" name="mobileno" oninvalid="this.setCustomValidity('Please give 10 digits')" oninput="setCustomValidity('')" required></td></tr>

<tr><td>Designation</td><td><input type="radio"  name="designation" value="professor">professor
<input type="radio" value="student" checked="checked" name="designation">Student</td></tr>

</table>

<br>

<input type="submit" value="Register" name="Insert">&nbsp&nbsp
<input type="reset" value="Reset">

</form>
<!--signin fields -->
<p>Already a user <a href="LandingPage.jsp"> signin </a>here</p>
<br>
<br>
</center>
</div>
</body>
</html>