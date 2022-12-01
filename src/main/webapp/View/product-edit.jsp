<%@page import="java.util.*"%>
<%@page import="model.Bean.ProductModel"%>
<%@page import="model.BO.ProductBO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Flower</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <link rel="stylesheet" href="../css/styleForm.css">
    <link rel="stylesheet" href="../css/style.css">
</head>


<body>
<% String admin = (String)request.getParameter("username");%>

<!-- header section starts  -->
<header>

    <input type="checkbox" name="" id="toggler">
    <label for="toggler" class="fas fa-bars"></label>

    <a href="../HomeAdmin" class="logo">flower<span>.</span></a>

    <div class="icons" style="display: flex; align-items: center;">
        <h2><%=admin%></h2>
        <a href="../logoutController" class="fas fa-sign-out-alt"></a>
    </div>

</header>


<section class="home" id="home">
	<div class="content">
		<%
			ProductModel product =  ProductBO.getProductbyID(Integer.parseInt(request.getParameter("id")));
		%>
		<form action="../ProductEdit" method="post" class="edit-form">
			<h1><span>Edit flower form</span></h1>
 			<input type="text" name="product-id" placeholder="Id" value="<%=product.getId()%>" class="edit-box" readonly >
 			<input type="file" name="product-img" placeholder="Img" value="<%=new String(Base64.getEncoder().encode(product.getImg()))%>" class="edit-box">
			<input type="text" name="product-name" placeholder="Name" value="<%=product.getName()%>" class="edit-box">
			<input type="text" name="product-price" placeholder="Price" value="<%=product.getPrice()%>" class="edit-box">
			<input type="text" name="product-discount" placeholder="Discount" value="<%=product.getDiscount()%>" class="edit-box">
			<button type="submit" class="edit-btn" class="edit-box">Save</button>
		</form>
	</div>
</section>

<!-- home section ends -->

<section class="footer">

    <div class="box-container">

        <div class="box">
            <h3>quick links</h3>
            <a href="#">home</a>
            <a href="#">about</a>
            <a href="#">products</a>
            <a href="#">review</a>
            <a href="#">contact</a>
        </div>

        <div class="box">
            <h3>extra links</h3>
            <a href="#">my account</a>
            <a href="#">my order</a>
            <a href="#">my favorite</a>
        </div>

        <div class="box">
            <h3>locations</h3>
            <a href="#">india</a>
            <a href="#">USA</a>
            <a href="#">japan</a>
            <a href="#">france</a>
        </div>

        <div class="box">
            <h3>contact info</h3>
            <a href="#">099813463</a>
            <a href="#">Hoanhalam@gmail.com</a>
            <a href="#">DaNang, VietNam - 55000</a>
            <img src="images/payment.png" alt="">
        </div>

    </div>


</section>

<!-- footer section ends -->    
</body>
</html>