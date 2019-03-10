<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<head>
<meta charset="UTF-8">
<title>Read Contribution</title>
</head>
<body>
	<h1>${heading}</h1>
	<br />
	<p>
		<b>Titel:</b> ${titel}
	</p>
	<p>
		<b>Geschrieben von:</b> ${name}
	</p>
	<p>
		<b>Email:</b> ${email}
	</p>
	<p>
		<b>Geschrieben am:</b> ${zeit}
	</p>
	<br />
	<hr />
	<p>${inhalt}</p>
	<hr />
	<br />
	<h1>${bottomHeading}</h1>
	<table>
		<tr>
			<th>Name:</th>
			<th>Email:</th>
			<th>Titel:</th>
			<th>Inhalt:</th>
		</tr>
		<c:forEach items="${answers}" var="answers">
			<tr>
				<td><c:out value="${answers.name}" /></td>
				<td><c:out value="${answers.email}" /></a></td>
				<td><c:out value="${answers.titel}" /></a></td>
				<td><c:out value="${answers.inhalt}" /></td>
			</tr>
		</c:forEach>
	</table>
<br/>

	<a href="/">zurück</a> |
	<a href="/">Übersicht</a> |
	<a href="antworten/${id}" name="id">Antworten</a>



</body>
</html>