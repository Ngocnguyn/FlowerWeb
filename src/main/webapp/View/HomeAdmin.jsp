<%@page import="java.util.*"%>
<%@page import="model.Bean.ProductModel"%>
<%@page import="model.Bean.Admin"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Flower</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

<% Admin admin = (Admin) session.getAttribute("admin");%>
<!-- header section starts  -->
<header>

    <input type="checkbox" name="" id="toggler">
    <label for="toggler" class="fas fa-bars"></label>

    <a href="HomeAdmin" class="logo">flower<span>.</span></a>

    <div class="icons" style="display: flex; align-items: center;">
     	<h2><%=admin.getUsername()%></h2>
      <a href="logoutController" class="fas fa-sign-out-alt"></a>
    </div>

</header>

<section class="home" id="home">

    <div class="content">
        <h3>Welcome, <%=admin.getUsername()%></h3>
        <span> natural & beautiful flowers </span>
    </div>
    
</section>

<!-- products section starts  -->

<section class="products" id="products">

    <h1 class="heading"> latest <span>products</span>  </h1>
	<a class ="btn" href="View/product-add.jsp?username=<%=admin.getUsername()%>">
	    + New Item
    </a>
    <div class="box-container" style="margin-top:2rem;">
    <% ArrayList<ProductModel> products = (ArrayList<ProductModel>)request.getAttribute("products");%>
		<%for(ProductModel item : products){
			%>
			<div class="box">
            <span class="discount">-<%=item.getDiscount()%>%</span>
            <div class="image">
                 <img src=<%="data:image/png;base64," + new String(Base64.getEncoder().encode(item.getImg()))%> alt=""
                 	onerror="this.src='https://img.freepik.com/premium-vector/sunflower-character-with-crying-tears-emotion-sad-face-depressive-eyes-arms-legs-plant-person-with-melancholy-expression-yellow-sun-flower-emoticon-vector-flat-illustration_427567-4060.jpg?w=2000'">
             
                 <div class="icons">
                    <a href="#" class="fas fa-heart"></a>
                    <a href="ProductDetail?id=<%=item.getId()%>&&username=<%=admin.getUsername() %>" class="cart-btn">Edit</a>
                    <a href="ProductDelete?id=<%=item.getId()%>" class="fas fa-trash"></a>
                </div>
            </div>
            <div class="content">
                <h3><%=item.getName()%></h3>
                <div class="price"> $<%= item.getPrice()*(100-item.getDiscount())/100%> <span>$<%=item.getPrice()%></span> </div>
            </div>
        </div>
		<%}%>
    </div>

</section>

<!-- prodcuts section ends -->

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