<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	request.setCharacterEncoding("UTF-8");	%>
<%@ page import="java.util.*,com.dreammotors.vo.BoardVO,com.dreammotors.vo.PagingVO,java.sql.*,java.text.SimpleDateFormat,java.util.Date"%>
<%	List<BoardVO> boardList = (ArrayList<BoardVO>)request.getAttribute("RESULT"); 
	PagingVO pVO = (PagingVO)request.getAttribute("PAGE");%>
<%	Date date = new Date(); SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd"); String year = (String)simpleDate.format(date);%>
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
<% if(request.getAttribute("CHECK") != null){
	if(request.getAttribute("CHECK").equals("dsu")){%>
		<script type="text/javascript">alert("글 삭제되었습니다.");</script>
	<%}else if(request.getAttribute("CHECK").equals("msu")){%>
		<script type="text/javascript">alert("글 수정되었습니다.");</script>
	<%}else if(request.getAttribute("CHECK").equals("isu")){%>
	<script type="text/javascript">alert("글 등록되었습니다.");</script>
<%}
}%>
</head>
<body>
	<jsp:include page="header.jsp"/>
	<div class="container">
		<div class="mainbanner">
			<img class="mainImg" src="img/banner/banner_main2.png">
		</div>
		<div class="directory-label">
			<label class="control-label"><span class="glyphicon glyphicon-home" aria-hidden="true"></span> 커뮤니티 <span class="glyphicon glyphicon-menu-right" aria-hidden="true"></span> 고객 후기</label>
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
			<div class="btn-write-pos">
				<input class="btn btn-danger" type="button" value="글등록" onclick="insertBoard()" />
			</div>
			<center>
			<table class="table table-hover">
				<thead>
					<tr>
						<th class="board-th1">번호</th>
						<th class="board-th2">제목</th>
						<th class="board-th3">작성자</th>
						<th class="board-th4">등록일</th>
					</tr>
				</thead>
				<tbody class="board-body" id="pboard-list">
				<%	int index = pVO.getTotalCount()-((pVO.getPageNo()-1)*15);
					for(BoardVO list : boardList){ %>
					<tr id="<%=list.getBoardIndex()%>">
						<td><%=index--%></td>
						<td><%=list.getBoardTitle()%>
							<% if(year.equals(list.getBoardRegDatetime().substring(0, 10))){
								%> <img id="newicon_img" src="img/icon/new.jpg"><%	
							}%>
							
						</td>
						<td><%=list.getBoardRegName()%></td>
						<td><%=list.getBoardRegDatetime().substring(0, 10)%></td>
					</tr>
				<% if(index==0)break;}%>
				</tbody>
			</table>
			</center>
			<div class="board-paging">
				<nav>
				  <ul class="pagination">
			  	 	<%if(pVO.getFirstPageNo() == pVO.getStartPageNo()){ %>
				    	<li class="disabled"><a href="#" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
				    <%}else{ %>
				    	<% if((String)request.getAttribute("SEARCH")!=null){%>
				    		<li><a href="cubrd_search.do?prepage=<%=pVO.getPrevPageNo()%>&sCntnt=<%=(String)request.getAttribute("SEARCH")%>&stype=<%=(String)request.getAttribute("STYPE")%>" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
				    	<%}else{%>
				    		<li><a href="?prepage=<%=pVO.getPrevPageNo()%>" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
				    	<%}%>
				    <%} %>
				  	
				    <%	int pgCnt=0, endPage = pVO.getEndPageNo();
				    	for(int i=pVO.getFirstPageNo() ; i<=endPage ; i++){%>
						<% if(i==pVO.getPageNo()){ %>
							<li class="active" id="paging"><a href="#"><%= i %></a></li>	
						<%}else{ %>
							<% if((String)request.getAttribute("SEARCH")!=null){%>
								<li id="paging"><a href="cubrd_search.do?page=<%=i%>&sCntnt=<%=(String)request.getAttribute("SEARCH")%>&stype=<%=(String)request.getAttribute("STYPE")%>"><%= i %></a></li>
							<%}else{ %>
								<li id="paging"><a href="?page=<%=i%>"><%= i %></a></li>
							<%}%>
			    		<%}%>
				    <%}%>
				    <%if(pVO.getEndPageNo() == pVO.getFinalPageNo()){ %>
						<li class="disabled"><a href="#" aria-label="Next"><span aria-hidden="true">&raquo;</span></a></li>
				    <%}else{ %>
				    	<% if((String)request.getAttribute("SEARCH")!=null){%>
				    		<li><a href="cubrd_search.do?nextpage=<%=pVO.getNextPageNo()%>&sCntnt=<%=(String)request.getAttribute("SEARCH")%>&stype=<%=(String)request.getAttribute("STYPE")%>" aria-label="Next"><span aria-hidden="true">&raquo;</span></a></li>
				    	<%}else{%>
				    		<li><a href="?nextpage=<%=pVO.getNextPageNo()%>" aria-label="Next"><span aria-hidden="true">&raquo;</span></a></li>
				    	<%} %>
				    	
				    <%} %>
				  </ul>
				</nav>
			</div>
		</div>
		
		<div class="searchbox">
				<select class="search-type" name="inpStype" id="searchTypeList">
					<option value="a">통합검색</option>
					<option value="t">제목</option>
					<option value="w">작성자</option>
					<option value="c">내용</option>
				</select>
			<div class="search-form">
				<input type="text" class="search-content" name="inpScntnt" <% if((String)request.getAttribute("SEARCH")!=null){%>value="<%=(String)request.getAttribute("SEARCH")%>"<%}%>>
				<button type="button" class="btn btn-danger" id="btn_brdSearch" onclick="brdsearch()">검색</button>
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
		<% if((String)request.getAttribute("STYPE")!=null){%>$('#searchTypeList').val("<%=(String)request.getAttribute("STYPE")%>");<%}%>
		$('.board-body tr').click(function(){
			submitPost('${pageContext.request.contextPath}/cubrd_content.do',{"index":$(this).closest('tr').attr('id')});
		});
		
		$(".btn-group .dropdown-menu li a").click(function(){	//학기 선택 이벤트
			var selText = $(this).text();
			$(this).parents('.btn-group').find('.dropdown-toggle').html(selText+' <span class="caret"></span>');
		});
	});
	function brdsearch(){
		submitPost('${pageContext.request.contextPath}/cubrd_search.do', {'stype':$('select[name="inpStype"]').val(), 'sCntnt':$('input[name=inpScntnt]').val()});
	}
	function insertBoard() {
		location.href = "${pageContext.request.contextPath}/cubrd_wpg.do";
	}
	</script>
</html>