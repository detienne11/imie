package fr.imie.training.cdi13.dav.tpejb;

import java.io.IOException;
import java.util.Collections;
import java.util.Properties;

import javax.naming.InitialContext;
import javax.naming.NameClassPair;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.imie.training.cdi13.dav.tpejb.ejb.HelloRemote;

/**
 * Servlet implementation class HelloRemoteServlet
 */
@WebServlet("/remote")
public class HelloRemoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private HelloRemote ejbRemote;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String text = "text null";
		
		try {
			Properties p = new Properties();
			p.put("java.naming.factory.initial", "org.apache.openejb.client.RemoteInitialContextFactory");
			p.put("java.naming.provider.url", "http://localhost:8081/tomee/ejb");
			// user and pass optional
			// p.put("java.naming.security.principal", "myuser");
			// p.put("java.naming.security.credentials", "mypass");

			InitialContext ctx = new InitialContext(p);

			for (NameClassPair pair : Collections.list(ctx.list(""))) {
				System.out.println(pair.getName());
				System.out.println(pair.getClassName());
			}

			ejbRemote = (HelloRemote) ctx.lookup("HelloEjbRemote");
			
			text = ejbRemote.message();
						
			System.out.println("EJB OK");
		} catch (Exception ex) {
			ex.printStackTrace();
			text = ex.getMessage();
		}
		
		// TODO Auto-generated method stub
		response.getWriter().append("REMOTE HelloRemoteServlet ask remote EJB : ").append(text);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
