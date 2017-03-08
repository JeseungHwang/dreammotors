<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id="header">
	<div id="topmenu">
		<% if((String)session.getAttribute("UID") == null){ %>
		<label><a href="${pageContext.request.contextPath}/agreement.jsp">회원가입</a></label>
		<span class="span1"></span>
		<%}%>
		<% if((String)session.getAttribute("UID") != null){ %>
			<label><a href="${pageContext.request.contextPath}/myinfo.do">내 정보 수정</a></label>
			<span class="span1"></span>
			<label><a href="${pageContext.request.contextPath}/member_management.do">회원관리</a></label>
			<span class="span1"></span>
			<label><a href="${pageContext.request.contextPath}/logout.do">로그아웃</a></label> 
		<%}else{%>
			<label><a href="${pageContext.request.contextPath}/login.jsp">로그인</a></label>
		<%} %>
	</div>
	<div id="clogo">
		<img alt="" src="img/banner/logo.png">
	</div>
	<nav class="navbar navbar-default" role="navigation">
		<ul class="nav navbar-nav" style="margin:0;">
			<li class="dropdown">
				<a class="navbar-toggle" data-toggle="dropdown" href="#">메인 화면</a>
				<ul class="dropdown-menu">
	                <li><a href="${pageContext.request.contextPath}/mainview.do">메인 화면</a></li>
	            </ul>
	        </li>
	        <li class="dropdown">
				<a class="navbar-toggle"  data-toggle="dropdown" href="${pageContext.request.contextPath}/companyinfo.do">드림모터스</a>
				<ul class="dropdown-menu">
	                <li><a href="${pageContext.request.contextPath}/companyinfo.do">회사 소개</a></li>
	                <li role="separator" class="divider"></li>
	                <li><a href="${pageContext.request.contextPath}/familyinfo.do">직원 소개</a></li>
	                <li role="separator" class="divider"></li>
	                <li><a href="${pageContext.request.contextPath}/direction.do">찾아오시는 길</a></li>
	            </ul>
			</li>
			<li class="dropdown">
				<a class="navbar-toggle"  data-toggle="dropdown" href="${pageContext.request.contextPath}/process.do">구입 프로세스</a>
				<ul class="dropdown-menu">
	                <li><a href="${pageContext.request.contextPath}/process.do">구입 프로세스</a></li>
	            </ul>
			</li>
			<li class="dropdown">
				<a class="navbar-toggle"  data-toggle="dropdown" href="${pageContext.request.contextPath}/pubrd.do">고객 상담</a>
				<ul class="dropdown-menu">
	                <li><a href="${pageContext.request.contextPath}/pubrd.do">중고차 구입문의</a></li>
	                <li role="separator" class="divider"></li>
	                <li><a href="${pageContext.request.contextPath}/sabrd.do">중고차 판매문의</a></li>
	            </ul>
			</li>
			<li class="dropdown">
				<a class="navbar-toggle"  data-toggle="dropdown" href="${pageContext.request.contextPath}/nobrd.do">커뮤니티</a>
				<ul class="dropdown-menu">
	                <li><a href="${pageContext.request.contextPath}/nobrd.do">공지사항</a></li>
	                <li role="separator" class="divider"></li>
	                <li><a href="${pageContext.request.contextPath}/rebrd.do">차량 판매 후기</a></li>
	                <li role="separator" class="divider"></li>
	                <li><a href="${pageContext.request.contextPath}/cubrd.do">고객 후기</a></li>
	            </ul>
			</li>
		</ul>
	</nav>
</div>