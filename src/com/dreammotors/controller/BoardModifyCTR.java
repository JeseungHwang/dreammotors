package com.dreammotors.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dreammotors.dao.BoardDAO;
import com.dreammotors.dao.MemberDAO;
import com.dreammotors.vo.BoardVO;

/**
 * Servlet implementation class BoardModifyCTR
 */
@WebServlet({ "/pubrd_modify.do", "/sabrd_modify.do", "/cubrd_modify.do", "/nobrd_modify.do", "/rebrd_modify.do", 
			  "/pubrd_comparePW.do", "/sabrd_comparePW.do", "/cubrd_comparePW.do", "/nobrd_modiform.do", "/rebrd_modiform.do"})
public class BoardModifyCTR extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String requestPath = request.getRequestURI().replaceAll("/DreamMotors","");
		//switch(requestPath){
		switch(request.getRequestURI()){
			case "/pubrd_comparePW.do":
				pubrd_comparePW(request, response);
				break;
			case "/pubrd_modify.do":
				pubrd_modify(request, response);
				break;
			case "/sabrd_comparePW.do":
				sabrd_comparePW(request, response);
				break;
			case "/sabrd_modify.do":
				sabrd_modify(request, response);
				break;
			case "/cubrd_comparePW.do":
				cubrd_comparePW(request, response);
				break;
			case "/cubrd_modify.do":
				cubrd_modify(request, response);
				break;
			case "/nobrd_modiform.do":
				nobrd_modiform(request, response);
				break;
			case "/nobrd_modify.do":
				nobrd_modify(request, response);
				break;
			case "/rebrd_modify.do":
				rebrd_modify(request, response);
				break;
			case "/rebrd_modiform.do":
				rebrd_modiform(request, response);
				break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private boolean isAdmin(String uid) throws ServletException, IOException {
		MemberDAO mDAO = new MemberDAO();
		boolean isAdmin = false;
		try {
			isAdmin = mDAO.isAdmin(uid);
		} catch (Exception e1) {}
		return isAdmin;
	}
	
	private boolean isWriter(BoardVO bVO) throws ServletException, IOException {
		MemberDAO mDAO = new MemberDAO();
		boolean writer = false;
		try {
			writer = mDAO.isBrdWriter(bVO);
		} catch (Exception e1) {}
		return writer;
	}
	
	private void pubrd_comparePW(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession session = request.getSession();
		boolean isAdmin = false;
		boolean isLogin = false;
		String url = "/pubrd_content.do";
		BoardVO bVO = new BoardVO();
		BoardDAO dao = new BoardDAO();
		if(session.getAttribute("UID") != null){
			isLogin = true;
			MemberDAO mDAO = new MemberDAO();
			try {
				isAdmin = mDAO.isAdmin(session.getAttribute("UID").toString());
			} catch (Exception e1) {}
		}

		if(isAdmin){	//관리자 일때
			bVO.setBoardIndex(Integer.parseInt(request.getParameter("index")));
			try {
				bVO = dao.doModifyConsultBoard(bVO);
				request.setAttribute("BOARD", bVO);
				url = "/ad_consult_purchase_modify.jsp";
			} catch (Exception e) {}
		}else{	//일반 유저	
			if(isLogin){	//로그인 한 유저
				bVO.setBoardIndex(Integer.parseInt(request.getParameter("index")));
				bVO.setMemId(session.getAttribute("UID").toString());
				if(isWriter(bVO)){		//해당 글 작성자 맞을때
					try {
						bVO = dao.doModifyCustomerBoard(bVO);
						request.setAttribute("BOARD", bVO);
						url = "/consult_purchase_modify.jsp";
					} catch (Exception e) {}
				}
			}else{	//로그인 안한 유저
				bVO.setBoardIndex(Integer.parseInt(request.getParameter("index")));
				bVO.setBoardRegPW(new String(request.getParameter("brdPW").getBytes("ISO-8859-1"), "UTF-8"));
				try {
					bVO = dao.doModifyCustomerBoard(bVO);
					if(bVO != null){
						request.setAttribute("BOARD", bVO);
						url = "/consult_purchase_modify.jsp";
					}else{
						request.setAttribute("CHECK", "fail");
						request.setAttribute("index", request.getParameter("index"));
						url = "/pubrd_content.do";
					}
				} catch (Exception e) {
				}
			}
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

	private void pubrd_modify(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		BoardVO bVO = new BoardVO();
		bVO.setBoardIndex(Integer.parseInt(request.getParameter("index")));
		bVO.setbTypeId(request.getParameter("inpBtype"));
		bVO.setBoardIsPrivate(request.getParameter("inpIsPrivate").equals("true") ? 1 : 0);
		bVO.setBoardTitle(new String(request.getParameter("inpTitle").getBytes("ISO-8859-1"), "UTF-8"));
		bVO.setBoardRegName(new String(request.getParameter("inpNm").getBytes("ISO-8859-1"), "UTF-8"));
		bVO.setBoardTell(request.getParameter("inpTell"));
		bVO.setBoardContext(new String(request.getParameter("inpContent").getBytes("ISO-8859-1"), "UTF-8"));
		BoardDAO dao = new BoardDAO();
		String url = null;
		try {
			int result = dao.doUpdateConsultBoard(bVO);
			if(result == 1){
				request.setAttribute("CHECK", "msu");
				url = "/pubrd.do";
			}else{
				request.setAttribute("CHECK", "mfa");
				url = "/pubrd_modify.do";
			}
		} catch (Exception e) {
			
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
	
	private void sabrd_comparePW(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession session = request.getSession();
		boolean isAdmin = false;
		boolean isLogin = false;
		String url = "/sabrd_content.do";
		BoardVO bVO = new BoardVO();
		BoardDAO dao = new BoardDAO();
		if(session.getAttribute("UID") != null){
			isLogin = true;
			MemberDAO mDAO = new MemberDAO();
			try {
				isAdmin = mDAO.isAdmin(session.getAttribute("UID").toString());
			} catch (Exception e1) {}
		}

		if(isAdmin){	//관리자 일때
			bVO.setBoardIndex(Integer.parseInt(request.getParameter("index")));
			try {
				bVO = dao.doModifyConsultBoard(bVO);
				request.setAttribute("BOARD", bVO);
				url = "/ad_consult_sales_modify.jsp";
			} catch (Exception e) {}
		}else{	//일반 유저	
			if(isLogin){	//로그인 한 유저
				bVO.setBoardIndex(Integer.parseInt(request.getParameter("index")));
				bVO.setMemId(session.getAttribute("UID").toString());
				if(isWriter(bVO)){		//해당 글 작성자 맞을때
					try {
						bVO = dao.doModifyCustomerBoard(bVO);
						request.setAttribute("BOARD", bVO);
						url = "/consult_sales_modify.jsp";
					} catch (Exception e) {}
				}
			}else{	//로그인 안한 유저
				bVO.setBoardIndex(Integer.parseInt(request.getParameter("index")));
				bVO.setBoardRegPW(new String(request.getParameter("brdPW").getBytes("ISO-8859-1"), "UTF-8"));
				try {
					bVO = dao.doModifyCustomerBoard(bVO);
					if(bVO != null){
						request.setAttribute("BOARD", bVO);
						url = "/consult_sales_modify.jsp";
					}else{
						request.setAttribute("CHECK", "fail");
						request.setAttribute("index", request.getParameter("index"));
						url = "/sabrd_content.do";
					}
				} catch (Exception e) {
				}
			}
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

	private void sabrd_modify(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		BoardVO bVO = new BoardVO();
		bVO.setBoardIndex(Integer.parseInt(request.getParameter("index")));
		bVO.setbTypeId(request.getParameter("inpBtype"));
		bVO.setBoardIsPrivate(request.getParameter("inpIsPrivate").equals("true") ? 1 : 0);
		bVO.setBoardTitle(new String(request.getParameter("inpTitle").getBytes("ISO-8859-1"), "UTF-8"));
		bVO.setBoardRegName(new String(request.getParameter("inpNm").getBytes("ISO-8859-1"), "UTF-8"));
		bVO.setBoardTell(request.getParameter("inpTell"));
		bVO.setBoardContext(new String(request.getParameter("inpContent").getBytes("ISO-8859-1"), "UTF-8"));
		BoardDAO dao = new BoardDAO();
		String url = null;
		try {
			int result = dao.doUpdateConsultBoard(bVO);
			if(result == 1){
				request.setAttribute("CHECK", "msu");
				url = "/sabrd.do";
			}else{
				request.setAttribute("CHECK", "mfa");
				url = "/sabrd_modify.do";
			}
		} catch (Exception e) {
			
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
	
	private void cubrd_comparePW(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession session = request.getSession();
		boolean isAdmin = false;
		boolean isLogin = false;
		String url = "/cubrd_content.do";
		BoardVO bVO = new BoardVO();
		BoardDAO dao = new BoardDAO();
		if(session.getAttribute("UID") != null){
			isLogin = true;
			MemberDAO mDAO = new MemberDAO();
			try {
				isAdmin = mDAO.isAdmin(session.getAttribute("UID").toString());
			} catch (Exception e1) {}
		}
		if(isAdmin){	//관리자 일때
			bVO.setBoardIndex(Integer.parseInt(request.getParameter("index")));
			try {
				bVO = dao.doModifyCustomerBoard(bVO);
				request.setAttribute("BOARD", bVO);
				url = "/ad_community_customer_modify.jsp";
			} catch (Exception e) {}
		}else{		//일반 유저
			if(isLogin){	//로그인 한 유저
				bVO.setBoardIndex(Integer.parseInt(request.getParameter("index")));
				bVO.setMemId(session.getAttribute("UID").toString());
				if(isWriter(bVO)){		//해당 글 작성자 맞을때
					try {
						bVO = dao.doModifyCustomerBoard(bVO);
						request.setAttribute("BOARD", bVO);
						url = "/community_customer_modify.jsp";
					} catch (Exception e) {}
				}
			}else{	//로그인 안한 유저
				bVO.setBoardIndex(Integer.parseInt(request.getParameter("index")));
				bVO.setBoardRegPW(new String(request.getParameter("brdPW").getBytes("ISO-8859-1"), "UTF-8"));
				try {
					bVO = dao.doModifyCustomerBoard(bVO);
					if(bVO != null){
						request.setAttribute("BOARD", bVO);
						url = "/community_customer_modify.jsp";
					}else{
						request.setAttribute("CHECK", "fail");
						request.setAttribute("index", request.getParameter("index"));
						url = "/cubrd_content.do";
					}
				} catch (Exception e) {
				}
			}
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

	private void cubrd_modify(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		BoardVO bVO = new BoardVO();
		bVO.setBoardIndex(Integer.parseInt(request.getParameter("index")));
		bVO.setBoardTitle(new String(request.getParameter("inpTitle").getBytes("ISO-8859-1"), "UTF-8"));
		bVO.setBoardRegName(new String(request.getParameter("inpNm").getBytes("ISO-8859-1"), "UTF-8"));
		bVO.setBoardTell(request.getParameter("inpTell"));
		bVO.setBoardContext(new String(request.getParameter("inpContent").getBytes("ISO-8859-1"), "UTF-8"));
		BoardDAO dao = new BoardDAO();
		String url = null;
		try {
			int result = dao.doUpdateCustomerBoard(bVO);
			if(result == 1){
				request.setAttribute("CHECK", "msu");
				url = "/cubrd.do";
			}else{
				request.setAttribute("RESULT", "mfa");
				url = "/cubrd_modify.do";
			}
		} catch (Exception e) {
			
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
	
	private void nobrd_modiform(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession session = request.getSession();
		String url = "/nobrd_content.do";
		boolean isAdmin = false;
		if(session.getAttribute("UID") != null){
			MemberDAO mDAO = new MemberDAO();
			try {
				isAdmin = mDAO.isAdmin(session.getAttribute("UID").toString());
			} catch (Exception e1) {}
		}
		if(isAdmin){	//관리자 일때
			BoardVO bVO = new BoardVO();
			bVO.setBoardIndex(Integer.parseInt(request.getParameter("index")));
			BoardDAO dao = new BoardDAO();
			try {
				bVO = dao.doSelectNoticeBoard(bVO);
				url = "/ad_community_notice_modify.jsp";
				request.setAttribute("BOARD", bVO);
			} catch (Exception e) {}
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
		}else{
			request.setAttribute("CHECK", "fail");
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
		}
	}
	
	private void nobrd_modify(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession session = request.getSession();
		String url = "/nobrd_content.do";
		boolean isAdmin = false;
		if(session.getAttribute("UID") != null){
			MemberDAO mDAO = new MemberDAO();
			try {
				isAdmin = mDAO.isAdmin(session.getAttribute("UID").toString());
			} catch (Exception e1) {}
		}
		
		if(isAdmin){	//관리자 일때
			BoardVO bVO = new BoardVO();
			bVO.setBoardIndex(Integer.parseInt(request.getParameter("index")));
			bVO.setBoardTitle(new String(request.getParameter("inpTitle").getBytes("ISO-8859-1"), "UTF-8"));
			bVO.setBoardIsNotice(request.getParameter("isNotice") != null ? 1 : 0);
			bVO.setBoardContext(new String(request.getParameter("inpContent").getBytes("ISO-8859-1"), "UTF-8"));
			BoardDAO dao = new BoardDAO();
			try {
				int result = dao.doUpdateNoticeBoard(bVO);
				if(result == 1){
					request.setAttribute("CHECK", "msu");
					url = "/nobrd.do";
				}else{
					request.setAttribute("CHECK", "mfa");
					url = "/ad_nobrd_modify.do";
				}
			} catch (Exception e) {
				
			}
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
	
	private void rebrd_modify(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession session = request.getSession();
		String url = "/rebrd_content.do";
		boolean isAdmin = false;
		if(session.getAttribute("UID") != null){
			MemberDAO mDAO = new MemberDAO();
			try {
				isAdmin = mDAO.isAdmin(session.getAttribute("UID").toString());
			} catch (Exception e1) {}
		}
		
		if(isAdmin){	//관리자 일때
			BoardVO bVO = new BoardVO();
			bVO.setBoardIndex(Integer.parseInt(request.getParameter("index")));
			bVO.setBoardTitle(new String(request.getParameter("inpTitle").getBytes("ISO-8859-1"), "UTF-8"));
			bVO.setBoardContext(new String(request.getParameter("inpContent").getBytes("ISO-8859-1"), "UTF-8"));
			BoardDAO dao = new BoardDAO();
			try {
				int result = dao.doUpdateReviewBoard(bVO);
				if(result == 1){
					request.setAttribute("CHECK", "msu");
					url = "/rebrd.do";
				}else{
					request.setAttribute("CHECK", "mfa");
					url = "/rebrd_modify.do";
				}
			} catch (Exception e) {
				
			}
		}else{
			request.setAttribute("CHECK", "fail");
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
	
	private void rebrd_modiform(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession session = request.getSession();
		String url = "/rebrd_content.do";
		boolean isAdmin = false;
		if(session.getAttribute("UID") != null){
			MemberDAO mDAO = new MemberDAO();
			try {
				isAdmin = mDAO.isAdmin(session.getAttribute("UID").toString());
			} catch (Exception e1) {}
		}
		if(isAdmin){	//관리자 일때
			BoardVO bVO = new BoardVO();
			bVO.setBoardIndex(Integer.parseInt(request.getParameter("index")));
			BoardDAO dao = new BoardDAO();
			try {
				bVO = dao.doSelectReviewBoard(bVO);
				request.setAttribute("BOARD", bVO);
				url = "/ad_community_review_modify.jsp";
			} catch (Exception e) {}
		}else{
			request.setAttribute("CHECK", "fail");
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
