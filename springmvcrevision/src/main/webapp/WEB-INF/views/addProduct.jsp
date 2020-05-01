<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="./added" method="post">
		<table>
			<tr>
				<td>ProductId</td>
				<td><input type="number" name="productId"></td>
			</tr>
			<tr>
				<td>ProductName</td>
				<td><input type="text" name="productName"></td>
			</tr>
			<tr>
				<td>ProductPrice</td>
				<td><input type="text" name=productPrice></td>
			</tr>
			<tr>
			<tr>
				<td>ProductDescription</td>
				<td><input type="text" name="productDescription"></td>
			</tr>
			
			<tr>
				<td colspan="2" align="center"><input type="submit" value="Register"></td>
				
			</tr>



		</table>


	</form>

</body>
</html>