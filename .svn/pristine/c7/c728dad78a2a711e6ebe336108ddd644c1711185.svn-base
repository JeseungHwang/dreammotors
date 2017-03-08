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

import com.dreammotors.dao.BoardDAO;
import com.dreammotors.dao.MemberDAO;
import com.dreammotors.vo.BoardVO;
import com.dreammotors.vo.PagingVO;

/**
 * Servlet implementation class BoardSelectCTR
 */
@WebServlet({ "/pubrd.do", "/pubrd_search.do", "/sabrd.do", "/sabrd_search.do", "/cubrd.do", "/cubrd_search.do", 
	"/nobrd.do", "/nobrd_search.do", "/rebrd.do", "/rebrd_search.do", "/mainview.do", "/process.do"})
public class BoardListCTR extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String requestPath = request.getRequestURI().replaceAll("/DreamMotors","");
		//switch(requestPath){
		switch(request.getRequestURI()){
		case "/pubrd.do":
			pubrd(request, response);
			break;
		case "/pubrd_search.do":
			pubrd_search(request, response);
			break;
		case "/sabrd.do":
			sabrd(request, response);
			break;
		case "/sabrd_search.do":
			sabrd_search(request, response);
			break;
		case "/cubrd.do":
			cubrd(request, response);
			break;
		case "/cubrd_search.do":
			cubrd_search(request, response);
			break;
		case "/nobrd.do":
			nobrd(request, response);
			break;
		case "/nobrd_search.do":
			nobrd_search(request, response);
			break;
		case "/rebrd.do":
			rebrd(request, response);
			break;
		case "/rebrd_search.do":
			rebrd_search(request, response);
			break;
		case "/mainview.do":
			mainview(request, response);
			break;
		case "/process.do":
			process(request, response);
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
	
	private PagingVO setPaging(HttpServletRequest request) throws ServletException, IOException {
		PagingVO pVO = new PagingVO();
		pVO.setStartPageNo(1);
		pVO.setFirstPageNo(1);
		pVO.setEndPageNo(1);
		pVO.setFinalPageNo(1);
		if(request.getParameter("page")!=null){
			int selectPage = Integer.parseInt(request.getParameter("page"));
			pVO.setPageNo(selectPage);
			pVO.setFirstPageNo(((selectPage-1)/10)*10+1);
			pVO.setNextPageNo(pVO.getFirstPageNo()/10+1);
			pVO.setPrevPageNo(pVO.getNextPageNo()-1);
		}
		if(request.getParameter("nextpage")!=null){
			int nextPage = Integer.parseInt(request.getParameter("nextpage"));
			pVO.setFirstPageNo(nextPage*10+1);
			pVO.setPageNo(nextPage*10+1);
			pVO.setNextPageNo(nextPage+1);
			pVO.setPrevPageNo(nextPage);
		}
		if(request.getParameter("prepage")!=null){
			int prePage = Integer.parseInt(request.getParameter("prepage"));
			pVO.setFirstPageNo((prePage-1)*10+1);
			pVO.setPageNo(prePage*10);
			pVO.setNextPageNo(prePage);
			pVO.setPrevPageNo(prePage-1);
		}
		return pVO;
	}
	
	private PagingVO setEndPaging(HttpServletRequest request, PagingVO pVO, int totalCnt) throws ServletException, IOException {
		pVO.setTotalCount(totalCnt);
		if(totalCnt%15 == 0){
			pVO.setFinalPageNo(totalCnt/15);
		}else{
			pVO.setFinalPageNo(totalCnt/15+1);
		}
		pVO.setEndPageNo(pVO.getFirstPageNo()+9);
		if(pVO.getEndPageNo() > pVO.getFinalPageNo())
			pVO.setEndPageNo(pVO.getFinalPageNo());
		return pVO;
	}

	private void pubrd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String url = "/consult_purchase.jsp";
		BoardDAO bDAO = new BoardDAO();
		PagingVO pVO = setPaging(request);
		if(session.getAttribute("UID") != null){
			MemberDAO mDAO = new MemberDAO();
			try {
				if(mDAO.isAdmin(session.getAttribute("UID").toString())){
					url = "/ad_consult_purchase.jsp";
				}
			} catch (Exception e1) {}
		}		
		try {
			int brdlimit = (pVO.getPageNo()-1)*15;
			List<BoardVO> VOList = bDAO.doSelectAllPurchaseBoard(brdlimit);
			int totalCnt = bDAO.doSelectTotaleBoardCount("p");
			pVO = setEndPaging(request, pVO, totalCnt);
			request.setAttribute("PAGE", pVO);
			request.setAttribute("RESULT", VOList);
		} catch (Exception e) {
			
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
	
	private void pubrd_search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String url = "/consult_purchase.jsp";
		PagingVO pVO = setPaging(request);
		String stype = request.getParameter("stype");
		String cntnt = new String(request.getParameter("sCntnt").getBytes("ISO-8859-1"), "UTF-8");
		BoardDAO bDAO = new BoardDAO();
		if(session.getAttribute("UID") != null){
			MemberDAO mDAO = new MemberDAO();
			try {
				if(mDAO.isAdmin(session.getAttribute("UID").toString())){
					url = "/ad_consult_sales.jsp";
				}
			} catch (Exception e1) {}
		}
		try {
			int brdlimit = (pVO.getPageNo()-1)*15;
			List<BoardVO> VOList = bDAO.doSearchBoard("p", stype, cntnt, brdlimit);
			int totalCnt = bDAO.doSearchBoardCount("p", stype, cntnt);
			pVO = setEndPaging(request, pVO, totalCnt);
			request.setAttribute("SEARCH", cntnt);
			request.setAttribute("STYPE", stype);
			request.setAttribute("PAGE", pVO);
			request.setAttribute("RESULT", VOList);
		} catch (Exception e) {
			
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

	private void sabrd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String url = "/consult_sales.jsp";
		BoardDAO bDAO = new BoardDAO();
		PagingVO pVO = setPaging(request);
		if(session.getAttribute("UID") != null){
			MemberDAO mDAO = new MemberDAO();
			try {
				if(mDAO.isAdmin(session.getAttribute("UID").toString())){
					url = "/ad_consult_sales.jsp";
				}
			} catch (Exception e1) {}
		}
		try {
			int brdlimit = (pVO.getPageNo()-1)*15;
			List<BoardVO> VOList = bDAO.doSelectAllSalesBoard(brdlimit);
			int totalCnt = bDAO.doSelectTotaleBoardCount("s");
			pVO = setEndPaging(request, pVO, totalCnt);
			request.setAttribute("PAGE", pVO);
			request.setAttribute("RESULT", VOList);
		} catch (Exception e) {
			
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
	
	private void sabrd_search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String url = "/consult_sales.jsp";
		PagingVO pVO = setPaging(request);
		String stype = request.getParameter("stype");
		String cntnt = new String(request.getParameter("sCntnt").getBytes("ISO-8859-1"), "UTF-8");
		BoardDAO bDAO = new BoardDAO();
		if(session.getAttribute("UID") != null){
			MemberDAO mDAO = new MemberDAO();
			try {
				if(mDAO.isAdmin(session.getAttribute("UID").toString())){
					url = "/ad_consult_sales.jsp";
				}
			} catch (Exception e1) {}
		}
		
		try {
			int brdlimit = (pVO.getPageNo()-1)*15;
			List<BoardVO> VOList = bDAO.doSearchBoard("s", stype, cntnt, brdlimit);
			int totalCnt = bDAO.doSearchBoardCount("s", stype, cntnt);
			pVO = setEndPaging(request, pVO, totalCnt);
			request.setAttribute("SEARCH", cntnt);
			request.setAttribute("STYPE", stype);
			request.setAttribute("PAGE", pVO);
			request.setAttribute("RESULT", VOList);
		} catch (Exception e) {
			
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

	private void nobrd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String url = "/community_notice.jsp";
		PagingVO pVO = setPaging(request);
		BoardDAO bDAO = new BoardDAO();
		if(session.getAttribute("UID") != null){
			MemberDAO mDAO = new MemberDAO();
			try {
				if(mDAO.isAdmin(session.getAttribute("UID").toString())){
					url = "/ad_community_notice.jsp";
				}
			} catch (Exception e1) {}
		}
		try {
			int brdlimit = (pVO.getPageNo()-1)*15;
			List<BoardVO> VOList = bDAO.doSelectAllNoticeBoard(brdlimit);
			List<BoardVO> isNoticeVOList = bDAO.doSelectIsNoticeBoard();
			int totalCnt = bDAO.doSelectTotaleNoticeBoardCount();
			pVO = setEndPaging(request, pVO, totalCnt);
			request.setAttribute("PAGE", pVO);
			request.setAttribute("RESULT1", VOList);
			request.setAttribute("RESULT2", isNoticeVOList);
		} catch (Exception e) {
			
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
	
	private void nobrd_search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String url = "/community_notice.jsp";
		PagingVO pVO = setPaging(request);
		String stype = request.getParameter("stype");
		String cntnt = new String(request.getParameter("sCntnt").getBytes("ISO-8859-1"), "UTF-8");
		BoardDAO bDAO = new BoardDAO();
		if(session.getAttribute("UID") != null){
			MemberDAO mDAO = new MemberDAO();
			try {
				if(mDAO.isAdmin(session.getAttribute("UID").toString())){
					url = "/ad_community_notice.jsp";
				}
			} catch (Exception e1) {}
		}
		try {
			int brdlimit = (pVO.getPageNo()-1)*15;
			List<BoardVO> VOList = bDAO.doSearchBoard("n", stype, cntnt,brdlimit);
			List<BoardVO> isNoticeVOList = bDAO.doSelectIsNoticeBoard();
			int totalCnt = bDAO.doSearchBoardCount("n", stype, cntnt);
			pVO = setEndPaging(request, pVO, totalCnt);
			request.setAttribute("SEARCH", cntnt);
			request.setAttribute("STYPE", stype);
			request.setAttribute("PAGE", pVO);
			request.setAttribute("RESULT1", VOList);
			request.setAttribute("RESULT2", isNoticeVOList);
		} catch (Exception e) {
			
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
	
	private void rebrd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String url = "/community_review.jsp";
		PagingVO pVO = setPaging(request);
		BoardDAO bDAO = new BoardDAO();
		if(session.getAttribute("UID") != null){
			MemberDAO mDAO = new MemberDAO();
			try {
				if(mDAO.isAdmin(session.getAttribute("UID").toString())){
					url = "/ad_community_review.jsp";
				}
			} catch (Exception e1) {}
		}
		
		try {
			int brdlimit = (pVO.getPageNo()-1)*15;
			List<BoardVO> VOList = bDAO.doSelectAllReviewBoard(brdlimit);
			int totalCnt = bDAO.doSelectTotaleBoardCount("r");
			pVO = setEndPaging(request, pVO, totalCnt);
			request.setAttribute("PAGE", pVO);
			request.setAttribute("RESULT", VOList);
		} catch (Exception e) {
			
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
	
	private void rebrd_search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String url = "/community_review.jsp";
		PagingVO pVO = setPaging(request);
		String stype = request.getParameter("stype");
		String cntnt = new String(request.getParameter("sCntnt").getBytes("ISO-8859-1"), "UTF-8");
		BoardDAO bDAO = new BoardDAO();
		if(session.getAttribute("UID") != null){
			MemberDAO mDAO = new MemberDAO();
			try {
				if(mDAO.isAdmin(session.getAttribute("UID").toString())){
					url = "/ad_community_review.jsp";
				}
			} catch (Exception e1) {}
		}
		try {
			
			int brdlimit = (pVO.getPageNo()-1)*15;
			List<BoardVO> VOList = bDAO.doSearchBoard("r", stype, cntnt,brdlimit);
			int totalCnt = bDAO.doSearchBoardCount("r", stype, cntnt);
			pVO = setEndPaging(request, pVO, totalCnt);
			request.setAttribute("SEARCH", cntnt);
			request.setAttribute("STYPE", stype);
			request.setAttribute("PAGE", pVO);
			request.setAttribute("RESULT", VOList);
		} catch (Exception e) {
			
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
	
	private void cubrd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String url = "/community_customer.jsp";
		PagingVO pVO = setPaging(request);
		BoardDAO bDAO = new BoardDAO();
		if(session.getAttribute("UID") != null){
			MemberDAO mDAO = new MemberDAO();
			try {
				if(mDAO.isAdmin(session.getAttribute("UID").toString())){
					url = "/ad_community_customer.jsp";
				}
			} catch (Exception e1) {}
		}
		try {
			int brdlimit = (pVO.getPageNo()-1)*15;
			List<BoardVO> VOList = bDAO.doSelectAllCustomerBoard(brdlimit);
			int totalCnt = bDAO.doSelectTotaleBoardCount("c");
			pVO = setEndPaging(request, pVO, totalCnt);
			request.setAttribute("PAGE", pVO);
			request.setAttribute("RESULT", VOList);
		} catch (Exception e) {
			
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
	
	private void cubrd_search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String url = "/community_customer.jsp";
		BoardDAO bDAO = new BoardDAO();
		PagingVO pVO = setPaging(request);
		String stype = request.getParameter("stype");
		String cntnt = new String(request.getParameter("sCntnt").getBytes("ISO-8859-1"), "UTF-8");
		if(session.getAttribute("UID") != null){
			MemberDAO mDAO = new MemberDAO();
			try {
				if(mDAO.isAdmin(session.getAttribute("UID").toString())){
					url = "/ad_community_customer.jsp";
				}
			} catch (Exception e1) {}
		}
		try {
			int brdlimit = (pVO.getPageNo()-1)*15;
			List<BoardVO> VOList = bDAO.doSearchBoard("c", stype, cntnt, brdlimit);
			int totalCnt = bDAO.doSearchBoardCount("c", stype, cntnt);
			pVO = setEndPaging(request, pVO, totalCnt);
			request.setAttribute("SEARCH", cntnt);
			request.setAttribute("STYPE", stype);
			request.setAttribute("PAGE", pVO);
			request.setAttribute("RESULT", VOList);
		} catch (Exception e) {
			
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
	
	private void mainview(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String url = "/main.jsp";
		BoardDAO bDAO = new BoardDAO();
		if(session.getAttribute("UID") != null){
			MemberDAO mDAO = new MemberDAO();
			try {
				if(mDAO.isAdmin(session.getAttribute("UID").toString())){
					url = "/ad_main.jsp";
				}
			} catch (Exception e1) {}
		}
		try {
			List<BoardVO> VOList1 = bDAO.doSelectMainPurchaseBoard();
			List<BoardVO> VOList2 = bDAO.doSelectMainSalesBoard();
			List<BoardVO> VOList3 = bDAO.doSelectMainNoticeBoard();
			List<BoardVO> VOList4 = bDAO.doSelectMainReviewBoard();
			List<BoardVO> VOList5 = bDAO.doSelectMainCustomerBoard();
			request.setAttribute("RESULT1", VOList1);
			request.setAttribute("RESULT2", VOList2);
			request.setAttribute("RESULT3", VOList3);
			request.setAttribute("RESULT4", VOList4);
			request.setAttribute("RESULT5", VOList5);
		} catch (Exception e) {
			
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
	
	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("purchase_process.jsp");
		dispatcher.forward(request, response);
	}

}
