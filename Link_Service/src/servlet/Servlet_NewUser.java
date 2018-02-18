package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao_Users;
import model.User;


@WebServlet("/Servlet_NewUser")
public class Servlet_NewUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Servlet_NewUser() {
        super();
        System.out.println("Servlet_NewUser.Servlet_NewUser()");
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet_NewUser.doGet()");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet_NewUser.doPost()");
		
		User user = new User();
		user.setFirstname(request.getParameter("fistname"));
		user.setLastname(request.getParameter("lastname"));
		user.setEmail(request.getParameter("email"));
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		
		Dao_Users dao = new Dao_Users();
		if(dao.addUser(user)){
			response.sendRedirect("index.jsp?signin=1");
		}else{
			response.sendRedirect("index.jsp?signin=0");
		}
		
	}

}
