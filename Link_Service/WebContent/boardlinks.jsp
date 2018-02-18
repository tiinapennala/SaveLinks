<%@include file="header.jsp" %>
<%@ page import="java.util.ArrayList"%> 
<%@ page import="model.Link"%> 
<%@ page import="model.Board"%> 
<%! @SuppressWarnings("unchecked") %> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<div id="container">
<%
Board board = null;
if(request.getAttribute("board")!=null){
	board = (Board)request.getAttribute("board");	
}
%>
	<br><br>
	<a class="button" href="#popup_NewLink">New Link</a>
	<br>
	<div id="otsikko_1">
	<%out.print("<h2>" + board.getName() + board.getBoard_id() +"</h2>" );%>
	</div>
	<br><br>
	

<%--**** LIST ALL LINKS THAT ARE IN THE BOARD****--%> 
<%
	if(request.getAttribute("boardlinks")!=null){	
				ArrayList<Link> links = (ArrayList<Link>)request.getAttribute("links");				
				if(request.getAttribute("links")!=null){					
					for(int i=0;i<links.size();i++){
						out.print("<div class='gallery'>");
						out.print("<li>");
						// <img src="">
						out.print("<img class='galeryimg' src='images/no_image.png' >");
//						out.print("<h3>"+links.get(i).getTitle() + links.get(i).getLink_id() +"</h3>");
						out.print("<h3>"+links.get(i).getTitle() +"</h3>");
						out.print("\n<img src='images/delete1.png' class='icon delete' id='delete_"+links.get(i).getLink_id()+"' name='"+links.get(i).getTitle()+"' title='Delete'>");
						out.print("\n<img src='images/edit3.png' class='icon edit' id='edit_"+links.get(i).getLink_id()+"' name='"+links.get(i).getTitle()+"' title='Edit'>");
						out.print("<a href='"+links.get(i).getLink()+"' target='_blank'><img src='images/web.png' class='icon web'/>"+"</a>");
//						out.print("<p>"+links.get(i).getLink()+"</p>");
						out.print("<p>"+links.get(i).getDetails()+"</p>");
						out.print("\n</br>");
						out.print("</li>");
						out.print("</div>");
					}	
				}		
	}
%>

	<%--**** NEW LINK/ADD LINK POPUP ****--%> 
	<div id="popup_NewLink" class="overlay">
		<div class="popup">
			<a class="close" href="#">&times;</a>
			<div class="content">
				<fieldset id="linkDetails">
					<legend>New link:</legend>
					<form action="Servlet_NewLink" method="post" id="newForm">
						<label>Board:</label>
							<select name="boardAjax" id="boardAjax"></select><br><br>
						<label>Title:</label>
							<input type="text" name="title" id="title" value="" size="70"><br><br>
						<label>Link:</label>
							<input type="text" name="link" id="link" value="" size="70"><br><br>	
						<label>Details:</label>	
							<textarea rows="8" cols="70" name="details" id="details"></textarea><br><br>
						<label></label>	
						<input type="submit" value="Save" id="addBtn">				
<%
	if(request.getParameter("ok")!=null){
		if(request.getParameter("ok").equals("1")){
			out.print("New link has been added.");	
		}else if(request.getParameter("ok").equals("0")){
			out.print("Addig was unsuccesful.");	
		}
	}
%>
					</form>
				</fieldset>
			</div>
		</div>
	</div>
	
</div>
<script>
	$(document).ready(function(){
			$("#poistonVahvistus").hide();
		});

		
		$(".edit").click(function(){	
			document.location="Servlet_EditLink?Link_id=" + $(this)[0].id;	
		});
		
		var poistettava_id;	
		$(".delete").click(function(event){	//event kantaa mukanaan tapahtuman, mm. klikkauksen sijainnin	
			poistettava_id=$(this)[0].id;
			$("#poistettavaNimi").html("Poista " + $(this)[0].title + "?<br>");
			$("#poistonVahvistus").css({ 
				"width": "170px", 
				"height": "50px",
				"background-color": "#4CAF50",
				"border-radius": "15px",
				"color": "white",
				"text-align": "center",
				"padding": "10px",
				"border": "1px solid black",
				"position": "absolute",
				"left": event.pageX +"px",
				"top": event.pageY +"px"
			});			
			$("#poistonVahvistus").show();
		});
		
		$("#vahvistaPoisto").click(function(){
			document.location="Servlet_DeleteLink?Link_id="+poistettava_id;
		});
		
		$("#peruutaPoisto").click(function(){
			$("#poistonVahvistus").hide();
		});
		
		$("#boardAjax").append("<option value='-1'>Select board</option>");  
		$.getJSON("Servlet_BoardsAjax", function(result){
		    $.each(result, function(i, field){
		    	$("#boardAjax").append("<option value='"+field.Board_id+"'>"+field.Name+"</option>");            
		    });
		});
		
</script>
<br>
<br>
</body>
</html>