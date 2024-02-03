<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pregled porudzbina po danu</title>
</head>
<body>
	<h1>Pregled porudzbina po danu</h1>
	<c:if test="${!empty porudzbine }">
		<form action="/Prodavnica/porudzbina/getPorudzbine" method="get">
			<input type="date" name="datumNarucivanja">
			<input type="submit" value="Prikazi vise">
		</form>
	</c:if>
	<br>
	<c:if test="${brojPorudzbina >= 0}">
		Broj porudzbina: ${brojPorudzbina }
	</c:if><br><br>
	<button onclick="goToIndex()">Vrati se na pocetnu stranu</button>
	<script>
        function goToIndex() {window.location.href = "/Prodavnica/admin/statistika/pregledStatistike.jsp";}
    </script><br>
</body>
</html>