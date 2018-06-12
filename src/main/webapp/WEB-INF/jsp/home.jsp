<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}
</style>
</head>
<body>
	<table style="width: 100%">
		<tr>
			<th>empno</th>
			<th>ename</th>
			<th>email</th>
		</tr>
		<c:forEach var = "emp" items = "${listemp }">
			<tr>
				<td>${emp.userid}</td>
				<td>${emp.username}</td>
				<td>${emp.password}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>