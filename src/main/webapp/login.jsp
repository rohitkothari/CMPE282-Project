


<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html lang="en">
<head>
<meta charset="utf-8">
<title>CanceReco! - Login</title>


<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="bootstrap/bootstrap.min.css" rel="stylesheet" media="screen"
	type="text/css">
<link href="bootstrap/bootstrap.css" rel="stylesheet" media="screen"
	type="text/css">
<link href="bootstrap/bootstrap-responsive.css" rel="stylesheet"
	media="screen" type="text/css">
<link href="bootstrap/bootstrap-responsive.min.css" rel="stylesheet"
	media="screen" type="text/css">
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript" src="jsbootstrap/bootstrap.js" /></script>
<script type="text/javascript" src="jsbootstrap/bootstrap.min.js" /></script>
<script type="text/javascript" src="jsbootstrap/bootstrap-dropdown.js" /></script>
<script type="text/javascript" src="jsbootstrap/bootstrap-alert.js" /></script>
<script type="text/javascript" src="jsbootstrap/bootstrap-button.js" /></script>
<script type="text/javascript" src="jsbootstrap/bootstrap-carousel.js" /></script>
<script type="text/javascript" src="jsbootstrap/bootstrap-scrollspy.js" /></script>
<script type="text/javascript" src="jsbootstrap/bootstrap-modal.js" /></script>


<script type="text/javascript">

function userLogin(){
	 //alert('inside Login page');
	   var email = $('#email').val();
	   var password = $('#password').val();
	 
	 //alert('Username : '+email);
	   
		$.ajax({
			url : "rest/MainController/login",
		    type: "POST",
		    data : "email=" + email + "&password=" + password,
		   
		    success:function(data, textStatus, jqXHR){
		    	//alert('login success');
		    	window.location.href="home.jsp";
		    },
		    error: function(jqXHR, textStatus, errorThrown){
		    	alert('Could not process request.. ' + errorThrown);
		    }
		});
}
function EmailVerify() {
    var email = document.getElementById('email').value;
    var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
    var message = document.getElementById('emailMessage');
    var badColor = "red";
    message.style.color = badColor;

    if (!filter.test(email)) {   
       $('#emailMessage').html("Please Enter valid Email");
       return false;
    }else{
       $('#emailMessage').html("");
       $.get('/check_email?email=' + email, function(data){
            if(data == "true")
                $('#emailMessage').html("Email already exists");
       });
    }
    return true;
}

</script>
</head>

<body>
	<%@include file="/header.jsp" %>
	

	<div id="container" style="padding-top: 40px;" align="center">
		<div class="container-fluid">
			<div id="loginOptions" style="margin: 80px 0px 0px 40px;">
				<div></div>
				<div class="span5" style="margin-right: 350px; margin-left: 300px;">
					<div
						style="background-color: ghostwhite; -webkit-box-shadow: 3px 0px 5px #888888; -moz-box-shadow: 3px 0px 5px #888888; box-shadow: 3px 0px 5px #888888; padding: 30px;">
						<h3>Sign In</h3>
						<table>
							<tr>
								<td><label for="inputEmail3" class="col-sm-2 control-label">Email</label></td>
								<td><div class="col-sm-50">
										<input type="email" class="form-control" id="email"
											placeholder="Your registered email"  onChange="EmailVerify();">
									</div></td>
							</tr>
							<tr>
								<td><label for="inputPassword3" class="col-sm-2 control-label">Password</label></td>
								<td><div class="col-sm-50"> <input type="password" class="form-control" id="password"
											placeholder="Password">
									</div></td>
							</tr>
							<tr></tr>
							
							<tr>
								<td></td>
								<td><div class="col-sm-offset-0 col-sm-10">
										<button type="submit" class="btn btn-primary" style= "margin-left:45px" id="login"  onclick="userLogin()">Login</button>
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




