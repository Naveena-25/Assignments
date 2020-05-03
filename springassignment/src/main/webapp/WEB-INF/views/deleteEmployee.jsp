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
	<legend>Delete Employee</legend>
	<form action="./deleteEmployee">
	Employee Id : <input type ="number" name="id" required>
	&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="submit" value="Delete">
	</form>
	</fieldset>

</body>
</html>