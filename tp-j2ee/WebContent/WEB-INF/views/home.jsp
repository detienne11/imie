<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Home</title>
		<link type="text/css" href="./resources/css/main.css" rel="stylesheet"/>
	</head>
	<body>
	
		
		<a href="tp2">tp2</a>
	
		<h2>Home</h2>
		
		<%
		
		String username = (String) request.getAttribute("login");
		if (username != null) {
			out.write("<p>" + username + "</p>");
		}
		%>
		
		<p><a href="auth/logout">logout</a></p>
	
	<p>
		<form action="tpredirect" method="post">		
			<label>Forward</label>
			<input type="radio" name="redirectGroup" value="1" checked="checked"><br/>
			<label>Include</label>
			<input type="radio" name="redirectGroup" value="2"><br/>
			<label>Redirect</label>
			<input type="radio" name="redirectGroup" value="3"><br/>
			<input type="submit" value="Submit" id="btn1"/>
		</form>
	</p>
			
	</body>
</html>