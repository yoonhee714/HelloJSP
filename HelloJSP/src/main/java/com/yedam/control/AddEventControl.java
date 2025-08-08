package com.yedam.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.yedam.common.Control;
import com.yedam.service.EventService;
import com.yedam.service.EventServiceImpl;
import com.yedam.vo.ReplyVO;

public class AddEventControl implements Control {
	
	public void execute(HttpServletRequest req, HttpServletResponse resp, Object event) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        String title = req.getParameter("title");
        String start = req.getParameter("startDate");
        String end = req.getParameter("endDate");

        ReplyVO map = new ReplyVO();
        map.setTitle(title);
        map.setStartDate(start);
        map.setEndDate(end);

        EventService service = new EventServiceImpl(null);

        String result = "NG";
        try {
            service.insertEvent(event);
            result = "OK";
        } catch (Exception e) {
            result = "NG";
        }

        Map<String, String> resultMap = new HashMap<>();
        resultMap.put("retCode", result);

        Gson gson = new Gson();
        String json = gson.toJson(resultMap);

        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().print(json);
    }
	
//???이건뭐지
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}


	
	
}

