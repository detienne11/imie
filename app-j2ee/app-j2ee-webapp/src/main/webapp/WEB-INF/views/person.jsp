<!DOCTYPE html>

<%@page import="java.util.List"%>
<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
		<meta charset="UTF-8">
		<title>TP JPA : Relation (1:1 1:n n:n) + Heritage</title>
		<jsp:include page="boxes/links.jsp" />
	</head>
	<body>
		<!-- 1: cas -->
		<c:set var="tpId" value="v1"/>
		
		<fmt:setLocale value="fr"/>
		<fmt:setBundle basename="application" />
			
		<jsp:include page="boxes/header.jsp" />
		<jsp:include page="boxes/nav.jsp" />
		<main>
			
			<section>
				<h2><fmt:message key="ihm.person.section.title"/></h2>
			
				<p>					
					<table>
						<caption><fmt:message key="ihm.person.list.caption"/></caption>
						<thead>
							<tr>
								<th><fmt:message key="ihm.person.list.field.id"/></th>
								<th><fmt:message key="ihm.person.list.field.type"/></th>							
								<th><fmt:message key="ihm.person.list.field.nom"/></th>
								<th><fmt:message key="ihm.person.list.field.prenom"/></th>
								<th><fmt:message key="ihm.person.list.field.email"/></th>
								<th><fmt:message key="ihm.person.list.field.nomClasse"/></th>
								<th></th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="person" items="${personList}">
								<tr>
									<form action="person/upd/${tpId}" method="post">
										<td><input type="hidden" name="person.id" value="${person.id}"/><c:out value="${person.id}"/></td>
										<td>
											<label>
											<c:choose>
												<c:when test="${person.type == 1}">
													<input type="radio" name="person.type" value="1" checked/>
												</c:when>
												<c:otherwise>
													<input type="radio" name="person.type" value="1" />
												</c:otherwise>
											</c:choose>Person</label>
											
											<label>
											<c:choose>
												<c:when test="${person.type == 2}">
													<input type="radio" name="person.type" value="2" checked/>
												</c:when>
												<c:otherwise>
													<input type="radio" name="person.type" value="2" />
												</c:otherwise>
											</c:choose>Parent</label>
											
											<label>
											<c:choose>
												<c:when test="${person.type == 3}">
													<input type="radio" name="person.type" value="3" checked/>
												</c:when>
												<c:otherwise>
													<input type="radio" name="person.type" value="3" />
												</c:otherwise>
											</c:choose>Eleve</label>
											
										</td>
										<td><input type="text" name="person.nom" placeholder="Entrez votre nom" value="${person.nom}" required /></td>
										<td><input type="text" name="person.prenom" placeholder="Entrez votre prenom" value="${person.prenom}" required /></td>
										<td><input type="email" name="person.email" placeholder="Entrez votre email" value="${person.email}" /></td>
										<td><input type="text" name="person.nomClasse" placeholder="Entrez votre nomClasse" value="${person.nomClasse}" /></td>
										<td><input type="submit" name="person.update" value="modifier" id="btnUpd"/></td>
										<td><input type="submit" name="person.delete" value="supprimer" id="btnDel"/></td>
									</form>									
								</tr>
							</c:forEach>
						</tbody>
						<tfoot>
							<form action="person/add/${tpId}" method="post">
								<tr>
									<td></td>
									<td>
										<label><input type="radio" name="person.type" value="1"/>Person</label>											
										<label><input type="radio" name="person.type" value="2" />Parent</label>
										<label><input type="radio" name="person.type" value="3" />Eleve</label>
									</td>
									<td><input type="text" name="person.nom" placeholder="Entrez votre nom" required /></td>
									<td><input type="text" name="person.prenom" placeholder="Entrez votre prenom" required /></td>
									<td><input type="email" name="person.email" placeholder="Entrez votre email" /></td>
									<td><input type="text" name="person.nomClasse" placeholder="Entrez votre nomClasse" /></td>									
									<td colspan="2"><input type="submit" value="ajouter" id="btn1"/></td>								
								</tr>
							</form>						
						</tfoot>
					</table>
					
				</p>
			</section>
			
		</main>
		<jsp:include page="boxes/footer.jsp" />
	</body>
</html>