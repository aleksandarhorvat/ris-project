<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pregled kategorija prozivodae</title>
</head>
<body>
	<h1>Kategorije proizvoda</h1>
	<c:if test="${!empty kategorije }">
		<form action="/Prodavnica/kategorija/getKategorije" method="get">
			<select name="idK">
				<c:forEach items="${kategorije }" var="k">
					<c:if test="${!empty k }">
						<option value="${k.idKategorija}">${k.naziv}</option>
					</c:if>
				</c:forEach>
			</select> <input type="submit" value="Prikazi vise">
		</form>
	</c:if>
	<br>
	<form action="/Prodavnica/kategorija/deleteKategorija" method="get">
		<c:if test="${!empty kategorijaIzmena}">
			<input type="hidden" name="idK" value="${kategorijaIzmena.idKategorija}" />
			<input type="submit" value="Izbrisi Kategoriju">
		</c:if>
	</form>
	<br>
	<form:form action="/Prodavnica/kategorija/changeKategorija" method="post" modelAttribute="kategorija">
		<c:if test="${!empty kategorijaIzmena}">
			<td><form:input type="hidden" path="idKategorija" required="true" value="${kategorijaIzmena.idKategorija }"/></td>
			<table border="1">
				<tr>
					<td>Naziv:</td>
					<td><form:input type="text" path="naziv" /></td>
					<td>Trenutna vrednost: ${kategorijaIzmena.naziv }</td>
				</tr>
			</table><br>
			<input type="submit" value="Izmeni kategoriju">
		</c:if>
	</form:form>
	<br>
	<button onclick="goToIndex()">Vrati se na pocetnu stranu</button>
	<script>
        function goToIndex() {window.location.href = "/Prodavnica/adminPage.jsp";}
    </script><br>
    <c:if test="${!empty porukaKategorija}">
		${porukaKategorija }
	</c:if>
</body>
</html>