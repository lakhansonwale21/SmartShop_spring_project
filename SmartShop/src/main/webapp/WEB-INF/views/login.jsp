<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/css/style.css">
<meta charset="UTF-8">
<title>login | Page</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	
		<h4>${msgs}</h4>
	
	<form action="/verify-customer" method="post">
		<h2> Login</h2>
		username :
		<input type="text" name="username" placeholder="Enter Username">
		
		password :
		<input type="password" name="password" placeholder="Enter password">
		
		<button type="submit"> Login </button><br>
		<h4>${msg}</h4>
		<br><a href= "/register">Register</a>
	</form>
	<jsp:include page="footer.jsp" />
</body>
</html>