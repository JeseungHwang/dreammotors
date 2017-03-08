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
        
<%if(session.getAttribute("UID") != null){
	response.sendRedirect("/mainview.do");
}if(request.getAttribute("CHECK") != null){
	if(request.getAttribute("CHECK").equals("in")){
		session.setAttribute("UID", request.getAttribute("UID"));
		session.setAttribute("UNM", request.getAttribute("UNM"));
		response.sendRedirect("/mainview.do");
	}
}%>
<%
	Cookie[] cookie = request.getCookies();
	String uid = "";
	if(cookie != null){
		for(int i=0;i<cookie.length; i++){
			if(cookie[i].getName().trim().equals("uid")){
				uid = cookie[i].getValue();
			}
		}
	}
%>
</head>
<body>
	<jsp:include page="header.jsp"/>
	<div class="container">
		<div class="login_form">
			<div class="field-container">
				<div class="form-container">
					<label class="form-title"><span class="span5">로그인</span></label>
					<input class="form-field" id="input_ID" type="text" name="inpID" placeholder="아이디 입력" size="20" value="<%=uid%>"/><br />
					<input class="form-field" id="input_PW" type="password" name="inpPW" placeholder="비밀번호 입력" /><br />
					<input type="hidden" id="rsaPublicKeyModulus" value="<%=request.getAttribute("publicKeyModulus")%>" />
	          		<input type="hidden" id="rsaPublicKeyExponent" value="<%=request.getAttribute("publicKeyExponent")%>" />
	          		<div class="field-checkbox">
						<label class="checkSaveID">
							<input class="remId" type="checkbox" name="remId" <%if(uid.length()>1)out.println("checked"); %>/> 아이디 저장
						</label>
					</div>
					<div class="submit_container">
						<input class="submit-button" type="button" value="Login"  onclick="validateEncryptedForm()"/>
					</div>
					<div class="find_container">
						<input class="btn btn-default" type="button" value="아이디  / 비밀번호 찾기"  onclick="findPage()"/>
					</div>
				</div>
				
			</div>
			
			
			<!-- </form> -->
			<form id="securedLoginForm" name="securedLoginForm" action="${pageContext.request.contextPath}/login.do" method="POST" style="display: none;">
	            <input type="hidden" name="securedUsername" id="securedUsername" value="" />
	            <input type="hidden" name="securedPassword" id="securedPassword" value="" />
	        </form>
			<%
			if(request.getAttribute("CHECK")!= null){%>
				<p id="notcorrect_message">아이디 또는 비밀번호가 틀렸습니다.</p>
			<%}%>
		</div>
	</div>
	</body>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/asset/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/javascript.js"></script>
	<script type="text/javascript">
	var isRemember;
	function validateEncryptedForm() {
	    var username = document.getElementById("input_ID").value;
	    var password = document.getElementById("input_PW").value;
	    if (!username || !password) {
	        alert("ID/비밀번호를 입력해주세요.");
	        return false;
	    }
	    try {
	        var rsaPublicKeyModulus = document.getElementById("rsaPublicKeyModulus").value;
	        var rsaPublicKeyExponent = document.getElementById("rsaPublicKeyExponent").value;
	        submitEncryptedForm(username,password, rsaPublicKeyModulus, rsaPublicKeyExponent);
	    } catch(err) {
	        alert(err);
	    }
	    return false;
	}
	function submitEncryptedForm(username, password, rsaPublicKeyModulus, rsaPpublicKeyExponent) {
	    var rsa = new RSAKey();
	    rsa.setPublic(rsaPublicKeyModulus, rsaPpublicKeyExponent);

	    // 사용자ID와 비밀번호를 RSA로 암호화한다.
	    var securedUsername = rsa.encrypt(username);
	    var securedPassword = rsa.encrypt(password);

	    // POST 로그인 폼에 값을 설정하고 발행(submit) 한다.
	    var securedLoginForm = document.getElementById("securedLoginForm");
	    securedLoginForm.securedUsername.value = securedUsername;
	    securedLoginForm.securedPassword.value = securedPassword;
    	if($("input:checkbox[name='remId']").is(":checked")){
    		isRemember = confirm("이 PC에 로그인 정보를 저장하시겠습니까? PC방등의 공공장소에서는 개인정보가 유출될 수 있으니 주의해주십시오.");
    	    if(isRemember){
    	    	saveLogin(document.getElementById("input_ID").value); 	
    	    }
 	    }else{
 		   saveLogin("");
 	    }
    	securedLoginForm.submit();
	}
	function saveLogin(id) {
        if (id != "") {		// userid 쿠키에 id 값을 7일간 저장
            setsave("uid", id, 1);
        } else {			// userid 쿠키 삭제
            setsave("uid", id, -1);
        }
    }
	function setsave(name, value, expiredays) {
		var today = new Date();
		today.setDate(today.getDate() + expiredays);
		document.cookie = name + "=" + escape(value) + "; path=/; expires=" + today.toGMTString() + ";";
    }
	function findPage(){
		document.location.href="/findform.do";
	}
	</script>
</html>