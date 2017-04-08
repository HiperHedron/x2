<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register Page</title>
</head>
<body>
		<form action="RegisterServlet" method="get"> 
		<label>New Username:<input type="text" id="username" name="username"/></label><br/>
		<label>New Password:<input type="password" id="password" name="password"/></label><br/>
		<label>Repeat password:<input type="password" id="password" name="confirmPassword"/></label><br/>
		<input type="submit" value="Submit"/>
		</form>
</body>
</html>