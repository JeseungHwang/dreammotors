package com.dreammotors.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dreammotors.DBAdapter.SqlMapClient;
import com.dreammotors.vo.BoardCommentVO;
import com.dreammotors.vo.BoardVO;
import com.dreammotors.vo.MemberVO;
import com.dreammotors.vo.SearchVO;

public class MemberDAO {
	public MemberVO doLogin(MemberVO mVO) throws Exception{
		SqlMapClient sqlSession = new SqlMapClient();
		SqlSession session = sqlSession.getSqlSession();
		MemberVO VO = session.selectOne("Member.SelectMember",mVO);
		session.close();
		return VO;
	}
	
	public int doSignin(MemberVO mVO) throws Exception{
		SqlMapClient sqlSession = new SqlMapClient();
		SqlSession session = sqlSession.getSqlSession();
		int result= session.insert("Member.InsertMember",mVO);
		session.commit();
		session.close();
		return result;
	}
	
	public MemberVO doSelectUserInfo(MemberVO mVO) throws Exception{
		SqlMapClient sqlSession = new SqlMapClient();
		SqlSession session = sqlSession.getSqlSession();
		MemberVO VO = session.selectOne("Member.SelectMemberInfo",mVO);
		session.close();
		return VO;
	}
	
	public MemberVO doSelectUserBoardInfo(String memId) throws Exception{
		SqlMapClient sqlSession = new SqlMapClient();
		SqlSession session = sqlSession.getSqlSession();
		MemberVO VO = session.selectOne("Member.SelectMemberBoardInfo",memId);
		session.close();
		return VO;
	}
	
	public MemberVO doSelectUserModifyInfo(MemberVO mVO) throws Exception{
		SqlMapClient sqlSession = new SqlMapClient();
		SqlSession session = sqlSession.getSqlSession();
		MemberVO VO = session.selectOne("Member.SelectUserModifyInfo",mVO);
		session.close();
		return VO;
	}
	
	public MemberVO doSelectAdminModifyInfo(MemberVO mVO) throws Exception{
		SqlMapClient sqlSession = new SqlMapClient();
		SqlSession session = sqlSession.getSqlSession();
		MemberVO VO = session.selectOne("Member.SelectAdminModifyInfo",mVO);
		session.close();
		return VO;
	}
	
	public int doUpdateUserModifyInfo(MemberVO mVO) throws Exception{
		SqlMapClient sqlSession = new SqlMapClient();
		SqlSession session = sqlSession.getSqlSession();
		int result = session.update("Member.UpdateMemberInfomation",mVO);
		session.commit();
		session.close();
		return result;
	}
	
	public boolean isAdmin(String memId) throws Exception{
		SqlMapClient sqlSession = new SqlMapClient();
		SqlSession session = sqlSession.getSqlSession();
		String result = session.selectOne("Member.IsAdmin",memId);
		session.close();
		if(result.equals(memId)){
			return true;
		}		
		return false;
	}
	
	public boolean isCommentWriter(BoardCommentVO cVO) throws Exception{
		SqlMapClient sqlSession = new SqlMapClient();
		SqlSession session = sqlSession.getSqlSession();
		String result = session.selectOne("BoardComment.IsCommentWriter",cVO);
		session.close();
		if(result.equals(cVO.getMemId())){
			return true;
		}		
		return false;
	}
	
	public boolean isBrdWriter(BoardVO bVO) throws Exception{
		SqlMapClient sqlSession = new SqlMapClient();
		SqlSession session = sqlSession.getSqlSession();
		String result = session.selectOne("CommunityBoard.isWriter",bVO);
		session.close();
		if(result.equals(bVO.getMemId())){
			return true;
		}		
		return false;
	}
	
	public List<MemberVO> doSelectAllMember(int pcnt) throws Exception{
		SqlMapClient sqlSession = new SqlMapClient();
		SqlSession session = sqlSession.getSqlSession();
		List<MemberVO> VOList = session.selectList("Member.SelectAllMemberList", pcnt);
		session.close();
		return VOList;
	}
	
	public List<MemberVO> doTermSelectMember(String stype, String cntnt, int pcnt) throws Exception{
		SqlMapClient sqlSession = new SqlMapClient();
		SearchVO sVO = new SearchVO();
		sVO.setStype(stype);
		sVO.setCntnt(cntnt);
		sVO.setSpage(pcnt);
		SqlSession session = sqlSession.getSqlSession();
		List<MemberVO> VOList = session.selectList("Member.TermSelectMember",sVO);
		session.close();
		return VOList;
	}
	
	public int doDeleteMember(String memId) throws Exception{
		SqlMapClient sqlSession = new SqlMapClient();
		SqlSession session = sqlSession.getSqlSession();
		int result= session.delete("Member.DeleteMember",memId);
		session.commit();
		session.close();
		return result;
	}
	
	public List<MemberVO> doSelectPermission() throws Exception{
		SqlMapClient sqlSession = new SqlMapClient();
		SqlSession session = sqlSession.getSqlSession();
		List<MemberVO> VOList = session.selectList("Member.SelectPermissionList");
		session.close();
		return VOList;
	}
	
	public int doUpdateMemberPermission(String memId, String ptype) throws Exception{
		SqlMapClient sqlSession = new SqlMapClient();
		SqlSession session = sqlSession.getSqlSession();
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("memId", memId);
		map.put("ptype", ptype);
		int result = session.update("Member.UpdateMemberPermission",map);
		session.commit();
		session.close();
		return result;
	}
	
	public boolean isExistID(String memId) throws Exception{
		SqlMapClient sqlSession = new SqlMapClient();
		SqlSession session = sqlSession.getSqlSession();
		String result = session.selectOne("Member.isExistID",memId);
		session.close();
		return result == null? true: false;
	}
	
	public String doSelectFindID(MemberVO mVO) throws Exception{
		SqlMapClient sqlSession = new SqlMapClient();
		SqlSession session = sqlSession.getSqlSession();
		String result = session.selectOne("Member.SelectFindID",mVO);
		session.close();
		return result;
	}
	
	public String doSelectFindPW(MemberVO mVO) throws Exception{
		SqlMapClient sqlSession = new SqlMapClient();
		SqlSession session = sqlSession.getSqlSession();
		String result = session.selectOne("Member.SelectFindPW",mVO);
		session.close();
		return result;
	}
	
	public int doUpdateUserPW(MemberVO mVO) throws Exception{
		SqlMapClient sqlSession = new SqlMapClient();
		SqlSession session = sqlSession.getSqlSession();
		int result = session.update("Member.UpdateUserPW",mVO);
		session.commit();
		session.close();
		return result;
	}
	
	public int doSelectTotalMemberCount() throws Exception{
		SqlMapClient sqlSession = new SqlMapClient();
		SqlSession session = sqlSession.getSqlSession();
		int result = session.selectOne("Member.SelectTotalMemberCount");
		session.close();
		return result;
	}
	
	public int doSelectMemberCount(String stype,String cntnt) throws Exception{
		SqlMapClient sqlSession = new SqlMapClient();
		SqlSession session = sqlSession.getSqlSession();
		SearchVO sVO = new SearchVO();
		sVO.setStype(stype);;
		sVO.setCntnt(cntnt);
		int result = session.selectOne("Member.SelectMemberCount", sVO);
		session.close();
		return result;
	}
}
