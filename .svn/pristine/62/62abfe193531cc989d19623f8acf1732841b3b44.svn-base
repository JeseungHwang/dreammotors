<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	request.setCharacterEncoding("UTF-8");	%>
<%@ page import="java.util.*" %>
<%@ page import="com.dreammotors.vo.BoardVO"%>
<%@ page import="com.dreammotors.vo.BoardCommentVO"%>
<%	BoardVO board = (BoardVO)request.getAttribute("BOARD"); %>
<%	List<BoardCommentVO> cList = (ArrayList<BoardCommentVO>)request.getAttribute("COMMENT"); %>

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
<%  if(request.getAttribute("CHECK") != null){
	if(request.getAttribute("CHECK").equals("fail")){%>
		<script type="text/javascript">
			alert("비밀번호가 틀렸습니다.");
		</script>
	<%}else if(request.getAttribute("CHECK").equals("noauth")){%>
		<script type="text/javascript">
			alert("권한이 없습니다.");
		</script>
	<%} %>
<%}%>
</head>
<body>
	<jsp:include page="header.jsp"/>
	<div class="container">
		<div class="mainbanner">
			<img class="mainImg" src="img/banner/banner_main2.png">
		</div>
		<div class="directory-label">
			<label class="control-label"><span class="glyphicon glyphicon-home" aria-hidden="true"></span> 고객 상담 <span class="glyphicon glyphicon-menu-right" aria-hidden="true"></span> 중고차 판매 문의 <span class="glyphicon glyphicon-menu-right" aria-hidden="true"></span> 상세내용</label>
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
			<div class="pboard-cntnt">
				<div class="pboard-cntnt-top">
					<h4><label>[<%= board.getbTypeName()%>] <%= board.getBoardTitle()%></label></h4>
					<div><span class="boardtop-span1"> <label><%= board.getBoardRegName()%></label></span><span class="boardtop-span2"> <label><%= board.getBoardRegDatetime()%></label></span><span class="boardtop-span2"><label>조회수 : <%= board.getBoardViewCnt()%></label></span><span class="boardtop-span2"><%if(board.getBoardTell() != null){ %><label>연락처 : <%=board.getBoardTell() %></label><%}%></span></div>
				</div>
				<div class="pboard-cntnt-view">
					<%= board.getBoardContext()%>
				</div>
			</div>
			<div class="pboard-cntnt-bottom">
				<div class=btn_brdModify>
					<input class="btn btn-danger btn-pboardmodify" type="button" value="글수정" onclick="btn_brdModify()"/>
					<input class="btn btn-danger btn-pboardmodify" type="button" value="글삭제" onclick="btn_brdDelete()"/>
				</div>
				<div class="brdModify_form" style="display: none;">
					<input type="password" class="form-control" id="inpModifyBrdPW" placeholder="비밀번호 입력" style="width: 15%; display: inline;">
					<input type="button" class="btn btn-danger" value="확인" onclick="btn_modify_comparePW()">
					<input type="button" class="btn btn-default" value="취소" onclick="btn_cancle()">
				</div>
				<div class="brdDelete_form" style="display: none;">
					<input type="password" class="form-control" id="inpDeleteBrdPW" placeholder="비밀번호 입력" style="width: 15%; display: inline;">
					<input type="button" class="btn btn-danger" value="확인" onclick="btn_delete_comparePW()">
					<input type="button" class="btn btn-default" value="취소" onclick="btn_cancle()">
				</div>
			</div>
			
			<%  int index = cList.size(); 
				for(BoardCommentVO list : cList){ %>
			<div class="pboard-cntnt-cmt-view">
				<div class="pboard-cntnt-cmt-top">
					<label class="control-label"><span class="glyphicon glyphicon-user" aria-hidden="true"></span><span class="boardtop-span1"><%= list.getBcmtRegName()%></span><span class="boardtop-span2">작성일 : <%= list.getBcmtRegDatetime()%></span></label>
					<div id="delete_cmt">
						<a id="<%=list.getBcmtOrder()%>"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></a>
					</div>
					
				</div>
				<div class="pboard-cntnt-cmt-wrap">
				<%= list.getBcmtContext()%>
				</div>
			</div>
			<%} %>
			<div class="pboard-cntnt-cmt-write">
				<div class="pboard-cmt-top">
					<div class="comment-label-form" id="cmt_label"><span id="brd-label">작성자</span></div>
					<div class="comment-context"><input type="text" class="comment-label" id="cmt-wRegNm" name="inpNm" <% if((String)session.getAttribute("UID") != null){%>value="<%=(String)session.getAttribute("UNM")%>"<%}%>></div>
				</div>
				<div class="pboard-cmt-wrap">
					<div class="inp_txtarea"><textarea class="cmt-tarea" id="cmt-wCmt" rows="4" name="inpCmt"></textarea></div>
					<div class="btn_cmtadd"><input type="button" class="btn btn-danger cmt-btn-insert" value="등록" onclick="cmt_insert()"/></div>
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
		$(document).ready(function(){
			$('.brdModify_form').hide();
			$('#delete_cmt a').on('click',function(){
				if(!confirm("해당 댓글을 삭제하시겠습니까?")){
					return
				}else{
					submitPost('${pageContext.request.contextPath}/comment_delete.do', {'index':<%= board.getBoardIndex()%>, 'order':this.id});
				}
			});
			$('.cmt-tarea').on('click',function(){
				<% if((String)session.getAttribute("UID") == null){%>
					alert("로그인 후에 사용하실수 있습니다.");
				<%}%>
				
			});
		});
		
		function btn_brdModify(){
			<% if((String)session.getAttribute("UID") != null){%>
				submitPost('${pageContext.request.contextPath}/sabrd_comparePW.do', {'index':<%= board.getBoardIndex()%>});
			<%}else{%>
			$('.btn_brdModify').hide();
			$('.brdModify_form').show();
			$('.brdDelete_form').hide();
			<%}%>
		}
		function btn_brdDelete(){
			<% if((String)session.getAttribute("UID") != null){%>
				if(!confirm("해당 글을 삭제하시겠습니까?")){
					return
				}else{
					submitPost('${pageContext.request.contextPath}/sabrd_delete.do', {'index':<%= board.getBoardIndex()%>});
				}
			<%}%>
			$('.btn_brdModify').hide();
			$('.brdModify_form').hide();
			$('.brdDelete_form').show();
		}
		function btn_cancle(){
			$('.btn_brdModify').show();
			$('.brdModify_form').hide();
			$('.brdDelete_form').hide();
		}
		function btn_modify_comparePW(){
			submitPost('${pageContext.request.contextPath}/sabrd_comparePW.do', {'index':<%= board.getBoardIndex()%>,'brdPW':$("input#inpModifyBrdPW").val()});
		}
		function btn_delete_comparePW(){
			if(!confirm("해당 글을 삭제하시겠습니까?")){
				return
			}else{
				submitPost('${pageContext.request.contextPath}/sabrd_delete.do', {'index':<%= board.getBoardIndex()%>,'brdPW':$("input#inpDeleteBrdPW").val()});
			}
		}
		function cmt_insert(){
			 if($.trim($('input#cmt-wRegNm').val()) == ""){
				 alert("이름을 입력해주세요.");
			 }else if($("textarea#cmt-wCmt").val() == ""){
				 alert("내용을 입력해주세요.");
			 }else{
				 submitPost('${pageContext.request.contextPath}/sacomment_add.do', {'index':<%= board.getBoardIndex()%>,'regNm':$("input#cmt-wRegNm").val(),'cmt':$("textarea#cmt-wCmt").val() }); 
			 }
		}
	</script>
</html>
