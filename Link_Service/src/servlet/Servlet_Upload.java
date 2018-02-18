package servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import dao.Dao_Links;

@SuppressWarnings("serial")
@WebServlet("/Servlet_Upload")
@MultipartConfig(fileSizeThreshold=1024*1024*2, maxFileSize=1024*1024*10, maxRequestSize=1024*1024*50)   // 2,10,50MB

public class Servlet_Upload extends HttpServlet {
 
   
    public Servlet_Upload() {
        super();
        System.out.println("Servlet_Upload.Servlet_Upload()");
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet_Upload.doGet()");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet_Upload.doPost()");
		String savePath = request.getServletContext().getRealPath("") + "uploads"; 
    	HttpSession session = request.getSession(true);
    	savePath = session.getAttribute("savePath").toString();
    	System.out.println("Polku on: " + savePath); //Shows the path from where server is serving not the path of your source code        
        File fileSaveDir = new File(savePath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdir();
        }  
        String fileName="";
        for (Part part : request.getParts()) {
            fileName = extractFileName(part);            
            fileName = new File(fileName).getName();            
            part.write(savePath + File.separator + fileName);
        }        
       
    	int link_id = Integer.parseInt(session.getAttribute("link_id").toString());
    	String photo = "link_" + link_id + fileName;
    	System.out.println(photo);
    	System.out.println("photon nimi="+photo);
        Dao_Links dao = new Dao_Links();
        try {
			dao.addPicture(photo, link_id);
		} catch (Exception e) {			
			e.printStackTrace();
		}        
        request.setAttribute("message", "Kuva on ladattu onnistuneesti");
        getServletContext().getRequestDispatcher("/uploader.jsp?link_id="+session.getAttribute("link_id")).forward(request, response);
        //Jotta photo p�ivittyisi automaattisesti my�s Eclipseen: Window-Preferences-General-Workspace-Refresh native hooks or pollings
    }
   
    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length()-1);
            }
        }
        return "";
    }
}
