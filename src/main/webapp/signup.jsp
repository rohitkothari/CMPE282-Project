<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>DiaB-Reco! - Register</title>

<%@include file="includes.jsp" %>

<script src="//code.jquery.com/jquery-1.9.1.js"></script>
<script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.8/jquery.validate.min.js"></script>
<script type="text/javascript"> $(document).ready(function(){ $("#subForm").validate(); }); </script>
<script src="http://jquery.bassistance.de/validate/additional-methods.js"></script>
<script type="text/javascript">



function checkPasswordMatch(){
//var checkPasswordMatch = function() {
    var password = $("#passwordInput").val();
    var rePassword = $("#reEnterPasswordInput").val();
	
    if (password != rePassword)
        $("#divCheckPasswordMatch").html("Passwords do not match!");
    else{
        $("#divCheckPasswordMatch").html("");  
    }
}

$(document).ready(function () {
	
	$("#reEnterPasswordInput").keyup(checkPasswordMatch());
   
   $('#signup').click(function(event) {
	   
	   var fname = $('#firstNameInput').val();
	   var lname = $('#lastNameInput').val();
	   var email = $('#emailInput').val();
	   var password = $('#passwordInput').val();
	   var address = $('#addressInput').val();
	   var pin = $('#pinInput').val();
	   var mobile = $('#mobileInput').val();
	   
		$.ajax({
			url : "rest/MainController/signup",
		    type: "POST",
		    data : "firstName=" + fname + "&lastName=" + lname + "&email=" + email + "&password=" + password + "&address=" + address + "&pin=" + pin + "&mobile=" + mobile,
		    success:function(data, textStatus, jqXHR){
		    	window.location.href="home.jsp";
		    },
		    error: function(jqXHR, textStatus, errorThrown){
		    	alert("Could not process request.. " + errorThrown);
		    }
		});
   });
});

</script>
<%@include file="header.jsp"%>
</head>
<body bgcolor = "PowderBlue">
	
	<div id="container" align="center" style="padding-top: 40px;">
		<div class="container-fluid">
			<div class="row-fluid">
				<!-- <div id="sidebar" class="span2">
						Sidebar content
					<ul id="sidebar-list" class="nav nav-list">
					</ul>
				</div> -->
					<div class="tab-content">
						<div class="tab-pane active" id="NewUserSignUp">
								<table cellpadding="5px">
								<!--Body content-->
								<tr>
  									<h2>Create an account here</h2>
								</tr>
								<tr>
									<td><h5>First Name</h5></td>
									<td></td>
									<td><div class="input-group">
											<input type="text" id="firstNameInput" class="required" placeholder="First Name">
										</div></td>
								</tr>
								<tr></tr>
								<tr>
									<td><h5>Last Name</h5></td>
									<td></td>
									<td><div class="input-group">
											<input type="text" id="lastNameInput" class="required" placeholder="Last Name">
										</div></td>
								</tr>
								<tr></tr>
								<tr>
									<td><h5>Email</h5></td>
									<td></td>
									<td><div class="input-group">
											<input type="email" id="emailInput" class="required email" placeholder="Email ID">
										</div></td>
								</tr>
								<tr></tr>
								<tr>
									<td><h5>Password</h5></td>
									<td></td>
									<td><div class="input-group">
											<input type="password" id="passwordInput" name="passwordInput" class="required" placeholder="Password">
										</div></td>
								</tr>
								<tr></tr>
								<tr>
									<td><h5>Re-enter Password</h5></td>
									<td></td>
									<td><div class="input-group">
											<input type="password" id="reEnterPasswordInput" name="reEnterPasswordInput" class="required" placeholder="Re-enter Password" onChange="checkPasswordMatch();">
										</div></td>
									<td><div class="registrationFormAlert" id="divCheckPasswordMatch"></div></td>
								</tr>
								<tr></tr>
								<tr>
									<td><h5>Address</h5></td>
									<td></td>
									<td><div class="input-group">
											<input type="text" id="addressInput" class="required" placeholder="Address">
										</div></td>
								</tr>
								<tr></tr>
								<tr>
									<td><h5>Zip</h5></td>
									<td></td>
									<td><div class="input-group">
											<input type="text" id="pinInput" class="required" placeholder="Zip Code">
										</div></td>
								</tr>
								<tr></tr>
								<tr>
									<td><h5>Mobile</h5></td>
									<td></td>
									<td><div class="input-group">
											<input type="text" id="mobileInput" class="required" placeholder="Mobile">
										</div></td>
								</tr>
								<tr></tr>
								<tr>
									<td></td>
									<td></td>
									<td><div class="col-sm-offset-2 col-sm-10">
									<input type="submit" class="btn btn-default" id="signup" value="Sign Up"/>
								</div></td>
								</tr>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	
<%@include file="footer.jsp" %>


</body>
</html>