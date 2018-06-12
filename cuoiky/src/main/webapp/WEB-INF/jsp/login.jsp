<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">
<script src="<c:url value="/resources/js/jquery-3.3.1.min.js" />" type="text/javascript"></script>
<script src="<c:url value="/resources/js/userjs.js" />" type="text/javascript"></script>
</head>
<body>
	<div class="container">
		<h2>ĐĂNG NHẬP</h2>
		<form action="javascript:login()">
			<div class="form-group">
				<label for="email">Email:</label> <input type="text"
					class="form-control" placeholder="Tên tài khoản" name="Username"
					id="Username">
			</div>
			<div class="form-group">
				<label for="pwd">Password:</label> <input type="password"
					class="form-control" placeholder="Mật khẩu" name="Password"
					id="Password">
			</div>
			<div class="form-group form-check"></div>
			<button type="submit" class="btn btn-primary" name = "action" value = "login">Đăng nhập</button>
		</form>
	</div>
</body>
</html>