package com.dreammotors.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dreammotors.DBAdapter.SqlMapClient;
import com.dreammotors.vo.BoardCommentVO;

public class BoardCommentDAO {
	public List<BoardCommentVO> doSelectAllBoardComment(BoardCommentVO cVO) throws Exception{
		SqlMapClient sqlSession = new SqlMapClient();
		SqlSession session = sqlSession.getSqlSession();
		List<BoardCommentVO> VOList = session.selectList("BoardComment.SelectAllBoardComment", cVO);
		session.close();
		return VOList;
	}
	
	public int doSelectBoardOrderCnt(int boardIndex) throws Exception{
		SqlMapClient sqlSession = new SqlMapClient();
		SqlSession session = sqlSession.getSqlSession();
		int result = session.selectOne("BoardComment.SelectBoardOrderCnt", boardIndex);
		session.close();
		return result;
	}
	
	public int doInsertBoardComment(BoardCommentVO cVO) throws Exception{
		SqlMapClient sqlSession = new SqlMapClient();
		SqlSession session = sqlSession.getSqlSession();
		String query = null;
		if(cVO.getMemId()!= null)
			query = "BoardComment.InsertBoardComment_Login";
		else
			query = "BoardComment.InsertBoardComment";
		int result= session.insert(query, cVO);
		session.commit();
		session.close();
		return result;
	}
	
	public int doDeleteBoardComment(BoardCommentVO cVO) throws Exception{
		SqlMapClient sqlSession = new SqlMapClient();
		SqlSession session = sqlSession.getSqlSession();
		int result= session.delete("BoardComment.DeleteBoardComment",cVO);
		session.commit();
		session.close();
		return result;
	}
}
