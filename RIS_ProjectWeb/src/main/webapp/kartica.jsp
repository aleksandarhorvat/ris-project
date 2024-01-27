<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dodaj Karticu</title>
</head>
<body>
	<h1>Dodaj karticu</h1>
	<form:form action="/Prodavnica/kartica/saveKartica" method="post" modelAttribute="kartica">
		<%--!Za korisnika <form:input type="text" path="korisnik_username" value="${trenutniKorisnik.getUsername() }"/><br>--%>
		Broj kartice: <form:input type="text" path="brojKartice"/><br>
		CVV: <form:input type="text" path="cvv"/><br>
		Datum Isticanja: <form:input type="date" path="datumIsticanja"/><br>

        <input type="submit" value="Unesi karticu">
    </form:form>
    <br>
	<c:if test="${!empty porukaKartica}">
		${porukaKartica }
	</c:if>
</body>
</html>