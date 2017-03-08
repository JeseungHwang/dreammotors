package com.dreammotors.controller;

import java.io.IOException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.RSAPublicKeySpec;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import com.dreammotors.dao.MemberDAO;
import com.dreammotors.vo.MemberVO;

import Util.RSAModule;

@WebServlet({"/signinfo.do", "/signin.do", "/idcheck.do", "/myinfo.do", "/infomodify.do"})
public class SigninCTR extends HttpServlet {
	private static final long serialVersionUID = -3118477650735935934L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//String requestPath = request.getRequestURI().replaceAll("/DreamMotors","");
		//switch(requestPath){
		switch(request.getRequestURI()){
		case "/signinfo.do":
			signinfo(request, response);
			break;
		case "/signin.do":
			signin(request, response);
			break;
		case "/idcheck.do":
			idcheck(request, response);
			break;
		case "/myinfo.do":
			myinfo(request, response);
			break;
		case "/infomodify.do":
			infomodify(request, response);
			break;
			
		}
		
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	} 
	
	private void signinfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
			generator.initialize(2048);

			KeyPair keyPair = generator.genKeyPair();
			KeyFactory keyFactory = KeyFactory.getInstance("RSA");

			PublicKey publicKey = keyPair.getPublic();
			PrivateKey privateKey = keyPair.getPrivate();

			HttpSession session = request.getSession();
			// 세션에 공개키의 문자열을 키로하여 개인키를 저장한다.
			session.setAttribute("__rsaPrivateKey__", privateKey);

			// 공개키를 문자열로 변환하여 JavaScript RSA 라이브러리 넘겨준다.
			RSAPublicKeySpec publicSpec = (RSAPublicKeySpec) keyFactory.getKeySpec(publicKey, RSAPublicKeySpec.class);

			String publicKeyModulus = publicSpec.getModulus().toString(16);
			String publicKeyExponent = publicSpec.getPublicExponent().toString(16);

			request.setAttribute("publicKeyModulus", publicKeyModulus);
			request.setAttribute("publicKeyExponent", publicKeyExponent);
		} catch (Exception e) {
		}
		request.getRequestDispatcher("signin.jsp").forward(request, response);
	}
	
	private void signin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberVO mVO = new MemberVO();
		String securedId = request.getParameter("securedId");
        String securedPassword = request.getParameter("securedPassword");
        String securedName = request.getParameter("securedName");
        String securedNick = request.getParameter("securedNick");
        String securedEmail = request.getParameter("securedEmail");
        String securedTell = request.getParameter("securedTell");
        String securedAddr = request.getParameter("securedAddr");
        PrivateKey privateKey = (PrivateKey) session.getAttribute("__rsaPrivateKey__");
        session.removeAttribute("__rsaPrivateKey__"); // 키의 재사용을 막는다. 항상 새로운 키를 받도록 강제.

        if (privateKey == null) {
            throw new RuntimeException("암호화 비밀키 정보를 찾을 수 없습니다.");
        }
        try {
        	mVO.setMemId(RSAModule.decryptRsa(privateKey, securedId));
        	mVO.setMemPw(RSAModule.decryptRsa(privateKey, securedPassword));
        	mVO.setMemName(RSAModule.decryptRsa(privateKey, securedName));
        	mVO.setMemNick(RSAModule.decryptRsa(privateKey, securedNick));
        	mVO.setMemEmail(RSAModule.decryptRsa(privateKey, securedEmail));
        	mVO.setMemTell(RSAModule.decryptRsa(privateKey, securedTell));
        	mVO.setMemAddr(RSAModule.decryptRsa(privateKey, securedAddr));
        } catch (Exception ex) {
            throw new ServletException(ex.getMessage(), ex);
        }
		JSONObject obj = new JSONObject();
		MemberDAO dao = new MemberDAO();
		String url = "signin.jsp";
		try {
			int result = dao.doSignin(mVO);
			if(result == 1){ 
				obj.put("CHECK", "success");
				url = "/mainview.do";
			}else{
				obj.put("CHECK", "fail");
			}
		} catch (Exception e) {
			
		}
		
		request.setAttribute("RESULT", obj.toString());
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
	
	private void idcheck(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDAO mDAO = new MemberDAO();
		JSONObject obj = new JSONObject();
		try {
			if(mDAO.isExistID(request.getParameter("UID"))){
				obj.put("CHECK", "ava");
			}else{
				obj.put("CHECK", "dis");
			}
		} catch (Exception e) {
			
		}
		request.setAttribute("result", obj.toJSONString());
		RequestDispatcher dispatcher = request.getRequestDispatcher("result.jsp");
		dispatcher.forward(request, response);
	}
	
	private void myinfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String url = "/myinformation.jsp";
		MemberVO mVO = new MemberVO();
		MemberDAO mDAO = new MemberDAO();
		boolean isAdmin = false;
		try {
			KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
			generator.initialize(2048);

			KeyPair keyPair = generator.genKeyPair();
			KeyFactory keyFactory = KeyFactory.getInstance("RSA");

			PublicKey publicKey = keyPair.getPublic();
			PrivateKey privateKey = keyPair.getPrivate();

			// 세션에 공개키의 문자열을 키로하여 개인키를 저장한다.
			session.setAttribute("__rsaPrivateKey__", privateKey);

			// 공개키를 문자열로 변환하여 JavaScript RSA 라이브러리 넘겨준다.
			RSAPublicKeySpec publicSpec = (RSAPublicKeySpec) keyFactory.getKeySpec(publicKey, RSAPublicKeySpec.class);

			String publicKeyModulus = publicSpec.getModulus().toString(16);
			String publicKeyExponent = publicSpec.getPublicExponent().toString(16);

			request.setAttribute("publicKeyModulus", publicKeyModulus);
			request.setAttribute("publicKeyExponent", publicKeyExponent);
		} catch (Exception e) {
		}
		
		if(session.getAttribute("UID") != null){
			mVO.setMemId(session.getAttribute("UID").toString());
			try {
				isAdmin = mDAO.isAdmin(session.getAttribute("UID").toString());
			} catch (Exception e1) {}
		}
		
		try {
			if(isAdmin){
				url="/ad_myinformation.jsp";
				mVO = mDAO.doSelectAdminModifyInfo(mVO);
			}else{
				mVO = mDAO.doSelectUserModifyInfo(mVO);
			}
		} catch (Exception e) {}
		request.setAttribute("RESULT", mVO);
		request.getRequestDispatcher(url).forward(request, response);
	}
	private void infomodify(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String url = "/myinfo.do";
		MemberVO mVO = new MemberVO();
		MemberDAO mDAO = new MemberDAO();
		String securedId = request.getParameter("securedId");
        String securedPassword = request.getParameter("securedPassword");
        String securedName = request.getParameter("securedName");
        String securedNick = request.getParameter("securedNick");
        String securedEmail = request.getParameter("securedEmail");
        String securedTell = request.getParameter("securedTell");
        String securedAddr = request.getParameter("securedAddr");
        PrivateKey privateKey = (PrivateKey) session.getAttribute("__rsaPrivateKey__");
        session.removeAttribute("__rsaPrivateKey__"); // 키의 재사용을 막는다. 항상 새로운 키를 받도록 강제.

        if (privateKey == null) {
            throw new RuntimeException("암호화 비밀키 정보를 찾을 수 없습니다.");
        }
        try {
        	mVO.setMemId(RSAModule.decryptRsa(privateKey, securedId));
        	mVO.setMemPw(RSAModule.decryptRsa(privateKey, securedPassword));
        	mVO.setMemName(RSAModule.decryptRsa(privateKey, securedName));
        	mVO.setMemNick(RSAModule.decryptRsa(privateKey, securedNick));
        	mVO.setMemEmail(RSAModule.decryptRsa(privateKey, securedEmail));
        	mVO.setMemTell(RSAModule.decryptRsa(privateKey, securedTell));
        	mVO.setMemAddr(RSAModule.decryptRsa(privateKey, securedAddr));
        	if(mVO.getMemPw().equals("")){
        		mVO.setMemPw(null);
        	}
        } catch (Exception ex) {
            throw new ServletException(ex.getMessage(), ex);
        }
		try {
			int result = mDAO.doUpdateUserModifyInfo(mVO);
			request.setAttribute("CHECK", "msu");
		} catch (Exception e) {
			
		}
		
		request.getRequestDispatcher(url).forward(request, response);
	}
	
}
