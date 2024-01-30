<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registruj se</title>
</head>
<body>
	<h1>Registruj se</h1>
	<form:form action="/Prodavnica/signin/saveKorisnik" method="post" modelAttribute="korisnik">
        Username: <form:input type="text" path="username" required="true"/><br>
        Password: <form:input type="password" path="password" required="true"/><br>
        First Name: <form:input type="text" path="ime" required="true"/><br>
        Last Name: <form:input type="text" path="prezime" required="true"/><br>
        Address: <form:input type="text" path="adresa" required="true"/><br>
        Uloge: <form:select path="uloga" items="${uloge}" itemValue="idUloga" itemLabel="naziv"/><br><br>
		
        <input type="submit" value="Sign in">
    </form:form>
    <br>
    <button onclick="goToIndex()">Vrati se na pocetnu stranu</button>
    <script>
        function goToIndex() {window.location.href = "/Prodavnica";}
    </script>
	<br>
	<c:if test="${!empty porukaKorisnik}">
		${porukaKorisnik }
	</c:if>
</body>
</html>