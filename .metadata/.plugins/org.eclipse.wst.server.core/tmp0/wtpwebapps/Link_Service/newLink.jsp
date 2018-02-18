<%@include file="header.jsp" %>
<%@ page import="java.util.*"%>  
<%@ page import="model.Link"%> 
<%@ page import="java.util.ArrayList"%>  
<%@ page import="java.io.File"%> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
//***BEGINNIN COMES FROM header.jsp ******************************************************************************************************
%>

<%
Link link = null;
%>


<fieldset id="linkDetails">
	<legend>Link details:</legend>
	<form action="Servlet_NewLink" method="post" id="newForm">
		<label>Kuvat:</label>
			<img src="images/add_image.png" class="icon_mini" id="lisaaKuvaVeneeseen"><br><br>
		<label>Title:</label>
			<input type="text" name="title" id="title" value="" size="40"><br>	
		<label>Link:</label>
			<input type="text" name="link" id="link" value="" size="40"><br>	
		<label>Details:</label>	
			<textarea rows="10" cols="30" name="details" id="details"></textarea><br>
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
<script>
$(document).ready(function(){
	
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




</script>
</body>
</html>