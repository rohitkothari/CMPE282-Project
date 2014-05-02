<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My Profile</title>
<%@include file="includes.jsp"%>
</head>
<body>
<%@include file="header.jsp"%>

	<div id="container" style="padding-top: 40px">
	
	<% if(session.getAttribute("user") == null) { %>
		<div class="container-fluid">
			<div class="row-fluid"><p>Please <a href="login.htm">login</a> to view this page.</p></div>
		</div>
	<% } else { %>
	
		<div class="container-fluid">
			<div class="row-fluid">
				<div class="span2"></div>
				<div id="UserProfile" style="margin: 0px 0px 10px 30px;">
				<div><h3>User Profile </h3></div>
				<div class="row-fluid"> 

					<div class="span8">
						<table>
							<tr>
								<td><h5>Username</h5></td>
								<td></td>
								<td><span style="margin-left: 10px;">${user.username}</span></td>
							</tr>
							<tr></tr>
							<tr>
								<td><h5>First Name</h5></td>
								<td></td>
								<td><span style="margin-left: 10px;">${user.firstname}</span></td>
							</tr>
							<tr></tr>
							<tr>
								<td><h5>Last Name</h5></td>
								<td></td>
								<td><span style="margin-left: 10px;">${user.lastname}</span></td>
							</tr>
							<tr></tr>
														
							<tr>
								<td><h5>Address</h5></td>
								<td></td>
								<td><span style="margin-left: 10px;">${user.address}</span></td>
							</tr>
							<tr></tr>
							<tr>
								<td><h5>Pin</h5></td>
								<td></td>
								<td><span style="margin-left: 10px;">${user.pin}</span></td>
							</tr>
							<tr></tr>
							<tr>
								<td><h5>Mobile</h5></td>
								<td></td>
								<td><span style="margin-left: 10px;">${user.mobile}</span></td>
							</tr>
							<tr></tr>
							
							<tr>
								<td></td>
								<td></td>
								<td></td>
							</tr>
						</table>
					</div>
					</div>
			<% } %>
			</div>
			</div>
			</div>
			</div>
	<%@include file="footer.jsp"%>
			
</body>
</html>