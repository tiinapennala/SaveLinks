<%@ page import="java.util.ArrayList"%> 
<%! @SuppressWarnings("unchecked") %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<title>Insert title here</title>
<style>
label{
    display:inline-block;
    width:100px;
    text-align:right;
    vertical-align:top;
}
.nappi{
	width:80px;
}
</style>  
</head>
<body>
 	<form method="post" action="Servlet_Upload" enctype="multipart/form-data" id="lomake">
        <label>Valitse photo:</label><input type="file" name="uploadFile" id="upLoadFile"/><br>
        <label>(png/jpg/gif) </label><input class="nappi" type="button" value=" Tallenna " onclick="lataa()" />        
    </form><br>
    <img src="images/spinner.gif" id="spinner">
    
    <ol id="sortable">
    <%
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
	%>
	</ol>  

<script>
	function lataa(){	
		var paatteet = ["png", "jpg", "gif"]; 
		var paate = document.getElementById("upLoadFile").value.split(".")[1];
		var kelvollinen = 0;
		for(var i=0;i<paatteet.length;i++){
			if(paatteet[i]==paate.toLowerCase()){
				kelvollinen=1;
				break;
			}
		}		
		if(kelvollinen==1&&document.getElementById("upLoadFile").value.length>0){
			document.getElementById("lomake").submit();
			$("#spinner").show();
		}
	}


	$(document).ready(function(){	
		$("#sortable").sortable({
			 stop: function(event, ui) {
				 	var photoJarjestys = "";
			        $("#sortable li img").each(function(i, el){			           
			            var photo = $(el).attr("title");			            				
			            if(photo!=null){
			            	photo="link_<%out.print(request.getParameter("link_id"));%>" + photo;			
			            	photoJarjestys+=photo+";";
			            }			        	
			        });	
			        console.log(photoJarjestys);
			        $.ajax({url: "Servlet_OrderPhotos?photos="+photoJarjestys, success: function(result){}});
			    }			
		});   
		$("#spinner").hide();
		$("#spinner").css({
			"position": "absolute",
			"left": "100px",
			"top": "50px"
		});	
		$(".pikkuphotos").css({
			"height": "100px",
			"border": "1px solid black"
		});	
		$(".deletephoto").css({
			"height": "30px"			
		});	
		
		$(".deletephoto").click(function(){	
			var deletable = "link_<%out.print(request.getParameter("link_id"));%>"+this.id;
			var r = confirm("Delete photo " + this.id + "?");
			if (r == true) {
				$("#spinner").show();
				$.ajax({url: "Servlet_DeletePhoto?photo_id="+deletable, success: function(result){
					 document.location="Servlet_GetPhotos?link_id=<%out.print(request.getParameter("link_id"));%>";
				}});
			}			 
		});		
	});
</script>
</body>
</html>
<%
if(request.getAttribute("message")!=null){	
	response.sendRedirect("Servlet_GetPhotos?link_id=" + request.getParameter("link_id"));
	Thread.sleep(5000);//odotetaan 5 sekuntia, jotta photo ehtii latautua
}
%>