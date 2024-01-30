<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pregled Kupca</title>
</head>
<body>
	<h1>Pocetna stranica za kupca</h1>
	<a href="/Prodavnica/kartica/getKartica">Dodaj karticu</a><br>
	<a href="/Prodavnica/proizvod/getProizvodiKupac">Pogledaj prozivode</a><br>
	<a href="/Prodavnica/kategorija/getKategorijaPage">Napravi kategoriju prozivoda</a><br>
	<a href="/Prodavnica/kategorija/getDodajProizvodePage">Dodaj proizvode u kategoriju</a><br>
	<a href="/Prodavnica/porudzbina/getPorudzbina">Pogledaj sadrzaj korpe</a><br><br>
	<button onclick="goToIndex()">Vrati se na pocetnu stranu</button>
    <script>
        function goToIndex() {window.location.href = "/Prodavnica";}
    </script>
</body>
</html>