<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	request.setCharacterEncoding("UTF-8");	%>
<%@ page import="java.util.*,com.dreammotors.vo.BoardVO,java.sql.*,java.text.SimpleDateFormat,java.util.Date"%>
<%	List<BoardVO> bList1 = (ArrayList<BoardVO>)request.getAttribute("RESULT1");
	List<BoardVO> bList2 = (ArrayList<BoardVO>)request.getAttribute("RESULT2");
	List<BoardVO> bList3 = (ArrayList<BoardVO>)request.getAttribute("RESULT3");
	List<BoardVO> bList4 = (ArrayList<BoardVO>)request.getAttribute("RESULT4");
	List<BoardVO> bList5 = (ArrayList<BoardVO>)request.getAttribute("RESULT5");
%>
<%	Date date = new Date(); SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd"); String year = (String)simpleDate.format(date);%>
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
<link rel="stylesheet" href="https://netdna.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link href="${pageContext.request.contextPath}/asset/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/main.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/tbmenu.css" rel="stylesheet">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/asset/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/javascript.js"></script>
<%  if(request.getAttribute("CHECK") != null){
		if(request.getAttribute("CHECK").equals("out")){%>
		<script type="text/javascript">alert("로그아웃 되었습니다.");</script>
		<%session.invalidate();
		}
}%>
</head>
<body>
	<jsp:include page="header.jsp"/>
	<div class="container">
		<div class="mainbanner">
			<img class="mainImg" src="img/banner/banner_main.png">
		</div>
		<div class="banngergroup">
			<div class="banner_cntnt">
				<div class="banner_img">
					<a href="${pageContext.request.contextPath}/companyinfo.do"><img class="bnimg" src="img/banner/banner_dreammotors_off.png"></a>
				</div>
				<div class="banner_img">
					<a href="${pageContext.request.contextPath}/process.do"><img class="bnimg" src="img/banner/banner_process_off.png"></a>
				</div>
				<div class="banner_img">
					<a href="${pageContext.request.contextPath}/nobrd.do"><img class="bnimg" src="img/banner/banner_notice_off.png"></a>
				</div>
			</div>
			<div class="banner_cntnt">
				<div class="banner_img">
					<a href="${pageContext.request.contextPath}"><img class="bnimg" src="img/banner/banner_tell.png"></a>
				</div>
				<div class="banner_img">
					<a href="${pageContext.request.contextPath}/pubrd.do"><img class="bnimg" src="img/banner/banner_consult_off.png"></a>
				</div>
				<div class="banner_img">
					<a href="${pageContext.request.contextPath}/direction.do"><img class="bnimg" src="img/banner/banner_direction_off.png"></a>
				</div>
			</div>
			<div class="main_brdtables">
				<div class="brdtable">
					<div class="brd_header">
						<div class="brd_header_left">
							<h4><span class="glyphicon glyphicon-list" aria-hidden="true"></span><span class="span2"><strong>고객 상담</strong></span></h4>
						</div>
						<div class="brd_header_right">
							<label class="control-label" id="a_more"><a href="${pageContext.request.contextPath}/pubrd.do">More▶</a></label>
						</div>
					</div>
					
					<div role="tabpanel">
						<ul class="nav nav-tabs" role="tablist" id="consult_tab">
							<li role="presentation" class="active"><a href="#pubrd" aria-controls="pubrd" role="tab" data-toggle="tab"><label>구입 문의</label></a></li>
							<li role="presentation"><a href="#sabrd" aria-controls="sabrd" role="tab" data-toggle="tab"><label>판매문의</label></a></li>
						</ul>
		  			</div>
		  			<div class="tab-content">
					    <div role="tabpanel" class="tab-pane active" id="pubrd">
							<table class="table table-hover">
								<tbody>
								<%	for(BoardVO list : bList1){ %>
									<tr id="<%=list.getBoardIndex()%>">
										<td><%=list.getBoardTitle()%>
											<% if(list.getBoardIsPrivate()==1){%> 
												<span class="glyphicon glyphicon-lock" aria-hidden="true" style="color:gray;"></span><% 
											}%>
											<% if(year.equals(list.getBoardRegDatetime().substring(0, 10))){
												%> <img id="newicon_img" src="img/icon/new.jpg"><%	
											}%>
										</td>
										<td id="td_date"><%=list.getBoardRegDatetime().substring(0, 10)%></td>
									</tr>
								<% }%>
								</tbody>
							</table>
						</div>
					    <div role="tabpanel" class="tab-pane" id="sabrd">
					    	<table class="table table-hover">
								<tbody>
								<%	for(BoardVO list : bList2){ %>
									<tr id="<%=list.getBoardIndex()%>">
										<td><%=list.getBoardTitle()%>
											<% if(list.getBoardIsPrivate()==1){%> 
												<span class="glyphicon glyphicon-lock" aria-hidden="true" style="color:gray;"></span><% 
											}%>
											<% if(year.equals(list.getBoardRegDatetime().substring(0, 10))){
												%> <img id="newicon_img" src="img/icon/new.jpg"><%	
											}%>
										</td>
										<td id="td_date"><%=list.getBoardRegDatetime().substring(0, 10)%></td>
									</tr>
								<% }%>
								</tbody>
							</table>
					    </div>
					  </div>
				</div>
				<div class="brdtable">
					<div class="brd_header">
						<div class="brd_header_left">
							<h4><span class="glyphicon glyphicon-list" aria-hidden="true"></span><span class="span2"><strong>커뮤니티</strong></span></h4>
						</div>
						<div class="brd_header_right">
							<label class="control-label" id="a_more"><a href="${pageContext.request.contextPath}/nobrd.do">More▶</a></label>
						</div>
					</div>
					<div role="tabpanel">
						<ul class="nav nav-tabs" role="tablist" id="community_tab">
							<li role="presentation" class="active"><a href="#nobrd" aria-controls="nobrd" role="tab" data-toggle="tab"><label>공지사항</label></a></li>
							<li role="presentation"><a href="#rebrd" aria-controls="rebrd" role="tab" data-toggle="tab"><label>차량 판매 문의</label></a></li>
							<li role="presentation"><a href="#cubrd" aria-controls="cubrd" role="tab" data-toggle="tab"><label>고객 후기</label></a></li>
						</ul>
		  			</div>
		  			<div class="tab-content">
					    <div role="tabpanel" class="tab-pane active" id="nobrd">
					    	<table class="table table-hover">
								<tbody>
									<%	for(BoardVO list : bList3){ %>
									<tr id="<%=list.getBoardIndex()%>">
										<td><%=list.getBoardTitle()%>
											<% if(year.equals(list.getBoardRegDatetime().substring(0, 10))){
												%> <img id="newicon_img" src="img/icon/new.jpg"><%	
											}%>
										</td>
										<td id="td_date"><%=list.getBoardRegDatetime().substring(0, 10)%></td>
									</tr>
								<% }%>
								</tbody>
							</table>
					    </div>
					    <div role="tabpanel" class="tab-pane" id="rebrd">
							<table class="table table-hover">
								<tbody>
									<%	for(BoardVO list : bList4){ %>
									<tr id="<%=list.getBoardIndex()%>">
										<td><%=list.getBoardTitle()%>
											<% if(year.equals(list.getBoardRegDatetime().substring(0, 10))){
												%> <img id="newicon_img" src="img/icon/new.jpg"><%	
											}%>
										</td>
										<td id="td_date"><%=list.getBoardRegDatetime().substring(0, 10)%></td>
									</tr>
								<% }%>
								</tbody>
							</table>
					    </div>
					    <div role="tabpanel" class="tab-pane" id="cubrd">
					    	<table class="table table-hover">
								<tbody>
									<%	for(BoardVO list : bList5){ %>
									<tr id="<%=list.getBoardIndex()%>">
										<td><%=list.getBoardTitle()%>
											<% if(year.equals(list.getBoardRegDatetime().substring(0, 10))){
												%> <img id="newicon_img" src="img/icon/new.jpg"><%	
											}%>
										</td>
										<td id="td_regNm"><%=list.getBoardRegName()%></td>
										<td id="td_date"><%=list.getBoardRegDatetime().substring(0, 10)%></td>
									</tr>
								<% }%>
								</tbody>
							</table>
					    </div>
					</div>
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
		$('#pubrd tr').click(function(){
			submitPost('${pageContext.request.contextPath}/pubrd_content.do',{"index":$(this).closest('tr').attr('id')});
		});
		$('#sabrd tr').click(function(){
			submitPost('${pageContext.request.contextPath}/sabrd_content.do',{"index":$(this).closest('tr').attr('id')});
		});
		$('#nobrd tr').click(function(){
			submitPost('${pageContext.request.contextPath}/nobrd_content.do',{"index":$(this).closest('tr').attr('id')});
		});
		$('#rebrd tr').click(function(){
			submitPost('${pageContext.request.contextPath}/rebrd_content.do',{"index":$(this).closest('tr').attr('id')});
		});
		$('#cubrd tr').click(function(){
			submitPost('${pageContext.request.contextPath}/cubrd_content.do',{"index":$(this).closest('tr').attr('id')});
		});
	});
	</script>
</html>