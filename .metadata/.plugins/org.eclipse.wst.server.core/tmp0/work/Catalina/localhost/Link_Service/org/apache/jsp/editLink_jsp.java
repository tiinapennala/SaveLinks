/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.33
 * Generated at: 2018-02-18 10:57:01 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import java.text.*;
import java.util.ArrayList;
import model.Link;
import model.Board;
import model.BoardLink;

public final class editLink_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

 @SuppressWarnings("unchecked") 
  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/header.jsp", Long.valueOf(1518951416926L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("java.util");
    _jspx_imports_packages.add("java.text");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("model.Board");
    _jspx_imports_classes.add("model.BoardLink");
    _jspx_imports_classes.add("model.Link");
    _jspx_imports_classes.add("java.util.ArrayList");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

final java.lang.String _jspx_method = request.getMethod();
if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
return;
}

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;


if(session.getAttribute("savePath")==null){
	String savePath ="C:/Users/penna/Documents/HH 2015-/2017_Kevat/Ohjelmistoprojekti/Oma projekti/Link_Service_siistitty/Link_Service/WebContent/images/uploaded";
	session.setAttribute("savePath", savePath);		
}
if(!request.getRequestURI().equals("/Link_Service/index.jsp")){ 	//jos kutsutaan jotakin muuta kuin index.jsp -sivua
	if(session.getAttribute("SignIn_name")==null){			//ja kirjautumista ei ole tapahtunut
		//response.sendRedirect("index.jsp");
	}
}

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js\"></script>\r\n");
      out.write("<script src=\"http://ajax.aspnetcdn.com/ajax/jquery.validate/1.15.0/jquery.validate.min.js\"></script>\r\n");
      out.write("<script src=\"https://code.jquery.com/ui/1.12.1/jquery-ui.js\"></script>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/Link_Service/style.css\" type=\"text/css\" >\r\n");
      out.write("<title>BLink</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div id=\"header-wrapper\">\r\n");
      out.write("\t\t  <div id=\"header\" class=\"containerheader\">\r\n");
      out.write("\t\t   <div id=\"logo\">\r\n");
      out.write("\t\t\t\t<h1><a href=\"#\">BLink</a></h1>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div id=\"menu\">\r\n");
      out.write("\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t<div id=\"signInSuccessful\">\r\n");
      out.write("\t\t\t\t\t\t\tUser: ");
out.print(session.getAttribute("SignIn_name"));
      out.write("<br>\r\n");
      out.write("\t\t\t\t\t\t\t<a style=\"float:right; font-size: 10px; padding: 2px; color:#ababab;\" href=\"Servlet_SignIn?out=1\">Log out</a>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t<li><a class=\"menu active\" id=\"boardIcon\" onclick=\"document.location='boards.jsp'\">Boards</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a class=\"menu active\" id=\"linkIcon\" onclick=\"document.location='mainview.jsp'\">Links</a></li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t </div>\r\n");
      out.write("\t\t");
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");

if(session.getAttribute("SignIn_name")==null){		
	out.println("<script>");
	out.println("$('#signInSuccessful').hide();");
	out.println("$('#boardIcon').hide();");
	out.println("$('#linkIcon').hide();");	
	out.println("</script>");	
}

      out.write('\r');
      out.write('\n');
      out.write('	');
      out.write("\r\n");
      out.write(" \r\n");
      out.write(" \r\n");
      out.write(" \r\n");
      out.write(" \r\n");
      out.write(" \r\n");
      out.write(" \r\n");
      out.write(' ');
      out.write('\r');
      out.write('\n');

Link link= null;
if( request.getAttribute("link")!=null){
	link = (Link)request.getAttribute("link");	
}

      out.write("\r\n");
      out.write("\r\n");
      out.write("<div id=\"container\">\r\n");
      out.write("\t<fieldset id=\"linkDetails\">\r\n");
      out.write("\t\t<legend>Link details:</legend>\r\n");
      out.write(" \r\n");
      out.write("\t\t<input type=\"submit\" class=\"leftbutton\" value=\"Add Picture\" id=\"addLinkPicture\" onclick=\"addLinkPicture();\"><br><br><br>\r\n");
      out.write("\t\t\t\r\n");
      out.write(" \r\n");
      out.write("\t<h4> Linked boards: </h4>\r\n");

boolean deleted=false;
	if(request.getAttribute("boardlinks")!=null){
		ArrayList<BoardLink> boardlinks = (ArrayList<BoardLink>)request.getAttribute("boardlinks");	
		ArrayList<Board> boards = (ArrayList<Board>)request.getAttribute("boards");	
			for(int i=0;i<boardlinks.size();i++){				
				if(boardlinks.get(i).getDeleted()==0){	
					out.print("<li class='linkedboard'>");
					out.print("<p>"+ boards.get(i).getName() +"<img src='images/delete1.png' class='icon delete' id='delete_"+boardlinks.get(i).getBoardlink_id()+"'></p>");
					out.print("</li>");
				}
			} 
			out.print("<br>");			
		}

      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t<form action=\"Servlet_EditLink\" method=\"post\" id=\"newForm\">\r\n");
      out.write("\t\t\t<label>Add board:</label>\r\n");
      out.write("\t\t\t\t<select name=\"boardAjax\" id=\"boardAjax\"></select><br><br>\r\n");
      out.write("\t\t\t<label>Title:</label>\r\n");
      out.write("\t\t\t\t<input type=\"text\" name=\"title\" id=\"title\" value=\"");
out.print(link.getTitle());
      out.write("\" size=\"40\"><br><br>\t\r\n");
      out.write("\t\t\t<label>Link:</label>\r\n");
      out.write("\t\t\t\t<input type=\"text\" name=\"link\" id=\"link\" value=\"");
out.print(link.getLink());
      out.write("\" size=\"40\"><br><br>\t\r\n");
      out.write("\t\t\t<label>Details:</label>\t\r\n");
      out.write("\t\t\t\t<textarea rows=\"10\" cols=\"30\" name=\"details\" id=\"details\">");
out.print(link.getDetails());
      out.write("</textarea><br><br>\r\n");
      out.write("\t\t\t<label></label>\r\n");
      out.write("\t\t\t\t<input type=\"submit\" value=\"Save\" id=\"addBtn\"><br>\r\n");

if(request.getParameter("ok")!=null){
	if(request.getParameter("ok").equals("1")){
		out.print("New link has been added.");	
	}else if(request.getParameter("ok").equals("0")){
		out.print("Addig was unsuccesful.");	
	}
}

      out.write("\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"link_id\" value=\"");
out.print(link.getLink_id());
      out.write("\">\t\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t</fieldset>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t");
      out.write("\r\n");
      out.write("\t<div id=\"deleteConfirmationationation\">\r\n");
      out.write("\t\t<span id=\"deletableName\"></span>\r\n");
      out.write("\t\t<img src=\"images/accept.png\" title=\"Delete\" class=\"icon\" id=\"confirmDelete\">\r\n");
      out.write("\t\t<img src=\"images/delete.png\" title=\"Cancel\" class=\"icon\" id=\"cancelDelete\">\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("$(document).ready(function(){\r\n");
      out.write("\t$(\"#deleteConfirmationationation\").hide();\r\n");
      out.write("\t\r\n");
      out.write("\t$(\"#linkDetails\").css({\r\n");
      out.write("\t\t\"width\": \"500px\", \r\n");
      out.write("\t\t\"border-radius\": \"15px\"\r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("\t$(\"#newForm\").validate({\t\t\t\t\t\t\r\n");
      out.write("\t\trules: {\t\r\n");
      out.write("\t\t\tlink:  {\r\n");
      out.write("\t\t\t\trequired: true,\r\n");
      out.write("\t\t\t\tminlength: 2\t\t\t\t\r\n");
      out.write("\t\t\t}\t\t\r\n");
      out.write("\t\t},\r\n");
      out.write("\t\tmessages: {\r\n");
      out.write("\t\t\tlinkUrl: {     \r\n");
      out.write("\t\t\t\trequired: \"Required\",\r\n");
      out.write("\t\t\t\tminlength: \"Too short\"\t\t\t\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t},\t\t\t\r\n");
      out.write("\r\n");
      out.write("\t\tsubmitHandler: function (form) {\t\r\n");
      out.write("\t\t\tdocument.forms[\"newForm\"].submit();\r\n");
      out.write("\t\t}\t\r\n");
      out.write("\t});   \r\n");
      out.write("\r\n");
      out.write("//\tAJAX SEARCH FOR BOARDS\r\n");
      out.write("\t$(\"#boardAjax\").append(\"<option value='-1'>Select board</option>\");  \r\n");
      out.write("\t$.getJSON(\"Servlet_BoardsAjax\", function(result){\r\n");
      out.write("\t    $.each(result, function(i, field){\r\n");
      out.write("\t    \t$(\"#boardAjax\").append(\"<option value='\"+field.Board_id+\"'>\"+field.Board_id+ \" \"+field.Name+\"</option>\"); \r\n");
      out.write("\t    \t\r\n");
      out.write("\t    });\r\n");
      out.write("\t});\t\r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write("var deletable_id;\t\r\n");
      out.write("$(\".delete\").click(function(event){\t//event kantaa mukanaan tapahtuman, mm. klikkauksen sijainnin\t\r\n");
      out.write("\tdeletable_id=$(this)[0].id;\r\n");
      out.write("\t$(\"#deletableName\").html(\"Delete\"+ $(this)[0].title + \"?<br>\");\r\n");
      out.write("\t$(\"#deleteConfirmationationation\").css({ \r\n");
      out.write("\t\t\"width\": \"170px\", \r\n");
      out.write("\t\t\"height\": \"50px\",\r\n");
      out.write("\t\t\"background-color\": \"#4CAF50\",\r\n");
      out.write("\t\t\"border-radius\": \"15px\",\r\n");
      out.write("\t\t\"color\": \"white\",\r\n");
      out.write("\t\t\"text-align\": \"center\",\r\n");
      out.write("\t\t\"padding\": \"10px\",\r\n");
      out.write("\t\t\"border\": \"1px solid black\",\r\n");
      out.write("\t\t\"position\": \"absolute\",\r\n");
      out.write("\t\t\"left\": event.pageX +\"px\",\r\n");
      out.write("\t\t\"top\": event.pageY +\"px\"\r\n");
      out.write("\t});\t\t\t\r\n");
      out.write("\t$(\"#deleteConfirmationationation\").show();\r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write("$(\"#confirmDelete\").click(function(){\r\n");
      out.write("\tdocument.location=\"Servlet_DeleteBoardlink?boardlink_id=\"+deletable_id+\"&link_id=");
out.print(link.getLink_id());
      out.write("\";\r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write("$(\"#cancelDelete\").click(function(){\r\n");
      out.write("\t$(\"#deleteConfirmationationation\").hide();\r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write("function addLinkPicture(){\r\n");
      out.write("\twindow.open('Servlet_GetPhotos?link_id=' + ");
out.print(link.getLink_id());
      out.write(" ,null, 'toolbar=no,status=no,width=400,height=600,left=150,top=100,scrollbars=yes')\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("//$(\"#addLinkPicture\").click(function(event){\r\n");
      out.write("//\twindow.open('Servlet_GetPhotos?link_id=' + ");
out.print(link.getLink_id());
      out.write(" ,null, 'toolbar=no,status=no,width=400,height=600,left=150,top=100,scrollbars=yes')\r\n");
      out.write("//\r\n");
      out.write("//});\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("</div>\r\n");
      out.write("<br><br>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
