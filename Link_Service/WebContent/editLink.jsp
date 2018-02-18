<%@include file="header.jsp" %>
<%@ page import="java.util.*"%> 
<%@ page import="java.text.*"%> 
<%@ page import="java.util.ArrayList"%> 
<%@ page import="model.Link"%> 
<%@ page import="model.Board"%> 
<%@ page import="model.BoardLink"%> 
<%! @SuppressWarnings("unchecked") %> 
<%
Link link= null;
if( request.getAttribute("link")!=null){
	link = (Link)request.getAttribute("link");	
}
%>

<div id="container">
	<fieldset id="linkDetails">
		<legend>Link details:</legend>
<%--	<img src="images/add.png" class="icon_mini" id="addLinkPicture"><br><br>--%> 
		<input type="submit" class="leftbutton" value="Add Picture" id="addLinkPicture" onclick="addLinkPicture();"><br><br><br>
			
<%--**** LIST BOARDS AJAX ****--%> 
	<h4> Linked boards: </h4>
<%
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
%>						
		<form action="Servlet_EditLink" method="post" id="newForm">
			<label>Add board:</label>
				<select name="boardAjax" id="boardAjax"></select><br><br>
			<label>Title:</label>
				<input type="text" name="title" id="title" value="<%out.print(link.getTitle());%>" size="40"><br><br>	
			<label>Link:</label>
				<input type="text" name="link" id="link" value="<%out.print(link.getLink());%>" size="40"><br><br>	
			<label>Details:</label>	
				<textarea rows="10" cols="30" name="details" id="details"><%out.print(link.getDetails());%></textarea><br><br>
			<label></label>
				<input type="submit" value="Save" id="addBtn"><br>
<%
if(request.getParameter("ok")!=null){
	if(request.getParameter("ok").equals("1")){
		out.print("New link has been added.");	
	}else if(request.getParameter("ok").equals("0")){
		out.print("Addig was unsuccesful.");	
	}
}
%>
			
			<input type="hidden" name="link_id" value="<%out.print(link.getLink_id());%>">	
		</form>
	</fieldset>


	<%--**** DELETE CONFIRMATION ****--%>
	<div id="deleteConfirmationationation">
		<span id="deletableName"></span>
		<img src="images/accept.png" title="Delete" class="icon" id="confirmDelete">
		<img src="images/delete.png" title="Cancel" class="icon" id="cancelDelete">
	</div>

<script>
$(document).ready(function(){
	$("#deleteConfirmationationation").hide();
	
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

//	AJAX SEARCH FOR BOARDS
	$("#boardAjax").append("<option value='-1'>Select board</option>");  
	$.getJSON("Servlet_BoardsAjax", function(result){
	    $.each(result, function(i, field){
	    	$("#boardAjax").append("<option value='"+field.Board_id+"'>"+field.Board_id+ " "+field.Name+"</option>"); 
	    	
	    });
	});	
});

var deletable_id;	
$(".delete").click(function(event){	//event kantaa mukanaan tapahtuman, mm. klikkauksen sijainnin	
	deletable_id=$(this)[0].id;
	$("#deletableName").html("Delete"+ $(this)[0].title + "?<br>");
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
	document.location="Servlet_DeleteBoardlink?boardlink_id="+deletable_id+"&link_id=<%out.print(link.getLink_id());%>";
});

$("#cancelDelete").click(function(){
	$("#deleteConfirmationationation").hide();
});

function addLinkPicture(){
	window.open('Servlet_GetPhotos?link_id=' + <%out.print(link.getLink_id());%> ,null, 'toolbar=no,status=no,width=400,height=600,left=150,top=100,scrollbars=yes')
}

//$("#addLinkPicture").click(function(event){
//	window.open('Servlet_GetPhotos?link_id=' + <%out.print(link.getLink_id());%> ,null, 'toolbar=no,status=no,width=400,height=600,left=150,top=100,scrollbars=yes')
//
//});

</script>
</div>
<br><br>
</body>
</html>