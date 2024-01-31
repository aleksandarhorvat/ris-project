<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Promeni status porudzbine</title>
</head>
<body>
	<h1>Promeni status porudzbine</h1>
	<c:if test="${!empty korisnici }">
		<form action="/Prodavnica/porudzbina/getPorudzbinu" method="get">
			<select name="idK">
				<c:forEach items="${korisnici }" var="k">
					<c:if test="${!empty k }">
						<option value="${k.username}">${k.username}</option>
					</c:if>
				</c:forEach>
			</select> <input type="submit" value="Prikazi vise">
		</form>
	</c:if>
	<br>
	<form:form action="/Prodavnica/porudzbina/changeStatus" method="post" modelAttribute="porudzbina">
		<c:if test="${!empty proudzbinaIzmena}">
			<td><form:input type="hidden" path="korisnik_username" required="true" value="${proudzbinaIzmena.korisnik_username }"/></td>
			<table border="1">
				<tr>
					<td>Naziv:</td>
					<td><form:input type="text" path="status" /></td>
					<td>Trenutna vrednost: ${proudzbinaIzmena.status }</td>
				</tr>
			</table><br>
			<input type="submit" value="Izmeni porudzbinu">
		</c:if>
	</form:form><br>
	<button onclick="goToIndex()">Vrati se na pocetnu stranu</button>
	<script>
        function goToIndex() {window.location.href = "/Prodavnica/adminPage.jsp";}
    </script><br>
    <c:if test="${!empty porukaPorudzbina}">
		${porukaPorudzbina }
	</c:if>
</body>
</html>