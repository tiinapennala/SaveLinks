<%@include file="header.jsp" %>
<%@ page import="java.util.ArrayList"%> 
<%@ page import="model.Link"%> 
<%! @SuppressWarnings("unchecked") %> 

<fieldset id="customerDetails">
<legend>New User</legend>

	<form action="Servlet_UusiAsiakas" method="post" id="newForm">
		<label>Firstname </label>
		<input type="text" name="fistname" id="fistname"><br>
		<label>Lastname</label>
		<input type="text" name="lastname" id="lastname"><br>
		<label>Email</label>
		<input type="text" name="email" id="email"><br>
		<label>Username</label>
		<input type="text" name="username" id="username"><br>
		<label>Password</label>
		<input type="text" name="password" id="password"><br>
		<label>Password again</label>
		<input type="text" name="password2" id="password2"><br>
		<input type="button" value="Register" id="RegisterBtn"><br>
	</form>
</fieldset>

<script>
	$(document).ready(function(){
		
		$("#customerDetails").css({
			"width": "500px", 
			"border-radius": "15px"
		});	
		
		$("#newForm").validate({						
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
					equalTo: salasana
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
			}
			//"}," olisiko pitänyt olla näin?
		});   
	});

</script>

</body>
</html>