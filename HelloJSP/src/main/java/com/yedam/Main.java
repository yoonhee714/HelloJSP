package com.yedam;

import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class Main {
	public static void main(String[] args) {
		
		BoardService svc = new BoardServiceImpl();
		
		int searchNo = 1;
		

		//조회. 조회수 증가 => 업무(조회: 글번호 조회 +  조회 카운트)
		BoardVO board = svc.searchBoard(searchNo);
	
		//hr, 근태, +++++ => 업무
		System.out.println(board.toString());
		
//		List<BoardVO> list = mapper.selectList();
//		for(BoardVO board : list) {
//			System.out.println(board.toString());
//		}
		
	}
}
