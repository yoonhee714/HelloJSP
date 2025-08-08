package com.yedam.service;

import java.util.List;

import com.yedam.vo.ReplyVO;

public interface EventService {
	// 목록,추가 ,삭제 ReplyServiceImpl에 구현
		List<ReplyVO> evenList();

		void insertEvent(Object event);
}
