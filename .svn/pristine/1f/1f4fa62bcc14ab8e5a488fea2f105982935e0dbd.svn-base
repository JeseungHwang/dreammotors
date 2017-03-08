<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	request.setCharacterEncoding("UTF-8");	%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ko">
<head>
<!--[if lt IE 9]>
<script src="//html5shiv.googlecode.com/svn/trunk/html5.js"></script>
<script src="http://ie7-js.googlecode.com/svn/version/2.1(beta4)/IE9.js"></script>
<![endif]-->
<!--[if lt IE 8]>
<script src="http://ie7-js.googlecode.com/svn/version/2.1(beta4)/IE8.js"></script>
<![endif]-->
<!--[if lt IE 7]>
<script src="http://ie7-js.googlecode.com/svn/version/2.1(beta4)/IE7.js"></script>
<![endif]-->
<!--[if lt IE 9]>
 <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
<![endif]-->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Dream Motors</title>
<link href="${pageContext.request.contextPath}/asset/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/main.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/tbmenu.css" rel="stylesheet">
<script type="text/javascript" src="<%=request.getContextPath()%>/js/rsa/jsbn.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/rsa/rsa.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/rsa/prng4.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/rsa/rng.js"></script>
</head>
<body>
	<jsp:include page="header.jsp"/>
	<div class="container">
		<div class="directory-label">
			<label class="control-label"><span class="glyphicon glyphicon-home" aria-hidden="true"></span> 약관동의 <span class="glyphicon glyphicon-menu-right" aria-hidden="true"></span> <span class="span4">회원정보 입력</span> <span class="glyphicon glyphicon-menu-right" aria-hidden="true"></span> 회원가입 완료</label>
		</div>
		
		<div style="width: 100%; text-align: center; margin-bottom: 40px;">
			<img src="img/banner/family_sign2.jpg">
		</div>
			
		<div class="signin-field-container">
			<%-- <form id="signin_form" action="${pageContext.request.contextPath}/signin.do" method="POST" accept-charset="utf-8" class="form-horizontal" name="signinform"> --%>
				<div class="sign-form">
					<div id="sign-label-form"><span id="info-label">ID</span></div>
					<div id="sign-context">
						<input type="text" class="sign-wContent" id="sign-id" name="inpID" size="20"/>
						<p id="sign-id-help">5~15자 내외의 영어, 숫자만 사용</p>
					</div>
					<div id="sign-context2">
						<input type="button" class="brd-btn" id="btn-idcheck" value="중복 확인" onclick="idcheck()" />
						<p id="sign-idcheck-help"></p>
					</div>
				</div>
				<input type="hidden" id="rsaPublicKeyModulus" value="<%=request.getAttribute("publicKeyModulus")%>" />
          		<input type="hidden" id="rsaPublicKeyExponent" value="<%=request.getAttribute("publicKeyExponent")%>" />
				<div class="sign-form">
					<div id="sign-label-form"><span id="info-label">비밀번호</span></div>
					<div id="sign-context">
						<input type="password" class="sign-wContent" id="sign-pw" name="inpPW"/>
						<p id="sign-pw-help"></p>
					</div>
				</div>
				
				<div class="sign-form">
					<div id="sign-label-form"><span id="info-label">비밀헌호 재입력</span></div>
					<div id="sign-context">
						<input type="password" class="sign-wContent" id="sign-pw2" name="inpPW2"/>
						<p id="sign-pw2-help"></p>
					</div>
				</div>
				
				<div class="sign-form">
					<div id="sign-label-form"><span id="info-label">이름</span></div>
					<div id="sign-context">
						<input type="text" class="sign-wContent" id="sign-nm" name="inpNm"/>
						<p id="sign-nm-help"></p>
					</div>
				</div>
				
				<div class="sign-form">
					<div id="sign-label-form"><span id="info-label">닉네임</span></div>
					<div id="sign-context">
						<input type="text" class="sign-wContent" id="sign-nick" name="inpNick"/>
						<p id="sign-nick-help"></p>
					</div>
				</div>
				
				<div class="sign-form">
					<div id="sign-label-form"><span id="info-label">E-mail</span></div>
					<div id="sign-context">
						<input type="email" class="sign-wContent" id="sign-email" name="inpEmail"/>
						<p id="sign-email-help"></p>
					</div>
				</div>
				
				<div class="sign-form">
					<div id="sign-label-form"><span id="info-label">전화번호</span></div>
					<div id="sign-context">
						<input type="tel" class="sign-wContent" id="sign-tell" name="inpTell" maxlength="11"/>
						<p id="sign-tell-help"></p>
					</div>
				</div>
				
				<div class="sign-form">
					<div id="sign-label-form"><span id="info-label">주소</span></div>
					<div id="sign-context">
						<input type="text" class="sign-wContent" id="sign-addr" name="inpAddr"/>
						<p id="sign-addr-help"></p>
					</div>
				</div>
				<div class="sign-form">
					<input type="button" class="brd-btn btn btn-danger" id="btn-signin" value="회원 가입" onclick="emptyCheck()" >
					<input type="button" class="brd-btn btn btn-default" id="btn-cancle" value="취소" onclick="pageBack()" >
				</div>
				
			<form id="securedSigninForm" name="securedSigninForm" action="${pageContext.request.contextPath}/signin.do" method="POST" style="display: none;">
	            <input type="hidden" name="securedId" id="securedId" value="" />
	            <input type="hidden" name="securedPassword" id="securedPassword" value="" />
	            <input type="hidden" name="securedName" id="securedName" value="" />
	            <input type="hidden" name="securedNick" id="securedNick" value="" />
	            <input type="hidden" name="securedEmail" id="securedEmail" value="" />
	            <input type="hidden" name="securedTell" id="securedTell" value="" />
	            <input type="hidden" name="securedAddr" id="securedAddr" value="" />
	        </form>
		</div>
	</div>
	<jsp:include page="footer.jsp"/>
	</body>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/asset/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/javascript.js"></script>
	<script type="text/javascript">
		var isEmpty=[false,false,false,false,false,false,false,false];
		function emptyCheck(){
			$('p#sign-id-help').html('');
		    $('p#sign-idcheck-help').html('');
		    $('p#sign-pw-help').html('');
		    $('p#sign-pw2-help').html('');
		    $('p#sign-nm-help').html('');
		    $('p#sign-nick-help').html('');
		    $('p#sign-email-help').html('');
		    $('p#sign-tell-help').html('');
		    $('p#sign-addr-help').html('');
		    
		    if($.trim($('input#sign-id').val()) == ""){
		    	$('p#sign-id-help').html('ID을 입력해주세요.').css('color','red');
		    	isEmpty[0] = false;
		    }else{
		    	if(idCheck($.trim($('input#sign-id').val()))){		//숫자외 입력
			    	$('p#sign-id-help').html('첫글자는 영어로 시작해야하며 특수문자는 사용 할 수 없습니다.').css('color','red');
			 	}else if($.trim($('input#sign-id').val()).length<5 || $.trim($('input#sign-id').val()).length>15){		//길이 미만
			    	$('p#sign-id-help').html('아이디는 5 ~ 20자 내외이어야 합니다.').css('color','red');
			   	}else{
			    	if(!isEmpty[0]){
				   		$('p#sign-id-help').html('ID 중복체크를 해주세요.').css('color','red');
				   	}
			 	}
		    }
		    if($.trim($('input#sign-pw').val()) == ""){
		    	$('p#sign-pw-help').html('비밀번호를 입력해주세요.').css('color','red');
		    	isEmpty[1] = false;
		    }else{
		    	if($.trim($('input#sign-pw').val()).length<6){		//길이 미만
		    		$('p#sign-pw-help').html('비밀번호를 6자 이상입력해주세요.').css('color','red');
		    	}else{
		    		isEmpty[1] = true;	
		    	}
		    }
		    if($.trim($('input#sign-pw2').val()) == ""){
		    	$('p#sign-pw2-help').html('비밀번호를 입력해주세요.').css('color','red');
		    	isEmpty[2] = false;
		    }else{
		    	if($.trim($('input#sign-pw2').val()) != $.trim($('input#sign-pw').val())){
		    		$('p#sign-pw2-help').html('비밀번호가 일치하지 않습니다.').css('color','red');
		    	}else if($.trim($('input#sign-pw2').val()) == $.trim($('input#sign-pw').val())){
		    		isEmpty[2] = true;
		    	}
		    }
		    if($.trim($('input#sign-nm').val()) == ""){
		    	$('p#sign-nm-help').html('이름을 입력해주세요.').css('color','red');
		    	isEmpty[3] = false;
		    }else{
		    	isEmpty[3] = true;
		    }
		    if($.trim($('input#sign-nick').val()) == ""){
		    	$('p#sign-nick-help').html('닉네임을 입력해주세요.').css('color','red');
		    	isEmpty[4] = false;
		    }else{
		    	isEmpty[4] = true;
		    }
		    if($.trim($('input#sign-email').val()) == ""){
		    	$('p#sign-email-help').html('E-Mail 주소를 입력해주세요.').css('color','red');
		    	isEmpty[5] = false;
		    }else{
		    	isEmpty[5] = true;
		    }
		    if($.trim($('input#sign-tell').val()) == ""){
		    	$('p#sign-tell-help').html('전화번호를 입력해주세요.').css('color','red');
		    	isEmpty[6] = false;
		    }else{
		    	isEmpty[6] = false;
		    	if(numCheck($.trim($('input#sign-tell').val()))){		//숫자외 입력
			    	$('p#sign-tell-help').html('번호(숫자)만 입력해주세요.').css('color','red');
			 	}else{
			    	if($.trim($('input#sign-tell').val()).length<11){		//길이 미만
				    	$('p#sign-tell-help').html('연락처를 정확하게 입력해주세요.').css('color','red');
				   	}else{
				   		isEmpty[6] = true;
				   	}
			 	}
		    }
		    if($.trim($('input#sign-addr').val()) == ""){
		    	$('p#sign-addr-help').html('주소를 입력해주세요.').css('color','red');
		    	isEmpty[7] = false;
		    }else{
		    	isEmpty[7] = true;
		    }
		    
		    if(isEmpty[0]&&isEmpty[1]&&isEmpty[2]&&isEmpty[3]&&isEmpty[4]&&isEmpty[5]&&isEmpty[6]&&isEmpty[7]){
		    	validateEncryptedForm();
		    }
		}
		function idcheck(){
			if($.trim($('input#sign-id').val()) == ""){
		    	$('p#sign-id-help').html('ID을 입력해주세요.').css('color','red');
		    }else{
		    	if(idCheck($.trim($('input#sign-id').val()))){		//숫자외 입력
			    	$('p#sign-id-help').html('첫글자는 영어로 시작해야하며 특수문자는 사용 할 수 없습니다.').css('color','red');
			 	}else{
			    	if($.trim($('input#sign-id').val()).length<5 || $.trim($('input#sign-id').val()).length>15){		//길이 미만
				    	$('p#sign-id-help').html('아이디는 5 ~ 20자 내외이어야 합니다.').css('color','red');
				   	}else{
				   		$.ajax({
				            url:'${pageContext.request.contextPath}/idcheck.do',
				            type:'POST',
				            data: { UID: $('input#sign-id').val() },
				            dataType:'json',
				            success:function(data){
				              if(data.CHECK=="ava"){
				            	  $('p#sign-id-help').html('사용 가능한 ID 입니다.').css('color','blue');
				            	  isEmpty[0] = true;
				              }else{
				            	  $('p#sign-id-help').html('중복되는 ID입니다.').css('color','red');
				              }
				            }, error : function (xhr, ajaxoptions, thrownError) {
							  
						  	}
				        })
				   	}
			 	}
		    }
		}
		
		function validateEncryptedForm() {
		    var ud = document.getElementById("sign-id").value;
		    var pa = document.getElementById("sign-pw").value;
		    var nm = document.getElementById("sign-nm").value;
		    var ni = document.getElementById("sign-nick").value;
		    var em = document.getElementById("sign-email").value;
		    var te = document.getElementById("sign-tell").value;
		    var ad = document.getElementById("sign-addr").value;
		    try {
		        var rsaPublicKeyModulus = document.getElementById("rsaPublicKeyModulus").value;
		        var rsaPublicKeyExponent = document.getElementById("rsaPublicKeyExponent").value;
		        submitEncryptedForm(ud,pa,nm,ni,em,te,ad,rsaPublicKeyModulus, rsaPublicKeyExponent);
		    } catch(err) {
		        alert(err);
		    }
		    return false;
		}
		function submitEncryptedForm(ud,pa,nm,ni,em,te,ad, rsaPublicKeyModulus, rsaPublicKeyExponent) {
		    var rsa = new RSAKey();
		    rsa.setPublic(rsaPublicKeyModulus, rsaPublicKeyExponent);

		    // 사용자ID와 비밀번호를 RSA로 암호화한다.
		    var securedId = rsa.encrypt(ud);
		    var securedPassword = rsa.encrypt(pa);
		    var securedName = rsa.encrypt(nm);
		    var securedNick = rsa.encrypt(ni);
		    var securedEmail = rsa.encrypt(em);
		    var securedTell = rsa.encrypt(te);
		    var securedAddr = rsa.encrypt(ad);
		    // POST 로그인 폼에 값을 설정하고 발행(submit) 한다.
		    var securedSigninForm = document.getElementById("securedSigninForm");
		    securedSigninForm.securedId.value = securedId;
		    securedSigninForm.securedPassword.value = securedPassword;
		    securedSigninForm.securedName.value = securedName;
		    securedSigninForm.securedNick.value = securedNick;
		    securedSigninForm.securedEmail.value = securedEmail;
		    securedSigninForm.securedTell.value = securedTell;
		    securedSigninForm.securedAddr.value = securedAddr;
		    securedSigninForm.submit();
		}
	</script>
</html>