package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;

public class RegisterControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) 
		throws ServletException, IOException {
		
			req.getRequestDispatcher("user/register_form.tiles").forward(req, resp);
		
		

	}

}
