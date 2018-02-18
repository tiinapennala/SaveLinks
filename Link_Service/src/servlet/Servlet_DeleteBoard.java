package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Dao_Boards;
import dao.Dao_Links;


@WebServlet("/Servlet_DeleteBoard")
public class Servlet_DeleteBoard extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Servlet_DeleteBoard() {
        super();
        System.out.println("Servlet_DeleteBoard.Servlet_DeleteBoard()");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet_DeleteBoard.doGet()");
		String id = request.getParameter("Board_id");
		id=id.replace("delete_", "");
		Dao_Boards dao = new Dao_Boards();
		try {
			dao.deleteBoard(Integer.parseInt(id));
			HttpSession session = request.getSession(true);
			response.sendRedirect("Servlet_GetBoards?keyword=" + session.getAttribute("keywordBoard"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet_DeleteBoard.doPost()");
	}

}
