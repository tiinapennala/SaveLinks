package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Servlet_GetLinksBoards")
public class Servlet_GetLinksBoards extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Servlet_GetLinksBoards() {
        super();
        System.out.println("Servlet_GetLinksBoards.Servlet_GetLinksBoards()");
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet_GetLinksBoards.doGet()");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet_GetLinksBoards.doPost()");
		
	}

}
