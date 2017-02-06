<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tp2 BIS</title>
</head>
<body>

<h2>Tp2 BIS</h2>

<%
	List<String> seasonList = new ArrayList<>();
	seasonList.add("Spring");
	seasonList.add("Summer");
	seasonList.add("Autumn");
	seasonList.add("Winter");
%>

	<form action="season.jsp" method="post">
		
		<input list="seasonList" name="season">

		<datalist id="seasonList">
		<% 
		  
		  for(int i=0;i< seasonList.size();i++) {
			  out.print("<option value=\"" + seasonList.get(i) + "\">");
		  }
		  
		%>
		</datalist>
		<input type="submit" value="Submit" id="btn1"/>
	</form>

</body>
</html>