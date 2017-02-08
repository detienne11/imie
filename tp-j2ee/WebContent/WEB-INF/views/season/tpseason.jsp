<%@page import="java.util.Arrays"%>
<%@page import="org.apache.tomcat.util.digester.ArrayStack"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tp Season</title>
<link type="text/css" href="./resources/css/main.css" rel="stylesheet"/>
</head>
<body>

<h2>Tp Season</h2>

<p>
<%

	LocalDate localDate = LocalDate.now();
	out.print(localDate.format(DateTimeFormatter.ofPattern("dd/MM/YYYY")));
%>
</p>

<%
	List<String> seasonList = Arrays.asList("Spring","Summer","Autumn","Winter");
%>

	<form action="season" method="post">
		
		<input list="seasonList" name="season">

		<datalist id="seasonList">
		<% for(int i=0;i< seasonList.size();i++) { %>		  
			  <option value="<%=seasonList.get(i) %>">
		<% } %>
		  
		</datalist>
		<input type="submit" value="Submit" id="btn1"/>
	</form>

</body>
</html>