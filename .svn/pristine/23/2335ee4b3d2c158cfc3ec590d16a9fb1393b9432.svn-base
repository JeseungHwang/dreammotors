package com.dreammotors.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dreammotors.dao.BoardDAO;
import com.dreammotors.dao.FamilyDAO;
import com.dreammotors.dao.MemberDAO;
import com.dreammotors.vo.DirectionVO;
import com.dreammotors.vo.FamilyVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class CompanyInfoCTR
 */
@WebServlet({ "/companyinfo.do", "/familyinfo.do", "/family_insert.do", "/family_delete.do", "/direction.do", "/direction_modify.do" })
public class CompanyInfoCTR extends HttpServlet {
	private static final long serialVersionUID = 9216196333396159130L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String requestPath = request.getRequestURI().replaceAll("/DreamMotors","");
		//switch(requestPath){
		switch(request.getRequestURI()){
		case "/companyinfo.do":
			companyinfo(request, response);
			break;
		case "/familyinfo.do":
			familyinfo(request, response);
			break;
		case "/family_insert.do":
			family_insert(request, response);
			break;
		case "/family_delete.do":
			family_delete(request, response);
			break;
		case "/direction.do":
			direction(request, response);
			break;
		case "/direction_modify.do":
			direction_modify(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	private void companyinfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String url = "/introduce_company.jsp";
		if(session.getAttribute("UID") != null){
			MemberDAO mDAO = new MemberDAO();
			try {
				if(mDAO.isAdmin(session.getAttribute("UID").toString())){
					url = "/ad_introduce_company.jsp";
				}
			} catch (Exception e1) {}
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
	
	private void familyinfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String url = "/introduce_family.jsp";
		List<FamilyVO> fVOList = new ArrayList<FamilyVO>();
		FamilyDAO mfDAO = new FamilyDAO();
		if(session.getAttribute("UID") != null){
			MemberDAO mDAO = new MemberDAO();
			try {
				if(mDAO.isAdmin(session.getAttribute("UID").toString())){
					url = "/ad_introduce_family.jsp";
				}
			} catch (Exception e1) {}
		}
		try {
			fVOList = mfDAO.doSelectFamilyList();
			request.setAttribute("RESULT", fVOList);
		} catch (Exception e) {
			
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
	
	private void family_insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FamilyVO fVO = new FamilyVO();
		String realFolder = "";
		int maxSize = 1024 * 1024 * 5;
		String savefile = "/img/family";
		ServletContext scontext = getServletContext();
		//realFlder = "C:/Devlopment/Workspace/DreamMotors/WebContent/img/family";
		realFolder = scontext.getRealPath(savefile);
		try {
			MultipartRequest multi = new MultipartRequest(request, realFolder, maxSize, "UTF-8", new DefaultFileRenamePolicy());
			fVO.setCmemImgUrl(savefile+"/"+new String (multi.getFilesystemName("profile_picture").getBytes(), "UTF-8"));
			fVO.setCmemName(new String (multi.getParameter("inpFNm").getBytes(), "UTF-8"));
			fVO.setPositionId(Integer.parseInt(multi.getParameter("inpFtype")));
		} catch (Exception e) {
			
		}
		FamilyDAO fDAO = new FamilyDAO();
		try {
			int result = fDAO.doInsertFamily(fVO);
		} catch (Exception e) {
			
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/familyinfo.do");
		dispatcher.forward(request, response);
	}
	
	private void family_delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sList = request.getParameter("index");
		StringTokenizer st = new StringTokenizer(sList,",");
		FamilyDAO fDAO = new FamilyDAO();
		try {
			while (st.hasMoreTokens()) {
				fDAO.doDeleteFamily(Integer.parseInt(st.nextToken()));
			}
		}catch (Exception e) {}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/familyinfo.do");
		dispatcher.forward(request, response);
	}
	
	private void direction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String url = "/introduce_direction.jsp";
		FamilyDAO fDAO = new FamilyDAO();
		DirectionVO dVO = new DirectionVO();
		if(session.getAttribute("UID") != null){
			MemberDAO mDAO = new MemberDAO();
			try {
				if(mDAO.isAdmin(session.getAttribute("UID").toString())){
					url = "/ad_introduce_direction.jsp";
				}
			} catch (Exception e1) {}
		}
		try {
			dVO = fDAO.doSelectDirection();
			request.setAttribute("RESULT", dVO);
		} catch (Exception e) {
			
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
	
	private void direction_modify(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DirectionVO dVO = new DirectionVO();
		try {
			dVO.setClocAddr(new String (request.getParameter("inpAddr").getBytes("ISO-8859-1"), "UTF-8"));
			dVO.setClocTell(new String (request.getParameter("inpTell").getBytes("ISO-8859-1"), "UTF-8"));
		} catch (Exception e) {
			
		}
		FamilyDAO fDAO = new FamilyDAO();
		try {
			int result = fDAO.doUpdateDirection(dVO);
			if(result == 1){
				request.setAttribute("CHECK", "msu");
			}else{
				request.setAttribute("CHECK", "mfa");
			}
		} catch (Exception e) {
			
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/direction.do");
		dispatcher.forward(request, response);
	}
}
