


<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html lang="en">
<head>
<meta charset="utf-8">
<title>CanceReco - Welcome! </title>


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
	 alert('inside Login page');
	   var email = $('#email').val();
	   var password = $('#password').val();
	 
	 alert('Username : '+email);
	   
		$.ajax({
			url : "rest/MainController/login",
		    type: "POST",
		    data : "email=" + email + "&password=" + password,
		   
		    success:function(data, textStatus, jqXHR){
		    	alert('login success');
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
	

	<div id="container" style="margin: 0px 0px 70px 0px; min-height: 600px !important; overflow-y:hidden;">
	    <div class="hero-unit" style="padding: 0px; font-size: 35px; color: #fff; text-shadow: 0 1px 1px rgba(0,0,0,.9);">
			
			<div style="width: auto; line-height: 40px; top: 6em; left: 6em; position: absolute; z-index: 10; margin: 0px 0px 0px 40px;">
				<p style="font-size: 45px;"><span style="color: green;">Welcome to</span> <span style="color: green;">CanceReco!<span style="color:red"></span></span></p>
				<p style="font-size: 25px;">Recommendations regarding Cancer</p>
			</div>
		</div>
		
	</div>
	<%@include file="/footer.jsp" %>
</body>
</html>




