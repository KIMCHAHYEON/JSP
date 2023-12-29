package webtest;

import java.io.IOException;

import beans.UsrDTO;
import db.Usr_db;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Webtest extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Webtest() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println(request.getParameter("q")); 주소 뒤에 변수 값을 들고옴, 하지만 get방식은 보안 이 안좋다. 
		//사용자 정보는 post로 get은 알려져도 상관없고 빠른 처리가 필요 할때.
		request.getRequestDispatcher("/WEB-INF/Webtest.jsp").forward(request, response);
        	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String u_name 	= 	request.getParameter("u_name");//jsp 파일의 U_name에 들어가는 값을 들고옴
		String u_id 	= 	request.getParameter("u_id"); 
		String pwd		= 	request.getParameter("pwd");
		String birthday = 	request.getParameter("birthday");
		String phone	= 	request.getParameter("phone");
		
		UsrDTO us = new UsrDTO();
		us.setU_id(u_id);
		us.setPhone(phone);
		us.setPwd(pwd);
		us.setBirthday(birthday);
		us.setU_name(u_name);
		
		Usr_db ud = new Usr_db();
		ud.join(us);
		
		response.sendRedirect("/TestWeb/Login");
		
	}

}
