<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="../css/bootstrap.min.css">
<title>Liste des livres</title>
</head>
<body>
	<H1>${livre.id}- ${livre.titre} (${livre.auteur})</H1>
	<table class="table">
		<tr>
			<th><b>ID</b></td>
			<td>${livre.id}</td>
		</tr>
		<tr>
			<th><b>Titre</b></td>
			<td>${livre.titre}</td>
		</tr>
		<tr>
			<th><b>Auteur</b>
			</th>
			<td>${livre.auteur}</td>
		</tr>
	</table>
	<script src="../js/jquery-3.3.1.min.js"></script>
	<script src="../js/bootstrap.min.js"></script>
</body>
</html>