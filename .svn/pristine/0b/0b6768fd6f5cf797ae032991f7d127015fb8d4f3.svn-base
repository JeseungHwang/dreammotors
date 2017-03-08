<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	request.setCharacterEncoding("UTF-8");	%>
<%@ page import="java.util.*" %>
<%@ page import="com.dreammotors.vo.BoardVO"%>
<%	BoardVO board = (BoardVO)request.getAttribute("BOARD"); %>
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
			<label class="control-label"><span class="glyphicon glyphicon-home" aria-hidden="true"></span> 고객 상담 <span class="glyphicon glyphicon-menu-right" aria-hidden="true"></span> 중고차 구입 & 판매 문의 <span class="glyphicon glyphicon-menu-right" aria-hidden="true"></span> 글수정</label>
		</div>
		<div id="left-menuform">
			<div class="sidebar">
				<ul class="nav nav-sidebar">
					<li class="sidebar-brand">고객상담</li>
					<li><a href="${pageContext.request.contextPath}/pubrd.do">중고차 구매 문의 <span class="glyphicon glyphicon-menu-right" id="left_menu_arrow" aria-hidden="true"></span></a></li>
					<li><a href="${pageContext.request.contextPath}/sabrd.do">중고차 판매 문의 <span class="glyphicon glyphicon-menu-right" id="left_menu_arrow" aria-hidden="true"></span></a></li>
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
			<form action="${pageContext.request.contextPath}/sabrd_modify.do" class="form-horizontal" id="saboard-modifyForm" method="POST">
				<div id="brd-form-group">
					<div id="brd-label-form"><span id="brd-label">분류</span></div>
					<div id="brd-context">
						<select class="brd-btype" name="inpBtype" id="sabrd-modify-btype">
							<option value="s">중고차 판매 상담</option>
							<option value="p">중고차 구입 상담</option>
						</select>
					</div>
				</div>
				<div id="brd-form-group">
					<div id="brd-label-form"><span id="brd-label">제목</span></div>
					<div id="brd-context">
						<input type="text" class="brd-wTitle" id="sabrd-modify-title" name="inpTitle" value="<%= board.getBoardTitle()%>">
						<div class="checkbox" id="brd-isprivate">
							<span id="brd-label2">
								<% if(board.getBoardIsPrivate() == 1){ %>
									<input type="checkbox" id="sabrd-modify-isprivate" name="isPrivate" checked>
								<%}else{ %>
									<input type="checkbox" id="sabrd-modify-isprivate" name="isPrivate">
								<%} %>
								<strong>비밀글</strong>
							</span>
						</div>
						<p id="sab-title-help"></p>
					</div>
				</div>
				<div id="brd-form-group">
					<div id="brd-label-form"><span id="brd-label">이름</span></div>
					<div id="brd-context">
						<input type="text" class="brd-wNm" id="sabrd-modify-nm" name="inpNm" value="<%= board.getBoardRegName()%>">
						<p id="sab-nm-help"></p>
					</div>
				</div>
				<div id="brd-form-group">
					<div id="brd-label-form"><span id="brd-label">연락처</span></div>
					<div id="brd-context">
						<input type="text" class="brd-wTell" id="sabrd-modify-tell" placeholder="- (하이픈) 없이 입력해주세요" name="inpTell" maxlength="11" value="<%= board.getBoardTell()%>">
						<p id="sab-tell-help"></p>
					</div>
				</div>
				<div id="brd-form-group1">
					<div id="brd-label-form"></div>
					<div id="brd-context">
						<textarea name="inpContent" id="sabrd-modify-content" rows="10" cols="100" style="width:100%; height:412px; display:none;"><%= board.getBoardContext()%></textarea>
					</div>
				</div>
				<div id="brd-form-group2">
					<input class="brd-btn btn btn-danger" type="button" value="수정" onclick="sabrd_modifyEvent()" />
					<input class="brd-btn btn btn-default" type="button" value="취소" onclick="pageBack()" />
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
		function sabrd_modifyEvent(){
			var isEmpty=[false,false,false];
		    $('p#sab-title-help').html('');
		    $('p#sab-nm-help').html('');
		    $('p#sab-tell-help').html('');
		    $('p#sab-pw-help').html('');
		    if($.trim($('input#sabrd-modify-title').val()) == ""){
		    	$('p#sab-title-help').html('제목을 입력해주세요.').css('color','red');
		    	isEmpty[0] = false;
		    }else{
		    	isEmpty[0] = true;
		    }
		    if($.trim($('input#sabrd-modify-nm').val()) == ""){
		    	$('p#sab-nm-help').html('작성자(이름)을 입력해주세요.').css('color','red');
		    	isEmpty[1] = false;
		    }else{
		    	isEmpty[1] = true;
		    }
		    if($.trim($('input#sabrd-modify-tell').val()) == ""){
		    	$('p#sab-tell-help').html('전화번호를 입력해주세요.').css('color','red');
		    	isEmpty[2] = false;
		    }else{
		    	isEmpty[2] = false;
		    	if(numCheck($.trim($('input#sabrd-modify-tell').val()))){		//숫자외 입력
			    	$('p#sab-tell-help').html('번호(숫자)만 입력해주세요.').css('color','red');
			 	}else{
			    	if($.trim($('input#sabrd-modify-tell').val()).length<11){		//길이 미만
				    	$('p#sab-tell-help').html('연락처를 정확하게 입력해주세요.').css('color','red');
				   	}else{
				   		isEmpty[2] = true;
				   	}
			 	}
		    }
		    if(isEmpty[0] && isEmpty[1] && isEmpty[2]){
		    	oEditors.getById["sabrd-modify-content"].exec("UPDATE_CONTENTS_FIELD", []);
		    	submitPost('${pageContext.request.contextPath}/sabrd_modify.do', 
		    			{'index':<%= board.getBoardIndex()%>,
			    		'inpBtype':$('#sabrd-modify-btype').val(),
			    		'inpIsPrivate':$("input:checkbox[id='sabrd-modify-isprivate']").is(":checked"),
			    		'inpTitle':$('#sabrd-modify-title').val(),
			    		'inpNm':$('#sabrd-modify-nm').val(),
			    		'inpTell':$('#sabrd-modify-tell').val(),
			    		'inpContent':$('#sabrd-modify-content').val()});
		    	alert("성공적으로 수정되었습니다.");
		    }
		}
		var oEditors = [];
		nhn.husky.EZCreator.createInIFrame({
		 oAppRef: oEditors,
		 elPlaceHolder: "sabrd-modify-content",
		 sSkinURI: "se/SmartEditor2Skin.html",
		 fCreator: "createSEditor2"
		});
	</script>
</html>