<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pregled prozivodjaca</title>
</head>
<body>
	<h1>Proizvodjaci</h1>
	<c:if test="${!empty proizvodjaci }">
		<form action="/Prodavnica/proizvodjac/getProizvodjaci" method="get">
			<select name="idP">
				<c:forEach items="${proizvodjaci }" var="p">
					<c:if test="${!empty p }">
						<option value="${p.idProizvodjac}">${p.naziv}</option>
					</c:if>
				</c:forEach>
			</select> <input type="submit" value="Prikazi vise">
		</form>
	</c:if>
	<br>
	<form action="/Prodavnica/proizvodjac/deleteProizvodjac" method="get">
		<c:if test="${!empty proizvodjacIzmena}">
			<input type="hidden" name="idP" value="${proizvodjacIzmena.idProizvodjac}" />
			<input type="submit" value="Izbrisi Prozivodjaca">
		</c:if>
	</form>
	<br>
	<form:form action="/Prodavnica/proizvodjac/changeProizvodjac" method="post" modelAttribute="proizvodjac">
		<c:if test="${!empty proizvodjacIzmena}">
			<td><form:input type="hidden" path="idProizvodjac" required="true" value="${proizvodjacIzmena.idProizvodjac }"/></td>
			<table border="1">
				<tr>
					<td>Naziv:</td>
					<td><form:input type="text" path="naziv" /></td>
					<td>Trenutna vrednost: ${proizvodjacIzmena.naziv }</td>
				</tr>
			</table><br>
			<input type="submit" value="Izmeni proizvodjaca">
		</c:if>
	</form:form>
	<br>
	<button onclick="goToIndex()">Vrati se na pocetnu stranu</button>
	<script>
        function goToIndex() {window.location.href = "/Prodavnica/admin/adminPage.jsp";}
    </script><br>
    <c:if test="${!empty porukaProizvodjac}">
		${porukaProizvodjac }
	</c:if>
</body>
</html>