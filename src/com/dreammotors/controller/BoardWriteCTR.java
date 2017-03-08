package com.dreammotors.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.plaf.synth.SynthSplitPaneUI;

import com.dreammotors.dao.BoardDAO;
import com.dreammotors.dao.MemberDAO;
import com.dreammotors.vo.BoardVO;
import com.dreammotors.vo.MemberVO;

@WebServlet({"/pubrd_write.do", "/sabrd_write.do",  "/cubrd_write.do", "/nobrd_write.do",  "/rebrd_write.do"})
public class BoardWriteCTR extends HttpServlet {
	private static final long serialVersionUID = -2903193518903646951L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String requestPath = request.getRequestURI().replaceAll("/DreamMotors","");
		//switch(requestPath){
		switch(request.getRequestURI()){
			case "/pubrd_write.do":
				pubrd_write(request, response);
				break;
			case "/sabrd_write.do":
				sabrd_write(request, response);
				break;
			case "/cubrd_write.do":
				cubrd_write(request, response);
				break;
			case "/nobrd_write.do":
				nobrd_write(request, response);
				break;
			case "/rebrd_write.do":
				rebrd_write(request, response);
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
	
	public void pubrd_write(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String url = "/consult_purchase_write.jsp";
		if(session.getAttribute("UID") != null){
			MemberDAO mDAO = new MemberDAO();
			try {
				if(mDAO.isAdmin(session.getAttribute("UID").toString())){
					url = "/ad_consult_purchase_write.jsp";
				}
			} catch (Exception e1) {}
		}
		BoardVO bVO = new BoardVO();
		bVO.setbTypeId(request.getParameter("inpBtype"));
		bVO.setBoardTitle(new String(request.getParameter("inpTitle").getBytes("ISO-8859-1"), "UTF-8"));
		bVO.setBoardIsPrivate(request.getParameter("isPrivate") != null ? 1 : 0);
		bVO.setBoardRegName(new String(request.getParameter("inpNm").getBytes("ISO-8859-1"), "UTF-8"));
		bVO.setBoardTell(request.getParameter("inpTell"));
		bVO.setBoardContext(new String(request.getParameter("inpContent").getBytes("ISO-8859-1"), "UTF-8"));
		bVO.setBoardRegPW(new String(request.getParameter("inpPw").getBytes("ISO-8859-1"), "UTF-8"));
		String uid = new String(request.getParameter("uid").getBytes("ISO-8859-1"), "UTF-8");
		if(uid.equals(null) || uid == null || uid.equals("null")){
		}else{
			bVO.setMemId(uid);
		}
		BoardDAO dao = new BoardDAO();
		try {
			int result = dao.doInsertConsultBoard(bVO);
			if(result == 1){
				request.setAttribute("CHECK", "isu");
			}else{
				request.setAttribute("CHECK", "ifa");
			}
		} catch (Exception e) {
			
		}
		MemberVO mVO = new MemberVO();
		mVO.setMemName(new String(request.getParameter("inpNm").getBytes("ISO-8859-1"), "UTF-8"));
		mVO.setMemTell(request.getParameter("inpTell"));
		request.setAttribute("RESULT", mVO);
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
	
	public void sabrd_write(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String url = "/consult_sales_write.jsp";
		if(session.getAttribute("UID") != null){
			MemberDAO mDAO = new MemberDAO();
			try {
				if(mDAO.isAdmin(session.getAttribute("UID").toString())){
					url = "/ad_consult_sales_write.jsp";
				}
			} catch (Exception e1) {}
		}
		BoardVO bVO = new BoardVO();
		bVO.setbTypeId(request.getParameter("inpBtype"));
		bVO.setBoardTitle(new String(request.getParameter("inpTitle").getBytes("ISO-8859-1"), "UTF-8"));
		bVO.setBoardIsPrivate(request.getParameter("isPrivate") != null ? 1 : 0);
		bVO.setBoardRegName(new String(request.getParameter("inpNm").getBytes("ISO-8859-1"), "UTF-8"));
		bVO.setBoardTell(request.getParameter("inpTell"));
		bVO.setBoardContext(new String(request.getParameter("inpContent").getBytes("ISO-8859-1"), "UTF-8"));
		bVO.setBoardRegPW(new String(request.getParameter("inpPw").getBytes("ISO-8859-1"), "UTF-8"));
		String uid = new String(request.getParameter("uid").getBytes("ISO-8859-1"), "UTF-8");
		if(uid.equals(null) || uid == null || uid.equals("null")){
		}else{
			bVO.setMemId(uid);
		}
		BoardDAO dao = new BoardDAO();
		try {
			int result = dao.doInsertConsultBoard(bVO);
			if(result == 1){
				request.setAttribute("CHECK", "isu");
			}else{
				request.setAttribute("CHECK", "ifa");
			}
		} catch (Exception e) {
			
		}
		MemberVO mVO = new MemberVO();
		mVO.setMemName(new String(request.getParameter("inpNm").getBytes("ISO-8859-1"), "UTF-8"));
		mVO.setMemTell(request.getParameter("inpTell"));
		request.setAttribute("RESULT", mVO);
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
	
	public void nobrd_write(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberVO mVO = new MemberVO();
		mVO.setMemId(new String(request.getParameter("uid").getBytes("ISO-8859-1"), "UTF-8"));
		MemberDAO mDAO = new MemberDAO();
		try {
			mVO = mDAO.doSelectUserInfo(mVO);
		} catch (Exception e) {
			
		}
		BoardVO bVO = new BoardVO();
		bVO.setBoardTitle(new String(request.getParameter("inpTitle").getBytes("ISO-8859-1"), "UTF-8"));
		bVO.setBoardIsNotice(request.getParameter("isNotice") != null ? 1 : 0);
		bVO.setBoardRegName(mVO.getMemName());
		bVO.setBoardTell(mVO.getMemTell());
		bVO.setBoardContext(new String(request.getParameter("inpContent").getBytes("ISO-8859-1"), "UTF-8"));
		bVO.setBoardRegPW(mVO.getMemPw());
		BoardDAO bDAO = new BoardDAO();
		try {
			int result = bDAO.doInsertNoticeBoard(bVO);
			if(result == 1){
				request.setAttribute("CHECK", "isu");
			}else{
				request.setAttribute("CHECK", "ifa");
			}
		} catch (Exception e) {
			
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/ad_community_notice_write.jsp");
		dispatcher.forward(request, response);
	}
	
	public void rebrd_write(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberVO mVO = new MemberVO();
		mVO.setMemId(new String(request.getParameter("uid").getBytes("ISO-8859-1"), "UTF-8"));
		MemberDAO mDAO = new MemberDAO();
		try {
			mVO = mDAO.doSelectUserInfo(mVO);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		BoardVO bVO = new BoardVO();
		bVO.setBoardTitle(new String(request.getParameter("inpTitle").getBytes("ISO-8859-1"), "UTF-8"));
		bVO.setBoardRegName(mVO.getMemName());
		bVO.setBoardTell(mVO.getMemTell());
		bVO.setBoardContext(new String(request.getParameter("inpContent").getBytes("ISO-8859-1"), "UTF-8"));
		bVO.setBoardRegPW(mVO.getMemPw());
		BoardDAO bDAO = new BoardDAO();
		try {
			int result = bDAO.doInsertReviewBoard(bVO);
			if(result == 1){
				request.setAttribute("CHECK", "isu");
			}else{
				request.setAttribute("CHECK", "ifa");
			}
		} catch (Exception e) {
			
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/ad_community_review_write.jsp");
		dispatcher.forward(request, response);
	}
	
	public void cubrd_write(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String url = "/community_customer_write.jsp";
		if(session.getAttribute("UID") != null){
			MemberDAO mDAO = new MemberDAO();
			try {
				if(mDAO.isAdmin(session.getAttribute("UID").toString())){
					url = "/ad_community_customer_write.jsp";
				}
			} catch (Exception e1) {}
		}
		BoardVO bVO = new BoardVO();
		bVO.setBoardTitle(new String(request.getParameter("inpTitle").getBytes("ISO-8859-1"), "UTF-8"));
		bVO.setBoardRegName(new String(request.getParameter("inpNm").getBytes("ISO-8859-1"), "UTF-8"));
		bVO.setBoardTell(request.getParameter("inpTell"));
		bVO.setBoardContext(new String(request.getParameter("inpContent").getBytes("ISO-8859-1"), "UTF-8"));
		bVO.setBoardRegPW(new String(request.getParameter("inpPw").getBytes("ISO-8859-1"), "UTF-8"));
		String uid = new String(request.getParameter("uid").getBytes("ISO-8859-1"), "UTF-8");
		if(uid.equals(null) || uid == null || uid.equals("null")){
		}else{
			bVO.setMemId(uid);
		}
		BoardDAO dao = new BoardDAO();
		try {
			int result = dao.doInsertCustomerBoard(bVO);
			if(result == 1){
				request.setAttribute("CHECK", "isu");
			}else{
				request.setAttribute("CHECK", "ifa");
			}
		} catch (Exception e) {
			
		}
		MemberVO returnVO = new MemberVO();
		returnVO.setMemName(new String(request.getParameter("inpNm").getBytes("ISO-8859-1"), "UTF-8"));
		returnVO.setMemTell(request.getParameter("inpTell"));
		request.setAttribute("RESULT", returnVO);
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
