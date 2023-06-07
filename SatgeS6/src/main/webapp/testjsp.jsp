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
<title></title>

<link rel="stylesheet" href="style.css">
</head>
<body>

<ul class="tabs">
  <li class="active" data-cont=".one">Ajouter</li>
  <li data-cont=".two">Modfier</li> 
  <li data-cont=".three">Supprimer</li>
</ul>
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
<div class="last">
<input type="submit" value="exporter"></div>
<script src="script.js"></script>
</body>
</html>