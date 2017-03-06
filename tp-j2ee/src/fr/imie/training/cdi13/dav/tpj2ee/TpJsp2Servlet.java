package fr.imie.training.cdi13.dav.tpj2ee;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.imie.training.cdi13.dav.tpj2ee.bean.User;

/**
 * Servlet implementation class TP10Servlet
 */
@WebServlet("/tpjsp2")
public class TpJsp2Servlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private final static String VIEW = "/WEB-INF/views/tpjsp2.jsp";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// Tp jsp 2 exo 1-2
		User user = new User("Brad", "Pitt");
		request.setAttribute("user", user);
		
		// Tp jsp 2 exo 3-4
		List<String> liste = Arrays.asList("guitare","natation","lecture","sculpture");
		request.setAttribute("liste", liste);
		
		request.getRequestDispatcher(VIEW).forward(request, response);
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
