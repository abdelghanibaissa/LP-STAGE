<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/style.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>
<body>
<div class="center">
<form method=post action=RegisterServlet >
<h1>Sign up</h1>
<div class="txt-field">

<label>FullName</label>
<input type="text" name="fullname"><br>
</div>
<div class="txt-field">
<label>Username</label>
<input type="text" name="username"><br>
</div>
<div class="txt-field">
<label>Email</label>
<input type="email" name="email"><br>
</div>
<div class="txt-field">
<label>Password</label>
<input type="password" name="password"><br>
</div>
<div class="pass">
Already have an account?login<a href="login.jsp" class="pass">here</a> </div>
<input type="submit" value="Sign up">
</form></div>
</body>
</html>