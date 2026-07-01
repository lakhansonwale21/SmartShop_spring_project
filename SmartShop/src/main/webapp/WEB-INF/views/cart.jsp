<%@ page contentType="text/html;charset=UTF-8" language="java" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

		<!DOCTYPE html>
		<html>

		<head>
			<meta charset="UTF-8">
			<title>Shopping | Cart</title>

			<link rel="stylesheet" href="/css/style.css">
		</head>

		<body>
			<jsp:include page="header.jsp" />

			<div class="cart-container">
				<h1>Your Cart</h1>

				<c:if test="${not empty msg}">
					<h4 class="msg">${msg}</h4>
				</c:if>
				<c:forEach var="p" items="${cartproduct}">
					<div class="cart-card">

						<img src="${p.imagepath}" alt="${p.productname}" class="product-image">

						<div class="product-details">
							<h2>${p.productname}</h2>

							<p class="price">
								₹ ${p.price}
							</p>

							<form action="/remove-from-cart/${p.pid}" method="post">
								<button class="remove-btn" type="submit">
									Remove
								</button>
							</form>

						</div>

					</div>

				</c:forEach>
				<div class="cart-card">
					Total Amount :
					<c:if test="${totalAmount != null}">
						<span class="price">₹ ${totalAmount}</span>
					</c:if>
				</div>
			</div>

			<a href="/bill">Shop Now</a>

			<jsp:include page="footer.jsp" />
		</body>

		</html>