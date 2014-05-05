<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Health Recommendation</title>
<%@include file="includes.jsp"%>
</head>
<body style="background-color: grey;">
<%@include file="header.jsp"%>


		<%
			if (session.getAttribute("username") != null) {
		%>
		
		
		<div id="container" style="margin: 0px 0px 70px 0px; min-height: 600px !important; overflow-y:hidden;">
	    <div class="hero-unit" style="padding: 0px; font-size: 35px; color: #fff; text-shadow: 0 1px 1px rgba(0,0,0,.9);">
			
			<div style="width: auto; line-height: 40px; top: 6em; left: 6em; position: absolute; z-index: 10; margin: 0px 0px 0px 40px;">
				<p style="font-size: 30px;"><span style="color: green;">Why don't you try our recommedations?</span></p>
				<form action ="survey.jsp" method= "GET">
					<input type = "Submit" class="btn btn-primary" Value = "Click me for Survey"/>
				</form>
				<form action ="/cmpe282-project/rest/MainController/profile" method= "GET">
					<input type = "Submit" class="btn btn-primary" Value = "Profile"/>
				</form>
				<p style="font-size: 15px;">*Recommendations regarding Cancer</p>
			</div>
		</div>
		
	</div>
		
		
<%-- <p style=" color: black">We provide recommendations regarding Diabetes based on your answers for our questionnaire. </p>
	Helloo <c:out value='${sessionScope.username}'/>
<p style=" color: black"> Please click on the link to navigate </p> --%>

<!-- <form action="rest/MainController/user/profile" method="GET">
        <input type="submit" value="Show My Profile" />
    </form>
<form action ="survey.jsp" method= "GET">
<input type = "Submit" Value = "Take a Survey"/>
</form>  -->   
		<%
			} 
		%>
<%@include file="footer.jsp" %>

		
</body>
</html>