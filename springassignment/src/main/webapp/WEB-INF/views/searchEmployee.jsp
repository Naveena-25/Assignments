<%@page import="com.capgemini.springassignment.bean.EmployeeInfoBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	EmployeeInfoBean employeeInfoBean = (EmployeeInfoBean) request.getAttribute("employeeInfo");
	String errMsg = (String) request.getAttribute("errMsg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>
		<a href="./home" style="text-align: left">Home</a>
	</h2>
	<h2>
		<a href="./logout" style="text-align: right">logOut</a>
	</h2>
		<legend>Search Employee</legend>
		<form action="./getEmployee">
			<label>Employee ID:</label> <input type="number" name="empid"
				required><br> <br> <input type="submit"
				value="search">
		</form>
	</fieldset>
	<%
		if (errMsg != null && !errMsg.isEmpty()) {
	%>
	<h3 style="color: red;"><%=errMsg%></h3>
	<%
		}
	%>
	<%
		if (employeeInfoBean != null) {
	%>
	<div align="center">
		<table border="1" style="width: 60%">
			<tr style="background: navy; color: white">
				<th>Emp Id</th>
				<th>Name</th>
				<th>Age</th>
				<th>Salary</th>
				<th>Designation</th>
				<th>Password</th>
			<tr>
				<td><%=employeeInfoBean.getEmpid()%></td>
				<td><%=employeeInfoBean.getName()%></td>
				<td><%=employeeInfoBean.getAge()%></td>
				<td><%=employeeInfoBean.getSalary()%></td>
				<td><%=employeeInfoBean.getDesignation()%></td>
				<td><%=employeeInfoBean.getPassword()%></td>
			<tr>
		</table>

	</div>
	<%
		}
	%>