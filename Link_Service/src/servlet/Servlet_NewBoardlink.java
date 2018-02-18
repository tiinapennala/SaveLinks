package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao_Links;
import model.BoardLink;
import model.Link;


@WebServlet("/Servlet_NewBoardlink")
public class Servlet_NewBoardlink extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Servlet_NewBoardlink() {
        super();
        System.out.println("Servlet_NewBoardlink.Servlet_NewBoardlink()");
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet_NewBoardlink.doGet()");
		
		BoardLink boardlink = new BoardLink();
		boardlink.setBoard_id(Integer.parseInt(boardlink_id));
		
/*		Link link = new Link();
		link.setLink_id(Integer.parseInt(linkStr));
		link.setTitle(request.getParameter("title"));
		link.setLink(request.getParameter("link"));
		link.setDetails(request.getParameter("details"));
		Dao_Links dao = new Dao_Links();
		dao.editLink(link);
*/
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet_NewBoardlink.doPost()");
	}

}
