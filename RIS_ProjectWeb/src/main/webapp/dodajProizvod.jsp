<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dodaj Proizvod</title>
</head>
<body>
	<h1>Dodaj prizovd</h1>
	<form:form enctype="multipart/form-data" action="/Prodavnica/proizvod/saveProizvod" method="post" modelAttribute="proizvodDodat">
        Ime: <form:input type="text" path="ime" required="true"/><br>
        Cena: <form:input type="number" path="cena" required="true"/><br>
        Slika: <form:input type="file" path="slika" required="true"/><br>
        Opis: <form:input type="text" path="opis" required="true"/><br>
        Kategorije: <form:select path="kategorija" items="${kategorije}" itemValue="idKategorija" itemLabel="naziv"/><br>
		Proizvodjaci: <form:select path="proizvodjac" items="${proizvodjaci}" itemValue="idProizvodjac" itemLabel="naziv"/><br>
		Popusti: <form:select path="popust" items="${popusti}" itemValue="idPopust" itemLabel="procenat"/><br><br>
        <input type="submit" value="Dodaj proizvod">
    </form:form><br>
    <button onclick="goToIndex()">Vrati se na pocetnu stranu</button>
    <script>
        function goToIndex() {window.location.href = "/Prodavnica/adminPage.jsp";}
    </script><br>
    <c:if test="${!empty porukaProzivod}">
		${porukaProzivod }
	</c:if>
</body>
</html>