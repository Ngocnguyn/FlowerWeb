<%@page import="model.Bean.ProductModel"%>
<%@page import="model.BO.ProductBO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- Lay id -->
	<%
		ProductModel product =  ProductBO.getProductbyID(Integer.parseInt(request.getParameter("id")));
	%>
	<form action="ProductEdit" method="post">
 		<input type="text" name="product-id" placeholder="Id" value="<%=product.getId()%>" readonly >
 		<input type="text" name="product-img" placeholder="Img" value="<%=product.getImg()%>">
		<input type="text" name="product-name" placeholder="Name" value="<%=product.getName()%>">
		<input type="text" name="product-price" placeholder="Price" value="<%=product.getPrice()%>">
		<input type="text" name="product-discount" placeholder="Discount" value="<%=product.getDiscount()%>">
		<button type="submit">Save</button>
	</form>
</body>
</html>