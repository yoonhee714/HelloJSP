package com.yedam.mapper;

import java.util.List;

import com.yedam.common.SearchDTO;
import com.yedam.vo.BoardVO;

//규칙정의(추상메소드)
public interface BoardMapper {
	public List<BoardVO> selectList(SearchDTO search); //목록
	public BoardVO selectBoard(int boardNo); //단건조회
	public int updateCount(int boardNo); //조회수 증가
	public int insertBoard(BoardVO board); //insert
	public int deleteBoard(int boardNo); //삭제
	public int selectCount(SearchDTO search); //게시글 전체건수
	public int updateBoard(BoardVO board);
	public List<BoardVO> selectList(int page);
	
}
