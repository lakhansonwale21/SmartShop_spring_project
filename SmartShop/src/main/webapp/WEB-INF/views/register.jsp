<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="/css/style.css">
    <meta charset="UTF-8">
    <title>Customer | Registration | Page</title>
</head>
<body>
	<jsp:include page="header.jsp" />

	<c:if test="${not empty msg}">
			<h4 class="msg">${msg}</h4>
		</c:if>

    <form action="/add-customer" method="post">
		<h2> Registration </h2>
        <label>Full Name:</label><br>
        <input type="text" name="name" placeholder="Enter your name"><br><br>

        <label>Address:</label><br>
        <input type="text" name="address" placeholder="Enter your address"><br><br>

        <label>Mobile Number:</label><br>
        <input type="tel" name="mobile" placeholder="Enter mobile number"><br><br>

        <label>Email:</label><br>
        <input type="email" name="email" placeholder="Enter your email"><br><br>

        <label>Username:</label><br>
        <input type="text" name="username" placeholder="Enter username"><br><br>

        <label>Password:</label><br>
        <input type="password" name="password" placeholder="Enter password"><br><br>

        <input type="submit" value="Register">
        <input type="reset" value="Clear">

    </form>
	
	<jsp:include page="footer.jsp" />
</body>
</html>