<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="<c:url value="/resources/css/registerstyle.css" />"
	rel="stylesheet">
<title>Insert title here</title>
<script src="<c:url value="/resources/js/jquery-3.3.1.min.js" />"
	type="text/javascript"></script>
<script src="<c:url value="/resources/js/userjs.js" />"
	type="text/javascript"></script>
</head>
<body>
	<!-- main -->
	<div class="main-w3layouts wrapper">
		<h1>Tạo tài khoản</h1>
		<div class="main-agileinfo">
			<div class="agileits-top">
				<form action="javascript:check_confirm_password()">
					<input class="text" type="text" id="UserName"
						placeholder="Tên tài khoản" required=""> 
					<input class="text email" type="email" id="Email" placeholder="Email" required="true"> 
					<input class="text" type="password"	id="Password" placeholder="Mật khẩu" required="true"> 
					<input class="text w3lpass" type="password" id="repassword"	placeholder="Nhập lại mật khẩu" required="true"> 
					<input type="submit" value="Tạo tài khoản"> 
				</form>
			</div>
		</div>
		<!-- copyright -->
		<div class="w3copyright-agile">
			<p>
				© 2017 Bubble SignUp Form. All rights reserved | Design by <a
					href="http://w3layouts.com/" target="_blank">W3layouts</a>
			</p>
		</div>
		<!-- //copyright -->
		<ul class="w3lsg-bubbles">
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
		</ul>
	</div>
	<!-- //main -->
</body>
</html>