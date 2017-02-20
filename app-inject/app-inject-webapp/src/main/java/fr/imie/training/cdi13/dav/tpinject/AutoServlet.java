package fr.imie.training.cdi13.dav.tpinject;

import java.io.IOException;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.imie.training.cdi13.dav.tpinject.cdi.service.AutoService;

/**
 * Servlet implementation class AutoServlet
 */
@WebServlet("/auto")
public class AutoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Inject
	@Named("mercedesService")
	private AutoService mercedesSrv;

	@Inject
	@Named("VW")
	private AutoService vwSrv;
	
	@Inject
	@Named("Porsche")
	private AutoService porscheSrv;
	
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		StringBuffer str = new StringBuffer();
		
		if (this.mercedesSrv != null){
			str.append(mercedesSrv.getService());
		}
		else {
			str.append("mercedesSrv null");
		}
		str.append("\n");
		if (this.vwSrv != null){
			str.append(vwSrv.getService());
		}
		else {
			str.append("vwSrv null");
		}
		str.append("\n");
		if (this.porscheSrv != null){
			str.append(porscheSrv.getService());
		}
		else {
			str.append("porscheSrv null");
		}
		str.append("\n");
		System.out.println(str.toString());

		response.getWriter().append(str.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
