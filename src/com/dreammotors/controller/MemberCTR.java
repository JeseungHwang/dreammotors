package com.dreammotors.controller;

import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dreammotors.dao.FamilyDAO;
import com.dreammotors.dao.MemberDAO;
import com.dreammotors.vo.MemberVO;
import com.dreammotors.vo.PagingVO;

@WebServlet({"/member_management.do", "/member_search.do", "/member_modify.do", "/member_delete.do"})
public class MemberCTR extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String requestPath = request.getRequestURI().replaceAll("/DreamMotors","");
		//switch(requestPath){
		switch(request.getRequestURI()){
		case "/member_management.do":
			member_management(request, response);
			break;
		case "/member_search.do":
			member_search(request, response);
			break;
		case "/member_modify.do":
			member_modify(request, response);
			break;
		case "/member_delete.do":
			member_delete(request, response);
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
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
		if(totalCnt%20 == 0){
			pVO.setFinalPageNo(totalCnt/20);
		}else{
			pVO.setFinalPageNo(totalCnt/20+1);
		}
		pVO.setEndPageNo(pVO.getFirstPageNo()+9);
		if(pVO.getEndPageNo() > pVO.getFinalPageNo())
			pVO.setEndPageNo(pVO.getFinalPageNo());
		return pVO;
	}

	private void member_management(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberDAO mDAO = new MemberDAO();
		PagingVO pVO = setPaging(request);
		List<MemberVO> VOList = null;
		List<MemberVO> permissionList = null;
		String url = "/mainview.do";
		if(session.getAttribute("UID") != null){
			try {
				if(mDAO.isAdmin(session.getAttribute("UID").toString())){
					int brdlimit = (pVO.getPageNo()-1)*20;
					VOList = mDAO.doSelectAllMember(brdlimit);
					int totalCnt = mDAO.doSelectTotalMemberCount();
					pVO = setEndPaging(request, pVO, totalCnt);
					permissionList = mDAO.doSelectPermission();
					request.setAttribute("PAGE", pVO);
					request.setAttribute("RESULT", VOList);
					request.setAttribute("PList", permissionList);
					url = "/ad_member_management.jsp";
				}
			} catch (Exception e1) {}
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
	
	private void member_search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberDAO mDAO = new MemberDAO();
		PagingVO pVO = setPaging(request);
		List<MemberVO> VOList = null;
		List<MemberVO> permissionList = null;
		String url = "/mainview.do";
		if(session.getAttribute("UID") != null){
			try {
				if(mDAO.isAdmin(session.getAttribute("UID").toString())){
					int brdlimit = (pVO.getPageNo()-1)*20;
					String stype = request.getParameter("stype");
					String cntnt = new String(request.getParameter("sCntnt").getBytes("ISO-8859-1"), "UTF-8");
					VOList = mDAO.doTermSelectMember(stype, cntnt, brdlimit);
					int totalCnt = mDAO.doSelectMemberCount(stype, cntnt);
					pVO = setEndPaging(request, pVO, totalCnt);
					permissionList = mDAO.doSelectPermission();
					request.setAttribute("SEARCH", cntnt);
					request.setAttribute("STYPE", stype);
					request.setAttribute("PAGE", pVO);
					request.setAttribute("RESULT", VOList);
					request.setAttribute("PList", permissionList);
					url = "/ad_member_management.jsp";
				}
			} catch (Exception e1) {}
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
	
	private void member_modify(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberDAO mDAO = new MemberDAO();
		String url = "/mainview.do";
		if(session.getAttribute("UID") != null){
			try {
				if(mDAO.isAdmin(session.getAttribute("UID").toString())){
					String memId = new String(request.getParameter("memId").getBytes("ISO-8859-1"), "UTF-8");
					String ptype = new String(request.getParameter("ptype").getBytes("ISO-8859-1"), "UTF-8");
					mDAO.doUpdateMemberPermission(memId, ptype);
					url = "/member_management.do";
				}
			} catch (Exception e1) {}
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
	
	private void member_delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String url = "/mainview.do";
		MemberDAO mDAO = new MemberDAO();
		if(session.getAttribute("UID") != null){
			try {
				if(mDAO.isAdmin(session.getAttribute("UID").toString())){
					String sList = new String(request.getParameter("index").getBytes("ISO-8859-1"), "UTF-8");
					StringTokenizer st = new StringTokenizer(sList,",");
					while (st.hasMoreTokens()) {
						mDAO.doDeleteMember(st.nextToken());
					}
					url = "/member_management.do";
				}
			} catch (Exception e1) {}
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
