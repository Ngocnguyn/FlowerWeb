<%@page import="java.util.ArrayList"%>
<%@page import="model.Bean.ProductModel"%>
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

<!-- header section starts  -->

<header>
    <input type="checkbox" name="" id="toggler">
    <label for="toggler" class="fas fa-bars"></label>

    <a href="../Home" class="logo">flower<span>.</span></a>

    <div class="icons">
        <a href="#" class="fas fa-heart"></a>
        <a href="#" class="fas fa-shopping-cart"></a>
        <a href="Login.jsp" class="fas fa-user"></a>
    </div>
</header>


<section class="home" id="home">
    <div class="content">
		<form action="../loginController" method="post" class="login-form">
			<h1><span>Login form</span></h1>
			<input type="text" title="username" placeholder="username" name="username" class="login-box" /> 
			<input type="password" title="username" placeholder="password" name="password" class="login-box" />
			<button type="submit" class="login-btn">Login</button>
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