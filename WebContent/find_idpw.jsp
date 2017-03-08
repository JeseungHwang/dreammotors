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
	<div class="modal fade bs-example-modal-sm" id="findIDModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
			<form action="family_insert.do" class="form-horizontal" id="addfamily-Form" method="POST" enctype="multipart/form-data">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
					<h4 class="modal-title" id="myModalLabel">아이디 검색 결과</h4>
				</div>
				<div class="modal-body">
					<div class="form-group">
						<label class="col-sm-2 control-label">아이디</label>
						<div class="col-sm-5">
							<label class="col-sm-5 control-label" id="searchID" value=""></label>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
				</div>
				</form>
			</div>
		</div>
	</div>
	<div class="modal fade bs-example-modal-sm" id="findPWModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
					<h4 class="modal-title" id="myModalLabel">비밀번호 변경</h4>
				</div>
				<div class="modal-body">
					<div class="form-group2">
						<label class="col-sm-3 control-label">변경할 비밀번호</label>
						<div class="col-sm-5">
							<input type="password" class="form-control" name="cmppw1" id="cmppw1">
							<p id="pw-help1"></p>
						</div>
					</div>
					<div class="form-group2">
						<label class="col-sm-3 control-label">비밀번호 재입력</label>
						<div class="col-sm-5">
							<input type="password" class="form-control" name="cmppw2" id="cmppw2">
							<p id="pw-help2"></p>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-danger" onclick="mofidyPW()">비밀번호 변경</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
				</div>
				<form id="securedModifyPWForm" name="securedModifyPWForm" action="${pageContext.request.contextPath}/ModifyPW.do" method="POST" style="display: none;">
					<input type="hidden" name="securedID" id="securedID" value="" />
		            <input type="hidden" name="securedPW" id="securedPW" value="" />
		        </form>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="idfind">			
			<div class="find-form">
				<div class="find_img">
					<img src="img/banner/findid.png">
				</div>
				<div class="form-group2">
					<div class="find_form1">
						<label class="control-label2" >이름</label>
					</div>
					<div class="find_form2">
						<input type="text" class="form-control" id="input_Nm1" name="inpNm" placeholder="이름 입력">
					</div>
				</div>
				
				<div class="form-group2">
					<div class="find_form1">
						<label class="control-label2">E-Mail 주소</label>
					</div>
					<div class="find_form2">
						<input type="text" class="form-control" id="input_Email1" name="inpEmail" placeholder="E-Mail 입력">
					</div>
				</div>
				
				<input type="hidden" id="rsaPublicKeyModulus" value="<%=request.getAttribute("publicKeyModulus")%>" />
          		<input type="hidden" id="rsaPublicKeyExponent" value="<%=request.getAttribute("publicKeyExponent")%>" />
				<div class="idpwfinder-container">
					<input class="btn btn-danger" type="button" value="아이디 찾기" id="btn_find_id" onclick="findIdCheck()"/>
				</div>
			</div>
			<form id="securedIdForm" name="securedIdForm" action="${pageContext.request.contextPath}/findID.do" method="POST" style="display: none;">
	            <input type="hidden" name="securedName" id="securedName" value="" />
	            <input type="hidden" name="securedEmail" id="securedEmail" value="" />
	        </form>
		</div>
		
		<div class="pwfind">			
			<div class="find-form">
				<div class="find_img">
					<img src="img/banner/findpw.png">
				</div>
				<div class="form-group2">
					<div class="find_form1">
						<label class="control-label2">아이디</label>
					</div>
					<div class="find_form2">
						<input type="text" class="form-control" id="input_ID2" name="inpID" placeholder="아이디 입력">
					</div>
				</div>
				
				<div class="form-group2">
					<div class="find_form1">
						<label class="control-label2">이름</label>
					</div>
					<div class="find_form2">
						<input type="text" class="form-control" id="input_Nm2" name="inpNm" placeholder="이름 입력">
					</div>
				</div>
				
				<div class="form-group2">
					<div class="find_form1">
						<label class="control-label2">E-Mail 주소</label>
					</div>
					<div class="find_form2">
						<input type="text" class="form-control" id="input_Email2" name="inpEmail" placeholder="E-Mail 입력">
					</div>
				</div>
				<div class="idpwfinder-container">
					<input class="btn btn-danger" type="button" value="비밀번호 찾기" id="btn_find_id" onclick="findPwCheck()"/>
				</div>
			</div>
			<form id="securedPwForm" name="securedPwForm" action="${pageContext.request.contextPath}/findPW.do" method="POST" style="display: none;">
	            <input type="hidden" name="securedId" id="securedId" value="" />
	            <input type="hidden" name="securedName" id="securedName" value="" />
	            <input type="hidden" name="securedEmail" id="securedEmail" value="" />
	        </form>
		</div>
	</div>
	<jsp:include page="footer.jsp"/>
	</body>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/asset/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/javascript.js"></script>
	<script type="text/javascript">
	function findIdCheck(){
	    try {
	        var rsaPublicKeyModulus = document.getElementById("rsaPublicKeyModulus").value;
	        var rsaPublicKeyExponent = document.getElementById("rsaPublicKeyExponent").value;
	         var rsa = new RSAKey();
		    rsa.setPublic(rsaPublicKeyModulus, rsaPublicKeyExponent);
		    // 사용자ID와 비밀번호를 RSA로 암호화한다.
		    var securedName = rsa.encrypt(document.getElementById("input_Nm1").value);
		    var securedEmail = rsa.encrypt(document.getElementById("input_Email1").value);
		    // POST 로그인 폼에 값을 설정하고 발행(submit) 한다.
		    var securedIdForm = document.getElementById("securedIdForm");
		    securedIdForm.securedName.value = securedName;
		    securedIdForm.securedEmail.value = securedEmail;
		    securedIdForm.submit();
	    } catch(err) {
	        alert(err);
	    }
	    return false;
	}
	function findPwCheck(){
		  try {
		        var rsaPublicKeyModulus = document.getElementById("rsaPublicKeyModulus").value;
		        var rsaPublicKeyExponent = document.getElementById("rsaPublicKeyExponent").value;
		         var rsa = new RSAKey();
			    rsa.setPublic(rsaPublicKeyModulus, rsaPublicKeyExponent);
			    // 사용자ID와 비밀번호를 RSA로 암호화한다.
			    var securedId = rsa.encrypt(document.getElementById("input_ID2").value);
			    var securedName = rsa.encrypt(document.getElementById("input_Nm2").value);
			    var securedEmail = rsa.encrypt(document.getElementById("input_Email2").value);
			    // POST 로그인 폼에 값을 설정하고 발행(submit) 한다.
			    var securedPwForm = document.getElementById("securedPwForm");
			    securedPwForm.securedId.value = securedId;
			    securedPwForm.securedName.value = securedName;
			    securedPwForm.securedEmail.value = securedEmail;
			    securedPwForm.submit();
		    } catch(err) {
		        alert(err);
		    }
		    return false;
	}
	function mofidyPW(){
		var cmppw1 = document.getElementById("cmppw1").value;
		var cmppw2 = document.getElementById("cmppw2").value;
		var userID = document.getElementById("securedID").value;
		if (cmppw1 != cmppw2) {
			alert("변경하실 비밀번호가 일치하지 않습니다.");
	        return false;
	    }else if(cmppw1 == cmppw2){
	    	try {
		        var rsaPublicKeyModulus = document.getElementById("rsaPublicKeyModulus").value;
		        var rsaPublicKeyExponent = document.getElementById("rsaPublicKeyExponent").value;
		         var rsa = new RSAKey();
			    rsa.setPublic(rsaPublicKeyModulus, rsaPublicKeyExponent);
			    // 사용자ID와 비밀번호를 RSA로 암호화한다.
			    var securedID = rsa.encrypt(userID);
			    var securedPW = rsa.encrypt(cmppw1);
			    // POST 로그인 폼에 값을 설정하고 발행(submit) 한다.
			    var securedModifyPWForm = document.getElementById("securedModifyPWForm");
			    securedModifyPWForm.securedID.value = securedID;
			    securedModifyPWForm.securedPW.value = securedPW;
			    securedModifyPWForm.submit();
		    } catch(err) {
		        alert(err);
		    }
	   		return false; 
	    }
	}
	</script>
	<% if(request.getAttribute("CHECK") != null){
		if(request.getAttribute("CHECK").equals("inex")){%>
			<script type="text/javascript">alert("회원 정보가 없습니다. 다시 입력해주세요.");</script>
		<%}else if(request.getAttribute("CHECK").equals("iex")){%>
			<script type="text/javascript">
				$('#findIDModal').modal('show');
				$('#searchID').text("<%=request.getAttribute("RESULT")%>");
			</script>
		<%}
		if(request.getAttribute("CHECK").equals("pnex")){%>
			<script type="text/javascript">alert("일치하는 회원 정보가 없습니다. 다시 입력해주세요.");</script>
		<%}else if(request.getAttribute("CHECK").equals("pex")){%>
			<script type="text/javascript">
				$('#findPWModal').modal('show');
				document.getElementById("securedModifyPWForm").securedID.value = <%=request.getAttribute("RESULT")%>;
			</script>
		<%}
		if(request.getAttribute("CHECK").equals("usu")){%>
			<script type="text/javascript">alert("비밀번호가 수정되었습니다.");document.location.href="/mainview.do";</script>
		<%}
	}%>
</html>