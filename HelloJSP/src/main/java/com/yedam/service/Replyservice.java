package com.yedam.service;

import java.util.List;

import com.yedam.vo.ReplyVO;

public interface Replyservice {

	List<ReplyVO> replyList(int boardNo, int page);
	boolean removeReply(int replyNo);
	boolean addReply(ReplyVO reply); //등록
	int replyCount(int boardNo); //댓글건수계산
	// 목록,추가 ,삭제 ReplyServiceImpl에 구현
	List<ReplyVO> evenList();
}
