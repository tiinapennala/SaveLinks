package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Dao_Links;




@WebServlet("/Servlet_DeleteLink")
public class Servlet_DeleteLink extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Servlet_DeleteLink() {
        super();
        System.out.println("Servlet_DeleteLink.Servlet_DeleteLink()");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet_DeleteLink.doGet()");
		String id = request.getParameter("Link_id");
		id=id.replace("delete_", "");
		Dao_Links dao = new Dao_Links();
		try {
			dao.deleteLink(Integer.parseInt(id));
			HttpSession session = request.getSession(true);
			response.sendRedirect("Servlet_GetLinks?keyword=" + session.getAttribute("keywordLink"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet_DeleteLink.doPost()");
	}

}
