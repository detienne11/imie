<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Season</title>
</head>
<body>
<p><a href="tpseason">return</a></p>
<h2>
<%
	String s = request.getParameter("season");
	out.print(s);
%>
</h2>

</body>
</html>