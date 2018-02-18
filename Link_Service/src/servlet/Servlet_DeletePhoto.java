package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao_Links;


@WebServlet("/Servlet_DeletePhoto")
public class Servlet_DeletePhoto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Servlet_DeletePhoto() {
        super();
        System.out.println("Servlet_DeletePhoto.Servlet_DeletePhoto()");
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet_DeletePhoto.doGet()");
		String poistettava = request.getParameter("photo_id");
		Dao_Links dao = new Dao_Links();
		try {
			dao.deletePicture(poistettava);
		} catch (Exception e) {			
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet_DeletePhoto.doPost()");
	}

}
