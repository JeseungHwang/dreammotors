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

@WebServlet({ "/pubrd_delete.do", "/sabrd_delete.do", "/cubrd_delete.do", "/nobrd_delete.do", "/rebrd_delete.do" })
public class BoardDeleteCTR extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String requestPath = request.getRequestURI().replaceAll("/DreamMotors","");
		//switch(requestPath){
		switch(request.getRequestURI()){
			case "/pubrd_delete.do":
				pubrd_delete(request, response);
				break;
			case "/sabrd_delete.do":
				sabrd_delete(request, response);
				break;
			case "/cubrd_delete.do":
				cubrd_delete(request, response);
				break;
			case "/nobrd_delete.do":
				nobrd_delete(request, response);
				break;
			case "/rebrd_delete.do":
				rebrd_delete(request, response);
				break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
	
	private void pubrd_delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		boolean isAdmin = false;
		boolean isLogin = false;
		BoardVO bVO = new BoardVO();
		BoardDAO dao = new BoardDAO();
		String url = "/pubrd_content.do";
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
				int result = dao.doDeleteBoard(bVO);
				if(result == 1){
					url = "/pubrd.do";
					request.setAttribute("CHECK", "dsu");
				}else{
					url = "/pubrd_content.do";
					request.setAttribute("CHECK", "dfa");
				}
			} catch (Exception e) {}
		}else{		//일반 유저
			if(isLogin){	//로그인 한 유저
				bVO.setMemId(session.getAttribute("UID").toString());
				bVO.setBoardIndex(Integer.parseInt(request.getParameter("index")));
				if(isWriter(bVO)){		//해당 글 작성자 맞을때
					try {
						int result = dao.doDeleteBoard(bVO);	//비밀번호 값 비교안하고 삭제
						if(result == 1){
							url = "/pubrd.do";
							request.setAttribute("CHECK", "dsu");
						}else{
							url = "/pubrd_content.do";
							request.setAttribute("CHECK", "dfa");
						}
					} catch (Exception e) {
						
					}
				}
			}else{	//로그인 안한 유저
				bVO.setBoardIndex(Integer.parseInt(request.getParameter("index")));
				bVO.setBoardRegPW(new String(request.getParameter("brdPW").getBytes("ISO-8859-1"), "UTF-8"));
				try {
					int result = dao.doDeleteBoard(bVO);
					if(result == 1){
						url = "/pubrd.do";
						request.setAttribute("CHECK", "dsu");
					}else{
						url = "/pubrd_content.do";
						request.setAttribute("CHECK", "dfa");
					}
				} catch (Exception e) {
					
				}
			}
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
	
	private void sabrd_delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		boolean isAdmin = false;
		boolean isLogin = false;
		BoardVO bVO = new BoardVO();
		BoardDAO dao = new BoardDAO();
		String url = "/sabrd_content.do";
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
				int result = dao.doDeleteBoard(bVO);
				if(result == 1){
					url = "/sabrd.do";
					request.setAttribute("CHECK", "dsu");
				}else{
					url = "/sabrd_content.do";
					request.setAttribute("CHECK", "dfa");
				}
			} catch (Exception e) {
				
			}
		}else{		//일반 유저
			if(isLogin){	//로그인 한 유저
				bVO.setMemId(session.getAttribute("UID").toString());
				bVO.setBoardIndex(Integer.parseInt(request.getParameter("index")));
				if(isWriter(bVO)){		//해당 글 작성자 맞을때
					try {
						int result = dao.doDeleteBoard(bVO);	//비밀번호 값 비교안하고 삭제
						if(result == 1){
							url = "/sabrd.do";
							request.setAttribute("CHECK", "dsu");
						}else{
							url = "/sabrd_content.do";
							request.setAttribute("CHECK", "dfa");
						}
					} catch (Exception e) {
						
					}
				}
			}else{	//로그인 안한 유저
				bVO.setBoardIndex(Integer.parseInt(request.getParameter("index")));
				bVO.setBoardRegPW(new String(request.getParameter("brdPW").getBytes("ISO-8859-1"), "UTF-8"));
				try {
					int result = dao.doDeleteBoard(bVO);
					if(result == 1){
						url = "/sabrd.do";
						request.setAttribute("CHECK", "dsu");
					}else{
						url = "/sabrd_content.do";
						request.setAttribute("CHECK", "dfa");
					}
				} catch (Exception e) {
					
				}
			}
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
	
	private void cubrd_delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		boolean isAdmin = false;
		boolean isLogin = false;
		BoardVO bVO = new BoardVO();
		BoardDAO dao = new BoardDAO();
		String url = "/cubrd_content.do";
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
				int result = dao.doDeleteBoard(bVO);
				if(result == 1){
					url = "/cubrd.do";
					request.setAttribute("CHECK", "dsu");
				}else{
					url = "/cubrd_content.do";
					request.setAttribute("CHECK", "dfa");
				}
			} catch (Exception e) {
				
			}
		}else{		//일반 유저
			if(isLogin){	//로그인 한 유저
				bVO.setMemId(session.getAttribute("UID").toString());
				bVO.setBoardIndex(Integer.parseInt(request.getParameter("index")));
				if(isWriter(bVO)){		//해당 글 작성자 맞을때
					try {
						int result = dao.doDeleteBoard(bVO);	//비밀번호 값 비교안하고 삭제
						if(result == 1){
							url = "/cubrd.do";
							request.setAttribute("CHECK", "dsu");
						}else{
							url = "/cubrd_content.do";
							request.setAttribute("CHECK", "dfa");
						}
					} catch (Exception e) {
						
					}
				}
			}else{	//로그인 안한 유저
				bVO.setBoardIndex(Integer.parseInt(request.getParameter("index")));
				bVO.setBoardRegPW(new String(request.getParameter("brdPW").getBytes("ISO-8859-1"), "UTF-8"));
				try {
					int result = dao.doDeleteBoard(bVO);
					if(result == 1){
						url = "/cubrd.do";
						request.setAttribute("CHECK", "dsu");
					}else{
						url = "/cubrd_content.do";
						request.setAttribute("CHECK", "dfa");
					}
				} catch (Exception e) {
					
				}
			}
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
	
	private void nobrd_delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		boolean isAdmin = false;
		BoardVO bVO = new BoardVO();
		BoardDAO bDAO = new BoardDAO();
		String url = "/nobrd_content.do";
		if(session.getAttribute("UID") != null){
			MemberDAO mDAO = new MemberDAO();
			try {
				isAdmin = mDAO.isAdmin(session.getAttribute("UID").toString());
			} catch (Exception e1) {}
		}
		
		if(isAdmin){	//관리자 일때
			bVO.setBoardIndex(Integer.parseInt(request.getParameter("index")));
			try {
				int result = bDAO.doDeleteBoard(bVO);
				if(result == 1){
					url = "/nobrd.do";
					request.setAttribute("CHECK", "dsu");
				}
			} catch (Exception e) {
				
			}
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}
	
	private void rebrd_delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		boolean isAdmin = false;
		BoardVO bVO = new BoardVO();
		BoardDAO bDAO = new BoardDAO();
		String url = "/rebrd_content.do";
		if(session.getAttribute("UID") != null){
			MemberDAO mDAO = new MemberDAO();
			try {
				isAdmin = mDAO.isAdmin(session.getAttribute("UID").toString());
			} catch (Exception e1) {}
		}
		
		if(isAdmin){	//관리자 일때
			bVO.setBoardIndex(Integer.parseInt(request.getParameter("index")));
			try {
				int result = bDAO.doDeleteBoard(bVO);
				if(result == 1){
					request.setAttribute("CHECK", "dsu");
					url = "/rebrd.do";
				}
			} catch (Exception e) {
				
			}
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
