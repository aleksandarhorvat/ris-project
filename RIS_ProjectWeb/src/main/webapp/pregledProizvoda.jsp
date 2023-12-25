<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta charset="UTF-8">
<title>Pregled prozivoda</title>
</head>
<body>
	<h1>Dostupni proizvodi</h1><br>
	<c:if test="${!empty proizvodi }">
		<table border="1">
			<tr>
				<th>Ime proizvoda</th>
				<th>cena</th>
				<th>opis</th>
			</tr>
			<c:forEach items="${proizvodi}" var="p">
				<tr>
					<td>${p.ime }</td>
					<td>${p.cena }</td>
					<td>${p.opis }</td>
				</tr>
			</c:forEach>
		</table>	
	</c:if>
	<br>
</body>
</html>