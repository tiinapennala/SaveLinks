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

import dao.Dao_Links;
import model.Link;

@WebServlet("/Servlet_GetLinks")
public class Servlet_GetLinks extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Servlet_GetLinks() {
        super();
        /* write systr and press ctrl + space to get the comment below*/
        System.out.println("Servlet_GetLinks.Servlet_GetLinks()");
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet_GetLinks.doGet()");
		String keyword = request.getParameter("keyword");
		
		HttpSession session = request.getSession(true);
		session.setAttribute("keywordLink", keyword);	
				
		Dao_Links dao = new Dao_Links();
		try {
			ArrayList<Link> links = dao.getLinks(keyword);
			request.setAttribute("links", links);		
			String jsp = "/mainview.jsp"; 
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(jsp);
			dispatcher.forward(request, response);	
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		System.out.println("Servlet_GetLinks.doPost()");
	}

}
