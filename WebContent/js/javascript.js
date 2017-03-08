$(document).ready(function(){
	$('.navbar .dropdown').on('mouseover', function() {
		$(this).attr('class','dropdown open');
	}).on('mouseout', function() {
		$(this).attr('class','dropdown');
	});
});

function emptyCheck(){
	if ($('#input_ID').val().length == 0) {
		alert("아이디가 입력되지 않았습니다.");
		loginform.inpID.focus();
		return false;
	}
	else if ($('#input_PW').val().length == 0) {
		alert("비밀번호가 입력되지 않았습니다.");
		loginform.inpPW.focus();
		return false;
	}
	else if($('#input_ID').val().length != 0 && $('#input_PW').val().length != 0){
	   $("#login_form").submit();
	}
}

function numCheck(str){
	var num_check = /^[0-9]*$/;
	if (num_check.test(str)) {	//숫자만 입력했을때
		return false;
	} else {	//숫자 이외에 입력했을떄
		return true;
	}
}

function idCheck(str){
	var idReg = /^[a-zA-Z]{1}[a-zA-Z0-9_]{5,15}/g;
	if (idReg.test(str)) {
		return false;
	} else {
		return true;
	}
}

function extensionCheck(obj){
	 if (!(/png|jpe?g|gif/i).test(obj.val())) {
         alert('확장자 .png, .jpg, .gif 만 가능합니다.');
         return false;            
     } else if (obj[0].files[0].size > 5242880) { // 5mb
         alert('용량 5MB 미만의 사진을 업로드해주세요.');
         return false;
     }else{
    	 return true;
     }
}

function submitPost(url, params) {
	var form = document.createElement("form");
	form.setAttribute("method", "POST");
	form.setAttribute("action", url);
	for (var key in params) {
		var hiddenField = document.createElement("input");
		hiddenField.setAttribute("type", "hidden");
		hiddenField.setAttribute("name", key);
		hiddenField.setAttribute("value", params[key]);
		form.appendChild(hiddenField);
	}
	document.body.appendChild(form);
	form.submit();
}

function pageBack(){
	window.history.back();
}


