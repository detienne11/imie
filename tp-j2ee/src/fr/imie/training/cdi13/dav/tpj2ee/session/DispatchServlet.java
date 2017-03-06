package fr.imie.training.cdi13.dav.tpj2ee.session;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DispatchServlet
 */
@WebServlet("/tpredirect")
public class DispatchServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private final static String VIEW_PATH = "/WEB-INF/views/tpj2ee/";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String param = (String) request.getParameter("redirectGroup");

		int choice = 1;
		
		if (param != null) {
			choice = Integer.parseInt(param);
		}
		
		switch (choice) {
		case 1:
			// forward
			response.getWriter().append("<p>before forward</p><br/>");
			request.getRequestDispatcher(VIEW_PATH + "forward.jsp").forward(request, response);
			response.getWriter().append("<p>after forward</p><br/>");
			break;
		case 2:
			// include
			response.getWriter().append("<p>before include</p><br/>");
			request.getRequestDispatcher(VIEW_PATH + "include.jsp").include(request, response);
			response.getWriter().append("<p>after include</p><br/>");
			break;
		case 3:
			// redirect
			response.getWriter().append("<p>before redirect</p><br/>");
			response.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
			response.sendRedirect(request.getContextPath() + VIEW_PATH + "redirect.jsp");
			response.getWriter().append("<p>after redirect</p><br/>");
			// response.sendRedirect("https://www.google.com");
			break;

		default:
			request.getRequestDispatcher("/home").forward(request, response);
			break;
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
