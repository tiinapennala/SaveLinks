package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao_Links;


@WebServlet("/Servlet_OrderPhotos")
public class Servlet_OrderPhotos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Servlet_OrderPhotos() {
        super();
        System.out.println("Servlet_OrderPhotos.Servlet_OrderPhotos()");
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet_OrderPhotos.doGet()");
		String photos = request.getParameter("photos");
		Dao_Links dao = new Dao_Links();
		try {
			dao.orderPictures(photos);
		} catch (Exception e) {			
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet_OrderPhotos.doPost()");
	}

}
