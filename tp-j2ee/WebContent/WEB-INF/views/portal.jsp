<!DOCTYPE html>

<%@page import="java.util.List"%>
<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="imie" uri="/WEB-INF/tld/imie.tld" %>

<html>
	<head>
		<meta charset="UTF-8">
		<title>Portal</title>
		<jsp:include page="boxes/links.jsp" />
	</head>
	<body>
			
		<jsp:include page="boxes/header.jsp" />
		<jsp:include page="boxes/nav.jsp" />
		<main>
			
			Bonjour <%=System.getProperty("user.name") %><br/>!!

			<%=request.getRemoteAddr()%>
			
			<form action="tp2" method="POST">
				<input type="text" placeholder="Entrez votre nom" name="nom"/><br/>
				<input type="text" placeholder="Entrez votre prenom" name="prenom"/><br/>
				<input type="submit" value="Submit" id="button-1"/>
			</form>
			
			<%
				List<String> list = Arrays.asList("Alors","cette nouvelle ligne","dans un tableau","ca marche ?");
				request.setAttribute("list",list );
			%>
			
			<imie:table list="${list}"/>
			
			<c:set var="p1" value="2"/>
			
			<c:set var="p1" value="2"/>
			<c:set var="p2" value="8"/>
			${p1}<br/>
			${p2}<br/>
			
			<imie:somme param1="${p1}" param2="14"/>
			
			<h2>
				<fmt:bundle basename="message" >
					<fmt:message key="portal.h1"/>
				</fmt:bundle>
			</h2>
			
			<fmt:setLocale value="fr"/>
			
			<fmt:setBundle basename="message" />
				<fmt:message key="portal.h1"/>
			
			<section class="block-2">
				<h2>JSP</h2>
				<p>TP JSP</p>
			</section>
			
			<section class="block-2">
				<h2>Servlet</h2>
				<p>TP Servlet</p>
			</section>
			
		</main>
		<jsp:include page="boxes/footer.jsp" />
	</body>
</html>