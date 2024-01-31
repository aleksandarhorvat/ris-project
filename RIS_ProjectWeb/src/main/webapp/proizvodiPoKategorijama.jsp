<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Prikaz proizvoda po kategorijama</title>
</head>
<body>
<h1>Prikaz proizvoda po kategorijama</h1>
	<c:if test="${!empty kategorije }">
		<form action="/Prodavnica/kategorija/getProizvodi" method="get">
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
	<c:if test="${brojProizvoda >= 0}">
		Broj prozivoda: ${brojProizvoda }
	</c:if><br><br>
	<button onclick="goToIndex()">Vrati se na pocetnu stranu</button>
	<script>
        function goToIndex() {window.location.href = "/Prodavnica/pregledStatistike.jsp";}
    </script><br>
</body>
</html>