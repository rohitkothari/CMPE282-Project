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
<body>
<%@include file="header.jsp"%>


		<%
			if (session.getAttribute("username") != null) {
		%>
<p>We provide recommendations regarding Diabetes based on your answers for our questionnaire. </p>
	Helloo <c:out value='${sessionScope.username}'/>
<p> Please click on the link to navigate </p>

<a href="Profile.jsp" style="color: black;">My Profile</a> 
<a href="survey.jsp" style="color: black;">Survey</a> 
<form action="rest/MainController/user/profile" method="GET">
        <input type="submit" value="Retrive" />
    </form>
		<%
			} 
		%>
</body>
</html>