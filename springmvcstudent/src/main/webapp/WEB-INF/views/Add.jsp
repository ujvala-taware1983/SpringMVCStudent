<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:include page="NavBar.jsp" />
<%String msg = (String) request.getAttribute("msg"); %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Management</title>
<style type="text/css">
body{
background-image:
		url('https://images.unsplash.com/photo-1472289065668-ce650ac443d2?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8M3x8c2Nob29sJTIwbWFuYWdlbWVudHxlbnwwfHwwfHw%3D&w=1000&q=80');
	background-size: 100%;
}
</style>

</head>
<body>
	<div align="center">
		<form action="./add" method="post">
			<fieldset>
				<legend>Add Student</legend>
				<table>
					<tr>
						<td>Name</td>
						<td><input type="text" name="name"></td>
					</tr>
					<tr>
						<td>Contact</td>
						<td><input type="text" name="contact"></td>
					</tr>
					<tr>
						<td>Address</td>
						<td><input type="text" name="address"></td>
					</tr>
					<tr>
						<td>Course</td>
						<td><input type="text" name="course"></td>
					</tr>
				</table>
			</fieldset>
			<input type="submit" value="Add">
			<% 
			if(msg != null){
			%>
			<h3><%=msg %></h3>
			<%
			}
			%>
		</form>
	</div>
	
</body>
</html>