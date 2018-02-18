package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Dao_Boards;
import model.Board;


@WebServlet("/Servlet_GetBoards")
public class Servlet_GetBoards extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Servlet_GetBoards() {
        super();
        System.out.println("Servlet_GetBoards.Servlet_GetBoards()");
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet_GetBoards.doGet()");
		String keyword = request.getParameter("keyword");
		
		HttpSession session = request.getSession(true);
		session.setAttribute("keywordBoard", keyword);	
				
		Dao_Boards dao = new Dao_Boards();
		try {
			ArrayList<Board> boards = dao.getBoards(keyword);
			request.setAttribute("boards", boards);		
			String jsp = "/boards.jsp"; 
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(jsp);
			dispatcher.forward(request, response);	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet_GetBoards.doPost()");
	}

}
