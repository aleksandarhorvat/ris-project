<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dodaj kategoriju proizvoda</title>
</head>
<body>
	<h1>Dodaj kategoriju proizvoda</h1>
	<form:form action="/Prodavnica/kategorija/saveKategorija" method="post" modelAttribute="kategorija">
        Naziv: <form:input type="text" path="naziv" required="true"/><br>
        <input type="submit" value="Dodaj kategoriju">
    </form:form><br>
    <button onclick="goToIndex()">Vrati se na pocetnu stranu</button>
    <script>
        function goToIndex() {window.location.href = "/Prodavnica/admin/adminPage.jsp";}
    </script><br>
    <c:if test="${!empty porukaKategorija}">
		${porukaKategorija }
	</c:if>
</body>
</html>