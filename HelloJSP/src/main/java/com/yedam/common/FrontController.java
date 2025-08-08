package com.yedam.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.control.AddBoardControl;
import com.yedam.control.AddReplyControl;
import com.yedam.control.BoardControl;
import com.yedam.control.BoardListControl;
import com.yedam.control.ChartControl;
import com.yedam.control.EventControl;
import com.yedam.control.JSControl;
import com.yedam.control.LoginControl;
import com.yedam.control.LogoutControl;
import com.yedam.control.ModifyBoardControl;
import com.yedam.control.ModifyFormControl;
import com.yedam.control.RegisterControl;
import com.yedam.control.ReplyListControl;
import com.yedam.control.SignFormControl;
import com.yedam.control.SignUpControl;
import com.yedam.control.TotalCntControl;
import com.yedam.control.LoginFormControl;

//init -service - detroy
//*.do - 실행할 컨트롤 
//요청 url == 실행할 컨트롤
public class FrontController extends HttpServlet {
	
	Map<String, Control> map;

	// 생성자
	public FrontController() {
		map = new HashMap<String, Control>();
		
	}
	
	@Override
	public void init() throws ServletException {
		map.put("/boardList.do", new BoardListControl());//글목록
		map.put("/board.do", new BoardControl());//상세화면
		map.put("/register.do", new RegisterControl()); //등록화면
		map.put("/addBoard.do", new AddBoardControl()); //등록처리
		map.put("/modifyForm.do", new ModifyFormControl()); //수정화면
		map.put("/modifyBoard.do", new ModifyBoardControl()); //수정처리
		map.put("/signForm.do", new SignFormControl()); 
		map.put("/signup.do", new SignUpControl());
		map.put("/loginForm.do", new LoginFormControl()); //로그인 화면
		map.put("/login.do", new LoginControl()); //로그인
		map.put("/logout.do", new LogoutControl()); //로그아웃
		
		//기타
		map.put("/js.do", new JSControl()); 
		
		//댓글관련
		map.put("/replyList.do", new ReplyListControl()); //글번호 - 댓글목록
		map.put("/removeReply.do", new RemoveReplyControl()); //댓글 삭제 
		map.put("/addReply.do", new AddReplyControl()); //글등록 
		map.put("/totalReply.do", new TotalCntControl()); //글등록 para-> bno, json 문자열이 나오게 {"totalCnt": 78}
		
		//기타
		map.put("/chartData.do", new ChartControl()); 
		//fullcalendar 목록
		map.put("/eventList.do", new EventControl()); //이벤트목록
	//위에먼저	map.put("/addEvent.do", new AddEventControl()); //이벤트등록 {retcode:"OK"/"NG"}
		
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// url vs.uri
		// http://localhost:8080/HelloJSP/boardList.do => url
		// HelloJSP/boardList.do					   => uri
		String uri = req.getRequestURI();
		String context = req.getContextPath(); //  /HelloJSP
		String page = uri.substring(context.length()); // /boardList.do	
		
		Control control = map.get(page);		
		control.execute(req, resp);
	}

}
