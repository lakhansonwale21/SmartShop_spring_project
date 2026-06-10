<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SmartShop Bill</title>

<link rel="stylesheet" href="/css/style.css">

</head>
<body>
	<jsp:include page="header.jsp" />
<div class="bill-container">

    <h1>SmartShop Bill</h1>

    <table class="bill-table">
        <thead>
            <tr>
                <th>Product ID</th>
                <th>Product Name</th>
                <th>Price</th>
            </tr>
        </thead>

        <tbody>
            <c:forEach items="${billProduct}" var="product">
                <tr>
                    <td>${product.pid}</td>
                    <td>${product.productname}</td>
                    <td>₹ ${product.price}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <div class="bill-summary">
        <span>Total Amount :</span>
        <span class="total-price">₹ ${totalAmount}</span>
    </div>

    <div class="btn-container">
        <form action="#" method="post">
            <button type="submit" class="order-btn">
                Place Order
            </button>
        </form>
    </div>

</div>
<jsp:include page="footer.jsp" />
</body>
</html>