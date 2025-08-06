package com.yedam.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.Control;
import com.yedam.service.ReplyServiceImpl;
import com.yedam.service.Replyservice;
import com.yedam.vo.ReplyVO;

public class AddReplyControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/json; charset=UTF-8");
		
		// param: bno,reply,repler
		String bno = req.getParameter("bno");
		String reply = req.getParameter("reply");
		String replyer = req.getParameter("replyer");
		
		// addReply()
		ReplyVO rvo = new ReplyVO();
		rvo.setBoardNo(Integer.parseInt(bno));
		rvo.setReply(reply);
		rvo.setReplyer(replyer);
		
		// retCode, bno,reply,repler->map키 값
		Map<String, Object> map = new HashMap<String, Object>();
		
		Replyservice svc = new ReplyServiceImpl();
		if(svc.addReply(rvo)) {
				map.put("retCode", "OK");
				map.put("retVal", rvo);
				//resp.getWriter().print("{\"retCode\":\"OK\"}");
			}else {
				map.put("retCode", "NG");
				//resp.getWriter().print("{\"retCode\":\"NG\"}");	
		}
		Gson gson =new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(map); //자바객체 ->문자열(json)
		resp.getWriter().print(json);
	}

}
