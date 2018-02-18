package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao_Links;

@WebServlet("/Servlet_GetPhotos")
public class Servlet_GetPhotos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Servlet_GetPhotos() {
        super();
        System.out.println("Servlet_GetPhotos.Servlet_GetPhotos()");
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet_GetPhotos.doGet()");
		String id = request.getParameter("link_id");
		System.out.println(id); // check that you get the correct id to log
		Dao_Links dao = new Dao_Links();
		try {			
			ArrayList<String> photos = dao.getPictures(Integer.parseInt(id));			
			request.setAttribute("photos", photos);	
			String jsp = "/uploader.jsp?link_id="+id; 
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(jsp);
			dispatcher.forward(request, response);	
		} catch (Exception e) {			
			e.printStackTrace();
		} 
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet_GetPhotos.doPost()");
	}

}
