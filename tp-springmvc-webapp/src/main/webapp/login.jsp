<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
	<head>
		<meta charset="UTF-8">
		<!--[if IE]>
		<meta http-equiv="X-UA-Compatible" content="IE=edge" />
		<![endif]-->		
		<title>Login</title>
		<jsp:include page="boxes/links.jsp" />
	</head>
	<body>
	
		<jsp:include page="boxes/header.jsp" />
		<jsp:include page="boxes/nav.jsp" />
	
		<h2>Login form</h2>
		<form class="form" action="auth/logon" method="POST">
			<input type="text" placeholder="Entrez votre login" name="login" required/><br/>
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