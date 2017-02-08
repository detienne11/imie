<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>Response Tp2</h2>

<%
	String s = request.getParameter("nom");
	response.getWriter().print(s);
	out.println("==<br/>" + s + "<br/>==");
%>

<%=s%>

</body>
</html>