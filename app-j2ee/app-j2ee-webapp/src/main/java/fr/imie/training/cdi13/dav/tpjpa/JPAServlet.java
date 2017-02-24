package fr.imie.training.cdi13.dav.tpjpa;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.imie.training.cdi13.dav.appjee.bl.BusinessException;
import fr.imie.training.cdi13.dav.appjee.bl.domain.BO.STATE;
import fr.imie.training.cdi13.dav.appjee.bl.domain.User;
import fr.imie.training.cdi13.dav.appjee.bl.service.UserServiceEjb;

/**
 * Servlet implementation class JPAServlet
 */
@WebServlet("/user/*")
public class JPAServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private UserServiceEjb userServiceEjb;

	private final static String VIEW = "/WEB-INF/views/user.jsp";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		final String uri = request.getRequestURI();
		List<User> userList = null;
		try {
			if (Pattern.matches("^.*/add$", uri)) {

				User user = this.convertToDTO(request);
				user.setState(STATE.TO_INSERT);
				userServiceEjb.persistUser(user);

				response.sendRedirect(request.getContextPath() + "/user");

			} else if (Pattern.matches("^.*/del$", uri)) {

				User user = this.convertToDTO(request);
				user.setState(STATE.TO_REMOVE);
				userServiceEjb.persistUser(user);
				response.sendRedirect(request.getContextPath() + "/user");

			} else if (Pattern.matches("^.*/upd$", uri)) {

				User user = this.convertToDTO(request);
				user.setState(STATE.TO_UPDATE);
				userServiceEjb.persistUser(user);
				response.sendRedirect(request.getContextPath() + "/user");

			} else {
				userList = userServiceEjb.findUser();
				request.setAttribute("userList", userList);
				request.getRequestDispatcher(VIEW).forward(request, response);
			}

		} catch (BusinessException e) {
			userList = new ArrayList<>();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private User convertToDTO(HttpServletRequest request) {
		User bo = new User();
		String sId = request.getParameter("user.id");
		if (sId != null) {
			bo.setId(Integer.parseInt(sId));
		}
		bo.setConnectionId(request.getParameter("user.login"));
		bo.setNom(request.getParameter("user.nom"));
		bo.setPrenom(request.getParameter("user.prenom"));
		bo.setEmail(request.getParameter("user.email"));
		bo.setPassword(request.getParameter("user.password"));

		String sActif = request.getParameter("user.actif");
		boolean actif = false;
		if ("1".equals(sActif) || "on".equals(sActif)) {
			actif = true;
		}
		bo.setActif(Boolean.valueOf(actif));
		return bo;
	}

}
