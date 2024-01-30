<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dodaj prozivode u kategoriju</title>
</head>
<body>
<h1>Dodaj prozivode u kategoriju</h1>
	<form action="/Prodavnica/kategorijaKorisnika/saveProizvode" method="post">
        Izaberi kategoriju u koju zelis da dodas omiljene prozivode: <select name=idKategorija>
			<c:forEach items="${kategorije}" var="k">
				<option value="${k.idKategorijeKorisnika}">${k.naziv}</option>
			</c:forEach>
		</select><br>
		Izaberi omiljene: <select name=idOmiljeni multiple>
			<c:forEach items="${omiljeni}" var="k" varStatus="status">
				<option value="${omiljeni[status.index].idProizvod}">${omiljeni[status.index].ime}</option>
			</c:forEach>
		</select><br>
        <input type="submit" value="Sacuvaj">
    </form><br>
    <button onclick="goToIndex()">Vrati se na pocetnu stranu</button>
    <script>
        function goToIndex() {window.location.href = "/Prodavnica/kupacPage.jsp";}//dodaj ostalima ovo
    </script>
    	<c:if test="${!empty porukaKategorija}">
		${porukaKategorija }
	</c:if>
</body>
</html>