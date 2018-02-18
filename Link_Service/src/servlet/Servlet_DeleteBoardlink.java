package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao_BoardLinks;


@WebServlet("/Servlet_DeleteBoardlink")
public class Servlet_DeleteBoardlink extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Servlet_DeleteBoardlink() {
        super();
        System.out.println("Servlet_DeleteBoardlink.Servlet_DeleteBoardlink()");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet_DeleteBoardlink.doGet()");
		String id = request.getParameter("boardlink_id");
		id=id.replace("delete_", "");
		String link_id = request.getParameter("link_id");
//		link_id=id.replace("&link_id_", "");
		

		Dao_BoardLinks dao = new Dao_BoardLinks();
		try {
			dao.deleteBoardlink(Integer.parseInt(id));			
			response.sendRedirect("Servlet_EditLink?Link_id=edit_" + link_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet_DeleteBoardlink.doPost()");
	}

}
