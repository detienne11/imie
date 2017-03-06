<!DOCTYPE html>

<%@page import="java.util.List"%>
<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
		<meta charset="UTF-8">
		<title>Portal</title>
		<jsp:include page="boxes/links.jsp" />
	</head>
	<body>
		
		<fmt:setLocale value="fr"/>
		<fmt:setBundle basename="application" />
			
		<jsp:include page="boxes/header.jsp" />
		<jsp:include page="boxes/nav.jsp" />
		<main>
			
			<section>
				<h2><fmt:message key="ihm.user.section.title"/></h2>
				<p>
					<form action="/user2/save" >
						<input name="firstName" />
						<input name="lastName" />
					</form>
				</p>
			</section>
			
		</main>
		<jsp:include page="boxes/footer.jsp" />
	</body>
</html>