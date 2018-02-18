package servlet;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao_BoardLinks;
import dao.Dao_Links;
import model.Board;
import model.BoardLink;
import model.Link;


@WebServlet("/Servlet_EditLink")
public class Servlet_EditLink extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Servlet_EditLink() {
        super();
        System.out.println("Servlet_EditLink.Servlet_EditLink()");
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet_EditLink.doGet()");
		String linkStr = request.getParameter("Link_id");
		
		linkStr=linkStr.replace("edit_", "");
		int link_id = Integer.parseInt(linkStr);
		
		Dao_BoardLinks dao = new Dao_BoardLinks();
		Dao_Links daoLink = new Dao_Links();
		try {
			Link link= daoLink.getLink(link_id);
			request.setAttribute("link", link);
		//	request.setAttribute("kuva", daoLink.haePaaKuva(link_id));
			ArrayList<BoardLink> boardlinks = dao.getLinksBoards(link_id);
			ArrayList<Board> boards = new ArrayList<Board>();
			
			for(int i=0;i<boardlinks.size();i++){ 
				Board board = dao.findBoard(boardlinks.get(i).getBoardlink_id());
				boards.add(board);
			} 		
			request.setAttribute("boardlinks", boardlinks);
			request.setAttribute("boards", boards);
			String jsp = "/editLink.jsp"; 
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(jsp);
			dispatcher.forward(request, response);	
		} catch (Exception e) {			
			e.printStackTrace();
		} 
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet_EditLink.doPost()");
		int board_id = Integer.parseInt(request.getParameter("boardAjax"));
		int link_id = Integer.parseInt(request.getParameter("link_id"));		
		Dao_Links dao = new Dao_Links();
		Dao_BoardLinks daoBoardlink = new Dao_BoardLinks();
		
		try {
			Link link = new Link();
			link.setLink_id(link_id);
			link.setTitle(request.getParameter("title"));
			link.setLink(request.getParameter("link"));
			link.setDetails(request.getParameter("details"));
			dao.editLink(link);
			if (board_id>0) {
				 BoardLink boardlink = new BoardLink();
				 boardlink.setLink_id(link_id);
				 boardlink.setBoard_id(board_id);
				 int boardlink_id = daoBoardlink.addBoard(boardlink);
//				 daoBoardlink.addBoard(boardlink);
				 System.out.println(boardlink_id);
			}			
			response.sendRedirect("Servlet_GetLinks?keyword=" + URLEncoder.encode(request.getParameter("title"), "UTF-8"));

					
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
