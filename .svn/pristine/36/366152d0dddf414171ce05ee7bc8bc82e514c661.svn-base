<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	request.setCharacterEncoding("UTF-8");	%>
<%@ page import="com.dreammotors.vo.MemberVO"%>
<% MemberVO vo = (MemberVO)request.getAttribute("RESULT"); %>
<?php header('Access-Control-Allow-Origin: *'); ?>
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
<%
	if(request.getAttribute("CHECK")!=null){
		if(request.getAttribute("CHECK").equals("msu")){%>
			<script type="text/javascript">alert("정보가 수정되었습니다.");</script>
		<%}
	}
%>
</head>
<body>
	<jsp:include page="header.jsp"/>
	<div class="container">
		<div class="mainbanner">
			<img class="mainImg" src="img/banner/banner_main2.png">
		</div>
		<div class="directory-label">
			<label class="control-label"><span class="glyphicon glyphicon-home" aria-hidden="true"></span> 메인 화면 <span class="glyphicon glyphicon-menu-right" aria-hidden="true"></span> 내 정보 </label>
		</div>
		<div class="signin-field-container">
			<div class="sign-form">
				<div id="info-label-form"><span id="info-label">ID</span></div>
				<div id="info-context">
					<input type="text" class="info-wContent" id="myin-id" name="inpID" size="20" readonly="readonly" value="<%=vo.getMemId()%>"/>
				</div>
			</div>
			<input type="hidden" id="rsaPublicKeyModulus" value="<%=request.getAttribute("publicKeyModulus")%>" />
         		<input type="hidden" id="rsaPublicKeyExponent" value="<%=request.getAttribute("publicKeyExponent")%>" />
			
			<div class="sign-form">
				<div id="info-label-form"><span id="info-label">변경하실 비밀번호</span></div>
				<div id="info-context">
					<input type="password" class="info-wContent" id="myin-pw" name="inpPW"/>
					<p id="myin-pw-help"></p>
				</div>
			</div>
			
			<div class="sign-form">
				<div id="info-label-form"><span id="info-label">이름</span></div>
				<div id="info-context">
					<input type="text" class="info-wContent" id="myin-nm" name="inpNm" readonly="readonly" value="<%=vo.getMemName()%>"/>
					<p id="myin-nm-help"></p>
				</div>
			</div>
			
			<div class="sign-form">
				<div id="info-label-form"><span id="info-label">닉네임</span></div>
				<div id="info-context">
					<input type="text" class="info-wContent" id="myin-nick" name="inpNick" value="<%=vo.getMemNick()%>"/>
					<p id="myin-nick-help"></p>
				</div>
			</div>
			
			<div class="sign-form">
				<div id="info-label-form"><span id="info-label">E-mail</span></div>
				<div id="info-context">
					<input type="email" class="info-wContent" id="myin-email" name="inpEmail" value="<%=vo.getMemEmail()%>"/>
					<p id="myin-email-help"></p>
				</div>
			</div>
			
			<div class="sign-form">
				<div id="info-label-form"><span id="info-label">전화번호</span></div>
				<div id="info-context">
					<input type="tel" class="info-wContent" id="myin-tell" name="inpTell" maxlength="11" value="<%=vo.getMemTell()%>"/>
					<p id="myin-tell-help"></p>
				</div>
			</div>
			
			<div class="sign-form">
				<div id="info-label-form"><span id="info-label">주소</span></div>
				<div id="info-context">
					<input type="text" class="info-wContent" id="myin-addr" name="inpAddr" value="<%=vo.getMemAddr()%>"/>
					<p id="myin-addr-help"></p>
				</div>
			</div>
			
			<div class="sign-form">
				<div id="info-label-form"><span id="info-label">회원가입 날짜</span></div>
				<div id="info-context">
					<input type="text" class="info-wContent" id="myin-regDate" name="regDate" value="<%=vo.getMemRegDateTime()%>" readonly="readonly"/>
					<p id="myin-addr-help"></p>
				</div>
			</div>
			<div class="sign-form">
				<input type="button" class="brd-btn btn btn-danger" id="btn-signin" value="정보 수정" onclick="emptyCheck()" >
			</div>
				
			<form id="securedInfoModifyForm" name="securedInfoModifyForm" action="${pageContext.request.contextPath}/infomodify.do" method="POST" style="display: none;">
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
		var isEmpty=[false,false,false,false,false];
		function emptyCheck(){
		    $('p#myin-pw-help').html('');
		    $('p#myin-nm-help').html('');
		    $('p#myin-nick-help').html('');
		    $('p#myin-email-help').html('');
		    $('p#myin-tell-help').html('');
		    $('p#myin-addr-help').html('');
		    
		    if($('input#myin-pw').val().trim() != ""){
		    	if($('input#myin-pw').val().trim().length<6){		//길이 미만
		    		$('p#myin-pw-help').html('비밀번호를 6자 이상입력해주세요.').css('color','red');
		    	}
		    }
		    if($('input#myin-nm').val().trim() == ""){
		    	$('p#myin-nm-help').html('이름을 입력해주세요.').css('color','red');
		    	isEmpty[0] = false;
		    }else{
		    	isEmpty[0] = true;
		    }
		    if($('input#myin-nick').val().trim() == ""){
		    	$('p#myin-nick-help').html('닉네임을 입력해주세요.').css('color','red');
		    	isEmpty[1] = false;
		    }else{
		    	isEmpty[1] = true;
		    }
		    if($('input#myin-email').val().trim() == ""){
		    	$('p#myin-email-help').html('E-Mail 주소를 입력해주세요.').css('color','red');
		    	isEmpty[2] = false;
		    }else{
		    	isEmpty[2] = true;
		    }
		    if($('input#myin-tell').val().trim() == ""){
		    	$('p#myin-tell-help').html('전화번호를 입력해주세요.').css('color','red');
		    	isEmpty[3] = false;
		    }else{
		    	isEmpty[3] = false;
		    	if(numCheck($('input#myin-tell').val().trim())){		//숫자외 입력
			    	$('p#myin-tell-help').html('번호(숫자)만 입력해주세요.').css('color','red');
			 	}else{
			    	if($('input#myin-tell').val().trim().length<11){		//길이 미만
				    	$('p#myin-tell-help').html('연락처를 정확하게 입력해주세요.').css('color','red');
				   	}else{
				   		isEmpty[3] = true;
				   	}
			 	}
		    }
		    if($('input#myin-addr').val().trim() == ""){
		    	$('p#myin-addr-help').html('주소를 입력해주세요.').css('color','red');
		    	isEmpty[4] = false;
		    }else{
		    	isEmpty[4] = true;
		    }
		    
		    if(isEmpty.every(Boolean)){
		    	if(!confirm("내 정보를 수정하시겠습니까?")){
					return
				}else{
					validateEncryptedForm();
				}
		    }
		}
		function validateEncryptedForm() {
			var ud = document.getElementById("myin-id").value;
		    var pa = document.getElementById("myin-pw").value;
		    var nm = document.getElementById("myin-nm").value;
		    var ni = document.getElementById("myin-nick").value;
		    var em = document.getElementById("myin-email").value;
		    var te = document.getElementById("myin-tell").value;
		    var ad = document.getElementById("myin-addr").value;
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
		    var securedInfoModifyForm = document.getElementById("securedInfoModifyForm");
		    securedInfoModifyForm.securedId.value = securedId;
		    securedInfoModifyForm.securedPassword.value = securedPassword;
		    securedInfoModifyForm.securedName.value = securedName;
		    securedInfoModifyForm.securedNick.value = securedNick;
		    securedInfoModifyForm.securedEmail.value = securedEmail;
		    securedInfoModifyForm.securedTell.value = securedTell;
		    securedInfoModifyForm.securedAddr.value = securedAddr;
		    securedInfoModifyForm.submit();
		}
	</script>
</html>