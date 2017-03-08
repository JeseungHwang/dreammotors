<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	request.setCharacterEncoding("UTF-8");	%>
<%@ page import="java.util.*"%>
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
</head>
<body>
	<jsp:include page="header.jsp"/>
	<div class="container">
		<div class="mainbanner">
			<img class="mainImg" src="img/banner/banner_main2.png">
		</div>
		
		
		<div class="directory-label">
				<label class="control-label"><span class="glyphicon glyphicon-home" aria-hidden="true"></span> 고객 상담 <span class="glyphicon glyphicon-menu-right" aria-hidden="true"></span> 중고차 구입문의</label>
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
			<div class="pw_form">
				<div class="pw_form_top">
					<label class="control-label">비밀번호</label>
				</div>
				<div class="pw_form_cntnt">
					<form action="${pageContext.request.contextPath}/sabrd_content_cpw.do" class="form-horizontal" id="sabrd-pwCompareForm" method="POST">
						<input type="password" class="form-control" id="board-cpw" name="inpPw">
						<input type="hidden" name="index" value="<%=request.getAttribute("index")%>">
						<input type="submit" class="btn btn-danger" value="확인">
					</form>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp"/>
	</body>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/asset/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/javascript.js"></script>
	<script type="text/javascript">
	</script>
</html>