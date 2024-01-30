<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Napravi kategoriju</title>
</head>
<body>
	<h1>Napravi kategoriju</h1>
	<form:form action="/Prodavnica/kategorija/saveKategorija" method="post" modelAttribute="kategorija">
        Naziv: <input type="text" name="naziv"><br>
        <input type="submit" value="Sacuvaj">
    </form:form><br>
    <button onclick="goToIndex()">Vrati se na pocetnu stranu</button>
    <script>
        function goToIndex() {window.location.href = "/Prodavnica/kupacPage.jsp";}//dodaj ostalima ovo
    </script>
    <c:if test="${!empty porukaKategorija}">
		${porukaKategorija }
	</c:if>
</body>
</html>