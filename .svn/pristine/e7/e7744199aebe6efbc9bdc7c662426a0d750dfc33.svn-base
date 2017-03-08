package com.dreammotors.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dreammotors.DBAdapter.SqlMapClient;
import com.dreammotors.vo.BoardVO;
import com.dreammotors.vo.SearchVO;

public class BoardDAO {
	public List<BoardVO> doSelectAllPurchaseBoard(int spage) throws Exception{
		SqlMapClient sqlSession = new SqlMapClient();
		SqlSession session = sqlSession.getSqlSession();
		List<BoardVO> VOList = session.selectList("ConsultBoard.SelectAllPurchaseBoard",spage);
		session.close();
		return VOList;
	}
	
	public int doSelectTotaleBoardCount(String btype) throws Exception{
		SqlMapClient sqlSession = new SqlMapClient();
		SqlSession session = sqlSession.getSqlSession();
		int result = session.selectOne("ConsultBoard.SelectTotaleBoardCount", btype);
		session.close();
		return result;
	}
	
	public int doSelectTotaleNoticeBoardCount() throws Exception{
		SqlMapClient sqlSession = new SqlMapClient();
		SqlSession session = sqlSession.getSqlSession();
		int result = session.selectOne("ConsultBoard.SelectTotaleNoticeBoardCount");
		session.close();
		return result;
	}
	
	public List<BoardVO> doSelectMainPurchaseBoard() throws Exception{
		SqlMapClient sqlSession = new SqlMapClient();
		SqlSession session = sqlSession.getSqlSession();
		List<BoardVO> VOList = session.selectList("ConsultBoard.SelectMainPurchaseBoard");
		session.close();
		return VOList;
	}
	
	public List<BoardVO> doSelectMainSalesBoard() throws Exception{
		SqlMapClient sqlSession = new SqlMapClient();
		SqlSession session = sqlSession.getSqlSession();
		List<BoardVO> VOList = session.selectList("ConsultBoard.SelectMainSalesBoard");
		session.close();
		return VOList;
	}
	
	public BoardVO doSelectPurchaseBoard(BoardVO bVO) throws Exception{
		SqlMapClient sqlSession = new SqlMapClient();
		SqlSession session = sqlSession.getSqlSession();
		BoardVO VO = session.selectOne("ConsultBoard.SelectConsultBoard",bVO);
		session.close();
		return VO;
	}
	
	public BoardVO doSelectPurchaseBoard2(BoardVO bVO) throws Exception{
		SqlMapClient sqlSession = new SqlMapClient();
		SqlSession session = sqlSession.getSqlSession();
		BoardVO VO = session.selectOne("ConsultBoard.SelectConsultBoard2",bVO);
		session.close();
		return VO;
	}
	
	public BoardVO doModifyConsultBoard(BoardVO bVO) throws Exception{
		SqlMapClient sqlSession = new SqlMapClient();
		SqlSession session = sqlSession.getSqlSession();
		BoardVO VO = session.selectOne("ConsultBoard.ModifyConsultBoard",bVO);
		session.close();
		return VO;
	}
	
	public BoardVO doSelectNoticeBoard(BoardVO bVO) throws Exception{
		SqlMapClient sqlSession = new SqlMapClient();
		SqlSession session = sqlSession.getSqlSession();
		BoardVO VO = session.selectOne("CommunityBoard.SelectNoticeBoard",bVO);
		session.close();
		return VO;
	}
	
	public int doInsertConsultBoard(BoardVO bVO) throws Exception{
		SqlMapClient sqlSession = new SqlMapClient();
		SqlSession session = sqlSession.getSqlSession();
		int result= session.insert("ConsultBoard.InsertConsultBoard",bVO);
		session.commit();
		session.close();
		return result;
	}
	
	public int doUpdateConsultBoard(BoardVO bVO) throws Exception{
		SqlMapClient sqlSession = new SqlMapClient();
		SqlSession session = sqlSession.getSqlSession();
		int result= session.update("ConsultBoard.UpdateConsultBoard",bVO);
		session.commit();
		session.close();
		return result;
	}
	
	public int doDeleteBoard(BoardVO bVO) throws Exception{
		SqlMapClient sqlSession = new SqlMapClient();
		SqlSession session = sqlSession.getSqlSession();
		int result= session.delete("ConsultBoard.DeleteConsultBoard",bVO);
		session.commit();
		session.close();
		return result;
	}
	
	public List<BoardVO> doSelectAllSalesBoard(int spage) throws Exception{
		SqlMapClient sqlSession = new SqlMapClient();
		SqlSession session = sqlSession.getSqlSession();
		List<BoardVO> VOList = session.selectList("ConsultBoard.SelectAllSalesBoard",spage);
		session.close();
		return VOList;
	}
		
	public List<BoardVO> doSelectAllNoticeBoard(int spage) throws Exception{
		SqlMapClient sqlSession = new SqlMapClient();
		SqlSession session = sqlSession.getSqlSession();
		List<BoardVO> VOList = session.selectList("CommunityBoard.SelectAllNoticeBoard",spage);
		session.close();
		return VOList;
	}
	
	public List<BoardVO> doSelectIsNoticeBoard() throws Exception{
		SqlMapClient sqlSession = new SqlMapClient();
		SqlSession session = sqlSession.getSqlSession();
		List<BoardVO> VOList = session.selectList("CommunityBoard.SelectIsNoticeBoard");
		session.close();
		return VOList;
	}
	
	public int doInsertNoticeBoard(BoardVO bVO) throws Exception{
		SqlMapClient sqlSession = new SqlMapClient();
		SqlSession session = sqlSession.getSqlSession();
		int result= session.insert("CommunityBoard.InsertNoticeBoard",bVO);
		session.commit();
		session.close();
		return result;
	}
	
	public int doUpdateNoticeBoard(BoardVO bVO) throws Exception{
		SqlMapClient sqlSession = new SqlMapClient();
		SqlSession session = sqlSession.getSqlSession();
		int result= session.update("CommunityBoard.UpdateNoticeBoard",bVO);
		session.commit();
		session.close();
		return result;
	}
	
	public List<BoardVO> doSelectAllReviewBoard(int spage) throws Exception{
		SqlMapClient sqlSession = new SqlMapClient();
		SqlSession session = sqlSession.getSqlSession();
		List<BoardVO> VOList = session.selectList("CommunityBoard.SelectAllReviewBoard", spage);
		session.close();
		return VOList;
	}
	
	public List<BoardVO> doSelectMainReviewBoard() throws Exception{
		SqlMapClient sqlSession = new SqlMapClient();
		SqlSession session = sqlSession.getSqlSession();
		List<BoardVO> VOList = session.selectList("CommunityBoard.SelectMainReviewBoard");
		session.close();
		return VOList;
	}
	
	public List<BoardVO> doSelectMainNoticeBoard() throws Exception{
		SqlMapClient sqlSession = new SqlMapClient();
		SqlSession session = sqlSession.getSqlSession();
		List<BoardVO> VOList = session.selectList("CommunityBoard.SelectMainNoticeBoard");
		session.close();
		return VOList;
	}
	
	public List<BoardVO> doSelectMainCustomerBoard() throws Exception{
		SqlMapClient sqlSession = new SqlMapClient();
		SqlSession session = sqlSession.getSqlSession();
		List<BoardVO> VOList = session.selectList("CommunityBoard.SelectMainCustomerBoard");
		session.close();
		return VOList;
	}
	
	public BoardVO doSelectReviewBoard(BoardVO bVO) throws Exception{
		SqlMapClient sqlSession = new SqlMapClient();
		SqlSession session = sqlSession.getSqlSession();
		BoardVO VO = session.selectOne("CommunityBoard.SelectReviewBoard",bVO);
		session.close();
		return VO;
	}
	
	public BoardVO doSelectReviewBoard2(BoardVO bVO) throws Exception{
		SqlMapClient sqlSession = new SqlMapClient();
		SqlSession session = sqlSession.getSqlSession();
		BoardVO VO = session.selectOne("CommunityBoard.SelectReviewBoard2",bVO);
		session.close();
		return VO;
	}
	
	public int doInsertReviewBoard(BoardVO bVO) throws Exception{
		SqlMapClient sqlSession = new SqlMapClient();
		SqlSession session = sqlSession.getSqlSession();
		int result= session.insert("CommunityBoard.InsertReviewBoard",bVO);
		session.commit();
		session.close();
		return result;
	}
	
	public int doUpdateReviewBoard(BoardVO bVO) throws Exception{
		SqlMapClient sqlSession = new SqlMapClient();
		SqlSession session = sqlSession.getSqlSession();
		int result= session.update("CommunityBoard.UpdateReviewBoard",bVO);
		session.commit();
		session.close();
		return result;
	}
	
	public List<BoardVO> doSelectAllCustomerBoard(int spage) throws Exception{
		SqlMapClient sqlSession = new SqlMapClient();
		SqlSession session = sqlSession.getSqlSession();
		List<BoardVO> VOList = session.selectList("CommunityBoard.SelectAllCustomerBoard", spage);
		session.close();
		return VOList;
	}
	
	public BoardVO doSelectCustomerBoard(BoardVO bVO) throws Exception{
		SqlMapClient sqlSession = new SqlMapClient();
		SqlSession session = sqlSession.getSqlSession();
		BoardVO VO = session.selectOne("CommunityBoard.SelectCustomerBoard",bVO);
		session.close();
		return VO;
	}
	
	public int doInsertCustomerBoard(BoardVO bVO) throws Exception{
		SqlMapClient sqlSession = new SqlMapClient();
		SqlSession session = sqlSession.getSqlSession();
		int result= session.insert("CommunityBoard.InsertCustomerBoard",bVO);
		session.commit();
		session.close();
		return result;
	}
	
	public BoardVO doModifyCustomerBoard(BoardVO bVO) throws Exception{
		SqlMapClient sqlSession = new SqlMapClient();
		SqlSession session = sqlSession.getSqlSession();
		BoardVO VO = session.selectOne("CommunityBoard.ModifyCustomerBoard",bVO);
		session.close();
		return VO;
	}
	
	public int doUpdateCustomerBoard(BoardVO bVO) throws Exception{
		SqlMapClient sqlSession = new SqlMapClient();
		SqlSession session = sqlSession.getSqlSession();
		int result= session.update("CommunityBoard.UpdateCustomerBoard",bVO);
		session.commit();
		session.close();
		return result;
	}
	
	public int doSearchBoardCount(String btype, String stype, String cntnt) throws Exception{
		SqlMapClient sqlSession = new SqlMapClient();
		SqlSession session = sqlSession.getSqlSession();
		SearchVO sVO = new SearchVO();
		String query = null;
		if(btype.equals("p")){
			sVO.setBtype("p");
			query = "ConsultBoard.TermSelectConsultBoard2";
		}else if(btype.equals("s")){
			sVO.setBtype("s");
			query = "ConsultBoard.TermSelectConsultBoard2";
		}else if(btype.equals("n")){
			sVO.setBtype("n");
			query = "CommunityBoard.TermSelectNoticeBoard2";
		}else if(btype.equals("r")){
			sVO.setBtype("r");
			query = "CommunityBoard.TermSelectReviewBoard2";
		}else if(btype.equals("c")){
			sVO.setBtype("c");
			query = "CommunityBoard.TermSelectCustomerBoard2";
		}
		
		if(stype.equals("a")){
			sVO.setStype("a");
		}else if(stype.equals("t")){
			sVO.setStype("t");
		}else if(stype.equals("w")){
			sVO.setStype("w");
		}else if(stype.equals("c")){
			sVO.setStype("c");
		}
		sVO.setCntnt(cntnt);
		int result = session.selectOne(query, sVO);
		session.close();
		return result;
	}

	public List<BoardVO> doSearchBoard(String btype, String stype, String cntnt, int spage) throws Exception{
		SqlMapClient sqlSession = new SqlMapClient();
		SqlSession session = sqlSession.getSqlSession();
		SearchVO sVO = new SearchVO();
		String query = null;
		if(btype.equals("p")){
			sVO.setBtype("p");
			query = "ConsultBoard.TermSelectConsultBoard";
		}else if(btype.equals("s")){
			sVO.setBtype("s");
			query = "ConsultBoard.TermSelectConsultBoard";
		}else if(btype.equals("n")){
			sVO.setBtype("n");
			query = "CommunityBoard.TermSelectNoticeBoard";
		}else if(btype.equals("r")){
			sVO.setBtype("r");
			query = "CommunityBoard.TermSelectReviewBoard";
		}else if(btype.equals("c")){
			sVO.setBtype("c");
			query = "CommunityBoard.TermSelectCustomerBoard";
		}
		
		if(stype.equals("a")){
			sVO.setStype("a");
		}else if(stype.equals("t")){
			sVO.setStype("t");
		}else if(stype.equals("w")){
			sVO.setStype("w");
		}else if(stype.equals("c")){
			sVO.setStype("c");
		}
		sVO.setCntnt(cntnt);
		sVO.setSpage(spage);
		List<BoardVO> VOList = session.selectList(query, sVO);
		session.close();
		return VOList;
	}
	
	public int isPrivate(BoardVO bVO) throws Exception{
		int result = 0; 
		SqlMapClient sqlSession = new SqlMapClient();
		SqlSession session = sqlSession.getSqlSession();
		BoardVO VO = session.selectOne("ConsultBoard.IsPrivate",bVO);
		if(VO.getBoardIsPrivate() == 1){
			if(VO.getMemId() == null){	//비로그인 사용자의 비밀글
				result = 1;
			}else{	//로그인 사용자의 비밀글
				result = 2;
			}
		}// 공개글
		session.close();
		return result;
	}
	
	public BoardVO doBoardComparePW(BoardVO bVO) throws Exception{
		SqlMapClient sqlSession = new SqlMapClient();
		SqlSession session = sqlSession.getSqlSession();
		BoardVO VO = session.selectOne("ConsultBoard.CompareBoardPW",bVO);
		session.close();
		return VO;
	}
	
	public void doUpdateViewCnt(BoardVO bVO) throws Exception{
		SqlMapClient sqlSession = new SqlMapClient();
		SqlSession session = sqlSession.getSqlSession();
		int result= session.update("ConsultBoard.doUpdateViewCnt",bVO);
		session.commit();
		session.close();
	}
}
