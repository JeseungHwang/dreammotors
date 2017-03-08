<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	request.setCharacterEncoding("UTF-8");	%>
<%@ page import="java.util.*,com.dreammotors.vo.MemberVO"%>
<%	MemberVO vo = null;
	if(request.getAttribute("RESULT") != null){
		vo = (MemberVO)request.getAttribute("RESULT"); 
	}
%>
<%if(request.getAttribute("CHECK")!=null){
	if(request.getAttribute("CHECK").equals("isu")){%>
		<script type="text/javascript">
		alert("작성하신 글 등록하였습니다.");
		location.href = "${pageContext.request.contextPath}/cubrd.do"; </script>
	<%}
}%>
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
</head>
<body>
	<jsp:include page="ad_header.jsp"/>
	<div class="container">
		<div class="mainbanner">
			<img class="mainImg" src="img/banner/banner_main2.png">
		</div>
		<div class="directory-label">
			<label class="control-label"><span class="glyphicon glyphicon-home" aria-hidden="true"></span> 커뮤니티 <span class="glyphicon glyphicon-menu-right" aria-hidden="true"></span> 고객 후기<span class="glyphicon glyphicon-menu-right" aria-hidden="true"></span> 글작성</label>
		</div>
		<div id="left-menuform">
			<div class="sidebar">
				<ul class="nav nav-sidebar">
					<li class="sidebar-brand">커뮤니티</li>
					<li><a href="${pageContext.request.contextPath}/nobrd.do">공지사항 <span class="glyphicon glyphicon-menu-right" id="left_menu_arrow" aria-hidden="true"></span></a></li>
					<li><a href="${pageContext.request.contextPath}/rebrd.do">차량 판매 후기 <span class="glyphicon glyphicon-menu-right" id="left_menu_arrow" aria-hidden="true"></span></a></li>
					<li><a href="${pageContext.request.contextPath}/cubrd.do">고객 후기 <span class="glyphicon glyphicon-menu-right" id="left_menu_arrow" aria-hidden="true"></span></a></li>
				</ul>
			</div>
			<div class="left-banner">
				<div class="banner_img">
					<a href="${pageContext.request.contextPath}/process.do"><img class="brd_banner" src="img/banner/brd_process.png"></a>
				</div>
			</div>
			<div class="left-banner">
				<div class="banner_img">
					<img class="brd_banner" src="img/banner/brd_tell.png">
				</div>
			</div>
			<div class="left-banner">
				<div class="banner_img">
					<img class="brd_banner" src="img/banner/brd_kakao.png">
				</div>
			</div>
		</div>
		
		
		<div id="right-conentform">
			<form action="${pageContext.request.contextPath}/cubrd_write.do" class="form-horizontal" id="cubrd-writeForm" method="POST">
				<div id="brd-form-group">
					<div id="brd-label-form"><span id="brd-label">제목</span></div>
					<div id="brd-context">
						<input type="text" class="brd-wTitle" id="cuboard-wTitle" name="inpTitle" autofocus>
						<p id="cub-title-help"></p>
					</div>
				</div>
				<div id="brd-form-group">
					<div id="brd-label-form"><span id="brd-label">이름</span></div>
					<div id="brd-context">
						<input type="text" class="brd-wNm" id="cuboard-wNm" name="inpNm" <%if(request.getAttribute("RESULT") != null){%>value="<%=vo.getMemName()%>"<%}%>>
						<p id="cub-nm-help"></p>
					</div>
				</div>
				<div id="brd-form-group">
					<div id="brd-label-form"><span id="brd-label">연락처</span></div>
					<div id="brd-context">
						<input type="text" class="brd-wTell" id="cuboard-wTell" placeholder="- (하이픈) 없이 입력해주세요" name="inpTell" maxlength="11" <%if(request.getAttribute("RESULT") != null){%>value="<%=vo.getMemTell()%>"<%}%>>
						<p id="cub-tell-help"></p>
					</div>
				</div>
				<div id="brd-form-group1">
					<div id="brd-label-form"></div>
					<div id="brd-context">
						<textarea name="inpContent" id="cuboard-wCntnt" rows="10" cols="100" style="width:100%; height:412px; display:none;"></textarea>
					</div>
				</div>
				<div id="brd-form-group">
					<div id="brd-label-form"><span id="brd-label">비밀번호</span></div>
					<div id="brd-context">
						<input type="password" class="brd-wPw" id="cuboard-wPw" name="inpPw">
						<p id="cub-pw-help"></p>
					</div>
				</div>
				<div id="brd-form-group2">
					<input class="brd-btn btn btn-danger" type="submit" value="등록"  />
					<input class="brd-btn btn btn-default" type="button" value="취소" onclick="pageBack()" />
					<%  if(session.getAttribute("UID") != null){%>
					<input type="hidden" name="uid" value="<%= (String)session.getAttribute("UID")%>">
					<%}else{%>
					<input type="hidden" name="uid" value="null">
					<%} %>
				</div>
			</form>
		</div>
	</div>
	<jsp:include page="footer.jsp"/>
	</body>
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/asset/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/javascript.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/se/js/HuskyEZCreator.js" charset="utf-8"></script>
	<script type="text/javascript">
		$(document).ready(function(){	
			$('#cubrd-writeForm').submit(function(ev) {
				ev.preventDefault(); // to stop the form from submitting
			    var isEmpty=[false,false,false,false];
			    $('p#cub-title-help').html('');
			    $('p#cub-nm-help').html('');
			    $('p#cub-tell-help').html('');
			    $('p#cub-pw-help').html('');
			    if($.trim($('input#cuboard-wTitle').val()) == ""){
			    	$('p#cub-title-help').html('제목을 입력해주세요.').css('color','red');
			    	isEmpty[0] = false;
			    }else{
			    	isEmpty[0] = true;
			    }
			    if($.trim($('input#cuboard-wNm').val()) == ""){
			    	$('p#cub-nm-help').html('작성자(이름)을 입력해주세요.').css('color','red');
			    	isEmpty[1] = false;
			    }else{
			    	isEmpty[1] = true;
			    }
			    if($.trim($('input#cuboard-wTell').val()) == ""){
			    	$('p#cub-tell-help').html('전화번호를 입력해주세요.').css('color','red');
			    	isEmpty[2] = false;
			    }else{
			    	isEmpty[2] = false;
			    	if(numCheck($.trim($('input#cuboard-wTell').val()))){		//숫자외 입력
				    	$('p#cub-tell-help').html('번호(숫자)만 입력해주세요.').css('color','red');
				 	}else{
				    	if($.trim($('input#cuboard-wTell').val()).length<11){		//길이 미만
					    	$('p#cub-tell-help').html('연락처를 정확하게 입력해주세요.').css('color','red');
					   	}else{
					   		isEmpty[2] = true;
					   	}
				 	}
			    }
			    if($.trim($('input#cuboard-wPw').val()) == ""){
			    	$('p#cub-pw-help').html('비밀번호를 입력해주세요.').css('color','red');
			    	isEmpty[3] = false;
			    }else{
			    	isEmpty[3] = true;
			    }
			    if(isEmpty[0] && isEmpty[1] && isEmpty[2] && isEmpty[3]){
			    	oEditors.getById["cuboard-wCntnt"].exec("UPDATE_CONTENTS_FIELD", []);
			    	this.submit(); // If all the validations succeeded
			    }
			});
		});
		var oEditors = [];
		nhn.husky.EZCreator.createInIFrame({
		 oAppRef: oEditors,
		 elPlaceHolder: "cuboard-wCntnt",
		 sSkinURI: "se/SmartEditor2Skin.html",
		 fCreator: "createSEditor2"
		});
	</script>
	
</html>