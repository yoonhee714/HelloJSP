package com.yedam.mapper;

import java.util.List;
import com.yedam.vo.ReplyVO;

public interface EventMapper {
	// 250827 event 목록, 추가, 삭제 -> mapper.xml에 추가
	// 전체 일정 조회
    List<ReplyVO> getAllEvents();

    // 일정 등록
    int insertEvent(ReplyVO event);

    // 일정 수정
    int updateEvent(ReplyVO event);

    // 일정 삭제
    int deleteEvent(String title);
}

