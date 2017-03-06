<!DOCTYPE html>

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
		<link href="https://fonts.googleapis.com/css?family=Hind:700" rel="stylesheet">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	</head>
<body>

	<jsp:include page="boxes/header.jsp" />
	<jsp:include page="boxes/nav.jsp" />
	<main>
		<section>
			<h2>TP10</h2>
			
			<c:set var="nbMax"	value="20" />
			
			<jsp:useBean id="nbPremierMap" scope="page" class="java.util.HashMap" />
						
			<table>
				<caption>Nombre premiers</caption>
				<thead><tr><th>Nombre</th><th>EstPremier</th></tr></thead>
				<tbody>
				<c:forEach var="nb" begin="2" end="${nbMax}"  step="1">
					<c:set var="estPremier" value="false"/>
					
					<jsp:useBean id="diviseurList" scope="page" class="fr.imie.training.cdi13.dav.tpj2ee.bean.ListBean" />
					<c:set target="${nbPremierMap}"	property="${nb}" value="${diviseurList}" />
					
					<c:forEach var="divi" begin="2" end="${nb-1}"  step="1">
						<c:out value="${nb}"/>
						<c:if test="${(nb%divi) == 0}" >
							<c:set target="${diviseurList}"	property="child" value="${divi}" />							
							<c:out value="${nb}"/> % <c:out value="${divi}"/> = <c:out value="${(nb%divi)}"/>
							<c:set var="estPremier" value="true"/>
						</c:if>
					</c:forEach>
					
					<c:choose>
						<c:when test="${estPremier}">
							<c:set var="style" value="premier"/>
						</c:when>
						<c:otherwise>
							<c:set var="style" value="paspremier"/>
						</c:otherwise>
					</c:choose>
					
					<tr>
						<td class="${style}"><c:out value="${nb}"/></td>
						<td>
						<%-- <c:forEach var="divisList"	items="${nbPremierMap['nb']}">
							<c:forEach var="divis" items="${divisList}">
								<c:out value="${divis}"/>
							</c:forEach>
						</c:forEach> --%>
						</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
			
		</section>
		
		
	</main>
	<jsp:include page="boxes/footer.jsp" />
</body>
</html>