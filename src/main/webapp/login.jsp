<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!-- <a href="login.jsp">Login</a>|  
<a href="LogoutServlet">Logout</a>| -->  
<a href="registerNewUser.jsp">Register</a>|
<a href="ProfileServlet">Profile</a>

<form action="LoginServlet" method="get">
		<label>Username:<input type="text" id="username" name="username"/></label><br/>
		<label>Password:<input type="password" id="password" name="password"/></label><br/>
		<input type="submit" value="Login"/>
		</form>
</body>
</html>