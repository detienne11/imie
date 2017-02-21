package fr.imie.training.cdi13.dav.tpejb;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.imie.training.cdi13.dav.tpejb.ejb.HelloLocal;

/**
 * Servlet implementation class HelloEjbServlet
 */
@WebServlet("/local")
public class HelloEjbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	@EJB
	private HelloLocal helloLocal;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String text = helloLocal.message();
		
		response.getWriter().append("LOCAL HelloEjbServlet ask local EJB : ").append(text);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
