/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.33
 * Generated at: 2017-05-18 15:36:53 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;

public final class uploader_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

 @SuppressWarnings("unchecked") 
  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
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

      out.write(' ');
      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js\"></script>\r\n");
      out.write("<script src=\"https://code.jquery.com/ui/1.12.1/jquery-ui.js\"></script>\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<style>\r\n");
      out.write("label{\r\n");
      out.write("    display:inline-block;\r\n");
      out.write("    width:100px;\r\n");
      out.write("    text-align:right;\r\n");
      out.write("    vertical-align:top;\r\n");
      out.write("}\r\n");
      out.write(".nappi{\r\n");
      out.write("\twidth:80px;\r\n");
      out.write("}\r\n");
      out.write("</style>  \r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write(" \t<form method=\"post\" action=\"Servlet_Upload\" enctype=\"multipart/form-data\" id=\"lomake\">\r\n");
      out.write("        <label>Valitse photo:</label><input type=\"file\" name=\"uploadFile\" id=\"upLoadFile\"/><br>\r\n");
      out.write("        <label>(png/jpg/gif) </label><input class=\"nappi\" type=\"button\" value=\" Tallenna \" onclick=\"lataa()\" />        \r\n");
      out.write("    </form><br>\r\n");
      out.write("    <img src=\"images/spinner.gif\" id=\"spinner\">\r\n");
      out.write("    \r\n");
      out.write("    <ol id=\"sortable\">\r\n");
      out.write("    ");

	session.setAttribute("link_id", request.getParameter("link_id"));	
	if(request.getAttribute("photos")!=null){
		String polku = "images/uploaded/";
		ArrayList<String> linkpics=(ArrayList<String>)request.getAttribute("photos");	
		String photo="";				
		for(int i=0; i<linkpics.size();i++){
			photo = linkpics.get(i).replace("link_" + request.getParameter("link_id"),"");
			out.print("<li class='ui-state-default'><img title='"+photo+"' id='photo_"+photo+"' class='pikkuphotos' src='"+polku+photo+"'><img class='deletephoto' id='"+photo+"' src='images/delete.png'></li>");
		}	
	}
	
      out.write("\r\n");
      out.write("\t</ol>  \r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("\tfunction lataa(){\t\r\n");
      out.write("\t\tvar paatteet = [\"png\", \"jpg\", \"gif\"]; \r\n");
      out.write("\t\tvar paate = document.getElementById(\"upLoadFile\").value.split(\".\")[1];\r\n");
      out.write("\t\tvar kelvollinen = 0;\r\n");
      out.write("\t\tfor(var i=0;i<paatteet.length;i++){\r\n");
      out.write("\t\t\tif(paatteet[i]==paate.toLowerCase()){\r\n");
      out.write("\t\t\t\tkelvollinen=1;\r\n");
      out.write("\t\t\t\tbreak;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\t\t\r\n");
      out.write("\t\tif(kelvollinen==1&&document.getElementById(\"upLoadFile\").value.length>0){\r\n");
      out.write("\t\t\tdocument.getElementById(\"lomake\").submit();\r\n");
      out.write("\t\t\t$(\"#spinner\").show();\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t$(document).ready(function(){\t\r\n");
      out.write("\t\t$(\"#sortable\").sortable({\r\n");
      out.write("\t\t\t stop: function(event, ui) {\r\n");
      out.write("\t\t\t\t \tvar photoJarjestys = \"\";\r\n");
      out.write("\t\t\t        $(\"#sortable li img\").each(function(i, el){\t\t\t           \r\n");
      out.write("\t\t\t            var photo = $(el).attr(\"title\");\t\t\t            \t\t\t\t\r\n");
      out.write("\t\t\t            if(photo!=null){\r\n");
      out.write("\t\t\t            \tphoto=\"link_");
out.print(request.getParameter("link_id"));
      out.write("\" + photo;\t\t\t\r\n");
      out.write("\t\t\t            \tphotoJarjestys+=photo+\";\";\r\n");
      out.write("\t\t\t            }\t\t\t        \t\r\n");
      out.write("\t\t\t        });\t\r\n");
      out.write("\t\t\t        console.log(photoJarjestys);\r\n");
      out.write("\t\t\t        $.ajax({url: \"Servlet_OrderPhotos?photos=\"+photoJarjestys, success: function(result){}});\r\n");
      out.write("\t\t\t    }\t\t\t\r\n");
      out.write("\t\t});   \r\n");
      out.write("\t\t$(\"#spinner\").hide();\r\n");
      out.write("\t\t$(\"#spinner\").css({\r\n");
      out.write("\t\t\t\"position\": \"absolute\",\r\n");
      out.write("\t\t\t\"left\": \"100px\",\r\n");
      out.write("\t\t\t\"top\": \"50px\"\r\n");
      out.write("\t\t});\t\r\n");
      out.write("\t\t$(\".pikkuphotos\").css({\r\n");
      out.write("\t\t\t\"height\": \"100px\",\r\n");
      out.write("\t\t\t\"border\": \"1px solid black\"\r\n");
      out.write("\t\t});\t\r\n");
      out.write("\t\t$(\".deletephoto\").css({\r\n");
      out.write("\t\t\t\"height\": \"30px\"\t\t\t\r\n");
      out.write("\t\t});\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$(\".deletephoto\").click(function(){\t\r\n");
      out.write("\t\t\tvar deletable = \"link_");
out.print(request.getParameter("link_id"));
      out.write("\"+this.id;\r\n");
      out.write("\t\t\tvar r = confirm(\"Delete photo \" + this.id + \"?\");\r\n");
      out.write("\t\t\tif (r == true) {\r\n");
      out.write("\t\t\t\t$(\"#spinner\").show();\r\n");
      out.write("\t\t\t\t$.ajax({url: \"Servlet_DeletePhoto?photo_id=\"+deletable, success: function(result){\r\n");
      out.write("\t\t\t\t\t document.location=\"Servlet_GetPhotos?link_id=");
out.print(request.getParameter("link_id"));
      out.write("\";\r\n");
      out.write("\t\t\t\t}});\r\n");
      out.write("\t\t\t}\t\t\t \r\n");
      out.write("\t\t});\t\t\r\n");
      out.write("\t});\r\n");
      out.write("</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");

if(request.getAttribute("message")!=null){	
	response.sendRedirect("Servlet_GetPhotos?link_id=" + request.getParameter("link_id"));
	Thread.sleep(5000);//odotetaan 5 sekuntia, jotta photo ehtii latautua
}

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
