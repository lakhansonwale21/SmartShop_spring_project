<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<!DOCTYPE html>
	<html>

	<head>
		<meta charset="UTF-8">
		<title>Customer | Profile</title>

		<link rel="stylesheet" href="/css/style.css">

	</head>

	<body>

		<jsp:include page="header.jsp" />

		<div class="profile-container">

			<div class="profile-card">

				<div class="profile-header">
					<h1>Customer Profile</h1>
				</div>

				<div class="profile-body">

					<div class="profile-row">
						<span class="label">Name :</span>
						<span class="value">${customer.name}</span>
					</div>

					<div class="profile-row">
						<span class="label">Address :</span>
						<span class="value">${customer.address}</span>
					</div>

					<div class="profile-row">
						<span class="label">Mobile :</span>
						<span class="value">${customer.mobile}</span>
					</div>

					<div class="profile-row">
						<span class="label">Email :</span>
						<span class="value">${customer.email}</span>
					</div>

					<div class="profile-row">
						<span class="label">Username :</span>
						<span class="value">${customer.username}</span>
					</div>

					<div class="profile-buttons">
						<a href="" type="button" class="update-btn">Update Profile</a>
						<a href="/shop" type="button" class="shop-btn">Continue Shooping</a>
					</div>

				</div>

			</div>

		</div>

		<jsp:include page="footer.jsp" />

	</body>

	</html>