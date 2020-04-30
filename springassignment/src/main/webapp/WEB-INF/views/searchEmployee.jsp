<%@page import="com.capgemini.springassignment.bean.EmployeeInfoBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <% EmployeeInfoBean employeeInfoBean = (EmployeeInfoBean) request.getAttribute("employee_info");
    String errMsg = (String) request.getAttribute("errMsg");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<fieldset>
	<legend>Search Employee</legend>
	<form action="">
	<label>Employee ID:</label>
	<input type="number" name= "empid" required><br>
	<br>
	<input type="submit" value = "submit">
	</form>
	</fieldset>
	
	<%
		if (employeeInfoBean != null) {
	%>
	<div align="center">
		<table border="1" style="width: 70%">
			<tr style="background: black; color: white;">
				<th>ID</th>
				<th>Name</th>
				<th>Password</th>
				<th>Salary</th>
				<th>Age</th>
				<th>Designation</th>
			</tr>
			<tr>
				<td><%=employeeInfoBean.getEmpid()%></td>
				<td><%=employeeInfoBean.getName()%></td>
				<td><%=employeeInfoBean.getPassword()%></td>
				<td><%=employeeInfoBean.getSalary()%></td>
				<td><%=employeeInfoBean.getAge()%></td>
			</tr>
		</table>
	</div>
	<% } %>
</body>
</html>