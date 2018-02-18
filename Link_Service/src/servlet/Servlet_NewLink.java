package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardLink;
import model.Link;
import dao.Dao_BoardLinks;
import dao.Dao_Links;

@WebServlet("/Servlet_NewLink")
public class Servlet_NewLink extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public Servlet_NewLink() {
        super();
        System.out.println("Servlet_NewLink.Servlet_NewLink()");
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet_NewLink.doGet()");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet_NewLink.doPost()");
		int board_id = Integer.parseInt(request.getParameter("boardAjax"));
		
		Dao_BoardLinks daoBoardlink = new Dao_BoardLinks();
		Dao_Links dao = new Dao_Links();

		Link link = new Link();
		link.setLink(request.getParameter("link"));
		link.setTitle(request.getParameter("title"));
		link.setDetails(request.getParameter("details"));
		int link_id = dao.newLink(link);
		System.out.println(link_id);
		if (board_id>0) {
			 BoardLink boardlink = new BoardLink();
			 boardlink.setLink_id(link_id);
			 boardlink.setBoard_id(board_id);
			 daoBoardlink.addBoard(boardlink);
		}	
		
		response.sendRedirect("mainview.jsp");
		
	}

}
