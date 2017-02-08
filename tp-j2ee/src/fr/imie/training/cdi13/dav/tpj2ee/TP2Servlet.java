package fr.imie.training.cdi13.dav.tpj2ee;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TP2Servlet
 */
@WebServlet("/tp2")
public class TP2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private final static String VIEW = "/WEB-INF/views/tp2.jsp";
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException {
				
		response.setContentType("text/html");
		response.getWriter()
			.append("Protocol: ")
			.append(request.getProtocol())
			.append("<h2>Client</h2><br/>Client Address:")
			.append(request.getRemoteAddr())
			.append("<br/>Client Port :")
			.append(String.valueOf(request.getRemotePort()))
			.append("<br/>Client Name:")
			.append(request.getRemoteUser())
			.append("<h2>Server</h2><br/>Server Name:")
			.append(request.getServerName())
			.append("<br/>Server Port:")
			.append(String.valueOf(request.getServerPort()))
			.append("<br/>Local Address:")
			.append(String.valueOf(request.getLocalAddr()))
			.append("<br/>Local Port:")
			.append(String.valueOf(request.getLocalPort()))
			.append("<br/>Scheme :")
			.append(request.getScheme())
			.append("<br/>ContentType:")
			.append(request.getContentType())
			.append("<h2>Parameter</h2>Nom:")
			.append(request.getParameter("nom"))
			.append("<br/>Prenom:")
			.append(request.getParameter("prenom"))
			.append("<h2>Parameters</h2>");
		
		Enumeration<String> list = request.getParameterNames();
		while (list.hasMoreElements()) {
			String name = (String) list.nextElement();
			response.getWriter()
				.append(name).append("=")
				.append(request.getParameter(name))
				.append("<br/>");
		}
		
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
