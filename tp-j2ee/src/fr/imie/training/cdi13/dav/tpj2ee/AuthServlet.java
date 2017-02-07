package fr.imie.training.cdi13.dav.tpj2ee;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogonServlet
 */
@WebServlet("/auth/*")
public class AuthServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		boolean connected = false;
			
		String uri = request.getRequestURI();
		
		if (Pattern.matches("^.*/login$", uri)) {
			request.getRequestDispatcher("/login.jsp").forward(request, response);			
		}
		else if (Pattern.matches("^.*/logon$", uri)) {
			
			boolean checkUser = false;
			
			String login = request.getParameter("login");
			String password = request.getParameter("password");
			
			if ("david".equals(login)
					&& "123".equals(password)) {
				checkUser = true;
				request.changeSessionId();
				HttpSession session = request.getSession();
				session.setAttribute("login", login);
				session.setAttribute("authenticated", Boolean.TRUE);
			}
			
			if (checkUser) {
				HttpSession session = request.getSession();
				session.getAttribute("login");
				response.sendRedirect(request.getContextPath() + "/home");
//				request.getRequestDispatcher("/home").forward(request, response);
			}
			else {
				request.setAttribute("user-check", "login ou mot de passe incorrect");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
			
		}
		else if (Pattern.matches("^.*/logout$", uri)) {
			HttpSession session = request.getSession();
//			session.removeAttribute("login");
//			session.removeAttribute("authenticated");
			session.invalidate();
			response.sendRedirect(request.getContextPath() + "/auth/login");
		}
		else {
			request.setAttribute("error", "Page inconnu");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
