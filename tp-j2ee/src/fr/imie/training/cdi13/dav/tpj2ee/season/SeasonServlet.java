package fr.imie.training.cdi13.dav.tpj2ee.season;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SeasonServlet
 */
@WebServlet("/season")
public class SeasonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private final static String VIEW_PATH = "/WEB-INF/views/season/";
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String season = request.getParameter("season");
		
		String jsp = VIEW_PATH + "season.jsp";
		if (season != null) {
			jsp = String.format(VIEW_PATH + "%s.jsp",season.toLowerCase());
		}		

		request.getRequestDispatcher(jsp).forward(request, response);

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
