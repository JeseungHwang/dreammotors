<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	request.setCharacterEncoding("UTF-8");	%>
<%@ page import="java.util.*,com.dreammotors.vo.MemberVO,com.dreammotors.vo.PagingVO,java.sql.*,java.text.SimpleDateFormat,java.util.Date"%>
<%	List<MemberVO> mList = (ArrayList<MemberVO>)request.getAttribute("RESULT"); 
	List<MemberVO> pList = (ArrayList<MemberVO>)request.getAttribute("PList");
	PagingVO pVO = (PagingVO)request.getAttribute("PAGE");
%>
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
		<div class="directory-label">
			<label class="control-label"><span class="glyphicon glyphicon-home" aria-hidden="true"></span> 관리자모드<span class="glyphicon glyphicon-menu-right" aria-hidden="true"></span> 회원관리</label>
		</div>
		
		<div class="modal fade bs-example-modal-sm" id="memModifyModal" tabindex="-1" role="dialog" aria-labelledby="memModifyModalLabel" aria-hidden="true">
			<div class="modal-dialog" style="width:600px; height:480px; margin: auto;">
				<div class="modal-content">
				<form action="family_insert.do" class="form-horizontal" id="addfamily-Form" method="POST" enctype="multipart/form-data">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						<h4 class="modal-title" id="memModifyModalLabel">회원 상세정보</h4>
					</div>
					<div class="modal-body">
						<div id="management-form-gorup">
							<div id="management-label-form"><span class="management-label">ID</span></div>
							<div id="management-context">
								<div class="management-label" id="modal_memId"></div>
							</div>
						</div>
						<div id="management-form-gorup">
							<div id="management-label-form"><span class="management-label">직책 선택</span></div>
							<div id="management-context">
								<select id="modal_memPermission" name="inpPtype">
									<%	for(MemberVO list : pList){ %>
									<option value="<%=list.getMemPermission()%>"><%=list.getPositionName()%></option>
									<%} %>
								</select>
							</div>
						</div>
						<div id="management-form-gorup">
							<div id="management-label-form"><span class="management-label">이름</span></div>
							<div id="management-context">
								<div class="management-label" id="modal_memNm"></div>
							</div>
						</div>
						<div id="management-form-gorup">
							<div id="management-label-form"><span class="management-label">닉네임</span></div>
							<div id="management-context">
								<div class="management-label" id="modal_memNk"></div>
							</div>
						</div>
						<div id="management-form-gorup">
							<div id="management-label-form"><span class="management-label">E-mail</span></div>
							<div id="management-context">
								<div class="management-label" id="modal_memEmail"></div>
							</div>
						</div>
						<div id="management-form-gorup">
							<div id="management-label-form"><span class="management-label">전화번호</span></div>
							<div id="management-context">
								<div class="management-label" id="modal_memTell"></div>
							</div>
						</div>
						<div id="management-form-gorup">
							<div id="management-label-form"><span class="management-label">가입날짜</span></div>
							<div id="management-context">
								<div class="management-label" id="modal_regDate"></div>
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="brd-btn btn btn-danger" onclick="modifyMember()">수정</button>
						<button type="button" class="brd-btn btn btn-default" data-dismiss="modal">취소</button>
					</div>
					</form>
				</div>
			</div>
		</div>
		<div>
			<input class="btn btn-danger" type="button" value="회원삭제" onclick="deleteMember()"/>
		</div>
		<div class="member_table">
			<center>
			<table class="table table-hover">
				<thead>
					<tr>
						<th class=""><input type='checkbox' id='check_all' class='input_check' /></th>
						<th class="">등급</th>
						<th class="">사용자 ID</th>
						<th class="">이름</th>
						<th class="">닉네임</th>
						<th class="">E-Mail</th>
						<th class="">전화번호</th>
						<th class="">회원가입 날짜</th>
					</tr>
				</thead>
				
				<tbody class="board-body" id="pboard-list">
				<%	for(MemberVO list : mList){ %>
					<tr data-toggle="modal" data-target="#memModifyModal">
						<td><input type="checkbox" class="memcbox" id="<%= list.getMemId()%>" name ="memCbox" value="check"></td>
						<td class="perNm" id="<%= list.getMemPermission()%>"><%= list.getPositionName()%></td>
						<td class="memId"><%= list.getMemId()%></td>
						<td class="memNm"><%= list.getMemName()%></td>
						<td class="memNk"><%= list.getMemNick()%></td>
						<td class="email"><%= list.getMemEmail()%></td>
						<td class="tell"><%= list.getMemTell()%></td>
						<td class="regDate"><%= list.getMemRegDateTime()%></td>
					</tr>
					<%} %>
				</tbody>
			</table>
			</center>
		</div>
		<div class="board-paging">
			<nav>
			  <ul class="pagination">
			  	<%if(pVO.getFirstPageNo() == pVO.getStartPageNo()){ %>
				    	<li class="disabled"><a href="#" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
				    <%}else{ %>
				    	<% if((String)request.getAttribute("SEARCH")!=null){%>
				    		<li><a href="member_search.do?prepage=<%=pVO.getPrevPageNo()%>&sCntnt=<%=(String)request.getAttribute("SEARCH")%>&stype=<%=(String)request.getAttribute("STYPE")%>" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
				    	<%}else{%>
				    		<li><a href="?prepage=<%=pVO.getPrevPageNo()%>" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
				    	<%}%>
				    <%} %>
				<%	int pgCnt=0, endPage = pVO.getEndPageNo();
			    	for(int i=pVO.getFirstPageNo() ; i<=endPage ; i++){%>
					<% if(i==pVO.getPageNo()){ %>
						<li class="active" id="paging"><a href="#"><%= i %></a></li>	
					<%}else{ %>
						<li id="paging"><a href="?page=<%=i%>"><%= i %></a></li>
		    		<%}%>
			    <%}%>
			    <%if(pVO.getEndPageNo() == pVO.getFinalPageNo()){ %>
						<li class="disabled"><a href="#" aria-label="Next"><span aria-hidden="true">&raquo;</span></a></li>
				    <%}else{ %>
				    	<% if((String)request.getAttribute("SEARCH")!=null){%>
				    		<li><a href="member_search.do?nextpage=<%=pVO.getNextPageNo()%>&sCntnt=<%=(String)request.getAttribute("SEARCH")%>&stype=<%=(String)request.getAttribute("STYPE")%>" aria-label="Next"><span aria-hidden="true">&raquo;</span></a></li>
				    	<%}else{%>
				    		<li><a href="?nextpage=<%=pVO.getNextPageNo()%>" aria-label="Next"><span aria-hidden="true">&raquo;</span></a></li>
				    	<%} %>
				    	
				    <%} %>
			     </ul>
			</nav>
		</div>
		<div class="searchbox">
			<select class="search-type" name="inpStype" id="searchTypeList">
				<option value="i">사용자 ID</option>
				<option value="p">등급</option>
				<option value="nm">이름</option>
				<option value="nk">닉네임</option>
				<option value="e">E-mail</option>
				<option value="t">전화번호</option>
			</select>
			<div class="search-form">
				<input type="text" class="search-content" name="inpScntnt">
				<button type="button" class="btn btn-danger" id="btn_brdSearch" onclick="memSearch()">검색</button>
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
			$("#check_all").click(function(){
		        var chk = $(this).is(":checked");//.attr('checked');
		        if(chk) $('input[name="memCbox"]').prop('checked', true);
		        else  $('input[name="memCbox"]').prop('checked', false);
		    });
			
			$('#pboard-list tr').on('click',function(e){
				$("#modal_memPermission").val($(this).find('td').eq(1)[0].id);
				$('#modal_memId').text($(this).find('td').eq(2).text());
				$('#modal_memNm').text($(this).find('td').eq(3).text());
				$('#modal_memNk').text($(this).find('td').eq(4).text());
				$('#modal_memEmail').text($(this).find('td').eq(5).text());
				$('#modal_memTell').text($(this).find('td').eq(6).text());
				$('#modal_regDate').text($(this).find('td').eq(7).text());
			});
			
		});
	
		function memSearch(){
			submitPost('member_search.do', {'stype':$('select[name="inpStype"]').val(), 'sCntnt':$('input[name=inpScntnt]').val()});
		}
		function deleteMember(){
			if(!confirm("체크하신 회원(들)을 삭제하시겠습니까?")){
				return
			}else{
				var list=[];
				$("input[name=memCbox]:checked").each(function() {
					list.push($(this)[0].id);
				});
				if(list != ""){
					submitPost('member_delete.do', {'index': list });
					alert("삭제 되었습니다.");
				}else{
					alert("회원 삭제 할 대상을 선택하세요.");
				}
			}
		}
		function modifyMember(){
			if(!confirm($('#modal_memNm').text()+"님의 등급을 변경하시겠습니까?")){
				return
			}else{
				submitPost('member_modify.do', {'memId': $('#modal_memId').text(), 'ptype':$('select[name="inpPtype"]').val()});
				alert("변경되었습니다.");
			}
		}
	</script>
</html>
