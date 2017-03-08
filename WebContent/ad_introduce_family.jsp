<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	request.setCharacterEncoding("UTF-8");	%>
<%@ page import="java.util.*" %>
<%@ page import="com.dreammotors.vo.FamilyVO" %>
<%	List<FamilyVO> familyList = (ArrayList<FamilyVO>)request.getAttribute("RESULT");%>
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
	<jsp:include page="ad_header.jsp"/>
	<div class="container">
		<div class="mainbanner">
			<img class="mainImg" src="img/banner/banner_main2.png">
		</div>
	
		<div class="directory-label">
			<label class="control-label"><span class="glyphicon glyphicon-home" aria-hidden="true"></span> 드림모터스 <span class="glyphicon glyphicon-menu-right" aria-hidden="true"></span> 직원 소개</label>
		</div>
		
		<div class="modal fade bs-example-modal-sm" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog" style="width: 600px; height: 490px; margin: auto;">
				<div class="modal-content">
				<form action="family_insert.do" class="form-horizontal" id="addfamily-Form" method="POST" enctype="multipart/form-data">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						<h4 class="modal-title" id="myModalLabel">직원 추가</h4>
					</div>
					<div class="modal-body">
						<div id="intro-family-form1">
							<div class="family_picture_area" style="width:150px; margin: auto;">
								<img src="img/nopicture.png" id="cMemImg"  width="150px" height="170px" style="border: 1px solid;">
								<p id="addf-pic-help"></p>
								<input type="button" class="brd-btn btn btn-danger" id="btn_addfpic" value="사진 등록" onclick="addpicture()"/>
								<input type="file" name="profile_picture" id="btn_addpicture" onchange="readURL(this);" style="display: none;">
							</div>
						</div>
						<div id="intro-family-form">
							<div id="intro-family-label-form">직책 선택</div>
							<div class="intro-family-label">
								<select id="intro-family-posi" name="inpFtype">
									<option value="2">사원</option>
									<option value="3">매니저</option>
									<option value="4">실장</option>
									<option value="5">대표</option>
								</select>
							</div>
						</div>
						<div class="intro-family-form">
							<div id="intro-family-label-form">이름</div>
							<div class="intro-family-label">
								<input type="text" class="intro-family-context" name="inpFNm" id="addf-wNm">
								<p id="addf-nm-help"></p>
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="submit" class="brd-btn btn btn-danger">등록</button>
						<button type="button" class="brd-btn btn btn-default" data-dismiss="modal">취소</button>
					</div>
					</form>
				</div>
			</div>
		</div>
		
		<div id="left-menuform">
			<div class="sidebar">
				<ul class="nav nav-sidebar">
					<li class="sidebar-brand">DreamMotors</li>
					<li><a href="companyinfo.do">회사 소개 <span class="glyphicon glyphicon-menu-right" id="left_menu_arrow" aria-hidden="true"></span></a></li>
					<li><a href="familyinfo.do">직원 소개 <span class="glyphicon glyphicon-menu-right" id="left_menu_arrow" aria-hidden="true"></span></a></li>
					<li><a href="direction.do">찾아오시는 곳 <span class="glyphicon glyphicon-menu-right" id="left_menu_arrow" aria-hidden="true"></span></a></li>
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
		
		<h1>직원 소개</h1>
		<div class="family-area" id="right-conentform">
			<% for(FamilyVO list : familyList){ %>
			<div class="family-content">
				<input type="checkbox" class="f_chbox" id="<%=list.getCmcmIndex()%>" name ="cbox" value="check">
				<div><img id="family-img" alt="" src="<%=list.getCmemImgUrl()%>"></div>
				<div><span class="family-span-name"> <%= list.getCmemName()%></span></div>
				<div><span class="family-span-position">직책 : <%= list.getPositionName() %></span></div>
			</div>
			<%} %>
		</div>
		<div class="btn-add-family">
			<button type="button" class="brd-btn btn btn-danger" id="addf_openmodal" data-toggle="modal" data-target="#myModal">직원 추가</button>
			<button type="button" class="brd-btn btn btn-default" id="delete_family" onclick="btn_fmlyDelete()">직원 삭제</button>
		</div>
	</div>
	<jsp:include page="footer.jsp"/>
	</body>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/asset/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/javascript.js"></script>
	<script type="text/javascript">
	$(document).ready(function (){
		$('#addfamily-Form').submit(function(ev) {
		    ev.preventDefault(); // to stop the form from submitting
		    var isEmpty=[false,false];
		    $('p#addf-pic-help').html('');
		    $('p#addf-nm-help').html('');
		    if($('input[type="file"]').val() == ""){
		    	$('p#addf-pic-help').html('사진을 추가해주세요').css('color','red');
		    	isEmpty[0] = false;
		    }else if(extensionCheck($('input[type="file"]'))){
		    	isEmpty[0] = true;
		    }
		    if($.trim($('input#addf-wNm').val()) == ""){
		    	$('p#addf-nm-help').html('성명을 입력해주세요.').css('color','red');
		    	isEmpty[1] = false;
		    }else{
		    	isEmpty[1] = true;
		    }
		    if(isEmpty[0] && isEmpty[1]){
		    	this.submit(); // If all the validations succeeded
		    }
		});
		$('#addf_openmodal').click(function(){
			$('#cMemImg').attr('src', 'img/nopicture.png');
		});
	});
	
	function readURL(input) {
		console.log(input.files[0]);
	    if (input.files && input.files[0]) {
	        var reader = new FileReader();
	        reader.onload = function (e) {
	            $('#cMemImg').attr('src', e.target.result);
	        }
	        reader.readAsDataURL(input.files[0]);
	    }
	}
	function addpicture(){
		document.all.btn_addpicture.click();
	}
	
	function btn_fmlyDelete(){
		if($("input:checkbox[name='cbox']").is(":checked")){
			if(!confirm("체크하신 직원을 삭제하시겠습니까?")){
				return
			}else{
				var list=[];
				$("input[name=cbox]:checked").each(function() {
					list.push($(this)[0].id);
				});
				submitPost('family_delete.do', {'index': list });
				alert("삭제 되었습니다.");
			}
		}else{
			alert("삭제 할 대상을 선택해주세요.");
		}
		
	}
	</script>
</html>