<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">

<!-- Latest compiled and minified JavaScript -->
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>

<script type="text/javascript" src="http://platform.linkedin.com/in.js">
  api_key: 75wgepnpou4y46
  authorize: true
  scope: r_emailaddress
  onLoad : onLinkedInLoad
</script>

<div id="header">
	<div class="navbar navbar-inverse navbar-static-top">
		<div id="headerNav" class="navbar-inner">
			<a class="brand" href="/cmpe282-project/"><span style="color: green; margin: 0px 10px 0px 10px;">DiaB-Reco!<span style="color: red;">!</span></span></a>
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
				      <li><a href="/project-vars/showProfile.htm">Profile</a></li>
				      <li><a href="/project-vars/logout.htm">Logout</a></li>
				    </ul>
			    </li>
			</ul>
			<% } %>
		</div>
	</div>
</div>
