package webpage;

import java.io.IOException;
import java.util.List;

import beans.Board_DTO;
import db.BoardDB;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
public class BoardMain extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public BoardMain() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BoardDB bDB = new BoardDB();
		List<Board_DTO>boards = bDB.viewText();
		request.setAttribute("boards", boards);
		request.getRequestDispatcher("/WEB-INF/board.jsp").forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}

}
