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
<link href="<c:url value="/resources/css/bootstrap.css" />"
	rel="stylesheet">
<script src="<c:url value="/resources/js/jquery-3.3.1.min.js" />"
	type="text/javascript"></script>
<script src="<c:url value="/resources/js/profilejs.js" />"
	type="text/javascript"></script>
</head>
<body>
	<div class="container">
		<h2>DANH SÁCH PROFILE</h2>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>profile</th>
					<th>CONNECT_TIME</th>
					<th>IDLE_TIME</th>
					<th>SESSIONS_PER_USER</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="profile" items="${listprofile}">
					<tr>
						<td><p id="${profile[0]}">${profile[0]}</p></td>
						<td><p id="ct_${profile[0]}">${profile[1]}</p></td>
						<td><p id="it_${profile[0]}">${profile[2]}</p></td>
						<td><p id="spu_${profile[0]}">${profile[3]}</p>

							<div id="d_sua_${profile[0] }"
								class="position-relative d-inline float-right small"
								style="padding-left: 20px">
								<a href="javascript:chinhsuaprofile('${profile[0]}')"
									id="edit_${profile[0]}">chỉnh sửa</a>
							</div>
							<div class="float-right small">
								<a href="javascript:deleteprofile('${profile[0]}')">Xóa</a>
							</div></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<form  action="javascript:addprofile()" id = "formtaoprofile">
			<div class="form-group">
				<input type="text" class="form-control" placeholder="Tên profile"
					name="Username" id="profilename">
			</div>
			<div class="form-group">
				<input type="number" class="form-control"
					placeholder="session per user" id="add_spu">
			</div>
			<div class="form-group">
				<input type="number" class="form-control"
					placeholder="connect time" id="add_ct">
			</div>
			<div class="form-group">
				<input type="number" class="form-control"
					placeholder="inle time" id="add_it">
			</div>
			<div class="form-group form-check"></div>
			<button type="submit" class="btn btn-primary" name="action"
				value="login">thêm profile</button>
		</form>
	</div>
</html>