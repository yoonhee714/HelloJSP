package com.yedam.vo;

import java.util.Date;

import lombok.Data;


@Data
public class ReplyVO {
	private int replyNo;
	private int   boardNo; 
	private String reply;    
	private String replyer;    
	private Date replyDate;
	//250807 달력이벤트
	private String Title;
	private Date StartDate; 
	private Date EndDate;
	public void setStartDate(String start) {
		
	}
	public void setEndDate(String end) {
		
	} 

} 
