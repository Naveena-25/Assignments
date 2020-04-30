<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Form</title>
</head>
<body>
	<form action="./added" method="post">
		<table>
			<tr>
				<td>id</td>
				<legend>Add Employee</legend>
				<td><input type="number" name="id"></td>
			</tr>
			<tr>
				<td>Name:</td>
				<td><input type="text" name="name"></td>
			</tr>
			
			<tr>
				<td>Password:</td>
				<td><input type="password" name="password"></td>
			</tr>
		
			<tr>
				<td>Salary:</td>
				<td><input type="number" name="salary"></td>
			</tr>
			<tr>
				<td>Designation:</td>
				<td><input type="number" name="deptno"></td>
			</tr>
			<tr>
				<td>Age:</td>
				<td><input type="number" name="age"></td>
			</tr>
			<tr>
				<td><input type="submit" value="register"></td>
			</tr>
		</table>
	</form>
</body>
</html>