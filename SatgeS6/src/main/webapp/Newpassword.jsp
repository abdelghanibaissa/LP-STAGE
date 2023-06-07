<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<script type="text/javascript" src="js/script.js"></script>
<div class="center">
<h1>New password</h1>
<form method=post action=NewpasswordServlet onsubmit="return validateForm()">
<div class="txt-field">
<label>Your email</label>
<input type="text" name="email">
</div>
<div class="txt-field">
<label>Password</label>
<input type="password" name="password" id="password">
</div>
<div class="txt-field">
<label>Confirm Password</label>
<input type="password" name="newpassword" id="newpassword">
</div>
<input type="submit" value="Confirm" id="verify">
</form></div>
<script type="text/javascript">
function validateForm() {
    var password = document.getElementById("password").value;
    var newpassword = document.getElementById("newpassword").value;
    
    if (password == "" || confirmPassword == "") {
      alert("Please enter password or confirm password fields.");
    
      
    } else if (password !=newpassword){
		alert("not same password");
      return false;
    }
    window.open("Newpassword.jsp");
  }
</script>
</body>
</html>