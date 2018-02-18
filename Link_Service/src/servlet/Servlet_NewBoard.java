package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao_BoardLinks;
import dao.Dao_Boards;
import dao.Dao_Links;
import model.Board;
import model.BoardLink;
import model.Link;


@WebServlet("/Servlet_NewBoard")
public class Servlet_NewBoard extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	
    public Servlet_NewBoard() {
        super();
        System.out.println("Servlet_NewBoard.Servlet_NewBoard()");
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet_NewBoard.doGet()");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet_NewBoard.doPost()");
		Board board= new Board();
		board.setName(request.getParameter("name"));
		Dao_Boards dao = new Dao_Boards();
		if(dao.newBoard(board)){
			response.sendRedirect("boards.jsp?ok=1");
		}else{
			response.sendRedirect("boards.jsp?ok=0");
		}
		
	}

}
