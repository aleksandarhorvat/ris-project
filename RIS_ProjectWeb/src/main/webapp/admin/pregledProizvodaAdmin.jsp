<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pregled proizvoda</title>
</head>
<body>
	<h1>Proizvodi</h1>
	<c:if test="${!empty proizvodiAdmin }">
		<form action="/Prodavnica/proizvod/getProizvodAdmin" method="get">
			<select name="idP">
				<c:forEach items="${proizvodiAdmin }" var="p">
					<c:if test="${!empty p }">
						<option value="${p.idProizvod}">${p.ime}</option>
					</c:if>
				</c:forEach>
			</select> <input type="submit" value="Prikazi vise">
		</form>
	</c:if>
	<br>
	<br>
	<form action="/Prodavnica/proizvod/deleteProizvod" method="get">
		<c:if test="${!empty proizvod}">
			<input type="hidden" name="idP" value="${proizvod.idProizvod}" />
			<input type="submit" value="Izbrisi proizvod">
		</c:if>
	</form>
	<br>
	<form:form enctype="multipart/form-data" action="/Prodavnica/proizvod/changeProizvod" method="post" modelAttribute="proizvodDodat">
		<c:if test="${!empty proizvod }">
			<td><form:input type="hidden" path="idProizvod" required="true" value="${proizvod.idProizvod }"/></td>
			<table border="1">
				<tr>
					<td>Ime:</td>
					<td><form:input type="text" path="ime" /></td>
					<td>Trenutna vrednost: ${proizvod.ime }</td>
				</tr>
				<tr>
					<td>Cena:</td>
					<td><form:input type="number" path="cena" /></td>
					<td>Trenutna vrednost: ${proizvod.cena }</td>
				</tr>
				<tr>
					<td>Slika:</td>
					<td><form:input type="file" path="slika" /></td>
					<td>Trenutna vrednost: <img
						src="data:image/jpeg;base64,${proizvod.slikaAsBase64}" style="width: 200px;">
					</td>
				</tr>
				<tr>
					<td>Opis:</td>
					<td><form:input type="text" path="opis"/></td>
					<td>Trenutna vrednost: ${proizvod.opis }</td>
				</tr>
				<tr>
					<td>Kategorije:</td>
					<td><form:select path="kategorija" items="${kategorije}"
							itemValue="idKategorija" itemLabel="naziv" /></td>
					<td>Trenutna vrednost: ${proizvod.kategorija.naziv }</td>
				</tr>
				<tr>
					<td>Proizvodjaci:</td>
					<td><form:select path="proizvodjac" items="${proizvodjaci}"
							itemValue="idProizvodjac" itemLabel="naziv" /></td>
					<td>Trenutna vrednost: ${proizvod.proizvodjac.naziv }</td>
				</tr>
				<tr>
					<td>Popusti:</td>
					<td><form:select path="popust" items="${popusti}"
							itemValue="idPopust" itemLabel="procenat" /></td>
					<td>Trenutna vrednost: <c:if
							test="${not empty proizvod.popust}">${proizvod.popust.procenat }</c:if>
					</td>
				</tr>
			</table><br>
			<input type="submit" value="Izmeni proizvod">
		</c:if>
	</form:form><br>
	<button onclick="goToIndex()">Vrati se na pocetnu stranu</button>
	<script>
        function goToIndex() {window.location.href = "/Prodavnica/admin/adminPage.jsp";}
    </script><br>
    <c:if test="${!empty porukaProzivod}">
		${porukaProzivod }
	</c:if>
</body>
</html>