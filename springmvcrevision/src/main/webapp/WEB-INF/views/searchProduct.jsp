<%@page import="com.capgemini.springmvcrevision.bean.ProductInfoBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%ProductInfoBean productInfoBean=(ProductInfoBean)request.getAttribute("bean"); 
    String errMsg= (String) request.getAttribute("errMsg");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<fieldset>
<legend>Search Product</legend>
<form action="./getProduct">
<label>Product ID : </label>
<input type="number" name="productId" required><br>
<br><input type="submit" value="Search">
</form>
</fieldset>
<%if (errMsg !=null && !errMsg.isEmpty()){ %>
<h3 style="color:red;"><%=errMsg %></h3>
<%} %>
<% if (productInfoBean!=null) { %>
<div align="center">
<table border="1" style="width:60%">
<tr style="background:navy; color:white">
<th>ProductId</th>
<th>ProductName</th>
<th>ProductPrice</th>
<th>ProductDescription</th>
</tr>
<td><%=productInfoBean.getProductId()%></td>
<td><%=productInfoBean.getProductName() %></td>
<td><%=productInfoBean.getProductPrice() %></td>
<td><%=productInfoBean.getProductDescription()%></td>
<tr>
</table>

</div>
<%} %>


</body>
</html>