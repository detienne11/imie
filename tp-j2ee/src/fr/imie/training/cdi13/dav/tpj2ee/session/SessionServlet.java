package fr.imie.training.cdi13.dav.tpj2ee.session;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionServlet
 */
@WebServlet("/tpsession")
public class SessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private final static String VIEW = "/WEB-INF/views/tpj2ee/session.jsp";
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Integer nbVisite = (Integer)session.getAttribute("nbVisite");
		int counter = 0;
		if (nbVisite != null) {
			counter = nbVisite.intValue();
		}
		session.setAttribute("nbVisite",Integer.valueOf(++counter));
		
		request.getRequestDispatcher(VIEW).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
