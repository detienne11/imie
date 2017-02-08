<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Login</title>
		<link type="text/css" href="./resources/css/main.css" rel="stylesheet"/>
	</head>
	<body>
	
		<h2>Login form</h2>
		<form class="form" action="auth/logon" method="POST">
			<input type="text" placeholder="Entrez votre login" name="login"/><br/>
			<input type="password" placeholder="Entrez votre password" name="password"/>
			<input type="submit" value="Submit" id="btn1"/>
		</form>
	
		<%
			String userCheck = (String) request.getAttribute("user-check");
			if (userCheck != null) {
				out.write("<div class=\"red\">userCheck: " + userCheck + "</div>");
			}
			
			String error = (String) request.getAttribute("error");
			if (error != null) {
				out.write("<div class=\"red\">Error: " + error + "</div>");
			}
		
		%>
	
	</body>
</html>