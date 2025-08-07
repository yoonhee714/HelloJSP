package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.ReplyServiceImpl;
import com.yedam.service.Replyservice;



public class TotalCntControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/json;charset=utf-8");
		
		String bno = req.getParameter("bno");
		
		Replyservice svc = new ReplyServiceImpl();
		int cnt = svc.replyCount(Integer.parseInt(bno));
		//{"totalCnt:12"}
		
		resp.getWriter().print("{\"totalCnt\":"+ cnt +"}");

	}

}
