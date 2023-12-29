package webpage;

import java.io.IOException;

import beans.UsrDTO;
import db.UsrDB;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class WebPageMain extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public WebPageMain() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/main.jsp").forward(request, response);
	}	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String u_id 	= request.getParameter("u_id");
		String pwd 		= request.getParameter("pwd");
		String u_name 	= request.getParameter("u_name");
		String birthday = request.getParameter("birthday");
		String phone 	= request.getParameter("phone");
		
		UsrDTO ud = new UsrDTO();
		ud.setU_id(u_id);
		ud.setPwd(pwd);
		ud.setU_name(u_name);
		ud.setBirthday(birthday);
		ud.setPhone(phone);
		
		UsrDB udb = new UsrDB();
		
		udb.join(ud);
		
		response.sendRedirect("/JspTest/Login");
	}

}
