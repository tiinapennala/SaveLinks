<%@include file="header.jsp" %>
<%@ page import="java.util.ArrayList"%> 
<%@ page import="model.Link"%> 
<%! @SuppressWarnings("unchecked") %> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<div id="container">
	
	<br><br>
<%--<a class="button" href="#popup_NewLink">New Link</a>	--%> 
	<h2> Links </h2>
	<br><br>
	
	<input type="text" name="Search" placeholder="  Search link..." id="keyword">
	<input type="button" class="searchbutton" value="Search" id="getBtn">
	<a class="button" href="#popup_NewLink">New Link</a>
	
	
	<%--**** LIST ALL LINKS ****--%> 
<%
	if(request.getAttribute("links")!=null){	
		ArrayList<Link> links= (ArrayList<Link>)request.getAttribute("links");
		for(int i=0;i<links.size();i++){
			out.print("<div class='gallery'>");
			out.print("<li>");			
			// out.print("<div class='icon edit' id='edit_"+links.get(i).getLink_id()+"' name='"+links.get(i).getTitle()+"'>");					
					out.print("<img class='galeryimg' src='images/no_image.png' >");
					out.print("<h3>"+links.get(i).getTitle() +"</h3>");
					out.print("\n<img src='images/delete1.png' class='icon delete' id='delete_"+links.get(i).getLink_id()+"' name='"+links.get(i).getTitle()+"' title='Delete'>");
					out.print("\n<img src='images/edit4.png' class='icon edit' id='edit_"+links.get(i).getLink_id()+"' name='"+links.get(i).getTitle()+"' title='Edit'>");
					out.print("<a href='"+links.get(i).getLink()+"' target='_blank'><img src='images/web.png' class='icon web'/>"+"</a>");
					//out.print("<h3>"+links.get(i).getTitle() + links.get(i).getLink_id() +"</h3>");
					//out.print("<p>"+links.get(i).getLink()+"</p>");
					out.print("<p>"+links.get(i).getDetails()+"</p>");
					out.print("\n</br>");
			out.print("</li>");
			out.print("</div>");	
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
	
	
<%--**** DELETE CONFIRMATION ****--%>
	<div id="deleteConfirmationationation">
		<span id="deletableName"></span>
		<img src="images/accept.png" title="Delete" class="icon" id="confirmDelete">
		<img src="images/delete.png" title="Cancel" class="icon" id="cancelDelete">
	</div>
	<br>
	<br>
</div>
</body>
	
<script>
	$(document).ready(function(){
			$("#deleteConfirmationationation").hide();
		
			$("#getBtn").click(function(){
				document.location="Servlet_GetLinks?keyword=" + $("#keyword").val();		
			});
			
			$("#linkDetails").css({
				"width": "500px", 
				"border-radius": "15px"
			});	
	
			
			$("#newForm").validate({						
				rules: {	
					link:  {
						required: true,
						minlength: 2				
					}		
				},
				messages: {
					linkUrl: {     
						required: "Required",
						minlength: "Too short"			
					}
				},			
				
				submitHandler: function (form) {	
					document.forms["newForm"].submit();
				}	
			}); 

		});
		
		$("#boardAjax").append("<option value='-1'>Select board</option>");  
		$.getJSON("Servlet_BoardsAjax", function(result){
		    $.each(result, function(i, field){
		    	$("#boardAjax").append("<option value='"+field.Board_id+"'>"+field.Name+"</option>");            
		    });
		});
		
		$(".edit").click(function(){
			//Objektin ominaisuuksien ja arvojen läpikäynti (ei tarvita tässä tapauksessa, vain esimerkkinä)
			/*
			var obj = $(this); 	
			for(var key in obj) {
				console.log('key: ' + key + '\n' + 'value: ' + obj[key]);
			}
			*/		
			document.location="Servlet_EditLink?Link_id=" + $(this)[0].id;	
		});
		
		var deletable_id;	
		$(".delete").click(function(event){	//event kantaa mukanaan tapahtuman, mm. klikkauksen sijainnin	
			deletable_id=$(this)[0].id;
			$("#deletableName").html($(this)[0].title + "?<br>");
			$("#deleteConfirmationationation").css({ 
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
			$("#deleteConfirmationationation").show();
		});
		
		$("#confirmDelete").click(function(){
			document.location="Servlet_DeleteLink?Link_id="+deletable_id;
		});
		
		$("#cancelDelete").click(function(){
			$("#deleteConfirmationationation").hide();
		});	
</script>

</html>