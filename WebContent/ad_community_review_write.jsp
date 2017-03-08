<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	request.setCharacterEncoding("UTF-8");	%>
<%if(request.getAttribute("CHECK")!=null){
	if(request.getAttribute("CHECK").equals("isu")){%>
		<script type="text/javascript">
		alert("작성하신 글 등록하였습니다.");
		location.href = "${pageContext.request.contextPath}/rebrd.do"; </script>
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
			<label class="control-label"><span class="glyphicon glyphicon-home" aria-hidden="true"></span> 커뮤니티 <span class="glyphicon glyphicon-menu-right" aria-hidden="true"></span> 차량 판매 후기<span class="glyphicon glyphicon-menu-right" aria-hidden="true"></span> 글작성</label>
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
			<form action="${pageContext.request.contextPath}/rebrd_write.do" class="form-horizontal" id="rebrd-writeForm" method="POST">
				<div id="brd-form-group">
					<div id="brd-label-form"><span id="brd-label">제목</span></div>
					<div id="brd-context">
						<input type="text" class="brd-wTitle" id="reboard-wTitle" name="inpTitle" autofocus>
						<p id="reb-title-help"></p>
					</div>
				</div>
				<div id="brd-form-group1">
					<div id="brd-label-form"></div>
					<div id="brd-context">
						<textarea name="inpContent" id="reboard-wCntnt" rows="10" cols="100" style="width:100%; height:412px; display:none;"></textarea>
					</div>
				</div>
				<div id="brd-form-group2">
					<input class="brd-btn btn btn-danger" type="submit" value="등록"  />
					<input class="brd-btn btn btn-default" type="button" value="취소" onclick="pageBack()" />
					<%  if(session.getAttribute("UID") != null){%>
					<input type="hidden" name="uid" value="<%= (String)session.getAttribute("UID")%>">
					<%}%>
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
			$('#rebrd-writeForm').submit(function(ev) {
				 ev.preventDefault(); // to stop the form from submitting
				    var isEmpty=false;
				    $('p#reb-title-help').html('');
				    if($.trim($('input#reboard-wTitle').val()) == ""){
				    	$('p#reb-title-help').html('제목을 입력해주세요.').css('color','red');
				    	isEmpty = false;
				    }else{
				    	isEmpty = true;
				    }
				    if(isEmpty){
				    	oEditors.getById["reboard-wCntnt"].exec("UPDATE_CONTENTS_FIELD", []);
				    	this.submit(); // If all the validations succeeded
				    }
			});
		});
		var oEditors = [];
		nhn.husky.EZCreator.createInIFrame({
		 oAppRef: oEditors,
		 elPlaceHolder: "reboard-wCntnt",
		 sSkinURI: "se/SmartEditor2Skin.html",
		 fCreator: "createSEditor2"
		});
	</script>
	
</html>