<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pregled Administratora</title>
</head>
<body>
	<h1>Pocetna stranica za administratora</h1>
	<a href="/Prodavnica/proizvod/getDodajProizvodPage">Dodaj proizvod</a><br>
	<a href="/Prodavnica/proizvod/getProizvodiAdmin">Pogledaj prozivode</a><br><br>
	<a href="/Prodavnica/kategorija/getDodajKategorijuPage">Dodaj kategorjiu prozivoda</a><br>
	<a href="/Prodavnica/kategorija/getKategorijePage">Pogledaj kategorjie prozivoda</a><br><br>
	<a href="/Prodavnica/kartica/getKartica">Dodaj proizvodjaca</a><br>
	<a href="/Prodavnica/proizvod/getProizvodiKupac">Pogledaj proizvodjace</a><br><br>
	<a href="/Prodavnica/proizvod/getProizvodiKupac">Pregled statistike</a><br><br>
	<button onclick="goToIndex()">Vrati se na pocetnu stranu</button>
    <script>
        function goToIndex() {window.location.href = "/Prodavnica";}
    </script>
</body>
</html>