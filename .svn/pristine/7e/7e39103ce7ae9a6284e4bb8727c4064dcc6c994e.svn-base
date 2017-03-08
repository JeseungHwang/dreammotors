package com.dreammotors.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dreammotors.dao.BoardCommentDAO;
import com.dreammotors.dao.MemberDAO;
import com.dreammotors.vo.BoardCommentVO;

/**
 * Servlet implementation class BoardCommentCTR
 */
@WebServlet({"/sacomment_add.do", "/pucomment_add.do", "/cucomment_add.do", "/comment_delete.do"})
public class BoardCommentCTR extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String requestPath = request.getRequestURI().replaceAll("/DreamMotors","");
		//switch(requestPath){
		switch(request.getRequestURI()){
		case "/sacomment_add.do":
			sacomment_add(request, response);
			break;
		case "/pucomment_add.do":
			pucomment_add(request, response);
			break;
		case "/cucomment_add.do":
			cucomment_add(request, response);
			break;
		case "/comment_delete.do":
			comment_delete(request, response);
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void sacomment_add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String url = "/sabrd_content.do";
		BoardCommentDAO cDAO = new BoardCommentDAO();
		BoardCommentVO cVO = new BoardCommentVO();
		if(session.getAttribute("UID") != null){
			cVO.setMemId(session.getAttribute("UID").toString());
		}
		cVO.setBoardIndex(Integer.parseInt(request.getParameter("index")));
		cVO.setBcmtRegName(new String(request.getParameter("regNm").getBytes("ISO-8859-1"), "UTF-8"));
		cVO.setBcmtContext(new String(request.getParameter("cmt").getBytes("ISO-8859-1"), "UTF-8"));
		try {
			cVO.setBcmtOrder(cDAO.doSelectBoardOrderCnt(Integer.parseInt(request.getParameter("index")))+1);
		} catch (Exception e) {
			cVO.setBcmtOrder(0);
		}
		try {
			int flag = cDAO.doInsertBoardComment(cVO);
		} catch (Exception e) {}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
	
	private void pucomment_add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String url = "/pubrd_content.do";
		BoardCommentDAO cDAO = new BoardCommentDAO();
		BoardCommentVO cVO = new BoardCommentVO();
		if(session.getAttribute("UID") != null){
			cVO.setMemId(session.getAttribute("UID").toString());
		}
		cVO.setBoardIndex(Integer.parseInt(request.getParameter("index")));
		cVO.setBcmtRegName(new String(request.getParameter("regNm").getBytes("ISO-8859-1"), "UTF-8"));
		cVO.setBcmtContext(new String(request.getParameter("cmt").getBytes("ISO-8859-1"), "UTF-8"));
		try {
			cVO.setBcmtOrder(cDAO.doSelectBoardOrderCnt(Integer.parseInt(request.getParameter("index")))+1);
		} catch (Exception e) {
			cVO.setBcmtOrder(0);
		}
		try {
			int flag = cDAO.doInsertBoardComment(cVO);
		} catch (Exception e) {}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
	
	private void cucomment_add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String url = "/cubrd_content.do";
		BoardCommentDAO cDAO = new BoardCommentDAO();
		BoardCommentVO cVO = new BoardCommentVO();
		if(session.getAttribute("UID") != null){
			cVO.setMemId(session.getAttribute("UID").toString());
		}
		cVO.setBoardIndex(Integer.parseInt(request.getParameter("index")));
		cVO.setBcmtRegName(new String(request.getParameter("regNm").getBytes("ISO-8859-1"), "UTF-8"));
		cVO.setBcmtContext(new String(request.getParameter("cmt").getBytes("ISO-8859-1"), "UTF-8"));
		try {
			cVO.setBcmtOrder(cDAO.doSelectBoardOrderCnt(Integer.parseInt(request.getParameter("index")))+1);
		} catch (Exception e) {
			cVO.setBcmtOrder(0);
		}
		try {
			int flag = cDAO.doInsertBoardComment(cVO);
		} catch (Exception e) {}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
	
	private void comment_delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String url = "/sabrd_content.do";
		BoardCommentDAO cDAO = new BoardCommentDAO();
		BoardCommentVO cVO = new BoardCommentVO();
		boolean isAdmin = false;
		boolean isWriter = false;
		
		cVO.setBoardIndex(Integer.parseInt(request.getParameter("index")));
		cVO.setBcmtOrder(Integer.parseInt(request.getParameter("order")));
		if(session.getAttribute("UID") != null){
			cVO.setMemId(session.getAttribute("UID").toString());
			MemberDAO mDAO = new MemberDAO();
			try {
				isAdmin = mDAO.isAdmin(session.getAttribute("UID").toString());
			} catch (Exception e1) {}
			try {
				isWriter = mDAO.isCommentWriter(cVO);
			} catch (Exception e1) {}
		}
		if(isAdmin || isWriter){
			try {
				cDAO.doDeleteBoardComment(cVO);
			} catch (Exception e) {}
		}else{
			request.setAttribute("CHECK", "noauth");
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
