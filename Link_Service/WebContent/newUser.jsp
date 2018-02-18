<%@include file="header.jsp" %>
<%@ page import="java.util.*"%>  
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<div id="container">
	<br><br>
	<legend>New User</legend>
	<br>
	<form action="Servlet_NewUser" method="post" id="newUserForm">
		<label>Firstname:</label>
		<input type="text" name="fistname" id="fistname" value="" size="40"><br>	
		<label>Lastname</label>
		<input type="text" name="lastname" id="lastname" value="" size="40"><br>	
		<label>Email</label>
		<input type="text" name="email" id="email" value="" size="40"><br>
<!-- 
	<label>Username</label>
	<input type="text" name="username" id="username" value="" size="40"><br>
 -->		
		
		<label>Password</label>
		<input type="password" name="password" id="password" value=""><br>
		<label>Password again</label>
		<input type="password" name="password2" id="password2" value=""><br>
		<label></label>	
		<br><br>
		<input type="submit" class="indexbutton" value="Register" id="RegisterBtn" ><br>
		<%
			if(request.getParameter("ok")!=null){
				if(request.getParameter("ok").equals("1")){
					out.print("New User have been added.");	
				}else if(request.getParameter("ok").equals("0")){
					out.print("Adding the customer was not succesful.");	
				}
			}
		%>
	</form>


<script>
	$(document).ready(function(){
		
		$("#customerDetails").css({
			"width": "1000px", 
			"border-radius": "50px"
		});	
		
		$("#newUserForm").validate({						
			rules: {
				fistname:  {
					required: true,
					minlength: 2				
				},	
				lastname:  {
					required: true,
					minlength: 2				
				},			
				email:  {
					required: true,
					email: true			
				},
				username:  {				
					required: true,
					minlength: 2				
				},
				password:  {
					required: true,
					minlength: 5				
				},
				password2:  {
					required: true,
					minlength: 5,
					equalTo: password
				}			
			},
			messages: {
				fistname: {     
					required: "Details missing",
					minlength: "Name is too short"			
				},
				lastname: {
					required: "Details missing",
					minlength: "Name is too short"
				},	
				email: {
					required: "Details missing",
					email: "Not correct form"			
				},
				username:  {	
					required: "Field required",
					minlength: "Too short"				
				},
				password: {
					required: "Details missing",
					minlength: "Password is too short"			
				},
				password2: {
					required: "Details missing",
					minlength: "Password is too short",
					equalTo: "Doesn't equal with password"
				}	
			},
			submitHandler: function (form) {	
		//		alert("moi");
				document.forms["newUserForm"].submit();
			}	
		});   
	});

</script>
</div>
</body>
</html>