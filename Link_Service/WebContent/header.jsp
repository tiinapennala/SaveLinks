<%
if(session.getAttribute("savePath")==null){
	String savePath ="C:/xxx/Link_Service/Link_Service/WebContent/images/uploaded";
	session.setAttribute("savePath", savePath);		
}
if(!request.getRequestURI().equals("/Link_Service/index.jsp")){ 	//jos kutsutaan jotakin muuta kuin index.jsp -sivua
	if(session.getAttribute("SignIn_name")==null){			//ja kirjautumista ei ole tapahtunut
		//response.sendRedirect("index.jsp");
	}
}
%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.15.0/jquery.validate.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link rel="stylesheet" href="/Link_Service/style.css" type="text/css" >
<title>BLink</title>
</head>
<body>
	<div id="header-wrapper">
		  <div id="header" class="containerheader">
		   <div id="logo">
				<h1><a href="#">BLink</a></h1>
			</div>
			<div id="menu">
				<ul>
					<li>
						<div id="signInSuccessful">
							User: <%out.print(session.getAttribute("SignIn_name"));%><br>
							<a style="float:right; font-size: 10px; padding: 2px; color:#ababab;" href="Servlet_SignIn?out=1">Log out</a>
						</div>
					</li>
					<li><a class="menu active" id="boardIcon" onclick="document.location='boards.jsp'">Boards</a></li>
					<li><a class="menu active" id="linkIcon" onclick="document.location='mainview.jsp'">Links</a></li>
				</ul>
			</div>
		 </div>
		<%--  
		 <a class="button" href="#popup_NewLink">New Link</a>	
		--%>
		
	</div>

<%
if(session.getAttribute("SignIn_name")==null){		
	out.println("<script>");
	out.println("$('#signInSuccessful').hide();");
	out.println("$('#boardIcon').hide();");
	out.println("$('#linkIcon').hide();");	
	out.println("</script>");	
}
%>
	