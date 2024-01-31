<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dodaj proizvodjaca</title>
</head>
<body>
	<h1>Dodaj proizvodjaca</h1>
	<form:form action="/Prodavnica/proizvodjac/saveProizvodjac" method="post" modelAttribute="proizvodjac">
        Naziv: <form:input type="text" path="naziv" required="true"/><br>
        <input type="submit" value="Dodaj prozivodjaca">
    </form:form><br>
    <button onclick="goToIndex()">Vrati se na pocetnu stranu</button>
    <script>
        function goToIndex() {window.location.href = "/Prodavnica/adminPage.jsp";}
    </script><br>
    <c:if test="${!empty porukaProizvodjac}">
		${porukaProizvodjac }
	</c:if>
</body>
</html>