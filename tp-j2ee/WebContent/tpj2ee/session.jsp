<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Session</title>
<link type="text/css" href="./resources/css/main.css" rel="stylesheet" />
</head>
<body>

	<h2>Session</h2>

	<%
		
		String sessionId = session.getId();
		if (sessionId != null) {
			out.write("<p>ID session :" + sessionId + "</p>");
		}
		
		Integer nbVisite = (Integer) session.getAttribute("nbVisite");
		if (nbVisite != null) {
			out.write("<p>Nombre de visites :" + nbVisite.toString() + "</p>");
		}
		
		%>


</body>
</html>