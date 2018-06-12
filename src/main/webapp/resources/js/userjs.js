function deleteuser(id) {
	$.ajax({
		type : 'GET',
		contentType : 'application/json',
		url : 'deleteuser',
		data : {
			username : id
		},
		dataType : 'json',
		timeout : 100000,
		success : function(data) {
			window.location.href = "adminpage";
			console.log("SUCCESS: ", data);
		},
		error : function(errorThrown) {
			console.log("ERROR: ", errorThrown);
			alert("Lỗi gì đó");
		}
	});
}

function check_confirm_password() {
	var password = $("#Password").val();
	var repassword = $("#repassword").val();
	if (password === repassword) {
		create_account();
	} else
		alert("hai mật khẩu không trùng");
}

function create_account() {
	var user = {
		username : $("#UserName").val(),
		password : $("#Password").val(),
		email : $("#Email").val()
	}
	$.ajax({
		type : 'POST',
		contentType : 'application/json',
		url : 'createuser',
		data : JSON.stringify(user),
		dataType : 'json',
		timeout : 100000,
		success : function(data) {
			window.location.href = "adminpage";
			console.log("SUCCESS: ", data);
		},
		error : function(errorThrown) {
			console.log("ERROR: ", errorThrown);
			alert("Lỗi gì đó");
		}
	});
}

function login() {
	var user = {
		username : $("#Username").val(),
		password : $("#Password").val()
	}
	$.ajax({
		type : 'POST',
		contentType : 'application/json',
		url : 'login',
		data : JSON.stringify(user),
		dataType : 'json',
		timeout : 100000,
		success : function(data) {
			window.location.href = "adminpage";
		},
		error : function(errorThrown) {
			console.log("ERROR: ", errorThrown);
			alert("Lỗi gì đó");
		}
	});
}
function chinhsuauser(id){
	window.location.href = "modifypage?username="+id;
}

