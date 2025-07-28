package com.yedam.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DBUtil;
import com.yedam.mapper.BoardMapper;
import com.yedam.vo.BoardVO;

//BoardService 인터페이스 구현클래스
//인터페이스에 정의된 추상 메소드를 반드시 구현
public class BoardServiceImpl implements BoardService{

	SqlSession sqlSession = DBUtil.getInstance().openSession();
	BoardMapper mapper = sqlSession.getMapper(BoardMapper.class) ;
	
	@Override
	public List<BoardVO> boardList() {
		return mapper.selectList(); //DB 업무
	}

	@Override
	public BoardVO searchBoard(int boardNo) {
		BoardVO board = mapper.selectBoard(boardNo);//조회
		int r = mapper.updateCount(boardNo); //증가
		if (r>0) {
			sqlSession.commit();
		}
		return board;
	}

	@Override
	public boolean registerBoard(BoardVO board) {
		int r = mapper.insertBoard(board);
		if (r>0) {
			sqlSession.commit();
			return true;
		}
		return false;
	}

	@Override
	public boolean removeBoard(int boardNo) {
		int r = mapper.deleteBoard(boardNo);
		if (r>0) {
			sqlSession.commit();
			return true;
		}
		return false;
		
	}

}
