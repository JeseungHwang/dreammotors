package com.dreammotors.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dreammotors.dao.MemberDAO;
import com.dreammotors.vo.MemberVO;

/**
 * Servlet implementation class BoardWritePage
 */
@WebServlet({"/pubrd_wpg.do", "/sabrd_wpg.do",  "/cubrd_wpg.do", "/nobrd_wpg.do",  "/rebrd_wpg.do"})
public class BoardWritePage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		switch(request.getRequestURI()){
		case "/pubrd_wpg.do":
			pubrd_wpg(request, response);
			break;
		case "/sabrd_wpg.do":
			sabrd_wpg(request, response);
			break;
		case "/cubrd_wpg.do":
			cubrd_wpg(request, response);
			break;
		case "/nobrd_wpg.do":
			nobrd_wpg(request, response);
			break;
		case "/rebrd_wpg.do":
			rebrd_wpg(request, response);
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	public void pubrd_wpg(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String url = "/consult_purchase_write.jsp";
		MemberVO mVO = new MemberVO();
		if(session.getAttribute("UID") != null){
			MemberDAO mDAO = new MemberDAO();
			String uid = session.getAttribute("UID").toString();
			try {
				mVO = mDAO.doSelectUserBoardInfo(uid);
				request.setAttribute("RESULT", mVO);
				if(mDAO.isAdmin(uid)){
					url = "/ad_consult_purchase_write.jsp";
				}
			} catch (Exception e1) {}
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
	
	public void sabrd_wpg(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String url = "/consult_sales_write.jsp";
		MemberVO mVO = new MemberVO();
		if(session.getAttribute("UID") != null){
			MemberDAO mDAO = new MemberDAO();
			String uid = session.getAttribute("UID").toString();
			try {
				mVO = mDAO.doSelectUserBoardInfo(uid);
				request.setAttribute("RESULT", mVO);
				if(mDAO.isAdmin(uid)){
					url = "/ad_consult_sales_write.jsp";
				}
			} catch (Exception e1) {}
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
	
	public void cubrd_wpg(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String url = "/community_customer_write.jsp";
		MemberVO mVO = new MemberVO();
		if(session.getAttribute("UID") != null){
			MemberDAO mDAO = new MemberDAO();
			String uid = session.getAttribute("UID").toString();
			try {
				mVO = mDAO.doSelectUserBoardInfo(uid);
				request.setAttribute("RESULT", mVO);
				if(mDAO.isAdmin(uid)){
					url = "/ad_community_customer_write.jsp";
				}
			} catch (Exception e1) {}
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
	
	public void nobrd_wpg(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/ad_community_notice_write.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
	
	public void rebrd_wpg(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/ad_community_review_write.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
