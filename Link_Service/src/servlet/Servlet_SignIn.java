package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Dao_Users;
import model.User;


@WebServlet("/Servlet_SignIn")
public class Servlet_SignIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Servlet_SignIn() {
        super();
        System.out.println("Servlet_SignIn.Servlet_SignIn()");
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet_SignIn.doGet()");
		if(request.getParameter("out")!=null){
			HttpSession session = request.getSession(true);
			session.removeAttribute("SignIn_id");
			session.removeAttribute("SignIn_name");
			response.sendRedirect("index.jsp");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet_SignIn.doPost()");
		String uid = request.getParameter("uid");	
		String pwd = request.getParameter("pwd");
		Dao_Users dao = new Dao_Users();
		try {
			User user = dao.getUser(uid, pwd);
			if(user!=null){
				HttpSession session = request.getSession(true);
				session.setAttribute("SignIn_id", user.getUsername());	
				session.setAttribute("SignIn_name", user.getFirstname() + " " + user.getLastname());	
				response.sendRedirect("mainview.jsp");
				
			} else {
				response.sendRedirect("index.jsp?signin=2");
			}
			
		} catch (Exception e) {			
			e.printStackTrace();
		} 
	}

}
