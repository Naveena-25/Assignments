<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<fieldset>
	<h2>
		<a href="./home" style="text-align: left">Home</a>
	</h2>
	<h2>
		<a href="./logout" style="text-align: right">logOut</a>
	</h2>
	<legend>Update Employee</legend>
	<form action="./updateEmployee" method="post">
	Employee Id :<input type = "number" name="id" required>
	Employee age : <input type ="number" name="age" required>
	&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="submit" value="Update">
	</form>
	</fieldset>
</body>
</body>
</html>