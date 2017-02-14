package fr.imie.training.cdi13.dav.j2ee.tpspringmvc.ui;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

public class LoginFilter implements Filter {

	private final static String VIEW = "/login.jsp";

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain arg2)
			throws IOException, ServletException {

//		HttpSession session = request.getSession();
//		Boolean authenticated = (Boolean) session.getAttribute("authenticated");
//
//		if (Boolean.TRUE.equals(authenticated)) {
//			request.getRequestDispatcher(HomeServlet.VIEW).forward(request, response);
//		} else {
//			// unauthenticated
//			response.sendRedirect(request.getContextPath() + "/auth/login");
//		}

		String login = request.getParameter("login");

		if ("test".equals(login)) {
			arg2.doFilter(request, response);
		} else {
			request.getRequestDispatcher(VIEW);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
