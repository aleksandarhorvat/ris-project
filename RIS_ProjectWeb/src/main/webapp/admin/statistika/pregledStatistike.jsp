<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pregled statistike</title>
</head>
<body>
	<h1>Pregled statistike</h1>
	<a href="/Prodavnica/kategorija/getProizvodiPoKategorijiPage">Vidi koliko je proizvoda uneto po kategorijama</a><br>
	<a href="/Prodavnica/proizvodjac/getProizvodiPoProzivodjacuPage">Vidi koliko je proizvoda uneto po proizvodjacu</a><br>
	<a href="/Prodavnica/porudzbina/getPorudzbinePoDanimaPage">Vidi koliko je novih porudzbina stiglo odredjenog dana</a><br><br>
	<button onclick="goToIndex()">Vrati se na pocetnu stranu</button>
    <script>
        function goToIndex() {window.location.href = "/Prodavnica/admin/adminPage.jsp";}
    </script>
</body>
</html>