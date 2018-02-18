<%@include file="header.jsp" %>
<%@ page import="java.util.ArrayList"%> 
<%@ page import="model.Link"%> 
<%! @SuppressWarnings("unchecked") %> 
<label>Look for a link:</label>
<input type="text" id="keyword">
<input type="button" value="Search" id="getBtn"><br>

<%
if(request.getAttribute("links")!=null){
	ArrayList<Link> links= (ArrayList<Link>)request.getAttribute("links");
	for(int i=0;i<links.size();i++){
		out.print(links.get(i) + "<br>");
	}
}
%>


</body>

<script>
	$(document).ready(function(){
		$("#getBtn").click(function(){
			document.location="Servlet_GetLinks?keyword=" + $("#keyword").val();		
		});
	});
</script>

</html>