package fr.imie.training.cdi13.dav.tpj2ee;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.imie.training.cdi13.dav.tpj2ee.bean.User;

/**
 * Servlet implementation class XmlServlet
 */
@WebServlet("/xml")
public class XmlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<User> userList = new ArrayList<>();
		userList.add(new User("Leila", "Skywlaker"));
		userList.add(new User("Obiwan", "Kenobi"));
		request.setAttribute("userList", userList);
		response.setContentType("text/xml");
		
		response.getWriter().append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		response.getWriter().append("<users>\n");
		for (User user : userList) {
			response.getWriter().append("\t<user nom=\"" + user.getNom() + "\" prenom=\"" + user.getPrenom() + "\"/>\n");
		}
		response.getWriter().append("</users>\n");
		
//		request.getRequestDispatcher("/tpj2ee/xml.jsp").forward(request, response);		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
