<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Registration</title>

<script type="text/javascript">

  function register(){

  window.open("register.jsp","_self");

  }

</script>

<style type="text/css">

html{   
    width: 100%;   
    height: 100%;     
    font-style: sans-serif;   
}

body{   
    width: 100%;   
    height: 100%;   
    font-family: 'Open Sans',sans-serif;   
    margin: 0;   
    background-color: #727696;   
}

#reg{   
    position: absolute;   
    top: 50%;   
    left:50%;   
    margin: -150px 0 0 -150px;   
    width: 300px;   
    height: 300px;   
}

#reg h1{   
    color: #fff;   
    text-shadow:0 0 10px;   
    letter-spacing: 1px;   
    text-align: center;   
}

h1{   
    font-size: 2em;   
    margin: 0.67em 0;   
} 

input{   
    width: 278px;   
    height: 28px;   
    margin-bottom: 10px;   
    outline: none;   
    padding: 10px;   
    font-size: 13px;   
    color: #fff;   
    text-shadow:1px 1px 1px;   
    border-top: 1px solid #312E3D;   
    border-left: 1px solid #312E3D;   
    border-right: 1px solid #312E3D;   
    border-bottom: 1px solid #56536A;   
    border-radius: 4px;   
    background-color: #2D2D3F;   
} 

button{   
    width: 30px;   
    min-height: 9px;   
    display: block;   
    background-color: #4a77d4;   
    border: 1px solid #3762bc;   
    color: #fff;   
    padding: 14px 14px;   
    font-size: 15px;   
    line-height: normal;   
    border-radius: 5px;   
    margin: 0;   
}

</style>

</head>

<body>
<div id="reg">
	<script>

		
		function validate() {
			var username = document.getElementById("username");
			var password = document.getElementById("password");
			var passwordRep = document.getElementById("passwordRep");
			var email = document.getElementById("email");
			username = username.value;
			password = password.value;
			passwordRep = passwordRep.value;
			email = email.value;
			if (username.length == 0) {
				alert("username cannot be null");
				return false;
			}
			if (password.length == 0) {
				alert("password cannot be null");
				return false;
			}else if(password.length < 6){   
				alert("password length should be at least 6");
				return false;
			}else if(password != passwordRep){
				alert("Please enter the same password twice");
				return false;
			}
			if (email.length == 0) {
				alert("email cannot be null");
				return false;
			}else if(email.substring(email.length - 13) != "@utdallas.edu"){  
				alert("email should be UTD email");
				return false;
			}
			return true;
		}
	</script>
	

	<form action="register.do" method="post">

		<table border="0" style="color:#fff;">

			<tr>

				<td><label for="username">Username</label></td>

				<td><input type="text" name="username" id="username" /></td>

			</tr>

			<tr>

				<td><label for="password">Password</label></td>

				<td><input type="password" name="password" id="password" /></td>

			</tr>
			<tr>

				<td><label for="passwordRep">Confirm Password</label></td>

				<td><input type="password" name="passwordRep" id="passwordRep" /></td>

			</tr>
			<tr>

				<td><label for="email">Email：</label></td>

				<td><input type="text" name="email" id="email" /></td>

			</tr>

			<tr>

				<td colspan="2" align="center">
				<input type="submit" value="Submit" onclick="return validate()" style="background-color:#4a77d4; height: 36px; "/> 
				<input type="reset" value="Reset" style="background-color:#4a77d4; height: 36px; "/>
				</td>

			</tr>

		</table>

	</form>
</div>
<p>${message}</p>

</body>

</html>







