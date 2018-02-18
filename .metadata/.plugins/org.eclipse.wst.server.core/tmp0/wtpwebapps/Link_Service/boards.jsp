<%@include file="header.jsp" %>
<%@ page import="java.util.ArrayList"%> 
<%@ page import="model.Board"%> 
<%! @SuppressWarnings("unchecked") %> 

<div id="container"> 
	<br><br>	 
	<h2> Boards </h2>
	<br><br>
	<input type="text" name="Search" placeholder="  Search board..." id="keyword">
	<input type="button" class="searchbutton" value="Search" id="getBoard">
	<a class="button" href="#popup_NewBoard" class="add_icon" title="New board">New Board</a>	


<%--**** LIST ALL BOARDS ****--%> 
<%
if(request.getAttribute("boards")!=null){
	ArrayList<Board> boards = (ArrayList<Board>)request.getAttribute("boards");
	
	for(int i=0;i<boards.size();i++){
		out.print("<div class='gallery'>");
			out.print("<li>");
				out.print("<img class='galeryimg' src='images/folder2.png' >");
				out.print("<h3>"+boards.get(i).getName() +"</h3>");
				out.print("\n<img src='images/delete1.png' class='icon delete' id='delete_"+boards.get(i).getBoard_id()+"' name='"+boards.get(i).getName()+"' title='Delete'>");
				out.print("\n<img src='images/forward1.png' class='icon showLinks' id='boardlinks_"+boards.get(i).getBoard_id()+"' name='"+boards.get(i).getName()+"' title='Edit'>");
				out.print("\n</br>");
			out.print("</li>");
		out.print("</div>");
	}
}
%>

	<%--**** NEW BOARD/ADD BOARD POPUP ****--%> 
	<div id="popup_NewBoard" class="overlay">
		<div class="popup">
			<a class="close" href="#">&times;</a>
			<div class="content">
				<fieldset id="linkDetails">
					<legend>New board:</legend>
					<form action="Servlet_NewBoard" method="post" id="newForm">
						<label>Name of the board:</label>
							<input type="text" name="name" id="name" value="" size="70"><br>	
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
	
	<br><br>
</div>
</body>

<script>
	$(document).ready(function(){
		$("#deleteConfirmationationation").hide();
		
		$("#getBoard").click(function(){
			document.location="Servlet_GetBoards?keyword=" + $("#keyword").val();	
		console.log("moi")
		});
		
		$(".showLinks").click(function(){						
			document.location="Servlet_BoardLinks?Board_id=" + $(this)[0].id;	
		});
		
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
		document.location="Servlet_DeleteBoard?Board_id="+deletable_id;
	});
	
	$("#cancelDelete").click(function(){
		$("#deleteConfirmationationation").hide();
	});
	
</script>

</html>