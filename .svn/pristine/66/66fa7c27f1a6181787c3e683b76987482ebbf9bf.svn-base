package com.dreammotors.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dreammotors.DBAdapter.SqlMapClient;
import com.dreammotors.vo.DirectionVO;
import com.dreammotors.vo.FamilyVO;

public class FamilyDAO {
	
	public List<FamilyVO> doSelectFamilyList() throws Exception{
		SqlMapClient sqlSession = new SqlMapClient();
		SqlSession session = sqlSession.getSqlSession();
		List<FamilyVO> VOList = session.selectList("Family.SelectAllFamily");
		session.close();
		return VOList;
	}
	
	public int doInsertFamily(FamilyVO fVO) throws Exception{
		SqlMapClient sqlSession = new SqlMapClient();
		SqlSession session = sqlSession.getSqlSession();
		int result= session.insert("Family.InsertFamily",fVO);
		session.commit();
		session.close();
		return result;
	}
	
	public int doDeleteFamily(int index) throws Exception{
		SqlMapClient sqlSession = new SqlMapClient();
		SqlSession session = sqlSession.getSqlSession();
		int result= session.delete("Family.DeleteFamily",index);
		session.commit();
		session.close();
		return result;
	}
	
	public DirectionVO doSelectDirection() throws Exception{
		SqlMapClient sqlSession = new SqlMapClient();
		SqlSession session = sqlSession.getSqlSession();
		DirectionVO VO = session.selectOne("Direction.SelectDirection");
		session.close();
		return VO;
	}
	
	public int doUpdateDirection(DirectionVO dVO) throws Exception{
		SqlMapClient sqlSession = new SqlMapClient();
		SqlSession session = sqlSession.getSqlSession();
		int result = session.update("Direction.UpdateDirection", dVO);
		session.commit();
		session.close();
		return result;
	}
}
