package webpage;

import java.io.IOException;

import beans.Board_DTO;
import beans.UsrDTO;
import db.BoardDB;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
public class Text extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Text() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/text.jsp").forward(request, response);
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String b_pwd = request.getParameter("b_pwd");
		String b_title = request.getParameter("b_title");
		String b_text = request.getParameter("b_text");
		
		HttpSession session = request.getSession();
		UsrDTO user = (UsrDTO) session.getAttribute("usr");
		
		Board_DTO bdt = new Board_DTO();
		
		bdt.setB_pwd(b_pwd);
		bdt.setB_title(b_title);
		bdt.setB_text(b_text);
		bdt.setU_id(user.getU_id());
		
		BoardDB db = new BoardDB();
		
		db.boardInsert(bdt);
		
		response.sendRedirect("/JspTest/BoardMain");
		
		
		}

}
