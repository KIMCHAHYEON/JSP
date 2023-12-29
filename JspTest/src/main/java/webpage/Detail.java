package webpage;

import java.io.IOException;

import beans.Board_DTO;
import db.BoardDB;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Detail
 */
public class Detail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Detail() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getParameter("b_id");
		BoardDB bdb = new BoardDB();
		Board_DTO bdt = new Board_DTO();
		bdt.setB_id(request.getParameter("b_id"));
		//반환타입???
		bdb.detail(bdt);
		request.setAttribute("bdt", bdt);
		request.getRequestDispatcher("/WEB-INF/detail.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
