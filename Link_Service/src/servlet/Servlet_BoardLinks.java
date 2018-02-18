package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
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


@WebServlet("/Servlet_BoardLinks")
public class Servlet_BoardLinks extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public Servlet_BoardLinks() {
        super();
        System.out.println("Servlet_BoardLinks.Servlet_BoardLinks()");
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet_BoardLinks.doGet()");
		
		String boardStr = request.getParameter("Board_id");		
		boardStr = boardStr.replace("boardlinks_", "");
		int board_id = Integer.parseInt(boardStr);
		Dao_BoardLinks dao = new Dao_BoardLinks();
		Dao_Boards daoBoard = new Dao_Boards();
	
		
		try {
			Board board = daoBoard.getBoard(board_id);
			request.setAttribute("board", board);
			ArrayList<BoardLink> boardlinks = dao.getBoardLinks(board_id);
			ArrayList<Link> links = new ArrayList<Link>();
//			ArrayList<Asiakas> asiakkaat = new ArrayList<Asiakas>();
//			for(int i=0;i<tarjoukset.size();i++){ //etsitään tarjousten asiakkaat
//				Asiakas asiakas = dao.etsiAsiakas(tarjoukset.get(i).getTarjous_id());
//				asiakkaat.add(asiakas);
//			}
//			
	
			for(int i=0;i<boardlinks.size();i++){ //etsitään tarjousten asiakkaat
				Link link = dao.findLink(boardlinks.get(i).getBoardlink_id());
				links.add(link);
			}
		
			request.setAttribute("boardlinks", boardlinks);
			request.setAttribute("links", links);
			String jsp = "/boardlinks.jsp"; 
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(jsp);
			dispatcher.forward(request, response);	
		} catch (Exception e) {			
			e.printStackTrace();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet_BoardLinks.doPost()");
	}

}
