<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>
</head>
<body>
	<h1>${heading}</h1>
	<table>
		<tr>
			<th>${cell1}</th>
			<th>${cell2}</th>
			<th>${cell3}</th>
		</tr>
		<c:forEach items="${forum}" var="forum">
			<tr>
				<td><a href="${forum.id}" name="id"><c:out value="${forum.titel}"/></a></td>
				<td><c:out value="${forum.name}" /></td>
				<td><c:out value="${forum.zeit}" /></td>
			</tr>
		</c:forEach>
	</table>
	<br/>
	<hr />
	<br/>
	 <a href="beitrag-erstellen">Beitrag erstellen</a> 
	<br/>
	<br/>

	<hr />


</body>
</html>