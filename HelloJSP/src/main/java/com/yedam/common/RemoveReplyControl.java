package com.yedam.common;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.service.ReplyServiceImpl;
import com.yedam.service.Replyservice;

public class RemoveReplyControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 댓글번호 -> DB삭제 -> 처리결과 반환
		String rno = req.getParameter("rno");
		//서비스 호출
		Replyservice svc = new ReplyServiceImpl();
		if(svc.removeReply(Integer.parseInt(rno))) {
			//{"retCode":"OK"}
			resp.getWriter().print("{\"retCode\":\"OK\"}");
		}else {
			//{"retCode":"NG"}
			resp.getWriter().print("{\"retCode\":\"NG\"}");
		}
	}

}
