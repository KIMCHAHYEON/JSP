package webtest;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import beans.UsrDTO;
import db.Usr_db;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String msg = (String)request.getAttribute("msg");		
		if(msg == null) {
			request.setAttribute("msg", msg);
		}
		request.getRequestDispatcher("/WEB-INF/Login.jsp").forward(request, response);
	}

	/**
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String u_id = request.getParameter("u_id");
		String pwd  = request.getParameter("pwd");
		
		UsrDTO us = new UsrDTO();
		us.setU_id(u_id);
		us.setPwd(pwd);

		Usr_db ud = new Usr_db();
		int result = ud.select(us);
		
		if(result == 1) {
			HttpSession session = request.getSession();//세션이란? 서버쪽에 가지고 있는 정보. 필요성:로그인을 하더라도 세션에 정보를 저장 안하면 정보가 사라진다
													//쿠키란? 클라이언트에서 가지고 있는 정보. 보안은 떨어지나 세션보다 속도가 빠르다.
			session.setAttribute("usr", us);
			response.sendRedirect("/TestWeb/BoardMain");
		}else {
			request.setAttribute("msg", "로그인실패");
			doGet(request,response);
		}

		
	}

}
