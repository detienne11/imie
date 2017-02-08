<!DOCTYPE html>

<%@page import="java.util.List"%>
<%@page import="java.util.Arrays"%>
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
		<link href="https://fonts.googleapis.com/css?family=Hind:700" rel="stylesheet">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	</head>
<body>

	<jsp:include page="boxes/header.jsp" />
	<jsp:include page="boxes/nav.jsp" />
	<main>
		<jsp:useBean id="voitures" scope="page"	class="java.util.HashMap" />
		<c:set target="${voitures}"	property="Renault" value="Citadine" />
		<c:set target="${voitures}"	property="Ferrari" value="Sprotive" />
		
		<c:forEach var="entry"	items="${voitures}">
			${entry.key } : ${entry.value} <br />
		</c:forEach>
	</main>
	<jsp:include page="boxes/footer.jsp" />
</body>
</html>