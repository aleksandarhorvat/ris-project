<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Informacije o prozivodu</title>
</head>
<body>
	<h1>Vise o prozivodu</h1>
	<table border="1" style="text-align: center;">
		<tr>
			<th>Slika prozivoda</th>
			<th>Ime proizvoda</th>
			<th>Cena prozivoda</th>
			<th>Opis prozivoda</th>
			<th>Kategorija prozivoda</th>
			<th>Proizvodjac proizvoda</th>
			<c:if test="${!empty proizvod.popust}">
				<th>Popust</th>
			</c:if>
		</tr>
		<tr>
			<td style="width: fit-content">
			    <img src="data:image/jpeg;base64,${proizvod.slikaAsBase64}" alt="Slika proizvoda" style="width: 200px;">
			</td>
			<td>${proizvod.ime }</td>
			<c:if test="${empty proizvod.popust}">
				<td>${proizvod.cena }</td>
			</c:if>
			<c:if test="${!empty proizvod.popust}">
				<td>${proizvod.cena -  (proizvod.cena / proizvod.popust.procenat)}</td>
			</c:if>
			<td>${proizvod.opis }</td>
			<td>${proizvod.kategorija.naziv }</td>
			<td>${proizvod.proizvodjac.naziv }</td>
			<c:if test="${!empty proizvod.popust}">
				<th>${proizvod.popust.procenat } %</th>
			</c:if>
		</tr>
	</table>
	<br>
    <form action="/Prodavnica/proizvod/savePodaci" method="post">
        Ocena: <input type="number" name="ocena"><br>
        Omiljen: <input type="checkbox" name=omlijen><br>
        		 <input type="button" name=porudzbina><br>
        <input type="submit" value="Potvrdi">
    </form>
</body>
</html>