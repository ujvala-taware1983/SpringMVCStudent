<%@page import="java.util.List"%>
<%@page import="com.jspiders.springmvcstudent.pojo.StudentPOJO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:include page="NavBar.jsp" />

<%
String msg = (String) request.getAttribute("msg");
StudentPOJO student = (StudentPOJO) request.getAttribute("student");
List<StudentPOJO> students = (List<StudentPOJO>) request.getAttribute("studentList");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
thead {
	color: white;
	width: 100%;
	background: #000;
	padding: ($half-spacing-unit* 1.5) 0;
	width: 100%;
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
		<%
		if (student != null) {
		%>
		<form action="./updateData" method="post">
			<fieldset>
				<legend>Update Student</legend>
				<table>
					<tr hidden="true">
						<td>ID</td>
						<td><input type="text" name="id"
							value="<%=student.getId()%>"></td>
					</tr>
					<tr>
						<td>Name</td>
						<td><input type="text" name="name"
							value="<%=student.getName()%>"></td>
					</tr>
					<tr>
						<td>Contact</td>
						<td><input type="text" name="contact"
							value="<%=student.getContact()%>"></td>
					</tr>
					<tr>
						<td>Designation</td>
						<td><input type="text" name="address"
							value="<%=student.getAddress()%>"></td>
					</tr>
					<tr>
						<td>Salary</td>
						<td><input type="text" name="course"
							value="<%=student.getCourse()%>"></td>
					</tr>
				</table>
			</fieldset>
			<input type="submit" value="Update">
		</form>
		<%
		} else {
		%>
		<form action="./update" method="post">
			<fieldset>
				<legend> Student</legend>
				<table>
					<tr>
						<td>Enter ID</td>
						<td><input type="text" name="id"></td>
					</tr>
				</table>
			</fieldset>
			<input type="submit" value="Select">
		</form>
		<%
		if (msg != null) {
		%>
		<h3><%=msg%>
		</h3>
		<%
		}
		%>
		<%
		if (student != null) {
		%>
		<table id="data">
			<thead>
				<tr>
					<td>ID</td>
					<td>Name</td>
					<td>Contact</td>
					<td>Address</td>
					<td>Course</td>
				</tr>
			</thead>
			<%
			for (StudentPOJO pojo : students) {
			%>
			<tr>
				<td><%=pojo.getId()%></td>
				<td><%=pojo.getName()%></td>
				<td><%=pojo.getContact()%></td>
				<td><%=pojo.getAddress()%></td>
				<td><%=pojo.getCourse()%></td>
			</tr>
			<%
			}
			%>
		</table>

		<%
		}
		%>
		<%
		}
		%>
	</div>
</body>
</html>