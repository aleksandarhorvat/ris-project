<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Uloguj se</title>
</head>
<body>
	<h1>Uloguj se</h1>
	<form action="${loginUrl}" method="post">
	<table class="tabela-autentifikacija">
		<tr>
			<td>Korisnicko ime:</td>
			<td><input type="text" name="username"
				placeholder="Unesite korisnicko ime" required></td>
		</tr>
		<tr>
			<td>Sifra:</td>
			<td><input type="password" name="password"
				placeholder="Unesite sifru" required></td>
		</tr>
		 <tr>
               <td>Zapamti me:</td>
               <td><input type="checkbox" name="remember-me" /></td>
           </tr>
		<tr>
			<td><input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" /></td>
			<td><input type="submit" value="Prijava"></td>
		</tr>
	</table><br/><br/>
	  Nemate nalog? <a href="/Klinika/auth/registerUser">Registrujte se</a>
	</form>
</body>
</html>