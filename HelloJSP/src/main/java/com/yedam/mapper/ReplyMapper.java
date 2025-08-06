package com.yedam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.vo.ReplyVO;

public interface ReplyMapper {
	List<ReplyVO> replyList(@Param("boardNo") int boardNo, @Param("page")  int page);
	int deleteReply(int replyNo);
	int insertReply(ReplyVO reply);
	
}
