<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
Bonjour <%=System.getProperty("user.name") %><br/>!!

<%=request.getRemoteAddr()%>

<form action="tp2" method="POST">
	<input type="text" placeholder="Entrez votre nom" name="nom"/>
	<input type="text" placeholder="Entrez votre prenom" name="prenom"/>
	<input type="submit" value="Submit" id="button-1"/>
</form>


</body>
</html>