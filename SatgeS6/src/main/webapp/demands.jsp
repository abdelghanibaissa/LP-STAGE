<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import= "java.sql.Connection" %>
    <%@page import= "java.sql.PreparedStatement" %>
    <%@page import= "java.sql.SQLException" %>
    <%@page import= "home.ConnectionDB" %>
    <%@page import= "java.sql.ResultSet" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/reclamation.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" integrity="sha512-REvzCZJGd9Xx8fZW7O/H/ZMw/zd0tbKbQDvg5jq5gAAmNYBtmgI9t2Z2lLZmPwxyYdCIPGggf8J1ViOcEyHfzg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>
<nav class="navbar navbar-expand-lg " style="background-color: #e3f2fd;">
  <div class="container-fluid">
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="home.jsp">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="reclamation.jsp"><i class="bi bi-file-earmark-plus"></i>Reclamation</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="demands.jsp"><i class="bi bi-file-earmark-plus"></i>Demandes</a>
        </li>
      </ul>
      <a href="">profile</a>
    </div>
  </div>
</nav>
<div class="container">
<h1>Liste de demandes</h1>
<button type="button" class="btn btn-primary" id="btn">nouvelle demande</button>
<table class="content-table" id="table"><thead><tr>
<th>Nr</th>
<th>reason</th>
<th>explain</th>
<th>statue</th>
</tr></thead>
<% try{
	Connection cn=ConnectionDB.getConnection(); 
	PreparedStatement ps= cn.prepareStatement("SELECT * FROM reclamation");
	ResultSet rs= ps.executeQuery();
	while(rs.next()){
	%>
	<tbody><tr>
	<td><%= rs.getString("id_rec") %></td>
	<td><%= rs.getString("reason") %> </td>
	<td><%= rs.getString("exlpain") %> </td>
	<td><%= rs.getString("status") %> </td>
	</tr></tbody>
	<% 
	}
	}catch(Exception e){
	}%>
</table>
</div>
<div class="popup">
<div class="popup-content">
<img src="images/close.jpg" alt="close" class="close">
<form method=post action=reclamationServlet>
<div class="select">
<select name="reason" id="reason" onchange="showInput()">
<option selected disabled>--selectionez une option--</option>
<option>congie</option>
<option>autre</option>
</select>
</div><div class="textfield1">
<input type="hidden" id="reason1">
<input type="text" id="explain" name="explain">
</div><div class="textfield" >
<input type="submit" value="Envoyer" id="envoyer">
</div></form>
</div>
</div>
<script type="text/javascript">
document.getElementById("btn").addEventListener("click", function(){
	document.querySelector(".popup").style.display ="flex";
})
document.querySelector(".close").addEventListener("click", function(){
	document.querySelector(".popup").style.display ="none";
})
var table = document.getElementById("table"),rIndex;
for(var i = 1; i < table.rows.length; i++)
{
    table.rows[i].onclick = function()
    {
        rIndex = this.rowIndex;
        console.log(rIndex);
        document.querySelector(".popup1").style.display ="flex";
        document.getElementById("id_de").value = this.cells[0].innerHTML;
        document.getElementById("ty").value = this.cells[1].innerHTML;
        document.getElementById("exp").value = this.cells[2].innerHTML;
    };
}
</script>
<div class="popup1">
<div class="popup-content1">
<img src="images/close.jpg" alt="close" class="close">
<form method=post action=editreclamationServlet>
<label> Nr</label>
<input type="text" id="id_de" name="id_de" disabled>
<div class="textline">
<label>type de demandes</label>
<input type="text" id="ty" name="ty">
</div>
<div class="textline1">
<label>reason</label>
<input type="text" id="exp" name="exp">
</div>
<div class="textfield" >
<input type="submit" value="Edit" >
</div></form>
</div>
</div>
</body>
</html>