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
<title>Pointage</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<link rel="stylesheet" href="css/style1.css">
</head>
<body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
 integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<nav class="navbar navbar-expand-lg" style="background-color: #e3f2fd;">
  <div class="container-fluid">
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="home.jsp">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Link</a>
        </li>
      </ul>
      <form class="d-flex" method=post action=searchServlet>
        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" id="name" name="name">
        <button class="btn btn-outline-success" type="submit">Search</button>
      </form>
      <a href="">profile</a>
    </div>
  </div>
</nav>
<ul class="tabs">
  <li class="active" data-cont=".one">Ajouter</li>
  <li data-cont=".two">Modfier</li> 
  <li data-cont=".three">Supprimer</li>
</ul>
<div class="jamla">
<div class="content">
  <div class="one">
  <form method=post action=homeServlet >
			<div class="txt-field">
				<label>Nom</label><br>
				<input type="text" name="nom" id=nom>
			</div>
			<div class="txt-field">
				<label>Prenom</label><br>
				<input type="text" name="prenom" id=prenom>
			</div>
			<div class="txt-field">
				<label>Temps arrive</label><br>
				<input type="text" name="tempsa" id=tempsa>
			</div>
			<div class="txt-field">
				<label>Temps sortie</label><br>
				<input type="text" name="tempss" id=tempss>
			</div><div class="crud">
				<input type="submit" name="ajouter" value="ajouter"></div>
		</form>
  
  </div>
  <div class="two">
  <form method=post action=modifierServlet>
			<div class="txt-field">
				<label>Nom</label><br>
				<input type="text" name="nom1" id=nom1>
			</div>
			<div class="txt-field">
				<label>Prenom</label><br>
				<input type="text" name="prenom1" id=prenom1>
			</div>
			<div class="txt-field">
				<label>Temps arrive</label><br>
				<input type="text" name="tempsa" id=tempsa>
			</div>
			<div class="txt-field">
				<label>Temps sortie</label><br>
				<input type="text" name="tempss" id=tempss>
			</div>
			<div class="crud">
				<input type="submit" value="modifier">
				</div>
		</form></div>
  <div class="three">
  <form method=post action=supprimerServlet>
		<div class="txt-field">
			<label>Nom</label><br>
			<input type="text" name="nom2" id=nom2>
		</div>
		<div class="txt-field">
			<label>Prenom</label><br>
			<input type="text" name="prenom2" id=prenom2>
		</div><div class="crud">
			<input type="submit" value="supprimer">
		</div>
		</form>
  </div>
</div>
<table class="content-table" id="table"><thead><tr>
<th>nom</th>
<th>prenom</th>
<th>temps arrivee</th>
<th>temps sortie</th>
<th>pp</th>
<th>pf</th></tr></thead>
<% try{
	Connection cn=ConnectionDB.getConnection(); 
	PreparedStatement ps= cn.prepareStatement("SELECT * FROM empolyee");
	ResultSet rs= ps.executeQuery();
	while(rs.next()){
	%>
	<tbody><tr>
	<td><%= rs.getString("nom") %></td>
	<td><%= rs.getString("prenom") %> </td>
	<td><%= rs.getDouble("temps_arriver") %> </td>
	<td><%= rs.getDouble("temps_sortie") %> </td>
	<td><%= rs.getInt("pp") %></td>
		<td><%= rs.getInt("pf") %></td>
	</tr></tbody>
	<% 
	}
	}catch(Exception e){
	}%>
</table>
</div>
<script>
function exportData(){
	var table2excel = new Table2Excel();
  table2excel.export(document.querySelectorAll("table"));	
}
</script>
<div class="last">
<button onClick="exportData()" id="downloadexcel">Exporter</button></div>
<span class="up">Up</span>

<script type="text/javascript" src="js/script.js"></script>
<script type="text/javascript" src="js/table2excel.js"></script>
</body>
</html>