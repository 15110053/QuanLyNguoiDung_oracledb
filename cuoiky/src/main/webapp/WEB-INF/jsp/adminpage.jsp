<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<script src="<c:url value="/resources/js/userjs.js" />"
	type="text/javascript"></script>
<script src="<c:url value="/resources/js/jquery-3.3.1.min.js" />"
	type="text/javascript"></script>
</head>
<body>
	<a class="btn btn-primary" href="registerpage">tạo tài khoản</a>
	<a class="btn btn-primary" href="profile">tạo profile</a>
	<a class="btn btn-primary" href="">tạo role</a>
	<div class="container">
		<h2>DANH SÁCH TÀI KHOẢN</h2>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>tên tài khoản</th>
					<th>mật khẩu</th>
					<th>email</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="user" items="${listuser}">
					<tr>
						<td><p id="un_${user.username}">${user.username}</p></td>
						<td><p id="up_${user.username}">${user.password}</p></td>
						<td><p id="um_${user.username}">${user.email}</p>
							<div id="d_sua_${user.username }"
								class="position-relative d-inline float-right small"
								style="padding-left: 20px">
								<a href="javascript:chinhsuauser('${user.username}')"
									id="edit_${user.username}">chỉnh sửa</a>
							</div>
							<div class="float-right small">
								<a href="javascript:deleteuser('${user.username}')">Xóa</a>
							</div></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>