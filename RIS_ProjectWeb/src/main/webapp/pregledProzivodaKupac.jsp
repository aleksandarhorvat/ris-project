<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page import="java.util.Base64" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pregled prozivoda</title>
</head>
<body>
	<h1>Dostupni proizvodi Kupac</h1><br>
	<c:if test="${!empty proizvodi }">
		<table border="1">
			<tr>
				<th>Slika prozivoda</th>
				<th>Ime proizvoda</th>
				<th>Cena prozivoda</th>
				<th>Popust</th>
				<th>Informacije</th>
			</tr>
			<c:forEach items="${proizvodi}" var="p">
				<tr>
					<td style="width: fit-content">
					    <img src="data:image/jpeg;base64,${p.slikaAsBase64}" alt="Slika proizvoda" style="width: 200px;">
					</td>
					<td>${p.ime }</td>
					<c:if test="${empty p.popust}">
						<td>${proizvod.cena }</td>
					</c:if>
					<c:if test="${!empty p.popust}">
						<td>${p.cena -  (p.cena / p.popust.procenat)}</td>
					</c:if>
					<c:if test="${!empty p.popust}">
						<th>${p.popust.procenat } %</th>
					</c:if>
					<td><a href="/Prodavnica/proizvod/getProizvod?idP=${p.idProizvod}">Vise o proizvodu</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<br>
</body>
</html>