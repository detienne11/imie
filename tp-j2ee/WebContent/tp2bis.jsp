<!DOCTYPE html>

<%@page import="java.util.Arrays"%>
<%@page import="fr.imie.training.cdi13.dav.tpj2ee.bean.User"%>
<%@page import="fr.imie.training.cdi13.dav.tpj2ee.bean.HelloWorld"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta charset="UTF-8">
<title>Tp2 BIS</title>
<link type="text/css" href="./resources/css/main.css" rel="stylesheet" />
</head>
<body>

	<h2>Tp2 BIS / TP3 /Tp4 / TP5 / TP6 /TP7</h2>

	<p>
		<%
			LocalDate localDate = LocalDate.now();
			out.print(localDate.format(DateTimeFormatter.ofPattern("dd/MM/YYYY")));
		%>
	</p>

	<p>
	<table>
		<thead>
			<tr><th>col1</th><th>col2</th></tr>
		</thead>
		<tbody>
			<% for (int i = 1; i < 5; i++) {%>
			<tr><td>Nombre</td><td><%=i%></td></tr>
			<% }%>
		</tbody>
	</table>
	
	<table>
		<thead>
			<tr><th>col1</th><th>col2</th></tr>
		</thead>
		<tbody>
			<c:set var="nbMax" value="7"></c:set>
			<c:forEach var="j" begin="1" end="${nbMax}" step="1">
				<tr><td>Nb</td><td>${j}</td></tr>
			</c:forEach>
		</tbody>
	</table>
	
	<%	
		List<String> seasonList = Arrays.asList("ete","automne","hiver");
		request.setAttribute("seasonList",seasonList );
	%>
	<ul>
		<c:forEach var="saison" items="${seasonList}">
			<li>${saison}</li>
		</c:forEach>
	</ul>

	</p>

	<p>
	<h2>
		<%
			out.write(HelloWorld.afficheHelloWorld());
		%>
	</h2>
	</p>

	<p>
	

	<p>

	</p>

</body>
</html>