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
				<%-- <p>
					<form action="user/add" method="post">
						<label for="user.login"><fmt:message key="ihm.user.list.field.id"/></label>
						<input type="text" id="user.login" name="user.login" placeholder="Entrez votre login" required>
						
						<label for="user.nom"><fmt:message key="ihm.user.list.field.nom"/></label>
						<input type="text" id="user.nom" name="user.nom" placeholder="Entrez votre nom" required>
						
						<label for="user.prenom"><fmt:message key="ihm.user.list.field.prenom"/></label>
						<input type="text" id="user.prenom" name="user.prenom" placeholder="Entrez votre prenom" required>
						
						<label for="user.email"><fmt:message key="ihm.user.list.field.email"/></label>
						<input type="email" id="user.email" name="user.email" placeholder="Entrez votre email" required>
						
						<label for="user.password"><fmt:message key="ihm.user.list.field.password"/></label>
						<input type="password" id="user.password" name="user.password" placeholder="Entrez votre password" required>
						
						<input type="radio" id="user.actif" name="user.actif" value="1" checked>
						<label for="user.actif"><fmt:message key="ihm.user.list.field.actif"/></label>						
						<input type="radio" id="user.inactif" name="user.actif" value="0">
						<label for="user.inactif"><fmt:message key="ihm.user.list.field.inactif"/></label>
						
						<input type="submit" value="ajouter" id="btn1"/>
					</form>
				</p> --%>
				
				<p>					
					<table>
						<caption><fmt:message key="ihm.user.list.caption"/></caption>
						<thead>
							<tr>
								<th><fmt:message key="ihm.user.list.field.id"/></th>								
								<th><fmt:message key="ihm.user.list.field.login"/></th>
								<th><fmt:message key="ihm.user.list.field.nom"/></th>
								<th><fmt:message key="ihm.user.list.field.prenom"/></th>
								<th><fmt:message key="ihm.user.list.field.email"/></th>
								<th><fmt:message key="ihm.user.list.field.password"/></th>
								<th><fmt:message key="ihm.user.list.field.actif"/></th>
								<th></th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="user" items="${userList}">
								<tr>
									<form action="user/upd" method="post">
										<td><input type="hidden" name="user.id" value="${user.id}"/><c:out value="${user.id}"/></td>
										<td><input type="text" name="user.login" placeholder="Entrez votre login" value="${user.connectionId}" required/></td>
										<td><input type="text" name="user.nom" placeholder="Entrez votre nom" value="${user.nom}" required /></td>
										<td><input type="text" name="user.prenom" placeholder="Entrez votre prenom" value="${user.prenom}" required /></td>
										<td><input type="email" name="user.email" placeholder="Entrez votre email" value="${user.email}" required /></td>
										<td><input type="password" name="user.password" placeholder="Entrez votre password" value="${user.password}" required /></td>
										<td>
											<c:out value="${user.actif}"/>
											<c:choose>
												<c:when test="${user.actif}">
													<input type="checkbox" name="user.actif" checked/>
												</c:when>
												<c:otherwise>
													<input type="checkbox" name="user.actif"/>
												</c:otherwise>
											</c:choose>
										</td>
										<td><input type="submit" value="modifier" id="btnUpd"/></td>
									</form>
									<td>
										<form action="user/del" method="post">
											<input type="hidden" name="user.id" value="${user.id}"/>
											<input type="submit" value="supprimer" id="btnDel"/>
										</form>
									</td>
								</tr>
								
								
									<%-- <form action="user/upd" method="post">
										<input type="radio" name="user.select" value="${user.id}">
											<td class="none"><c:out value="${user.id}"/></td>
											<td><input type="text" name="user.login" placeholder="Entrez votre login" value="${user.connectionId}" required /></td>
											<td><c:out value="${user.nom}"/></td>
											<td><c:out value="${user.prenom}"/></td>
											<td><c:out value="${user.email}"/></td>
											<td><c:out value="${user.password}"/></td>
											<td><c:out value="${user.actif}"/></td>
											<td><input type="submit" value="modifier" id="btnUpd"/></td>
										</input>
									</form>
									<td>
										<form action="user/del" method="post">
											<input type="hidden" name="user.id" value="${user.id}"/>
											<input type="submit" value="supprimer" id="btnDel"/>
										</form>
									</td>
								</tr> --%>
							</c:forEach>
						</tbody>
						<tfoot>
							<form action="user/add" method="post">
								<tr>
									<td></td>
									<td><input type="text" name="user.login" placeholder="Entrez votre login" required /></td>
									<td><input type="text" name="user.nom" placeholder="Entrez votre nom" required /></td>
									<td><input type="text" name="user.prenom" placeholder="Entrez votre prenom" required /></td>
									<td><input type="email" name="user.email" placeholder="Entrez votre email" required /></td>
									<td><input type="password" name="user.password" placeholder="Entrez votre password" required /></td>
									<td>
										<input type="checkbox" name="user.actif" /><br>
									</td>
									<td><input type="submit" value="ajouter" id="btn1"/></td>
									<td></td>									
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