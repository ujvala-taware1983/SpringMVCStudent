<%@page import="com.jspiders.springmvcstudent.pojo.StudentPOJO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:include page = "NavBar.jsp"/>
<%
String msg = (String) request.getAttribute("msg");
StudentPOJO student = (StudentPOJO) request.getAttribute("student");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Management</title>
<style type="text/css">
form {
	margin-top: 10px;
}
form table {
	margin: auto;
	width: 100%;
}
tr {
	text-align: center;
}
fieldset table {
	margin: auto;
	text-align: left;
}
fieldset {
	margin: 15px 520px;
	text-align: center;
}
legend {
	color: white;
	background-color: #333;
}
body {
	background-image:
		url('https://images.unsplash.com/photo-1472289065668-ce650ac443d2?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8M3x8c2Nob29sJTIwbWFuYWdlbWVudHxlbnwwfHwwfHw%3D&w=1000&q=80');
	background-size: 100%;
}
#data {
	background-color: white;
	border: 1px solid black;
	width: 100%;
	border: 1px solid black;
}
#data td {
	border: 1px solid black;
	text-align: center;
}
</style>
</head>
<body>
<div align="center">
		<form action="./search" method="post">
			<fieldset>
				<legend>Search Student Record</legend>
				<table>
					<tr>
						<td>Enter ID</td>
						<td><input type="text" name="id"></td>
					</tr>
				</table>
			</fieldset>
			<input type="submit" value="Search">
		</form>
		<%
		if (msg != null) {
		%>
		<h3>
			<%=msg%>
		</h3>
		<%
		}
		%>
		<%
		if (student != null) {
		%>
		<table>
			<thead>
				<tr>
					<td>ID</td>
					<td>Name</td>
					<td>Contact</td>
					<td>Address</td>
					<td>Course</td>
				</tr>
			</thead>
			<tr>
				<td><%=student.getId()%></td>
				<td><%=student.getName()%></td>
				<td><%=student.getContact()%></td>
				<td><%=student.getAddress()%></td>
				<td><%=student.getCourse()%></td>
			</tr>
		</table>
		<%
		}
		%>
		</div>
</body>
</html>