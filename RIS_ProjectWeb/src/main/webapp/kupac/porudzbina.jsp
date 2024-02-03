<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pregled porudzbine</title>
</head>
<body>
	<h1>Pregled porudzbine</h1>
	<c:if test="${!empty proizvodi }">
		<table border="1" style="text-align: center;">
			<tr>
				<th>Slika prozivoda</th>
				<th>Ime proizvoda</th>
				<th>Cena prozivoda</th>
				<th>Kolicina</th>
			</tr>
			<c:forEach items="${proizvodi}" var="p" varStatus="status">
				<tr>
					<td style="width: fit-content">
					    <img src="data:image/jpeg;base64,${p.slikaAsBase64}" alt="Slika proizvoda" style="width: 200px;">
					</td>
					<td>${p.ime }</td>
					<c:if test="${empty p.popust}">
						<td>${p.cena }</td>
					</c:if>
					<c:if test="${!empty p.popust}">
						<td>${p.cena -  ((p.cena / 100) * p.popust.procenat)}</td>
					</c:if>
					<td>${kolicine[status.index] }</td>
				</tr>
			</c:forEach>
		</table>
	</c:if><br>
		Datum narucivanja: ${porudzbinaPrikaz.datumNarucivanja }<br>
		Datum isporuke: ${porudzbinaPrikaz.datumIsporuke }<br>
		Status narudzbine: ${porudzbinaPrikaz.status }<br><br>
	<button onclick="goToIndex()">Vrati se na pocetnu stranu</button>
    <script>
        function goToIndex() {window.location.href = "/Prodavnica/kupac/kupacPage.jsp";}
    </script>
</body>
</html>