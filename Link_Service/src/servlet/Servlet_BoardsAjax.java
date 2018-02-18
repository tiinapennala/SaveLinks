package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;


@WebServlet("/Servlet_BoardsAjax")
public class Servlet_BoardsAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public Servlet_BoardsAjax() {
        super();
        System.out.println("Servlet_BoardsAjax.Servlet_BoardsAjax()");
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet_BoardsAjax.doGet()");
		Dao dao = new Dao();
		try {
			String[] sarakkeet={"Board_id", "Name"};
			String strJSON = dao.haeTiedotJSON(sarakkeet,"LS_Boards","Deleted","0",2);
			PrintWriter out = response.getWriter(  );
		    response.setContentType("text/html"); 
		    out.println(strJSON);
	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet_BoardsAjax.doPost()");
	}

}
