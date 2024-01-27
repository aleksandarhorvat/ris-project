<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pregled Administratora</title>
</head>
<body>
	<h1>Pocetna stranica za Administratora</h1>
	<c:if test="${!empty trenutniKorisnik}">
		${trenutniKorisnik.ime }
	</c:if>
</body>
</html>