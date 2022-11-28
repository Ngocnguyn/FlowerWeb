<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="ProductAdd" method="post">
 		<input type="text" name="product-img" placeholder="Img">
		<input type="text" name="product-name" placeholder="Name">
		<input type="text" name="product-price" placeholder="Price">
		<input type="text" name="product-discount" placeholder="Discount">
		<button type="submit">Add</button>
	</form>
</body>
</html>