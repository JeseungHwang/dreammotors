<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	request.setCharacterEncoding("UTF-8");	%>
<%@ page import="java.util.*, com.dreammotors.vo.BoardVO"%>
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
			<label class="control-label"><span class="glyphicon glyphicon-home" aria-hidden="true"></span> 커뮤니티 <span class="glyphicon glyphicon-menu-right" aria-hidden="true"></span> 공지사항<span class="glyphicon glyphicon-menu-right" aria-hidden="true"></span> 글작성</label>
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
			<form action="${pageContext.request.contextPath}/nobrd_modify.do" class="form-horizontal" id="nobrd-modifyForm" method="POST">
				<div id="brd-form-group">
					<div id="brd-label-form"><span id="brd-label">제목</span></div>
					<div id="brd-context">
						<input type="text" class="brd-wTitle" id="nobrd-wTitle" name="inpTitle" autofocus value="<%= board.getBoardTitle()%>">
						<div class="checkbox" id="brd-isnotice">
							<span id="brd-label2">
							<% if(board.getBoardIsNotice() == 1){ %>
								<input type="checkbox" id="nobrd-wNotice" name="isNotice" checked>
							<%}else{ %>
								<input type="checkbox" id="nobrd-wNotice" name="isNotice">
							<%} %>
							<strong>공지</strong></span>
						</div>
						<p id="nob-title-help"></p>
					</div>
				</div>
				<div id="brd-form-group1">
					<div id="brd-label-form"></div>
					<div id="brd-context">
						<textarea name="inpContent" id="nobrd-modify-content" rows="10" cols="100" style="width:100%; height:412px; display:none;"><%= board.getBoardContext()%></textarea>
					</div>
				</div>
				<div id="brd-form-group2">
					<input class="brd-btn btn btn-danger" type="submit" value="수정" />
					<input class="brd-btn btn btn-default" type="button" value="취소" onclick="pageBack()" />
					<input type="hidden" name="index" value="<%= board.getBoardIndex()%>">
					<input type="hidden" name="uid" value="<%= (String)session.getAttribute("UID")%>">
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
			$('#nobrd-modifyForm').submit(function(ev) {
				ev.preventDefault(); // to stop the form from submitting
			    var isEmpty=false;
			    $('p#nob-title-help').html('');
			    if($.trim($('input#nobrd-wTitle').val()) == ""){
			    	$('p#nob-title-help').html('제목을 입력해주세요.').css('color','red');
			    	isEmpty = false;
			    }else{
			    	isEmpty = true;
			    }
			    if(isEmpty){
			    	oEditors.getById["nobrd-modify-content"].exec("UPDATE_CONTENTS_FIELD", []);
			    	this.submit(); // If all the validations succeeded
			    	alert("성공적으로 수정되었습니다.");
			    }
			});
		});
		var oEditors = [];
		nhn.husky.EZCreator.createInIFrame({
		 oAppRef: oEditors,
		 elPlaceHolder: "nobrd-modify-content",
		 sSkinURI: "se/SmartEditor2Skin.html",
		 fCreator: "createSEditor2"
		});
	</script>
</html>