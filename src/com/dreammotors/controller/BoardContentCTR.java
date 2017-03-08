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
import com.dreammotors.dao.BoardDAO;
import com.dreammotors.dao.MemberDAO;
import com.dreammotors.vo.BoardCommentVO;
import com.dreammotors.vo.BoardVO;

@WebServlet({ "/pubrd_content.do", "/sabrd_content.do", "/cubrd_content.do", "/nobrd_content.do", "/rebrd_content.do",
			"/pubrd_content_cpw.do", "/sabrd_content_cpw.do",})
public class BoardContentCTR extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String requestPath = request.getRequestURI().replaceAll("/DreamMotors","");
		//switch(requestPath){
		switch(request.getRequestURI()){
			case "/pubrd_content.do":
				pubrd_content(request, response);
				break;
			case "/pubrd_content_cpw.do":
				pubrd_content_cpw(request, response);
				break;
			case "/sabrd_content.do":
				sabrd_content(request, response);
				break;
			case "/sabrd_content_cpw.do":
				sabrd_content_cpw(request, response);
				break;
			case "/cubrd_content.do":
				cubrd_content(request, response);
				break;
			case "/nobrd_content.do":
				nobrd_content(request, response);
				break;
			case "/rebrd_content.do":
				rebrd_content(request, response);
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

	private void pubrd_content(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String url = "/consult_purchase_content.jsp";
		boolean isAdin = false;
		boolean isWriter = false;
		BoardVO bVO = new BoardVO();
		BoardDAO bDAO = new BoardDAO();
		BoardCommentVO cVO = new BoardCommentVO();
		BoardCommentDAO cDAO = new BoardCommentDAO();
		bVO.setBoardIndex(Integer.parseInt(request.getParameter("index")));
		if(session.getAttribute("UID") != null){
			MemberDAO mDAO = new MemberDAO();
			try {
				if(mDAO.isAdmin(session.getAttribute("UID").toString())){
					url = "/ad_consult_purchase_content.jsp";
					isAdin = true;
				}
			} catch (Exception e1) {}
			try{
				bVO.setMemId(session.getAttribute("UID").toString());
				if(mDAO.isBrdWriter(bVO)){
					isWriter = true;
				}
			}catch(Exception e2){}
		}
		cVO.setBoardIndex(Integer.parseInt(request.getParameter("index")));
		
		if(isAdin == false && isWriter == false){	//비로그인 사용자
			try {
				int check = bDAO.isPrivate(bVO);
				if(check==1){	//비로그인 사용자의 비밀글
					request.setAttribute("index", bVO.getBoardIndex());
					url = "/consult_purchase_comparePW.jsp";
				}else if(check==2){		//로그인 사용자의 비밀글
					request.setAttribute("CHECK", "nonAuoth");
					url = "/pubrd.do";
				}else{	//공개글
					try {
						bVO = bDAO.doSelectPurchaseBoard(bVO);
						bVO.setBoardViewCnt(bVO.getBoardViewCnt()+1);
						bDAO.doUpdateViewCnt(bVO);
						List<BoardCommentVO> VOList = cDAO.doSelectAllBoardComment(cVO);
						request.setAttribute("BOARD", bVO);
						request.setAttribute("COMMENT", VOList);
					} catch (Exception e) {}
				}
			} catch (Exception e2) {}
		}else{	//관리자나 글 게시자
			try {
				bVO = bDAO.doSelectPurchaseBoard2(bVO);
				bVO.setBoardViewCnt(bVO.getBoardViewCnt()+1);
				bDAO.doUpdateViewCnt(bVO);
				List<BoardCommentVO> VOList = cDAO.doSelectAllBoardComment(cVO);
				request.setAttribute("BOARD", bVO);
				request.setAttribute("COMMENT", VOList);
			} catch (Exception e) {}
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
	
	private void pubrd_content_cpw(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/consult_purchase_comparePW.jsp";
		BoardVO bVO = new BoardVO();
		BoardDAO bDAO = new BoardDAO();
		boolean flag = false;
		bVO.setBoardRegPW(new String(request.getParameter("inpPw").getBytes("ISO-8859-1"), "UTF-8"));
		bVO.setBoardIndex(Integer.parseInt(request.getParameter("index")));
		try {
			bVO = bDAO.doBoardComparePW(bVO);
			if(bVO.getBoardIndex() != 0){
				BoardCommentVO cVO = new BoardCommentVO();
				BoardCommentDAO cDAO = new BoardCommentDAO();
				bVO.setBoardViewCnt(bVO.getBoardViewCnt()+1);
				bDAO.doUpdateViewCnt(bVO);
				cVO.setBoardIndex(Integer.parseInt(request.getParameter("index")));
				List<BoardCommentVO> VOList = cDAO.doSelectAllBoardComment(cVO);
				request.setAttribute("BOARD", bVO);
				request.setAttribute("COMMENT", VOList);
				url="/consult_purchase_content.jsp";
			}
		} catch (Exception e) {request.setAttribute("index", request.getParameter("index"));}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
	
	private void sabrd_content(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String url = "/consult_sales_content.jsp";
		boolean isAdin = false;
		boolean isWriter = false;
		BoardVO bVO = new BoardVO();
		BoardDAO bDAO = new BoardDAO();
		BoardCommentVO cVO = new BoardCommentVO();
		BoardCommentDAO cDAO = new BoardCommentDAO();
		bVO.setBoardIndex(Integer.parseInt(request.getParameter("index")));
		if(session.getAttribute("UID") != null){
			MemberDAO mDAO = new MemberDAO();
			try {
				if(mDAO.isAdmin(session.getAttribute("UID").toString())){
					url = "/ad_consult_sales_content.jsp";
					isAdin = true;
				}
			} catch (Exception e1) {}
			try{
				bVO.setMemId(session.getAttribute("UID").toString());
				if(mDAO.isBrdWriter(bVO)){
					isWriter = true;
				}
			}catch(Exception e2){}
		}
		cVO.setBoardIndex(Integer.parseInt(request.getParameter("index")));
		
		if(isAdin == false && isWriter == false){	//비로그인 사용자
			try {
				int check = bDAO.isPrivate(bVO);
				if(check==1){	//비로그인 사용자의 비밀글
					request.setAttribute("index", bVO.getBoardIndex());
					url = "/consult_sales_comparePW.jsp";
				}else if(check==2){		//로그인 사용자의 비밀글
					request.setAttribute("CHECK", "nonAuoth");
					url = "/sabrd.do";
				}else{	//공개글
					try {
						bVO = bDAO.doSelectPurchaseBoard(bVO);
						bVO.setBoardViewCnt(bVO.getBoardViewCnt()+1);
						bDAO.doUpdateViewCnt(bVO);
						List<BoardCommentVO> VOList = cDAO.doSelectAllBoardComment(cVO);
						request.setAttribute("BOARD", bVO);
						request.setAttribute("COMMENT", VOList);
					} catch (Exception e) {}
				}
			} catch (Exception e2) {}
		}else{	//관리자나 글 게시자
			try {
				bVO = bDAO.doSelectPurchaseBoard2(bVO);
				bVO.setBoardViewCnt(bVO.getBoardViewCnt()+1);
				bDAO.doUpdateViewCnt(bVO);
				List<BoardCommentVO> VOList = cDAO.doSelectAllBoardComment(cVO);
				request.setAttribute("BOARD", bVO);
				request.setAttribute("COMMENT", VOList);
			} catch (Exception e) {}
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
	
	private void sabrd_content_cpw(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/consult_sales_comparePW.jsp";
		BoardVO bVO = new BoardVO();
		BoardDAO bDAO = new BoardDAO();
		boolean flag = false;
		bVO.setBoardRegPW(new String(request.getParameter("inpPw").getBytes("ISO-8859-1"), "UTF-8"));
		bVO.setBoardIndex(Integer.parseInt(request.getParameter("index")));
		try {
			bVO = bDAO.doBoardComparePW(bVO);
			if(bVO.getBoardIndex() != 0){
				bVO.setBoardViewCnt(bVO.getBoardViewCnt()+1);
				bDAO.doUpdateViewCnt(bVO);
				BoardCommentVO cVO = new BoardCommentVO();
				cVO.setBoardIndex(Integer.parseInt(request.getParameter("index")));
				BoardCommentDAO cDAO = new BoardCommentDAO();
				List<BoardCommentVO> VOList = cDAO.doSelectAllBoardComment(cVO);
				request.setAttribute("BOARD", bVO);
				request.setAttribute("COMMENT", VOList);
				url="/consult_sales_content.jsp";
			}
		} catch (Exception e) {request.setAttribute("index", request.getParameter("index"));}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
	
	private void nobrd_content(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String url = "/community_notice_content.jsp";
		BoardVO bVO = new BoardVO();
		bVO.setBoardIndex(Integer.parseInt(request.getParameter("index")));
		BoardDAO bDAO = new BoardDAO();
		if(session.getAttribute("UID") != null){
			MemberDAO mDAO = new MemberDAO();
			try {
				if(mDAO.isAdmin(session.getAttribute("UID").toString())){
					url = "/ad_community_notice_content.jsp";
				}
			} catch (Exception e1) {}
		}
		try {
			bVO = bDAO.doSelectNoticeBoard(bVO);
			bVO.setBoardViewCnt(bVO.getBoardViewCnt()+1);
			bDAO.doUpdateViewCnt(bVO);
			request.setAttribute("BOARD", bVO);
		} catch (Exception e) {}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
	
	private void rebrd_content(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String url = "/community_review_content.jsp";
		BoardVO bVO = new BoardVO();
		bVO.setBoardIndex(Integer.parseInt(request.getParameter("index")));
		BoardDAO bDAO = new BoardDAO();
		if(session.getAttribute("UID") != null){
			MemberDAO mDAO = new MemberDAO();
			try {
				if(mDAO.isAdmin(session.getAttribute("UID").toString())){
					url = "/ad_community_review_content.jsp";
				}
			} catch (Exception e1) {}
		}
		try {
			bVO = bDAO.doSelectReviewBoard(bVO);
			bVO.setBoardViewCnt(bVO.getBoardViewCnt()+1);
			bDAO.doUpdateViewCnt(bVO);
			request.setAttribute("BOARD", bVO);
		} catch (Exception e) {}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
	
	private void cubrd_content(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String url = "/community_customer_content.jsp";
		BoardVO bVO = new BoardVO();
		bVO.setBoardIndex(Integer.parseInt(request.getParameter("index")));
		BoardDAO bDAO = new BoardDAO();
		boolean isAdmin = false;
		if(session.getAttribute("UID") != null){
			MemberDAO mDAO = new MemberDAO();
			try {
				isAdmin = mDAO.isAdmin(session.getAttribute("UID").toString());
				if(isAdmin){
					url = "/ad_community_customer_content.jsp";
				}
			} catch (Exception e1) {}
		}
		try {
			if(isAdmin){
				bVO = bDAO.doSelectReviewBoard2(bVO);
			}else{
				bVO = bDAO.doSelectReviewBoard(bVO);
			}
			bVO.setBoardViewCnt(bVO.getBoardViewCnt()+1);
			bDAO.doUpdateViewCnt(bVO);
			request.setAttribute("BOARD", bVO);
			BoardCommentVO cVO = new BoardCommentVO();
			cVO.setBoardIndex(Integer.parseInt(request.getParameter("index")));
			BoardCommentDAO cDAO = new BoardCommentDAO();
			List<BoardCommentVO> VOList = cDAO.doSelectAllBoardComment(cVO);
			request.setAttribute("COMMENT", VOList);
		} catch (Exception e) {}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
