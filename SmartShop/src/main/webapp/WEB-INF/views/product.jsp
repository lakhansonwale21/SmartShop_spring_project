<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SmartShop | Products</title>

<link rel="stylesheet" href="/css/style.css">

</head>
<body>
	<jsp:include page="header.jsp" />
    <h1>Available Products</h1>

	<div class="product-grid">
	    <c:forEach var="p" items="${product}">

	        <div class="product-card">

	            <div class="image-box">
	                <img src="${p.imagepath}" alt="${p.productname}">
	            </div>

	            <div class="product-details">
	                <h3>${p.productname}</h3>

	                <p class="price">₹ ${p.price}</p>

	            </div>

	        </div>

	    </c:forEach>
	</div>

	<a href="/shop" type="button">Let's Shop--</a>
	
	<jsp:include page="footer.jsp" />	
</body>
</html>