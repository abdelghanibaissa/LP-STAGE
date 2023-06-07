<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" href="css/style.css">

</head>
<body>
<div class="center">
<h1>Login</h1>
<form method=post action=loginServlet>
<div class="txt-field">
<label>email</label>
<input type="text" name="email">
</div>
<div class="txt-field">
<label>Password</label>
<input type="password" name="password">
</div>
<div class="pass">
<a href="Newpassword.jsp">Forget password?</a><br>
Don't have an account?sign up<a href="register.jsp" class="pass">Here</a> 
</div>
<input type="submit" value="Login">
</form></div>
<script type="text/javascript">
function validateForm() {
    var password = document.getElementById("password").value;
    var newpassword = document.getElementById("email").value;
    
    if (password == "" || confirmPassword == "" || email == "") {
      alert("Please enter the empty fields.");
      return true;
    } else if (password != newpassword){
		alert("not same password");
      return false;
    }
    window.open("login.jsp");
  }
</script>
</body>
</html>