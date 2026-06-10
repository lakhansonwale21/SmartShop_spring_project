<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/css/style.css">
<meta charset="UTF-8">
<title>login | Page</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<c:if test="${not empty msg}">
		<h4 class="msg">${msg}</h4>
	</c:if>
	<form action="/verify-customer" method="post">
		<h2> Login</h2>
		username :
		<input type="text" name="username" placeholder="Enter Username">
		
		password :
		<input type="password" name="password" placeholder="Enter password">
		
		<button type="submit"> Login </button><br>
		
		<br>Don't have account? <a href= "/register">Sign up here</a>
	</form>
	<jsp:include page="footer.jsp" />
</body>
</html>