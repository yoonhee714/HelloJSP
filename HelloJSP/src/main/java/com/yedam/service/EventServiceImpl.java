package com.yedam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired; //???

import com.yedam.mapper.EventMapper;
import com.yedam.vo.ReplyVO;

public class EventServiceImpl implements EventService {
	
	private final EventMapper eventMapper;

    @Autowired //????
    public EventServiceImpl(EventMapper eventMapper) {
        this.eventMapper = eventMapper;
    }

    public List<ReplyVO> getAllEvents() {
        return eventMapper.getAllEvents();
    }

    public void insertEvent(ReplyVO event) {
        eventMapper.insertEvent(event);
    }

    public void updateEvent(ReplyVO event) {
        eventMapper.updateEvent(event);
    }

    public void deleteEvent(String title) {
        eventMapper.deleteEvent(title);
    }

	@Override
	public List<ReplyVO> evenList() {
		
		return null;
	}

	//????
	@Override
	public void insertEvent(Object event) {
		// TODO Auto-generated method stub
		
	}
}
