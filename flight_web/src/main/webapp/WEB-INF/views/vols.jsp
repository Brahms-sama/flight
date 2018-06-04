<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/bootstrap.min.css">
<title>Liste des livres</title>
</head>
<body>
	<h1 style="text-align: center;">Liste des livres</h1>
	<table class="table table-striped">
		<tr class="thead-light">
			<th>ID</th>
			<th>Titre</th>
			<th>Auteur</th>
			<th>Supprimer</th>
		</tr>
		<c:forEach items="${livres}" var="livre">
			<tr>
				<td><a href="<c:url value="/livres/" />${livre.id}">${livre.id}</a></td>
				<td>${livre.titre}</td>
				<td>${livre.auteur}</td>
				<td><a href="<c:url value="/delete/" />${livre.id}">DELETE</a></td>
			</tr>
		</c:forEach>
		<hr>
		<tr>
		<sf:form method="post" commandName="livre">
			<td>Ajouter</td>
			<td><sf:input path="titre"/></td>
			<td><sf:input path="auteur"/></td>
			<td><input type="button" class="btn" value="Ajouter"/></td>
		</sf:form>
		</tr>
	</table>
	<script src="js/jquery-3.3.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>