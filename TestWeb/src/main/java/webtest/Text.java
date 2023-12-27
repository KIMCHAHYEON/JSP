package webtest;

import java.io.IOException;

import beans.BoardDTO;
import beans.UsrDTO;
import db.Usr_db;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class Text
 */
public class Text extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/Text.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String b_id = request.getParameter("b_id");
		String b_pwd  = request.getParameter("b_pwd");
		String b_title = request.getParameter("b_title");
		String b_text= request.getParameter("b_text");
		
		
		HttpSession session = request.getSession();
		
		UsrDTO dt = (UsrDTO)session.getAttribute("usr");
		
		BoardDTO bt = new BoardDTO();
		bt.setB_id(b_id);
		bt.setB_pwd(b_pwd);
		bt.setB_text(b_text);
		bt.setB_title(b_title);
		bt.setU_id(dt.getU_id());

		Usr_db db = new Usr_db();
		db.boardInsert(bt);
		
		response.sendRedirect("/TestWeb/BoardMain");
	}

}
