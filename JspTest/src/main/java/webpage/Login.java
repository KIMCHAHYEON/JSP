package webpage;

import java.io.IOException;

import beans.UsrDTO;
import db.UsrDB;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String msg = (String)request.getAttribute("msg");		
		if(msg != null) {
			request.setAttribute("msg", msg);
		}
		request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String u_id = request.getParameter("u_id");
		String pwd = request.getParameter("pwd");
		
		UsrDTO udt = new UsrDTO();
		udt.setU_id(u_id);
		udt.setPwd(pwd);
		
		UsrDB udb = new UsrDB();
		int result = udb.login(udt);
		
		if(result == 1) {
			HttpSession session = request.getSession();
			session.setAttribute("usr", udt);
			response.sendRedirect("/JspTest/BoardMain");
			
		}
		else {
			request.setAttribute("msg", "로그인 실패");
			doGet(request,response);
		}
		
	}

}
