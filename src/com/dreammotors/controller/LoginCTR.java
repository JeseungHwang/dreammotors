package com.dreammotors.controller;

import java.io.IOException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.RSAPublicKeySpec;

import javax.crypto.Cipher;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dreammotors.dao.MemberDAO;
import com.dreammotors.vo.MemberVO;

import Util.RSAModule;

@WebServlet({"/loginview.do", "/login.do", "/logout.do", "/findform.do", "/findID.do", "/findPW.do", "/ModifyPW.do"})
public class LoginCTR extends HttpServlet {
	private static final long serialVersionUID = -3618114293841305502L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String requestPath = request.getRequestURI().replaceAll("/DreamMotors","");
		//switch(requestPath){
		switch(request.getRequestURI()){
		case "/loginview.do":
			loginview(request, response);
			break;
		case "/login.do":
			login(request, response);
			break;
		case "/logout.do":
			logout(request, response);
			break;
		case "/findform.do":
			findform(request, response);
			break;
		case "/findID.do":
			findID(request, response);
			break;
		case "/findPW.do":
			findPW(request, response);
			break;
		case "/ModifyPW.do":
			ModifyPW(request, response);
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
	
	private void loginview(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
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
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}
	
	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String url = "/login.jsp";
		MemberVO mVO = new MemberVO();
		String securedUsername = request.getParameter("securedUsername");
        String securedPassword = request.getParameter("securedPassword");
        PrivateKey privateKey = (PrivateKey) session.getAttribute("__rsaPrivateKey__");
        session.removeAttribute("__rsaPrivateKey__"); // 키의 재사용을 막는다. 항상 새로운 키를 받도록 강제.

        if (privateKey == null) {
            throw new RuntimeException("암호화 비밀키 정보를 찾을 수 없습니다.");
        }
        try {
        	mVO.setMemId(RSAModule.decryptRsa(privateKey, securedUsername));
        	mVO.setMemPw(RSAModule.decryptRsa(privateKey, securedPassword));
        } catch (Exception ex) {
            throw new ServletException(ex.getMessage(), ex);
        }
		MemberDAO dao = new MemberDAO();
		try {
			mVO = dao.doLogin(mVO);
			if (mVO != null) {
				request.setAttribute("CHECK", "in");
				session.setAttribute("UID", mVO.getMemId());
				session.setAttribute("UNM", mVO.getMemName());
				url = "/mainview.do";
			}else{
				request.setAttribute("CHECK", "fail");
				KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
				generator.initialize(2048);

				KeyPair keyPair = generator.genKeyPair();
				KeyFactory keyFactory = KeyFactory.getInstance("RSA");

				PublicKey publicKey = keyPair.getPublic();
				PrivateKey privateKey2 = keyPair.getPrivate();

				HttpSession session2 = request.getSession();
				// 세션에 공개키의 문자열을 키로하여 개인키를 저장한다.
				session2.setAttribute("__rsaPrivateKey__", privateKey2);

				// 공개키를 문자열로 변환하여 JavaScript RSA 라이브러리 넘겨준다.
				RSAPublicKeySpec publicSpec = (RSAPublicKeySpec) keyFactory.getKeySpec(publicKey, RSAPublicKeySpec.class);

				String publicKeyModulus = publicSpec.getModulus().toString(16);
				String publicKeyExponent = publicSpec.getPublicExponent().toString(16);

				request.setAttribute("publicKeyModulus", publicKeyModulus);
				request.setAttribute("publicKeyExponent", publicKeyExponent);
			}
		} catch (Exception e) {}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
	
	private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		request.setAttribute("CHECK", "out");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/mainview.do");
		dispatcher.forward(request, response);
	}
	
	private void findform(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		request.getRequestDispatcher("find_idpw.jsp").forward(request, response);
	}
	
	private void findID(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberVO mVO = new MemberVO();
		String securedName = request.getParameter("securedName");
        String securedEmail = request.getParameter("securedEmail");
        PrivateKey privateKey = (PrivateKey) session.getAttribute("__rsaPrivateKey__");
        session.removeAttribute("__rsaPrivateKey__"); // 키의 재사용을 막는다. 항상 새로운 키를 받도록 강제.

        if (privateKey == null) {
            throw new RuntimeException("암호화 비밀키 정보를 찾을 수 없습니다.");
        }
        try {
        	mVO.setMemName(RSAModule.decryptRsa(privateKey, securedName));
        	mVO.setMemEmail(RSAModule.decryptRsa(privateKey, securedEmail));
        } catch (Exception ex) {
            throw new ServletException(ex.getMessage(), ex);
        }
		MemberDAO mDAO = new MemberDAO();
		try {
			String result = mDAO.doSelectFindID(mVO);
			if(result != null){
				request.setAttribute("CHECK","iex");
				request.setAttribute("RESULT",result);
			}else{
				request.setAttribute("CHECK","inex");
			}
		} catch (Exception e) {}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/findform.do");
		dispatcher.forward(request, response);
	}

	private void findPW(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberVO mVO = new MemberVO();
		String securedId = request.getParameter("securedId");
		String securedName = request.getParameter("securedName");
        String securedEmail = request.getParameter("securedEmail");
        PrivateKey privateKey = (PrivateKey) session.getAttribute("__rsaPrivateKey__");
        session.removeAttribute("__rsaPrivateKey__"); // 키의 재사용을 막는다. 항상 새로운 키를 받도록 강제.

        if (privateKey == null) {
            throw new RuntimeException("암호화 비밀키 정보를 찾을 수 없습니다.");
        }
        try {
        	mVO.setMemId(RSAModule.decryptRsa(privateKey, securedId));
        	mVO.setMemName(RSAModule.decryptRsa(privateKey, securedName));
        	mVO.setMemEmail(RSAModule.decryptRsa(privateKey, securedEmail));
        } catch (Exception ex) {
            throw new ServletException(ex.getMessage(), ex);
        }
		MemberDAO mDAO = new MemberDAO();
		try {
			String result = mDAO.doSelectFindPW(mVO);
			if(result != null){
				request.setAttribute("CHECK","pex");
				request.setAttribute("RESULT",result);
			}else{
				request.setAttribute("CHECK","pnex");
			}
		} catch (Exception e) {}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/findform.do");
		dispatcher.forward(request, response);
	}
	
	private void ModifyPW(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberVO mVO = new MemberVO();
		String securedID = request.getParameter("securedID");
		String securedPW = request.getParameter("securedPW");
		PrivateKey privateKey = (PrivateKey) session.getAttribute("__rsaPrivateKey__");
        session.removeAttribute("__rsaPrivateKey__"); // 키의 재사용을 막는다. 항상 새로운 키를 받도록 강제.
        if (privateKey == null) {
            throw new RuntimeException("암호화 비밀키 정보를 찾을 수 없습니다.");
        }
        try {
        	mVO.setMemId(RSAModule.decryptRsa(privateKey, securedID));
        	mVO.setMemPw(RSAModule.decryptRsa(privateKey, securedPW));
        } catch (Exception ex) {
            throw new ServletException(ex.getMessage(), ex);
        }
		MemberDAO mDAO = new MemberDAO();
		try {
			int result = mDAO.doUpdateUserPW(mVO);
			if(result == 1){
				request.setAttribute("CHECK","usu");
			}
			
		} catch (Exception e) {}
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/findform.do");
		dispatcher.forward(request, response);
	}
	
}
