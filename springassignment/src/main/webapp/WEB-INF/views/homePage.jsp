<%@page import="com.capgemini.springassignment.bean.EmployeeInfoBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	EmployeeInfoBean loggedInEmpInfo = (EmployeeInfoBean) session.getAttribute("loggedIn");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	 <div style="width: 100;" align="center">
		<h1 style="color: navy;">
			Welcome You Have Logged In SuccessFully
		</h1>
	</div> 
	<a href="./getEmployeeForm">Search Employee</a>
	<br>
	<a href="./add">Add Employee</a>
	<br>
	<a href="./delete">Delete Employee</a>
	<br>
	<a href="./update">Update Employee</a>
	<br>
	<a href="./getAll">See All Employees</a>
	<br>
	<a href="./logout">Logout</a>
</body>
</html>