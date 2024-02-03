<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page import="java.util.Base64" %>
<html>
<head>
<meta charset="UTF-8">
<title>Pregled prozivoda</title>
</head>
<body>
	<h1>Dostupni proizvodi</h1><br>
	<c:if test="${!empty proizvodi }">
		<table border="1" style="text-align: center;">
			<tr>
				<th>Slika prozivoda</th>
				<th>Ime proizvoda</th>
				<th>Cena prozivoda</th>
				<th>Popust</th>
			</tr>
			<c:forEach items="${proizvodi}" var="p">
				<tr>
					<td style="width: fit-content">
					    <img src="data:image/jpeg;base64,${p.slikaAsBase64}" style="width: 200px;">
					</td>
					<td>${p.ime }</td>
					<c:if test="${empty p.popust}">
						<td>${p.cena }</td>
					</c:if>
					<c:if test="${!empty p.popust}">
						<td>${p.cena -  ((p.cena / 100) * p.popust.procenat)}</td>
					</c:if>
					<c:if test="${!empty p.popust}">
						<th>${p.popust.procenat } %</th>
					</c:if>
					<c:if test="${empty p.popust}">
						<th></th>
					</c:if>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<br>
	<button onclick="goToIndex()">Vrati se na pocetnu stranu</button>
    <script>
        function goToIndex() {window.location.href = "/Prodavnica";}
    </script>
	<br>
</body>
</html>