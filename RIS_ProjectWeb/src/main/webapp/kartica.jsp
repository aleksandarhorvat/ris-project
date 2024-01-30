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
		Broj kartice: <form:input type="number" path="brojKartice"/><br>
		CVV: <form:input type="number" path="cvv"/><br>
		Datum Isticanja: <form:input type="date" path="datumIsticanja"/><br>

        <input type="submit" value="Unesi karticu">
    </form:form>
    <br>
    <button onclick="goToIndex()">Vrati se na pocetnu stranu</button>
    <script>
        function goToIndex() {window.location.href = "/Prodavnica/kupacPage.jsp";}//dodaj ostalima ovo
    </script>
	<c:if test="${!empty porukaKartica}">
		${porukaKartica }
	</c:if>
</body>
</html>