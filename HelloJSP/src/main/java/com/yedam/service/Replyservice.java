package com.yedam.service;

import java.util.List;

import com.yedam.vo.ReplyVO;

public interface Replyservice {

	List<ReplyVO> replyList(int boardNo, int page);
	boolean removeReply(int replyNo);
	boolean addReply(ReplyVO reply); //등록
	
}
