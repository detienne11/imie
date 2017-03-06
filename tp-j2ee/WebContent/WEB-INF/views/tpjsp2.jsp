<!DOCTYPE html>

<%@page import="fr.imie.training.cdi13.dav.tpj2ee.bean.User"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="imie" uri="/WEB-INF/tld/imie.tld"%>

<html>
<head>
<meta charset="UTF-8">
<title>Map</title>
<link type="text/css" href="resources/css/main.css" rel="stylesheet" />
<link type="text/css" href="resources/css/cv2.css" rel="stylesheet" />
<link href="https://fonts.googleapis.com/css?family=Hind:700"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>

	<jsp:include page="boxes/header.jsp" />
	<jsp:include page="boxes/nav.jsp" />
	<main>
	<section>
		<!-- SCRIPTLET 1 -->
		<h2>TP JSP 2 exo 1 : scriptlet 1</h2>
		<p>
			<% User u1 = (User) request.getAttribute("user");%>
			<%= u1.toString() %><br/>
			<% 
				u1.setNom("Joli");
				u1.setPrenom("Angelina");
			%>
			<%= u1.toString() %>
			
		</p>
		
		<!-- SCRIPTLET 2 -->
		<h2>TP JSP 2 exo 1: scriptlet 2</h2>
		<p>			
			<jsp:declaration>
				/* User u2 = (User) request.getAttribute("user");*/
			</jsp:declaration>
			<jsp:scriptlet>
				u1.setNom("Skywalker");
				u1.setPrenom("Luke");	
			</jsp:scriptlet>
			<jsp:expression>
				u1.toString()
			</jsp:expression>
		</p>
		
		<!-- USEBEAN -->
		<h2>TP JSP 2 exo 1: UseBean 3</h2>
		<p>			
		<jsp:useBean id="u3" scope="page" class="fr.imie.training.cdi13.dav.tpj2ee.bean.User"/>			
		<jsp:getProperty name="u3" property="nom" /><br/>
		<jsp:getProperty name="u3" property="prenom" />
			
		</p>
	</section>
	<section>
		<!-- JSTL -->
		<h2>TP JSP 2 exo 2 : JSTL core</h2>
		<p>
			<c:out value="${user}"/>
		</p>
		<!-- EL -->
		<h2>TP JSP 2 exo 2: EL</h2>
		<p>
			${user.nom}<br/>
			${user.prenom}
		</p>
	</section>
	<section>
		<h2>TP JSP 2 exo 3 : SCRIPTLET</h2>
		<p>
			<% List<String> liste = (List<String>) request.getAttribute("liste");				
				
				out.println("<ul>");
				for(String str : liste) {
					out.println("<li>");
					out.println(str);
					out.println("</li>");
				}
				out.println("</ul>");
			%>
		</p>
	</section>
	<section>
		<h2>TP JSP 2 exo 4 : JSTL + EL</h2>
		<p>
			<ul>
				<c:forEach var="elt" items="${liste}">
					<li><c:out value="${elt}"/></li>
				</c:forEach>
			</ul>
		</p>
	</section>
	</main>
	<jsp:include page="boxes/footer.jsp" />
</body>
</html>