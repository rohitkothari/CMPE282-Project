<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>CanceReco! - My Profile</title>

<%@include file="/includes.jsp"%>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
    $('#example').dataTable( {
    	"sDom": "<'row'<'offset1 span4 'l><'offset3 span4'f>r>t<'row'<'offset1 span4'i><'offset3 span4'p >>"
    	//,"sPaginationType": "bootstrap"
    });
} );
</script>
<script>
$.extend( $.fn.dataTableExt.oStdClasses, {
    "sWrapper": "dataTables_wrapper form-inline"
} );

</script>



<style type="text/css">
#sidebar-list {
	font-size: 14px;
}
</style>
</head>
<body>

	<%@include file="/header.jsp"%>

	<div id="container" style="padding: 50px 0px 70px 0px;">
		<%
			if (session.getAttribute("username") == null) {
		%>
		<div class="container-fluid">
			<div class="row-fluid">
				<p>
					Please <a href="login.htm">login</a> to view this page.
				</p>
			</div>
		</div>
		<%
			} else {
		%>
		<div class="container-fluid">
			<div class="row-fluid">
				<div id="sidebar" class="span2" style="margin: 35px 10px 0px 20px; padding: 20px 1100px 50px 0px; background-color: ghostwhite;">
					<!--Sidebar content-->
					<ul id="sidebar-list" class="nav nav-list">
						<li class="nav-header" style="font-size: 15px;"><span style="color: #428bca;"><h4>User Menu</h4></span></li>
						<li class="active" style="font-size: 15px;"><a href="#ViewMyProjects"
							data-toggle="tab">Show Profile</a></li>
						<li style="font-size: 15px;"><a href="#PostNewProject" data-toggle="tab">Show Recommendations</a></li>
						
					</ul>
				</div>
				<div>
					<div class="tab-content">
						<div class="tab-pane" id="PostNewProject" align="center">
							
							<h3>Your Recommendations!</h3> 
							<table cellpadding="5px">
							<!--Body content-->
							
								<td><h5>Recommendation 1: </h5></td>
								<td></td>
								<td><span><c:out value="${reco1}"></c:out></span></td>
								<%-- <td><span>${project.title}</span></td> --%>
							</tr>
							<tr></tr>
							<tr>
							<%
								if (session.getAttribute("test") == null) {}
							%>
								<td><h5>Recommendation 2</h5></td>
								<td></td>
								<td><span></span></td>
								<%-- <td><span>${project.description}</span></td> --%>
							</tr>
							<tr></tr>
							<tr>
								<td><h5>Recommendation 3</h5></td>
								<td></td>
								<td><span></span></td>
								<%-- <td><span>${project.domain}</span></td> --%>
							</tr>
							<tr></tr>
							<tr>
								<td><h5>Recommendation 4</h5></td>
								<td></td>
								<td><span>Try 4</span></td>
								<%-- <td><span>${project.developerName}</span></td> --%>
							</tr>

							<tr></tr>
							<tr>
								<td><h5>Recommendation 5</h5></td>
								<td></td>
								<td><span>Try 5</span></td>
								<%-- <td><span>${project.testerName}</span></td> --%>
							</tr>
							
							<tr></tr>
							
						</table>

						</div>
						<div class="tab-pane active" id="ViewMyProjects" align="center">
							
							<table>
						
							<tr>
								<td><h4>Username:</h4></td>
								<td></td>
								<td><span style="margin-left: 10px;"> <c:out value="${username}"></c:out></span></td>
							</tr>
							<tr></tr>
							<tr>
								<td><h4>First Name:</h4></td>
								<td></td>
								<td><span style="margin-left: 10px;"> <c:out value="${firstname}"></c:out></span></td>
							</tr>
							<tr></tr>
							<tr>
								<td><h4>Last Name:</h4></td>
								<td></td>
								<td><span style="margin-left: 10px;"> <c:out value="${lastname}"></c:out></span></td>
							</tr>
							<tr></tr>
														
							<tr>
								<td><h4>Address:</h4></td>
								<td></td>
								<td><span style="margin-left: 10px;"> <c:out value="${address}"></c:out></span></td>
							</tr>
							<tr></tr>
							<tr>
								<td><h4>Pin:</h4></td>
								<td></td>
								<td><span style="margin-left: 10px;"><c:out value="${pin}"></c:out></span></td>
							</tr>
							<tr></tr>
							<tr>
								<td><h4>Mobile:</h4></td>
								<td></td>
								<td><span style="margin-left: 10px;"><c:out value="${mobile}"></c:out></span></td>
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
				</div>
			</div>
		</div>
		<%
			}
		%>
	</div>

	<%@include file="/footer.jsp"%>
</body>
</html>
