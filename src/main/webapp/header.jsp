<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<!-- Latest compiled and minified CSS -->
<!-- <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css"> -->

<!-- Optional theme -->
<!-- <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css"> -->

<!-- Latest compiled and minified JavaScript -->
<!-- <script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script> -->

<%@include file="includes.jsp"%>

<div id="header">
	<div class="navbar navbar-inverse navbar-static-top">
		<div id="headerNav" class="navbar-inner">
			<a class="brand" href="index.jsp"><span style="color: green; margin: 0px 10px 0px 10px; font-size:60px ;">CanceReco!<span style="color: red;"></span></span></a>
			<% if(session.getAttribute("user") != null) { %>
			<ul class="nav">
				<li><a href="/project-vars/viewProjects.htm" style="color: white;"><h1>View Projects</h1></a></li>
			</ul>
			<% } %>
			<% if(session.getAttribute("username") == null) { %>
			<ul id="loginMenu" class="nav" style=" float:right;">
				<li><a href="login.jsp" style="color: white;">Login</a></li>
				<li><a href="signup.jsp" style="color: white;">Sign Up</a></li>
			</ul>
			
			<% } else { %>
			<ul id="loggedInMenu" class="nav" style=" float:right; padding-right: 35px;">
				<li class="dropdown" id="loggedInDown">
					 <%-- <c:choose>
					   <c:when test="${user.isAdmin}">
					    	<a class="dropdown-toggle" data-toggle="dropdown" href="#loggedInDown" style="color: white;">Hello ${user.firstName} <span class="caret"></span></a>
					    </c:when>
	 					<c:otherwise> --%>
	 						<a class="dropdown-toggle" data-toggle="dropdown" href="#loggedInDown" style="color: white;">Hello ${username} <span class="caret"></span></a>
	 					<%--  </c:otherwise> 
 					</c:choose> --%>
					
					<ul class="dropdown-menu">
				      <li><a href="NewProfile.jsp">Profile</a></li>
				      <li><a href="/cmpe282-project/rest/MainController/logout">Logout</a></li>
				    </ul>
			    </li>
			</ul>
			<% } %>
			
			<%-- <% } else { %>
			<ul id="loggedInMenu" class="nav" style=" float:right; padding-right: 35px;">
				<li class="dropdown" id="loggedInDown">
					 <c:choose>
					   <c:when test="${user.isAdmin}">
					    	<a class="dropdown-toggle" data-toggle="dropdown" href="#loggedInDown" style="color: white;">Hello ${user.firstName} <span class="caret"></span></a>
					    </c:when>
	 					<c:otherwise>
	 						<a class="dropdown-toggle" data-toggle="dropdown" href="#loggedInDown" style="color: white;">Hello ${username} <span class="caret"></span></a>
	 					 </c:otherwise> 
 					</c:choose>
					
					<ul class="dropdown-menu">
				      <li><a href="Profile.jsp">Profile</a></li>
				      <li><a href="signout.jsp">Logout</a></li>
				    </ul>
			    </li>
			</ul>
			<% } %> --%>
		</div>
	</div>
</div>
