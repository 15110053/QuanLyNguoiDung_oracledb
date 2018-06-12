/**
 * 
 */
function deleteprofile(profilename) {
	var profilename = profilename;
	$.ajax({
		type : 'GET',
		contentType : 'application/json',
		url : 'deleteprofile',
		data : {
			profilename : profilename
		},
		dataType : 'json',
		timeout : 100000,
		success : function(data) { // hàm được thực thi khi request thực hiện
									// thành công
			location.reload();
		},
		error : function(errorThrown) { // hàm được thực thi khi request thất
										// bại
			console.log("ERROR: ", errorThrown);
			alert("Lỗi gì đó");
		}
	});
}
function chinhsuaprofile(id){
	$("#ct_"+id).replaceWith("<input class=\"form-control\" type = \"number\" id=\"mct_"+id+"\" value = \""+$("#ct_"+id).text()+"\">");
	$("#it_"+id).replaceWith("<input class=\"form-control\" type = \"number\" id=\"mit_"+id+"\" value = \""+$("#it_"+id).text()+"\">");
	$("#spu_"+id).replaceWith("<input class=\"form-control\" type = \"number\" id=\"mspu_"+id+"\" value = \""+$("#spu_"+id).text()+"\">");
	$("#d_sua_"+id).append("<a href=\"javascript:luubtn('"+id+"')\" id=\"luu_"+id+"\">Lưu</a>");
	$("#edit_"+id).fadeOut();
}
function luubtn(id){
	$("#edit_"+id).fadeIn();
	$("#luu_"+id).fadeOut();
	luu(id);
}
function luu(id){
	var ct = $("#mct_"+id).val();
	var it = $("#mit_"+id).val();
	var spu = $("#mspu_"+id).val();
	$.ajax({
		type : 'GET',
		contentType : 'application/json',
		url : 'modifyprofile',
		data : {
			profilename : id,
			ct : ct,
			it : it,
			spu : spu
		},
		dataType : 'json',
		timeout : 100000,
		success : function(data) { // hàm được thực thi khi request thực hiện
									// thành công
			location.reload();
		},
		error : function(errorThrown) { // hàm được thực thi khi request thất
										// bại
			console.log("ERROR: ", errorThrown);
			alert("Lỗi gì đó");
		}
	});
}
function openformadd(){
	$("#buttonopen").fadeOut();
	$("#formtaoprofile").fadeOut();
}
function addprofile(){
	var profilename = $("#profilename").val();
	var ct = $("#add_ct").val();
	var it = $("#add_it").val();
	var spu = $("#add_spu").val();
	$.ajax({
		type : 'GET',
		contentType : 'application/json',
		url : 'addprofile',
		data : {
			profilename : profilename,
			ct : ct,
			it : it,
			spu : spu
		},
		dataType : 'json',
		timeout : 100000,
		success : function(data) { // hàm được thực thi khi request thực hiện
									// thành công
			location.reload();
		},
		error : function(errorThrown) { // hàm được thực thi khi request thất
										// bại
			console.log("ERROR: ", errorThrown);
			alert("Lỗi gì đó");
		}
	});
}